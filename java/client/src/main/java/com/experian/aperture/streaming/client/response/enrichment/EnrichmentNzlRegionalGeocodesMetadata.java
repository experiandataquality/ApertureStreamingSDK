package com.experian.aperture.streaming.client.response.enrichment;
import com.google.gson.annotations.SerializedName;

/**
 * Attribute-level metadata for the NZL Regional Geocodes dataset.
 * */
public final class EnrichmentNzlRegionalGeocodesMetadata {
    /**
     * The front of property nztm x coordinate.
     * Example: 1757352.77679428
     */
    @SerializedName("front_of_property_nztm_x_coordinate")
    private DatasetMetadata frontOfPropertyNztmXCoordinate;

    /**
     * The front of property nztm y coordinate.
     * Example: 5920390.38954181
     */
    @SerializedName("front_of_property_nztm_y_coordinate")
    private DatasetMetadata frontOfPropertyNztmYCoordinate;

    /**
     * The centroid of property nztm x coordinate.
     * Example: 1757328.32545739
     */
    @SerializedName("centroid_of_property_nztm_x_coordinate")
    private DatasetMetadata centroidOfPropertyNztmXCoordinate;

    /**
     * The centroid of property nztm y coordinate.
     * Example: 5920399.80535698
     */
    @SerializedName("centroid_of_property_nztm_y_coordinate")
    private DatasetMetadata centroidOfPropertyNztmYCoordinate;

    /**
     * The linz parcel id.
     * Example: 5047052
     */
    @SerializedName("linz_parcel_id")
    private DatasetMetadata linzParcelId;

    /**
     * The property purpose type.
     * Example: Business
     */
    @SerializedName("property_purpose_type")
    private DatasetMetadata propertyPurposeType;

    /**
     * The addressable.
     * Example: N
     */
    @SerializedName("addressable")
    private DatasetMetadata addressable;

    /**
     * The mesh block code.
     * Example: 434000
     */
    @SerializedName("mesh_block_code")
    private DatasetMetadata meshBlockCode;

    /**
     * The territorial authority code.
     * Example: 76
     */
    @SerializedName("territorial_authority_code")
    private DatasetMetadata territorialAuthorityCode;

    /**
     * The territorial authority name.
     * Example: Auckland
     */
    @SerializedName("territorial_authority_name")
    private DatasetMetadata territorialAuthorityName;

    /**
     * The regional council code.
     * Example: 2
     */
    @SerializedName("regional_council_code")
    private DatasetMetadata regionalCouncilCode;

    /**
     * The regional authority name.
     * Example: Auckland Region
     */
    @SerializedName("regional_council_name")
    private DatasetMetadata regionalCouncilName;

    /**
     * The general electorate code.
     * Example: 001
     */
    @SerializedName("general_electorate_code")
    private DatasetMetadata generalElectorateCode;

    /**
     * The general electorate name.
     * Example: Auckland Central
     */
    @SerializedName("general_electorate_name")
    private DatasetMetadata generalElectorateName;

    /**
     * The maori electorate code.
     * Example: 3
     */
    @SerializedName("maori_electorate_code")
    private DatasetMetadata maoriElectorateCode;

    /**
     * The maori electorate name.
     * Example: Tamaki Makaurau
     */
    @SerializedName("maori_electorate_name")
    private DatasetMetadata maoriElectorateName;

    /**
     * The front of property latitude.
     * Example: -36.84930884682109
     */
    @SerializedName("front_of_property_latitude")
    private DatasetMetadata frontOfPropertyLatitude;

    /**
     * The front of property longitude.
     * Example: 174.76492824881467
     */
    @SerializedName("front_of_property_longitude")
    private DatasetMetadata frontOfPropertyLongitude;

    /**
     * The centroid of property latitude.
     * Example: -36.849228077790954
     */
    @SerializedName("centroid_of_property_latitude")
    private DatasetMetadata centroidOfPropertyLatitude;

    /**
     * The centroid of property longitude.
     * Example: 174.76465216104987
     */
    @SerializedName("centroid_of_property_longitude")
    private DatasetMetadata centroidOfPropertyLongitude;

    /**
     * The match level.
     * Example: Building
     */
    @SerializedName("match_level")
    private DatasetMetadata matchLevel;

    /**
     * Sets the front of property nztm x coordinate.
     * @param frontOfPropertyNztmXCoordinate The front of property nztm x coordinate.
     */
    public void setFrontOfPropertyNztmXCoordinate(final DatasetMetadata frontOfPropertyNztmXCoordinate) {
        this.frontOfPropertyNztmXCoordinate = frontOfPropertyNztmXCoordinate;
    }

    /**
     * Gets the front of property nztm x coordinate.
     * @return The front of property nztm x coordinate.
     * */
    public DatasetMetadata getFrontOfPropertyNztmXCoordinate() {
        return this.frontOfPropertyNztmXCoordinate;
    }

