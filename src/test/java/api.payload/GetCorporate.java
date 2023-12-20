package api.payload;

public class GetCorporate {



    private String requestRefNo;


    private String superInstitutionId;

    @Override
    public String toString() {
        return "GetCorporate{" +
                "requestRefNo='" + requestRefNo + '\'' +
                ", superInstitutionId='" + superInstitutionId + '\'' +
                ", institutionId='" + institutionId + '\'' +
                '}';
    }

    private String institutionId;

    public GetCorporate(String institutionId){
        this.requestRefNo = api.utility.Utility.generateUUID();
        this.superInstitutionId ="SI0000000000001";
        this.institutionId = institutionId;
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
    public void setSuperInstitutionId(String superInstitutionId) {
        this.superInstitutionId = superInstitutionId;
    }

    public String getSuperInstitutionId() {
        return superInstitutionId;
    }





}
