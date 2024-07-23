package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class GetCategoryById {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint with valid Id for get category")
    public String setValidIdApiEndpoint() {
        return url + "/categories/29716";
    }
    @Step("I set API endpoint with invalid Id for get category")
    public String setInvalidIdApiEndpoint() {
        return url + "/categories/1";
    }

    @Step("I send request to get valid Id category")
    public void sendGetValidCategoryRequest() {
        SerenityRest.given().get(setValidIdApiEndpoint());
    }
    @Step("I send request to get invalid Id category")
    public void sendGetInvalidCategoryRequest() {
        SerenityRest.given().get(setInvalidIdApiEndpoint());
    }

    @Step("I receive valid data for category")
    public void receiveValidCategoryData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_CATEGORY_BY_VALID_ID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I receive error for category")
    public void receiveInvalidCategoryError() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_CATEGORY_BY_INVALID_ID_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
