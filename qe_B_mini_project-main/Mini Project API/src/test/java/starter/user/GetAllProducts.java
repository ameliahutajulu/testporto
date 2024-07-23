package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllProducts {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for get all products")
    public String setApiEndpoint() {
        return url + "/products";
    }

    @Step("I send request to get all products")
    public void sendGetAllProductsRequest() {
        SerenityRest.given().get(setApiEndpoint());
    }

    @Step("I receive status code 200")
    public void receiveStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for all products")
    public void receiveValidProductsData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
