package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
public class DeleteACategory {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint with valid Id for delete category")
    public String setValidIdApiEndpoint() {
        return url + "/categories/29732";
    }

    @Step("I set API endpoint with invalid Id for delete category")
    public String setInvalidIdApiEndpoint() {
        return url + "/categories/1";
    }

    @Step("I set API endpoint with Undefined Id for delete category")
    public String setUndefinedIdApiEndpoint() {
        return url + "/categories";
    }

    @Step("I send request to delete category with valid ID")
    public void sendDeleteValidCategoryRequest() {
        SerenityRest.given().delete(setValidIdApiEndpoint());
    }

    @Step("I send request to delete category with invalid ID")
    public void sendDeleteInvalidCategoryRequest() {
        SerenityRest.given().delete(setInvalidIdApiEndpoint());
    }

    @Step("I send request to delete category with Undefined ID")
    public void sendDeleteUndefinedCategoryRequest() {
        SerenityRest.given().delete(setUndefinedIdApiEndpoint());
    }

    @Step("I receive deleted category data")
    public void receiveValidDeleteCategory() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.DELETE_A_CATEGORY_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
