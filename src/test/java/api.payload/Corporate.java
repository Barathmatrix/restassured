package api.payload;
import com.github.javafaker.Faker;

import java.lang.reflect.Field;


public class Corporate {
    @Override
    public String toString() {
        return "Corporate{" +
                "requestRefNo='" + requestRefNo + '\'' +
                ", institutionShortName='" + institutionShortName + '\'' +
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
                ", solutionCode='" + solutionCode + '\'' +
                '}';
    }

    private String requestRefNo;
    private static final String superInstitutionId = "SI0000000000001";
    private String institutionShortName;
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
    private String solutionCode;
    public String getRequestRefNo() {
        return requestRefNo;
    }
    public String getSolutionCode() {
        return solutionCode;
    }

    // Constructor to generate UUID for requestRefNo during object creation
    public Corporate() {
        this.requestRefNo = api.utility.Utility.generateUUID();
        this.institutionShortName = api.utility.Utility.generateRandom("AN", 6);
        Faker fake = new Faker();
        this.institutionName = fake.company().name();
        this.countryCode = "356";
        this.currencyCode = "356";
        this.branchId = api.utility.Utility.generateRandom("N", 6);
        this.address1 = fake.address().streetAddress();
        this.address2 = fake.address().city();
        this.address3 = fake.address().state();
        this.postalCode = api.utility.Utility.generateRandom("N", 6);
        this.mobileNumber = api.utility.Utility.generateRandom("N", 10);
        this.emailId = fake.internet().safeEmailAddress();
        this.website = fake.internet().url();
        this.solutionCode = "R9XHB62";
    }

    public String getSuperInstitutionId() {
        return superInstitutionId;
    }

    public String getInstitutionShortName() {
        return institutionShortName;
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

    }

