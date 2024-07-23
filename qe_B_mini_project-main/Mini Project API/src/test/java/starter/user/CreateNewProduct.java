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

public class CreateNewProduct {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for create new product")
    public String setApiEndpoint() {
        return url + "/products";
    }

    @Step("I send request to create new product with valid inputs")
    public void sendCreatenewProductRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Sony PS5");
        requestBody.put("description", "play has no limits");
        requestBody.put("price", 299);

        JSONArray categories = new JSONArray();
        categories.put(1);

        requestBody.put("categories", categories);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive valid data for create new product")
    public void receiveValidCreatenewProduct() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_PRODUCT_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
