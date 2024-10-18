package azureRestApi.azure_sql_database.page;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class SqlDatabaseRestApi {
    RequestSpecification requestSpecification;
    Response response;

//-----------------------------------
    public void test(){
        System.out.println("My name is Biswaranjan 8888");
    }
    //----------------------------
    public void setUrl(String url) {
        RestAssured.baseURI = url;
    }

    public void setHeader(String key, String value) {
        requestSpecification = given().header(key, value);
    }

    public void setRequestBody(Object requestBody) {
        requestSpecification.body(requestBody);
    }

    public void postRequest() {
        response = requestSpecification.when().post();
    }

    public void getRequest() {
        response = requestSpecification.when().get();
    }

    public void putRequest() {
        response = requestSpecification.when().put();
    }

    public void patchRequest() {
        response = requestSpecification.when().patch();
    }

    public void getResponseStatusCode() {
        System.out.println(response.getStatusCode());
    }

    public void getResponseBody() {
        response.then().log().all();
    }

}
