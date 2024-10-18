package azureRestApi.azure_sql_database.stepDef;

import azureRestApi.azure_sql_database.page.SqlDatabaseRestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SqlDatabaseRestApiStep extends SqlDatabaseRestApi {
    public static String subscriptionId;
    public static String resourceGroupName;
    public static String serverName;
    public static String databaseName;
    public static String schemaName;
    public static String tableName;

    @Given("test print")
    public void print(){
        test();
    }
    //--------------------------------------------------------------------------------------------------
    @Given("Set subscriptionId {string}")
    public void subscriptionId(String subscriptionId1){
        subscriptionId=subscriptionId1;
    }
    @Given("Set resourceGroupName {string}")
    public void resourceGroupName(String subscriptionId1){
        resourceGroupName=subscriptionId1;
    }
    @Given("Set serverName {string}")
    public void serverName(String subscriptionId1){
        serverName=subscriptionId1;
    }
    @Given("Set databaseName {string}")
    public void databaseName(String subscriptionId1){
        databaseName=subscriptionId1;
    }
    @Given("Set schemaName {string}")
    public void schemaName(String subscriptionId1){
        schemaName=subscriptionId1;
    }
    @Given("Set tableName {string}")
    public void tableName(String subscriptionId1){
        tableName=subscriptionId1;
    }
    @Given("Database table url")
    public void database_table_url(){
        setUrl("https://management.azure.com/subscriptions/{"+subscriptionId+"}/resourceGroups/{"+resourceGroupName+"}/providers/Microsoft.Sql/servers/{"+serverName+"}/databases/{"+databaseName+"}/schemas/{"+schemaName+"}/tables/{"+tableName+"}?api-version=2021-11-01");
    }
    @Given("Database url")
    public void databases_url(){
        setUrl("https://management.azure.com/subscriptions/{"+subscriptionId+"}/resourceGroups/{"+resourceGroupName+"}/providers/Microsoft.Sql/servers/{"+serverName+"}/databases/{"+databaseName+"}?api-version=2021-11-01");
    }
    @When("Post method")
    public void postMethod(){
        postRequest();
    }
    @When("Get method")
    public void getMethod(){
        getRequest();
    }
    @When("Put method")
    public void putMethod(){
        putRequest();
    }
    @Then("Print the response body")
    public void printResponseBody(){
        getResponseBody();
    }
}
