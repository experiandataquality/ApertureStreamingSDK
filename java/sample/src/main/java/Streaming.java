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
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentMetadata;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResult;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationMetadata;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.disposables.Disposable;

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
                                                .withEnrichmentOptions(true)
                                                .withMatchRule(null)
                                                .withLinkageRule("Relational")
                                                .withTimeout(Duration.ofSeconds(15))
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

        Disposable requestFailure = client.onRequestFailure().subscribe(failRequestResponse -> {
            final String message = String.format("Error sending a request. Method name: %s; Reference Id: %s; Error message: %s",
                    failRequestResponse.getMethod().getValue(),
                    failRequestResponse.getReferenceId(),
                    failRequestResponse.getError().getValue());
            System.out.println(message);
        });

        Disposable connectionFailure = client.onConnectionFailure().subscribe(connectionFailResponse -> {
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

                case "en geo" :
                    sendEnrichmentGeocodesRequest(client);
                    break;

                case "en uk essential" :
                    sendEnrichmentUkLocationEssentialRequest(client);
                    break;

                case "en usa" :
                    sendEnrichmentUsaGeocodeRequest(client);
                    break;

                case "en aus" :
                    sendEnrichmentAusGeocodeRequest(client);
                    break;

                case "en uklc" :
                    sendEnrichmentUkLocationCompleteRequest(client);
                    break;

                case "en nzl regional geocodes" :
                    sendEnrichmentNzlRegionalGeocodesRequest(client);
                    break;

                case "en nzl cv household" :
                    sendEnrichmentNzlCVHouseholdRequest(client);
                    break;

                case "p" :
                    System.out.println("Enter number to validate:");
                    String number = getInput();
                    System.out.println("Enter country Iso:");
                    String countryIso = getInput();
                    System.out.println("Enter get ported date option (true/false):");
                    Scanner sn = new Scanner(System.in);
                    boolean getPortedDate = sn.nextBoolean();
                    sendPhoneRequest(client, number, countryIso, getPortedDate);
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

        requestFailure.dispose();
        connectionFailure.dispose();
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
                .withAusCVPostcodeList(AusCVPostcode.HOUSEHOLD_COMPOSITION_CODE, AusCVPostcode.HOUSEHOLD_COMPOSITION_DESCRIPTION,
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
            System.out.println("AUS CV Postcode request sent");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendEnrichmentGeocodesRequest(Client client) {
        EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withGlobalAddressKey("aWQ9RnJpYXJzIEhvdXNlLCAxNjAgQmxhY2tmcmlhcnMgUmQsIExvbmRvbiBTRTEgOEVaLCBVbml0ZWQgS2luZ2RvbX5mb3JtYXRpZD02N2NiY2RkYS0wNzlmLTQ3NmEtOWFjOC1jNDc3Mjk4MDBiYjZ-cWw9MjJ-Z2VvPTA")
                .build();

        EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withGeocodesList(Geocodes.LATITUDE, Geocodes.LONGITUDE, Geocodes.MATCH_LEVEL)
                .build();

        EnrichmentRequest request = RequestBuilder.builder()
                .withEnrichmentRequest("ref")
                .withCountry("GBR")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
        try {
            client.onEnrichmentRequest(request);
            System.out.println("Geocodes request sent");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendEnrichmentUkLocationEssentialRequest(Client client) {
        EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withGlobalAddressKey("aWQ9RXhwZXJpYW4gRGF0YSBRdWFsaXR5LCBGcmlhcnMgSG91c2UsIEJsYWNrZnJpYXJzIFJvYWQsIExvbmRvbn5hbHRfa2V5PTU1MjQ0MjU2fmZvcm1hdGlkPWE4MzQwZmQyLTBlNzQtNDc3OS05OTdjLWM2ZDAyMjM0MzdiNn5xbD02MX5nZW89MA")
                .build();

        EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withUkLocationEssentialList(UkLocationEssential.LATITUDE, UkLocationEssential.LONGITUDE, UkLocationEssential.MATCH_LEVEL, UkLocationEssential.UDPRN, UkLocationEssential.UPRN, UkLocationEssential.X_COORDINATE, UkLocationEssential.Y_COORDINATE)
                .build();

        EnrichmentRequest request = RequestBuilder.builder()
                .withEnrichmentRequest("ref")
                .withCountry("GBR")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
        try {
            client.onEnrichmentRequest(request);
            System.out.println("UK Location Essential request sent");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendEnrichmentUsaGeocodeRequest(Client client) {
        EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withGlobalAddressKey("aWQ9VXJiIExhIFBsYXRhLDEgQ2FsbGUgMSxDb21lcmlvLFBSLDAwNzgyLTI3MTd+YWx0X2tleT1VcmIgTGEgUGxhdGF8MSBDYWxsZSAxfHxDb21lcmlvLFBSLDAwNzgyLTI3MTd+Zm9ybWF0SWQ9YTM5NjU1ODctYmIyNS00NmFkLTlkNmMtY2E4MDQ4YmQ0NGY2flFMPTl+Z2VvPTA=")
                .build();

        EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withUsaRegionalGeocodesList(UsaRegionalGeocodes.LONGITUDE,UsaRegionalGeocodes.LATITUDE,UsaRegionalGeocodes.MATCH_LEVEL)
                .build();

        EnrichmentRequest request = RequestBuilder.builder()
                .withEnrichmentRequest("ref")
                .withCountry("USA")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
        try {
            client.onEnrichmentRequest(request);
            System.out.println("USA Regional Geocodes request sent");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendEnrichmentAusGeocodeRequest(Client client) {
        EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withGlobalAddressKey("aWQ9OCBDb2NocmFuZSBTdHJlZXQsIFdFU1QgS0VNUFNFWSAgTlNXIDI0NDB-YWx0X2tleT0zMTE3NjQ5MH5kYXRhc2V0PUFVU19QQUZ-Zm9ybWF0aWQ9NGFlNTMyZDQtNjUwNC00Yzg2LThjZmQtYTBmZmNhNGRhN2Y0fnFsPTUzfmdlbz0w")
                .build();

        EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withAusRegionalGeocodesList(
                        AusRegionalGeocodes.LONGITUDE,
                        AusRegionalGeocodes.LATITUDE,
                        AusRegionalGeocodes.MATCH_LEVEL,
                        AusRegionalGeocodes.MESHBLOCK,
                        AusRegionalGeocodes.SA1,
                        AusRegionalGeocodes.LGA_CODE,
                        AusRegionalGeocodes.LGA_NAME)
                .build();

        EnrichmentRequest request = RequestBuilder.builder()
                .withEnrichmentRequest("ref")
                .withCountry("AUS")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
        try {
            client.onEnrichmentRequest(request);
            System.out.println("AUS Regional Geocodes request sent");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendPhoneRequest(Client client, String number,String countryIso, boolean getPortedDate) {
        PhoneValidationRequest request = RequestBuilder.builder()
                .withPhoneRequest("ref")
                .withNumber(number)
                .withCountryIso(countryIso)
                .withGetPortedDate(getPortedDate)
                .build();
        try {
            client.onPhoneRequest(request);
            System.out.println(String.format("Sent request: %s", number));
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendEnrichmentUkLocationCompleteRequest(Client client) {
        EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withGlobalAddressKey("aWQ9Q29tbXVuaXR5IEhlYWx0aCBTZXJ2aWNlcywgTHVraXMgSG91c2UsIEdyYW5nZSBSb2FkLCBTdC4gUGV0ZXIgUG9ydCwgR3Vlcm5zZXksIEdZMSAuLi4sIFVuaXRlZCBLaW5nZG9tfmFsdF9rZXk9NTA4Mzk5MjN-ZGF0YXNldD1HQlJfUEFGfmZvcm1hdGlkPWFkY2QxZjNkLWVhOGEtNDI3Yy1hYzE2LTMyNzVjYTExN2FkMn5xbD0yN35nZW89M")
                .build();

        EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withUkLocationCompleteList(
                        UkLocationComplete.LONGITUDE,
                        UkLocationComplete.LATITUDE,
                        UkLocationComplete.MATCH_LEVEL,
                        UkLocationComplete.X_COORDINATE,
                        UkLocationComplete.Y_COORDINATE,
                        UkLocationComplete.UDPRN,
                        UkLocationComplete.UPRN)
                .build();

        EnrichmentRequest request = RequestBuilder.builder()
                .withEnrichmentRequest("ref")
                .withCountry("GBR")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
        try {
            client.onEnrichmentRequest(request);
            System.out.println("UK Location Complete request sent");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendEnrichmentNzlRegionalGeocodesRequest(Client client) {
        EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withGlobalAddressKey("aWQ9Q29tbXVuaXR5IEhlYWx0aCBTZXJ2aWNlcywgTHVraXMgSG91c2UsIEdyYW5nZSBSb2FkLCBTdC4gUGV0ZXIgUG9ydCwgR3Vlcm5zZXksIEdZMSAuLi4sIFVuaXRlZCBLaW5nZG9tfmFsdF9rZXk9NTA4Mzk5MjN-ZGF0YXNldD1HQlJfUEFGfmZvcm1hdGlkPWFkY2QxZjNkLWVhOGEtNDI3Yy1hYzE2LTMyNzVjYTExN2FkMn5xbD0yN35nZW89M")
                .build();

        EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withNzlRegionalGeocodesList(
                        NzlRegionalGeocodes.REGIONAL_COUNCIL_CODE,
                        NzlRegionalGeocodes.REGIONAL_COUNCIL_NAME,
                        NzlRegionalGeocodes.ADDRESSABLE,
                        NzlRegionalGeocodes.CENTROID_OF_PROPERTY_NZTM_X_COORDINATE,
                        NzlRegionalGeocodes.CENTROID_OF_PROPERTY_NZTM_Y_COORDINATE,
                        NzlRegionalGeocodes.FRONT_OF_PROPERTY_NZTM_X_COORDINATE,
                        NzlRegionalGeocodes.FRONT_OF_PROPERTY_NZTM_Y_COORDINATE,
                        NzlRegionalGeocodes.GENERAL_ELECTORATE_CODE,
                        NzlRegionalGeocodes.GENERAL_ELECTORATE_NAME,
                        NzlRegionalGeocodes.REGIONAL_COUNCIL_NAME,
                        NzlRegionalGeocodes.REGIONAL_COUNCIL_CODE,
                        NzlRegionalGeocodes.LINZ_PARCEL_ID,
                        NzlRegionalGeocodes.MAORI_ELECTORATE_CODE,
                        NzlRegionalGeocodes.MAORI_ELECTORATE_NAME,
                        NzlRegionalGeocodes.MESH_BLOCK_CODE,
                        NzlRegionalGeocodes.PROPERTY_PURPOSE_TYPE,
                        NzlRegionalGeocodes.TERRITORIAL_AUTHORITY_CODE,
                        NzlRegionalGeocodes.TERRITORIAL_AUTHORITY_NAME,
                        NzlRegionalGeocodes.FRONT_OF_PROPERTY_LATITUDE,
                        NzlRegionalGeocodes.FRONT_OF_PROPERTY_LONGITUDE,
                        NzlRegionalGeocodes.CENTROID_OF_PROPERTY_LATITUDE,
                        NzlRegionalGeocodes.CENTROID_OF_PROPERTY_LONGITUDE,
                        NzlRegionalGeocodes.MATCH_LEVEL
                )
                .build();

        EnrichmentRequest request = RequestBuilder.builder()
                .withEnrichmentRequest("ref")
                .withCountry("NZL")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
        try {
            client.onEnrichmentRequest(request);
            System.out.println("NZL Regional Geocodes request sent");
        } catch (final RateLimitException | ConnectionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendEnrichmentNzlCVHouseholdRequest(Client client) {
        EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withGlobalAddressKey("aWQ9Q29tbXVuaXR5IEhlYWx0aCBTZXJ2aWNlcywgTHVraXMgSG91c2UsIEdyYW5nZSBSb2FkLCBTdC4gUGV0ZXIgUG9ydCwgR3Vlcm5zZXksIEdZMSAuLi4sIFVuaXRlZCBLaW5nZG9tfmFsdF9rZXk9NTA4Mzk5MjN-ZGF0YXNldD1HQlJfUEFGfmZvcm1hdGlkPWFkY2QxZjNkLWVhOGEtNDI3Yy1hYzE2LTMyNzVjYTExN2FkMn5xbD0yN35nZW89M")
                .build();

        EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withNzlCVHouseholdList(
                        NzlCVHousehold.Adults_At_Address,
                        NzlCVHousehold.Children_At_Address,
                        NzlCVHousehold.Head_Of_Household_Age,
                        NzlCVHousehold.Household_Composition,
                        NzlCVHousehold.Head_Of_Household_Lifestage,
                        NzlCVHousehold.Mosaic_Group,
                        NzlCVHousehold.Mosaic_Segment,
                        NzlCVHousehold.Mosaic_Type_Group
                )
                .build();

        EnrichmentRequest request = RequestBuilder.builder()
                .withEnrichmentRequest("ref")
                .withCountry("NZL")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
        try {
            client.onEnrichmentRequest(request);
            System.out.println("NZL Consumer View request sent");
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
            EnrichmentMetadata metadata = response.getMetadata();
            if (metadata != null)
            {
                String json = gson.toJson(metadata);
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
        System.out.println("Press 'en geo' to send enrichment Geocodes request.");
        System.out.println("Press 'en uk essential' to send enrichment UK Location Essential request.");
        System.out.println("Press 'en usa' to send enrichment USA Regional Geocodes request.");
        System.out.println("Press 'en aus' to send enrichment AUS Regional Geocodes request.");
        System.out.println("Press 'en uklc' to send enrichment UK Location Complete request.");
        System.out.println("Press 'en nzl cv household' to send enrichment NZL CV Household request.");
        System.out.println("Press 'en nzl regional geocodes' to send enrichment NZL Regional Geocodes request.");
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