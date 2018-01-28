package integration;

import com.eclipsesource.json.JsonObject;
import org.junit.Test;

import static integration.APITestSuit.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;

public class IT_RegistrationAPI {

    @Test public void
    register_a_new_user() {
        given()
                .body(withJsonContaining("Lucy", "alki324d", "About Lucy"))
        .when()
                .post(BASE_URL + "/registration")
        .then()
                .statusCode(201)
                .contentType(JSON)
                .body("userId", notNullValue())
                .body("username", is("Lucy"))
                .body("about", is("About Lucy"));
    }

    private String withJsonContaining(String username, String password, String about) {
        return new JsonObject()
                        .add("username", username)
                        .add("password", password)
                        .add("about", about)
                        .toString();
    }
}