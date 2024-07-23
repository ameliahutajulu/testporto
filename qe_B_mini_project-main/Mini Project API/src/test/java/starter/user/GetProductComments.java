package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class GetProductComments {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint with valid Id for get product comments")
    public String setValidIdApiEndpoint() {
        return url + "/products/85520/comments";
    }

    @Step("I set API endpoint with invalid Id for get product comments")
    public String setInvalidIdApiEndpoint() {
        return url + "/products/1/comments";
    }

    @Step("I send request to get valid Id product comments")
    public void sendGetValidProductCommentsRequest() {
        SerenityRest.given().get(setValidIdApiEndpoint());
    }
    @Step("I send request to get invalid Id product comments")
    public void sendGetInvalidProductCommentsRequest() {
        SerenityRest.given().get(setInvalidIdApiEndpoint());
    }

    @Step("I receive data for product comments")
    public void receiveValidProductComments() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_COMMENTS_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
