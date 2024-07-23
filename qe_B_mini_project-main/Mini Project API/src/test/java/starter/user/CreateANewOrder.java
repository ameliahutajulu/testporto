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
public class CreateANewOrder {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for create a new order")
    public String setApiEndpoint() {
        return url + "/orders";
    }

    @Step("I send request to create a new order with valid inputs")
    public void sendCreateAValidOrderRequest() {
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("product_id", 2);
        jsonObject.put("quantity", 1);

        jsonArray.put(jsonObject);
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(jsonArray.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive data for created order")
    public void receiveValidOrder() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_VALID_ORDER_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("I send request to create a new order with invalid Product Id")
    public void sendCreateAInvalidProductIdOrderRequest() {
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("product_id", "2");
        jsonObject.put("quantity", 1);

        jsonArray.put(jsonObject);
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(jsonArray.toString())
                .post(setApiEndpoint());
    }

    @Step("I send request to create a new order with invalid quantity")
    public void sendCreateAInvalidQuantityOrderRequest() {
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("product_id", 2);
        jsonObject.put("quantity", "1");

        jsonArray.put(jsonObject);
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(jsonArray.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive error create order")
    public void receiveErrorCreateOrder() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_INVALID_ORDER_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

}
