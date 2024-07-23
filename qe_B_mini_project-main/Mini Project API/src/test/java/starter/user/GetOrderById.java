package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class GetOrderById {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint with valid Id for get order")
    public String setValidIdApiEndpoint() {
        return url + "/orders/11925";
    }

    @Step("I set API endpoint with invalid Id for get order")
    public String setInvalidIdApiEndpoint() {
        return url + "/orders/1";
    }

    @Step("I send request to get valid Id order")
    public void sendGetValidOrderRequest() {
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setValidIdApiEndpoint());
    }
    @Step("I send request to get invalid Id order")
    public void sendGetInvalidOrderRequest() {
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setInvalidIdApiEndpoint());
    }

    @Step("I receive valid data for order")
    public void receiveValidOrderData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ORDER_BY_VALID_ID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I receive error for order")
    public void receiveInvalidOrderError() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ORDER_BY_INVALID_ID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
