package api.test;

import api.payload.GetCorporate;
import api.payload.InstitutionAccountDetails;
import api.payload.UpdateCorporate;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.CorporateEndpoints;
import api.payload.Corporate;
import api.endpoints.Securities;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;



public class CorporateTests {
    public String token;
    public String institutionId;

    public String jsonBody;

@BeforeMethod
    public void tearDown(Method method) {
        System.out.println("Test name: " + method.getName());
    }
    //Before class only executes before all the tests in the class are executed
@BeforeClass
    public void generateCorporateToken(){
    token = Securities.generateToken().header("Authorization");
}



@Test(priority = 1)
      public void corporateCreate() {
        Corporate corporateBody = new Corporate();
        Response response = CorporateEndpoints.createCorporate(corporateBody.toString(), token, "Create Corporate Successful");
        institutionId = response.path("institutionId");
        response.then().log().all();
    }
@Test(priority = 1)
    public void invalidSolutionCodeCreateCorporate(){
    Corporate corporateBody = new Corporate();
    try {
        jsonBody = api.utility.Utility.modifyValue(corporateBody, "solutionCode", "R9XHB5");
    }
    catch(Exception e){
        // Handle the exception (print a message, log, etc.)
        System.err.println("Error converting key: " + e.getMessage());
    }
     Response response = CorporateEndpoints.createCorporate(jsonBody, token, "Invalid Solution Code");
     response.then().log().all();
}

    @Test(priority = 1)
    public void addingNewValueCreateCorporate() {
        Corporate corporateBody = new Corporate();
        try {
            jsonBody = api.utility.Utility.addKeyAndValue(corporateBody, "student.name.first", "R9XHB5");
        } catch (Exception e) {
            // Handle the exception (print a message, log, etc.)
            System.err.println("Error converting key: " + e.getMessage());
        }
   // Response = CorporateEndpoints.createCorporate(jsonBody, token, "Invalid Solution Code");
//        response.then().log().all();
        System.out.println(jsonBody);
    }

@Test(priority = 2)
    public void invalidKeyTest(){
    Corporate corporateBody = new Corporate();
    try {
        jsonBody = api.utility.Utility.convertKey(corporateBody, "solutionCode", "solCode");
    }
  catch (Exception e) {
        // Handle the exception (print a message, log, etc.)
        System.err.println("Error converting key: " + e.getMessage());
    }
    System.out.println(jsonBody);

}



@Test(dependsOnMethods = "corporateCreate")
public void updateCorporate(){
    UpdateCorporate updateCorporateBody = new UpdateCorporate(institutionId);
    Response response = CorporateEndpoints.updateCorporate(updateCorporateBody.toString(), token);
    response.then().log().all();
    }

@Test(dependsOnMethods = "corporateCreate", priority = 2)
public void getCorporate(){
    GetCorporate getCorporateBody = new GetCorporate(institutionId);
    Response response = CorporateEndpoints.getCorporate(getCorporateBody.toString(), token);
    response.then().log().all();
}

@Test(dependsOnMethods = "corporateCreate", priority = 2)
public void corporateAccountDetails(){
    InstitutionAccountDetails corporateAccountDetailsBody = new InstitutionAccountDetails(institutionId);
    Response response = CorporateEndpoints.getCorporateAccountDetails(corporateAccountDetailsBody.toString(), token, "Corporate Account Details Successful");
    response.then().log().all();
}

@Test(dependsOnMethods = "corporateCreate", priority = 2)
public void corporateAccountBalance(){
    InstitutionAccountDetails corporateAccountBalanceBody = new InstitutionAccountDetails(institutionId);
    Response response = CorporateEndpoints.getCorporateAccountBalance(corporateAccountBalanceBody.toString(), token);
    response.then().log().all();
}

@Test(dependsOnMethods = "corporateCreate", priority = 2)
public void corporateTransactions(){
    InstitutionAccountDetails corporateTransactionsBody = new InstitutionAccountDetails(institutionId);
    Response response = CorporateEndpoints.getCorporateAccountTransactions(corporateTransactionsBody.toString(), token);
    response.then().log().all();
}


}





