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
public class Register {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for register")
    public String setApiEndpoint() {
        return url + "/auth/register";
    }

    @Step("I send request to register with valid input")
    public void sendValidRegisterRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "thisisemail@gmail.com");
        requestBody.put("password", "thisispassword");
        requestBody.put("fullname", "full name");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive registered account data")
    public void receiveRegisterAccountData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.REGISTER_VALID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("I send request to register with existed input")
    public void sendExistedRegisterRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "thisisemail@gmail.com");
        requestBody.put("password", "thisispassword");
        requestBody.put("fullname", "full name");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send request to register with invalid email")
    public void sendInvalidEmailRegisterRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", 8);
        requestBody.put("password", "thisispassword");
        requestBody.put("fullname", "full name");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send request to register with invalid password")
    public void sendInvalidPasswordRegisterRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "thisemail@gmail.com");
        requestBody.put("password", 8);
        requestBody.put("fullname", "full name");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send request to register with invalid full name")
    public void sendInvalidFullnameRegisterRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "thisemail@gmail.com");
        requestBody.put("password", "thispassword");
        requestBody.put("fullname", 8);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive register account error")
    public void receiveInvalidRegisterError() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.REGISTER_INVALID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
