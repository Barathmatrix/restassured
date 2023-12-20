package api.endpoints;

import api.endpoints.Securities;
import api.payload.Corporate;
import api.payload.GetCorporate;
import api.payload.InstitutionAccountDetails;
import api.payload.UpdateCorporate;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CorporateEndpoints {
    public static Response createCorporate(String payload, String token, String testCaseName){
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header("userID", Securities.userID)
                .header("Authorization", "Bearer "+token)
                .body(payload)
        .when()
                .post(Routes.create_corporate_url);
        return response;
    }
    public static Response updateCorporate(String payload, String token){
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header("userID", Securities.userID)
                .header("Authorization", "Bearer "+token)
                .body(payload)
                .when()
                .post(Routes.update_corporate_url);
        return response;
    }

    public static Response getCorporate(String payload, String token){
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header("userID", Securities.userID)
                .header("Authorization", "Bearer "+token)
                .body(payload)
                .when()
                .post(Routes.getCreate_corporate_url);
        return response;
    }

    public static Response getCorporateAccountDetails(String payload, String token, String testCaseName){
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header("userID", Securities.userID)
                .header("Authorization", "Bearer "+token)
                .body(payload)
                .when()
                .post(Routes.get_corporate_account_url);
        return response;
    }

    public static Response getCorporateAccountBalance(String payload, String token){
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header("userID", Securities.userID)
                .header("Authorization", "Bearer "+token)
                .body(payload)
                .when()
                .post(Routes.get_corporate_balance_url);
        return response;
    }
    public static Response getCorporateAccountTransactions(String payload, String token){
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header("userID", Securities.userID)
                .header("Authorization", "Bearer "+token)
                .body(payload)
                .when()
                .post(Routes.get_corporate_transactions_url);
        return response;
    }



}
