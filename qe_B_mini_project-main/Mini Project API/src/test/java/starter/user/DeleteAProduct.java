package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAProduct {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint with valid Id for delete product")
    public String setValidIdApiEndpoint() {
        return url + "/products/85539";
    }

    @Step("I set API endpoint with invalid Id for delete product")
    public String setInvalidIdApiEndpoint() {
        return url + "/products/1";
    }

    @Step("I set API endpoint with Undefined Id for delete product")
    public String setUndefinedIdApiEndpoint() {
        return url + "/products";
    }

    @Step("I send request to delete product with valid ID")
    public void sendDeleteValidProductRequest() {
        SerenityRest.given().delete(setValidIdApiEndpoint());
    }

    @Step("I send request to delete product with invalid ID")
    public void sendDeleteInvalidProductRequest() {
        SerenityRest.given().delete(setInvalidIdApiEndpoint());
    }

    @Step("I send request to delete product with Undefined ID")
    public void sendDeleteUndefinedProductRequest() {
        SerenityRest.given().delete(setUndefinedIdApiEndpoint());
    }

    @Step("I receive status code 405")
    public void receiveStatusCode405() {
        restAssuredThat(response -> response.statusCode(405));
    }

    @Step("I receive deleted product data")
    public void receiveValidDeleteProduct() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.DELETE_A_PRODUCT_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
