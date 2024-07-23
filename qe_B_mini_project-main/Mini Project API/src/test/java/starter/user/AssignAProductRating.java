package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AssignAProductRating {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint with valid Id for rate product")
    public String setValidIdApiEndpoint() {
        return url + "/products/85520/ratings";
    }

    @Step("I set API endpoint with invalid Id for rate product")
    public String setInvalidIdApiEndpoint() {
        return url + "/products/2/ratings";
    }

    @Step("I send request to rate product with valid ID")
    public void sendRateValidProductRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 4);

        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setValidIdApiEndpoint());
    }

    @Step("I send request to rate product with invalid ID")
    public void sendRateInvalidProductRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 4);

        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setInvalidIdApiEndpoint());
    }

    @Step("I receive rated product data")
    public void receiveValidRateProduct() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ASSIGN_A_PRODUCT_RATING_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive status code 500")
    public void receiveStatusCode500() {
        restAssuredThat(response -> response.statusCode(500));
    }
}
