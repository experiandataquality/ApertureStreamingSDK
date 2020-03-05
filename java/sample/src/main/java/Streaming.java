import com.experian.aperture.streaming.client.*;
import com.experian.aperture.streaming.client.options.address.AddressValidationOptions;
import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.options.RetryOptions;
import com.experian.aperture.streaming.client.options.RetryOptionsBuilder;
import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import com.experian.aperture.streaming.client.response.StreamingException;
import com.experian.aperture.streaming.client.response.address.AddressValidationMetadata;
import com.experian.aperture.streaming.client.response.address.AddressValidationResponse;
import com.experian.aperture.streaming.client.response.address.AddressValidationResult;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.email.EmailValidationResult;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResult;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationMetadata;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Streaming {
    private static String outputFormat = "\t%-20s%s";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static int requestsCount = 0;

    public static void main(String[] args) {
        final String url = args[0];
        final String token = args[1];

        URL endpoint = null;
        try {
            endpoint = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        EmailValidationOptions emailValidationOptions =  OptionsBuilder.builder()
                                                        .withEmailOptions(false)
                                                        .withTimeout(Duration.ofSeconds(3))
                                                        .build();

        EnrichmentOptions enrichmentOptions = OptionsBuilder.builder()
                                                .withEnrichmentOptions(false)
                                                .withMatchRule(null)
                                                .withLinkageRule("Relational")
                                                .withTimeout(Duration.ofSeconds(3))
                                                .build();

        AddressValidationOptions addressOptions = OptionsBuilder.builder()
                .withAddressOptions(true)
                .withTimeout(Duration.ofSeconds(15))
                .withIncludeComponents(true)
                .build();


        RetryOptions retryOptions = RetryOptionsBuilder.builder()
                .withEnableAutoReconnect(false)
                .withRestartIntervalInMilliseconds(30000)
                .withReconnectionCount(30)
                .build();
        Client client = ClientBuilder.builder()
                        .create(RequestManagerFactory.newInstance(endpoint, token, retryOptions))
                        .withEmailOptions(emailValidationOptions)
                        .withEnrichmentOptions(enrichmentOptions)
                        .withAddressOptions(addressOptions)
                        .build();

        client.onRequestFailure().subscribe(failRequestResponse -> {
            final String message = String.format("Error sending a request. Method name: %s; Reference Id: %s; Error message: %s",
                    failRequestResponse.getMethod().getValue(),
                    failRequestResponse.getReferenceId(),
                    failRequestResponse.getError().getValue());
            System.out.println(message);
        });

        client.onConnectionFailure().subscribe(connectionFailResponse -> {
            System.out.println(connectionFailResponse.getError().getValue());
            connectionFailResponse.getFailRequests().forEach(x -> {
                final String message = String.format("Error sending a request when reconnecting to server. Method name: %s; Reference Id: %s; Error message: %s",
                        x.getMethod().getValue(),
                        x.getReferenceId(),
                        x.getError().getValue());
                System.out.println(message);
            });
        });

        try {
            client.startStreaming();
        } catch (final ConnectionException ex) {
            System.out.println(ex.getMessage());
        }

        registerEmailHandler(client);
        registerEnrichmentHandler(client);
        registerPhoneHandler(client);
        registerAddressHandler(client);

        printOptions();
        String input = getInput();

        while (!input.equals("q")) {
            // reset counter, just to track number of requests sent.
            requestsCount = 0;

            switch (input) {
                case "e" :
                    System.out.println("Enter email to validate:");
                    String email = getInput();
                    sendEmailRequest(client, email);
                    break;

                case "eb" :
                    System.out.println("Enter no of emails to validate:");
                    int count = Integer.parseInt(getInput());
                    sendMultipleEmailRequest(client, count);
                    break;

                case "en" :
                    sendEnrichmentRequest(client);
                    break;

                case "p" :
                    System.out.println("Enter number to validate:");
                    String number = getInput();
                    sendPhoneRequest(client, number);
                    break;

                case "a" :
                    sendAddressRequest(client);
                    break;

                default:
                    System.out.println("Unknown option.");
            }
            printOptions();
            input = getInput();
        }

        client.stopStreaming();
        System.exit(1);
    }

    private static void registerEmailHandler(Client client) {
        client.onEmailResponse(Streaming::formatOutput);
    }

    private static void registerEnrichmentHandler(Client client) {
        client.onEnrichmentResponse(Streaming::formatOutput);
    }

    private static void registerPhoneHandler(Client client) {
        client.onPhoneResponse(Streaming::formatOutput);
    }

    private static void registerAddressHandler(Client client) {
        client.onAddressResponse(Streaming::formatOutput);
    }

    private static void sendEmailRequest(Client client, String input) {
        EmailValidationRequest request = RequestBuilder.builder()
                .withEmailRequest("ref")
                .withEmail(input)
                .build();
        try {
            client.onEmailRequest(request);
            System.out.println(String.format("Sent request: %s", input));
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendMultipleEmailRequest(Client client, final int count) {
        try {
            for (int i = 0; i < count; i++) {
                EmailValidationRequest request = RequestBuilder.builder()
                        .withEmailRequest(String.format("ref%d", i))
                        .withEmail(String.format("email%d@example.com", i))
                        .build();
                client.onEmailRequest(request);
            }
            System.out.println(String.format("Sent request: %d", count));
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendEnrichmentRequest(Client client) {
        EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withPostcode("7140")
                .build();

        EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withAusCvPostcodeList(AusCVPostcode.HOUSEHOLD_COMPOSITION_CODE, AusCVPostcode.HOUSEHOLD_COMPOSITION_DESCRIPTION,
                                       AusCVPostcode.LENGTH_OF_RESIDENCE_CODE, AusCVPostcode.LENGTH_OF_RESIDENCE_DESCRIPTION)
                .build();

        EnrichmentRequest request = RequestBuilder.builder()
                                    .withEnrichmentRequest("ref")
                                    .withCountry("AUS")
                                    .withKeys(datasetKeys)
                                    .withAttributes(attributes)
                                    .build();
        try {
            client.onEnrichmentRequest(request);
            System.out.println("Sent request!");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendPhoneRequest(Client client, String number) {
        PhoneValidationRequest request = RequestBuilder.builder()
                .withPhoneRequest("ref")
                .withNumber(number)
                .build();
        try {
            client.onPhoneRequest(request);
            System.out.println(String.format("Sent request: %s", number));
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendAddressRequest(Client client) {
        AddressValidationRequest request = RequestBuilder.builder()
                .withAddressValidationRequest("ref")
                .withCountryIso("USA")
                .withBuilding("125")
                .withStreet("Summer St")
                .withLocality("Boston")
                .build();
        try {
            client.onAddressRequest(request);
            System.out.println("Sent request!");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void formatOutput(EmailValidationResponse emailResponse) {
        System.out.println();
        try {
            EmailValidationResult result = emailResponse.getResult();
            if (result != null) {
                System.out.println(String.format(outputFormat, "ReferenceId", emailResponse.getReferenceId()));
                System.out.println(String.format(outputFormat, "Email", result.getEmail()));
                System.out.println(String.format(outputFormat, "Confidence", result.getConfidence()));
                System.out.println(String.format(outputFormat, "Count", (++requestsCount)));
            }
        } catch (StreamingException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void formatOutput(EnrichmentResponse response) {
        System.out.println();
        try {
            EnrichmentResult result = response.getResult();
            if (result != null) {
                String json = gson.toJson(result);
                System.out.println(json);
            }
        } catch (StreamingException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void formatOutput(PhoneValidationResponse response) {
        System.out.println();
        try {
            PhoneValidationResult result = response.getResult();
            if (result != null) {
                String json = gson.toJson(result);
                System.out.println(json);
            }

            PhoneValidationMetadata metadata = response.getMetadata();
            if (metadata != null) {
                String json = gson.toJson(metadata);
                System.out.println(json);
            }
        } catch (StreamingException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void formatOutput(AddressValidationResponse response) {
        System.out.println();
        try {
            AddressValidationResult result = response.getResult();
            if (result != null) {
                String json = gson.toJson(result);
                System.out.println(json);
            }
            AddressValidationMetadata metadata = response.getMetadata();
            if (metadata != null) {
                String json = gson.toJson(metadata);
                System.out.println(json);
            }
        } catch (StreamingException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printOptions() {
        System.out.println("Press a to send address validation request.");
        System.out.println("Press e to send email validation request.");
        System.out.println("Press eb to send bulk email validation request.");
        System.out.println("Press en to send enrichment request.");
        System.out.println("Press p to send phone validation request.");
        System.out.println("Press q to quit");
    }

    private static String getInput() {
        if (System.console() != null) {
            return System.console().readLine();
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private static List<String> ConvertStringToList(String input) {
        String[] inputList = input.split(",");
        return Arrays.asList(inputList);
    }
}

