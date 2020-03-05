package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * The organization component.
 */
public final class AddressValidationOrganisationElement {
    /**
     * The department name within an organization.
     **/
    @SerializedName("department_name")
    private String departmentName;

    /**
     * The secondary department name within an organization (if available).
     **/
    @SerializedName("secondary_department_name")
    private String secondaryDepartmentName;

    /**
     * The company name.
     **/
    @SerializedName("company_name")
    private String companyName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSecondaryDepartmentName() {
        return secondaryDepartmentName;
    }

    public void setSecondaryDepartmentName(final String secondaryDepartmentName) {
        this.secondaryDepartmentName = secondaryDepartmentName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }
}
