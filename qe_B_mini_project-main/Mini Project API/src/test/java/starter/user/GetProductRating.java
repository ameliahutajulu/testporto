package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class GetProductRating {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint with valid Id for get product rating")
    public String setValidIdApiEndpoint() {
        return url + "/products/85520/ratings";
    }
    @Step("I set API endpoint with invalid Id for get product rating")
    public String setInvalidIdApiEndpoint() {
        return url + "/products/1/ratings";
    }

    @Step("I send request to get valid Id product rating")
    public void sendGetValidProductRatingRequest() {
        SerenityRest.given().get(setValidIdApiEndpoint());
    }
    @Step("I send request to get invalid Id product rating")
    public void sendGetInvalidProductRatingRequest() {
        SerenityRest.given().get(setInvalidIdApiEndpoint());
    }

    @Step("I receive data for product rating")
    public void receiveValidProductRating() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_RATING_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}