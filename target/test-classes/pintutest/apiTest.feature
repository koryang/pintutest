@apitest
Feature: API automation

  @get
  Scenario: GET - /posts
    Given client set host
    When client send a GET endpoint "/posts"
    Then response "userId" should be "integer"
    And response "id" should be "integer"
    And response "title" should be "string"
    And response "body" should be "string"

  @post
  Scenario: Post - /posts
    Given client set host
    And client set body "title" with "recommendation" as "string"
    And client set body "body" with "motorcycle" as "string"
    And client set body "userId" with "12" as "integer"
    When client send a POST endpoint "/posts"
    Then response "title" should matching "recommendation"
    And response "body" should matching "motorcycle"
    And response "userId" should matching "12"
