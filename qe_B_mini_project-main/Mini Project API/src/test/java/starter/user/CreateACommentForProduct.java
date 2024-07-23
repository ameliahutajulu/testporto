package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class CreateACommentForProduct {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint with valid Id for create product comment")
    public String setValidIdApiEndpoint() {
        return url + "/products/85520/comments";
    }

    @Step("I set API endpoint with invalid Id for create product comment")
    public String setInvalidIdApiEndpoint() {
        return url + "/products/2/comments";
    }

    @Step("I send request to create valid Id product comment")
    public void sendCreateValidProductCommentRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");

        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setValidIdApiEndpoint());
    }
    @Step("I send request to get invalid Id product rating")
    public void sendCreateInvalidProductCommentRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");

        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setInvalidIdApiEndpoint());
    }

    @Step("I receive data for product comment")
    public void receiveValidProductComment() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_A_COMMENT_FOR_PRODUCT_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
