package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
public class GetAllOrders {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for get all orders")
    public String setApiEndpoint() {
        return url + "/orders";
    }

    @Step("I send request to get all orders")
    public void sendGetAllOrdersRequest() {
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setApiEndpoint());
    }

    @Step("I receive valid data for all orders")
    public void receiveValidOrdersData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ORDERS_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
