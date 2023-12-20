package api.endpoints;
import api.endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Securities {
    public static String password = "UGFzc0AxMjM0";
    public static String userID = "0000000001";
        public static Response generateToken(){
            Response response = given().contentType(ContentType.JSON)
                    .header("userID", Securities.userID)
                    .header("password",Securities.password)
                    .when()
                    .get(Routes.token_url);
            return response;
        }

}


