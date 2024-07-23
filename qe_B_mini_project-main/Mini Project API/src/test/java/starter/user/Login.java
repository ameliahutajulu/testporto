package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.json.JSONArray;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
public class Login {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for login")
    public String setApiEndpoint() {
        return url + "/auth/login";
    }

    @Step("I send request to login with valid input")
    public void sendValidLoginRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "thisisemail@gmail.com");
        requestBody.put("password", "thisispassword");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive logged in account data")
    public void receiveLoginAccountData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_VALID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("I send request to login with non exist input")
    public void sendNonExistLoginRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "this@gmail.com");
        requestBody.put("password", "password");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send request to login with invalid email")
    public void sendInvalidEmailLoginRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", 8);
        requestBody.put("password", "thisispassword");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send request to login with invalid password")
    public void sendInvalidPasswordLoginRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "thisisemail@gmail.com");
        requestBody.put("password", 8);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive login account error")
    public void receiveInvalidLoginError() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_INVALID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
