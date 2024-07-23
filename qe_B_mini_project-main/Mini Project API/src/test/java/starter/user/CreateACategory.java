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
public class CreateACategory {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for create category")
    public String setApiEndpoint() {
        return url + "/categories";
    }

    @Step("I send request to create category with valid input")
    public void sendCreateValidCategoryRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "gaming");
        requestBody.put("description", "for gaming purposes");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send request to create category with invalid name")
    public void sendCreateInvalidCategoryNameRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", 8);
        requestBody.put("description", "for gaming purposes");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send request to create category with invalid description")
    public void sendCreateInvalidCategoryDescriptionRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "gaming");
        requestBody.put("description", 8);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive status code 400")
    public void receiveStatusCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I receive created category data")
    public void receiveValidCreatenewCategory() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_A_VALID_CATEGORY_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("I receive create category error")
    public void receiveInvalidCreatenewCategory() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_AN_INVALID_CATEGORY_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

}
