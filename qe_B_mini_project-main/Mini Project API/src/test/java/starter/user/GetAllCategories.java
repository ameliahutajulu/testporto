package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
public class GetAllCategories {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for get all categories")
    public String setApiEndpoint() {
        return url + "/categories";
    }

    @Step("I send request to get all categories")
    public void sendGetAllCategoriesRequest() {
        SerenityRest.given().get(setApiEndpoint());
    }

    @Step("I receive valid data for all categories")
    public void receiveValidCategoriesData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CATEGORIES_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
