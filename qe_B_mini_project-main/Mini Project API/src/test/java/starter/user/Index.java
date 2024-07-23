package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.GenerateToken;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class Index {
    private static String url = "https://altashop-api.fly.dev/api";

    @Step("I set API endpoint for get hello Index")
    public String setApiEndpoint() {
        return url + "/hello";
    }

    @Step("I send request to get hello Index")
    public void sendGetIndexRequest() {SerenityRest.given().get(setApiEndpoint());}

    @Step("I receive valid data for hello Index")
    public void receiveIndexHello() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INDEX_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