    /**
     * Sets the front of property nztm y coordinate.
     * @param frontOfPropertyNztmYCoordinate The front of property nztm y coordinate.
     */
    public void setFrontOfPropertyNztmYCoordinate(final DatasetMetadata frontOfPropertyNztmYCoordinate) {
        this.frontOfPropertyNztmYCoordinate = frontOfPropertyNztmYCoordinate;
    }

    /**
     * Gets the front of property nztm y coordinate.
     * @return The front of property nztm y coordinate.
     * */
    public DatasetMetadata getFrontOfPropertyNztmYCoordinate() {
        return this.frontOfPropertyNztmYCoordinate;
    }

    /**
     * Sets the centroid of property nztm x coordinate.
     * @param centroidOfPropertyNztmXCoordinate The centroid of property nztm x coordinate.
     */
    public void setCentroidOfPropertyNztmXCoordinate(final DatasetMetadata centroidOfPropertyNztmXCoordinate) {
        this.centroidOfPropertyNztmXCoordinate = centroidOfPropertyNztmXCoordinate;
    }

    /**
     * Gets the centroid of property nztm x coordinate.
     * @return The centroid of property nztm x coordinate.
     * */
    public DatasetMetadata getCentroidOfPropertyNztmXCoordinate() {
        return this.centroidOfPropertyNztmXCoordinate;
    }

    /**
     * Sets the centroid of property nztm y coordinate.
     * @param centroidOfPropertyNztmYCoordinate The centroid of property nztm y coordinate.
     */
    public void setCentroidOfPropertyNztmYCoordinate(final DatasetMetadata centroidOfPropertyNztmYCoordinate) {
        this.centroidOfPropertyNztmYCoordinate = centroidOfPropertyNztmYCoordinate;
    }

    /**
     * Gets the centroid of property nztm y coordinate.
     * @return The centroid of property nztm y coordinate.
     * */
    public DatasetMetadata getCentroidOfPropertyNztmYCoordinate() {
        return this.centroidOfPropertyNztmYCoordinate;
    }

    /**
     * Sets the linz parcel id.
     * @param linzParcelId The linz parcel id.
     */
    public void setLinzParcelId(final DatasetMetadata linzParcelId) {
        this.linzParcelId = linzParcelId;
    }

    /**
     * Gets the linz parcel id.
     * @return The linz parcel id.
     * */
    public DatasetMetadata getLinzParcelId() {
        return this.linzParcelId;
    }

    /**
     * Sets the property purpose type.
     * @param propertyPurposeType The property purpose type.
     */
    public void setPropertyPurposeType(final DatasetMetadata propertyPurposeType) {
        this.propertyPurposeType = propertyPurposeType;
    }

    /**
     * Gets the property purpose type.
     * @return The property purpose type.
     * */
    public DatasetMetadata getPropertyPurposeType() {
        return this.propertyPurposeType;
    }

    /**
     * Sets the addressable.
     * @param addressable The addressable.
     */
    public void setAddressable(final DatasetMetadata addressable) {
        this.addressable = addressable;
    }

    /**
     * Gets the addressable.
     * @return The addressable.
     * */
    public DatasetMetadata getAddressable() {
        return this.addressable;
    }

    /**
     * Sets the mesh block code.
     * @param meshBlockCode The mesh block code.
     */
    public void setMeshBlockCode(final DatasetMetadata meshBlockCode) {
        this.meshBlockCode = meshBlockCode;
    }

    /**
     * Gets the mesh block code.
     * @return The mesh block code.
     * */
    public DatasetMetadata getMeshBlockCode() {
        return this.meshBlockCode;
    }

    /**
     * Sets the territorial authority code.
     * @param territorialAuthorityCode The territorial authority code.
     */
    public void setTerritorialAuthorityCode(final DatasetMetadata territorialAuthorityCode) {
        this.territorialAuthorityCode = territorialAuthorityCode;
    }

    /**
     * Gets the territorial authority code.
     * @return The territorial authority code.
     * */
    public DatasetMetadata getTerritorialAuthorityCode() {
        return this.territorialAuthorityCode;
    }

    /**
     * Sets the territorial authority name.
     * @param territorialAuthorityName The territorial authority name.
     */
    public void setTerritorialAuthorityName(final DatasetMetadata territorialAuthorityName) {
        this.territorialAuthorityName = territorialAuthorityName;
    }

    /**
     * Gets the territorial authority name.
     * @return The territorial authority name.
     * */
    public DatasetMetadata getTerritorialAuthorityName() {
        return this.territorialAuthorityName;
    }

    /**
     * Sets the regional council code.
     * @param regionalCouncilCode The regional council code.
     */
    public void setRegionalCouncilCode(final DatasetMetadata regionalCouncilCode) {
        this.regionalCouncilCode = regionalCouncilCode;
    }

