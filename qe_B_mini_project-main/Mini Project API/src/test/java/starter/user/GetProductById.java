package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class GetProductById {
        private static String url = "https://altashop-api.fly.dev/api";

        @Step("I set API endpoint with valid Id for get product")
        public String setValidIdApiEndpoint() {
            return url + "/products/85539";
        }
        @Step("I set API endpoint with invalid Id for get product")
        public String setInvalidIdApiEndpoint() {
            return url + "/products/1";
        }

        @Step("I send request to get valid Id product")
        public void sendGetValidProductRequest() {
            SerenityRest.given().get(setValidIdApiEndpoint());
        }
        @Step("I send request to get invalid Id product")
        public void sendGetInvalidProductRequest() {
            SerenityRest.given().get(setInvalidIdApiEndpoint());
        }

        @Step("I receive status code 404")
        public void receiveStatusCode404() {
            restAssuredThat(response -> response.statusCode(404));
        }

        @Step("I receive valid data for product")
        public void receiveValidProductData() {
            JsonSchemaHelper helper = new JsonSchemaHelper();
            String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_BY_VALID_ID_SCHEMA);
            restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        }
        @Step("I receive error for product")
        public void receiveInvalidProductError() {
            JsonSchemaHelper helper = new JsonSchemaHelper();
            String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_BY_INVALID_ID_SCHEMA);
            restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

