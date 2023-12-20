package api.payload;

import com.github.javafaker.Faker;

public class UpdateCorporate {

    private String requestRefNo;
    private String superInstitutionId;
    private String institutionName;
    private String countryCode;
    private String currencyCode;
    private String branchId;
    private String address1;
    private String address2;
    private String address3;
    private String postalCode;
    private String mobileNumber;
    private String emailId;
    private String website;
    private String institutionId;

    public UpdateCorporate(String institutionId) {
        this.requestRefNo = api.utility.Utility.generateUUID();
        this.superInstitutionId ="SI0000000000001";
        Faker fake;
        fake = new Faker();
        this.institutionId = institutionId;
        this.countryCode = "356";
        this.currencyCode = "356";
        this.branchId = api.utility.Utility.generateRandom("N", 6);
        this.address1 = new Faker().address().streetAddress();
        this.address2 = new Faker().address().city();
        this.address3 = new Faker().address().state();
        this.postalCode = api.utility.Utility.generateRandom("N", 6);
        this.mobileNumber = api.utility.Utility.generateRandom("N", 10);
        this.emailId = new Faker().internet().safeEmailAddress();
        this.website = new Faker().internet().url();
    }

    public void setSuperInstitutionId(String superInstitutionId) {
        this.superInstitutionId = superInstitutionId;
    }

    public String getSuperInstitutionId() {
        return superInstitutionId;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }



    public String getRequestRefNo() {
        return requestRefNo;
    }

    public void setRequestRefNo(String requestRefNo) {
        this.requestRefNo = requestRefNo;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "UpdateCorporate{" +
                "requestRefNo='" + requestRefNo + '\'' +
                ", superInstitutionId='" + superInstitutionId + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", branchId='" + branchId + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", website='" + website + '\'' +
                ", institutionId='" + institutionId + '\'' +
                '}';
    }
}