    /**
     * Gets the regional council code.
     * @return The regional council code.
     * */
    public DatasetMetadata getRegionalCouncilCode() {
        return this.regionalCouncilCode;
    }

    /**
     * Sets the regional council name.
     * @param regionalCouncilName The regional council name.
     */
    public void setRegionalCouncilName(final DatasetMetadata regionalCouncilName) {
        this.regionalCouncilName = regionalCouncilName;
    }

    /**
     * Gets the regional council name.
     * @return The regional council name.
     * */
    public DatasetMetadata getRegionalCouncilName() {
        return this.regionalCouncilName;
    }

    /**
     * Sets the general electorate code.
     * @param generalElectorateCode The general electorate code.
     */
    public void setGeneralElectorateCode(final DatasetMetadata generalElectorateCode) {
        this.generalElectorateCode = generalElectorateCode;
    }

    /**
     * Gets the general electorate code.
     * @return The general electorate code.
     * */
    public DatasetMetadata getGeneralElectorateCode() {
        return this.generalElectorateCode;
    }

    /**
     * Sets the general electorate name.
     * @param generalElectorateName The general electorate name.
     */
    public void setGeneralElectorateName(final DatasetMetadata generalElectorateName) {
        this.generalElectorateName = generalElectorateName;
    }

    /**
     * Gets the general electorate name.
     * @return The general electorate name.
     * */
    public DatasetMetadata getGeneralElectorateName() {
        return this.generalElectorateName;
    }

    /**
     * Sets the maori electorate code.
     * @param maoriElectorateCode The maori electorate code.
     */
    public void setMaoriElectorateCode(final DatasetMetadata maoriElectorateCode) {
        this.maoriElectorateCode = maoriElectorateCode;
    }

    /**
     * Gets the maori electorate code.
     * @return The maori electorate code.
     * */
    public DatasetMetadata getMaoriElectorateCode() {
        return this.maoriElectorateCode;
    }

    /**
     * Sets the maori electorate name.
     * @param maoriElectorateName The maori electorate name.
     */
    public void setMaoriElectorateName(final DatasetMetadata maoriElectorateName) {
        this.maoriElectorateName = maoriElectorateName;
    }

    /**
     * Gets the maori electorate name.
     * @return The maori electorate name.
     * */
    public DatasetMetadata getMaoriElectorateName() {
        return this.maoriElectorateName;
    }

    /**
     * Sets the front of property latitude.
     * @param frontOfPropertyLatitude The front of property latitude.
     */
    public void setFrontOfPropertyLatitude(final DatasetMetadata frontOfPropertyLatitude) {
        this.frontOfPropertyLatitude = frontOfPropertyLatitude;
    }

    /**
     * Gets the front of property latitude.
     * @return The front of property latitude.
     * */
    public DatasetMetadata getFrontOfPropertyLatitude() {
        return this.frontOfPropertyLatitude;
    }

    /**
     * Sets the front of property longitude.
     * @param frontOfPropertyLongitude The front of property longitude.
     */
    public void setFrontOfPropertyLongitude(final DatasetMetadata frontOfPropertyLongitude) {
        this.frontOfPropertyLongitude = frontOfPropertyLongitude;
    }

    /**
     * Gets the front of property longitude.
     * @return The front of property longitude.
     * */
    public DatasetMetadata getFrontOfPropertyLongitude() {
        return this.frontOfPropertyLongitude;
    }

    /**
     * Sets the centroid of property latitude.
     * @param centroidOfPropertyLatitude The centroid of property latitude.
     */
    public void setCentroidOfPropertyLatitude(final DatasetMetadata centroidOfPropertyLatitude) {
        this.centroidOfPropertyLatitude = centroidOfPropertyLatitude;
    }

    /**
     * Gets the centroid of property latitude.
     * @return The centroid of property latitude.
     * */
    public DatasetMetadata getCentroidOfPropertyLatitude() {
        return this.centroidOfPropertyLatitude;
    }

    /**
     * Sets the centroid of property longitude.
     * @param centroidOfPropertyLongitude The centroid of property longitude.
     */
    public void setCentroidOfPropertyLongitude(final DatasetMetadata centroidOfPropertyLongitude) {
        this.centroidOfPropertyLongitude = centroidOfPropertyLongitude;
    }

    /**
     * Gets the centroid of property longitude.
     * @return The centroid of property longitude.
     * */
    public DatasetMetadata getCentroidOfPropertyLongitude() {
        return this.centroidOfPropertyLongitude;
    }

    /**
     * Sets the match level.
     * @param matchLevel The match level.
     */
    public void setMatchLevel(final DatasetMetadata matchLevel) {
        this.matchLevel = matchLevel;
    }

    /**
     * Gets the match level.
     * @return The match level.
     * */
    public DatasetMetadata getMatchLevel() {
        return this.matchLevel;
    }
}
