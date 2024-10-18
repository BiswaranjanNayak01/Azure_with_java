Feature: creating java libraries for Azure Sql Database.

  @test
  Scenario: first test
    Given test print

    @test
    Scenario: Get Databases
      Given Set databaseName ""
      And Set resourceGroupName ""
      And Set schemaName ""
      And Set serverName ""
      And Set subscriptionId ""
      And Set tableName ""
      Given Database url
      When Get method
      Then Print the response body