package api.payload;

public class InstitutionAccountDetails {

    private String requestRefNo;
    private String institutionId;

    public InstitutionAccountDetails(String institutionId) {
        this.requestRefNo = api.utility.Utility.generateUUID();
        this.institutionId = institutionId;
    }

    @Override
    public String toString() {
        return "InstitutionAccountDetails{" +
                "requestRefNo='" + requestRefNo + '\'' +
                ", institutionId='" + institutionId + '\'' +
                '}';
    }

    public String getRequestRefNo() {
        return requestRefNo;
    }

    public void setRequestRefNo(String requestRefNo) {
        this.requestRefNo = requestRefNo;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }


}
