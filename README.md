# pintutest
## Maven
Add the following dependency to your pom.xml:
```
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.5.0</version>
    <scope>test</scope>
</dependency>
```

## Before we begin, you will need the following:

- [Java SE](https://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html)
- A build tool. You can choose between:
  - [Maven](https://maven.apache.org/index.html) - version 3.3.1 or higher
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (which will be used in this tutorial)
  - [IntelliJ IDEA Cucumber for Java plugin](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java)
- [Eclipse](https://www.eclipse.org/) (a good alternative if you don’t use IntelliJ)
  - [Cucumber Eclipse](https://cucumber.github.io/cucumber-eclipse/)
  
## Android Automation test
need to adjust the capabilities before running the android automation test
```
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("platformVersion", "11");
  capabilities.setCapability("deviceName", "emulator-5554");
  capabilities.setCapability("app", "/Users/koryanggraeni/test/apk/Tes_v4.apk");
```

## Running test

| action                  | command                                           |
|-------------------------|---------------------------------------------------|
| run all test cases      | `mvn test`                                        |
| run specific test case  | `mvn test -Dcucumber.filter.tags="@tags"`         |
| run api test case       | `mvn test -Dcucumber.filter.tags="@testapi"`      |
| run android test case   | `mvn test -Dcucumber.filter.tags="@androidTest"`  |


## Folder Structure
For your convenient please put the file based on the folder structure.

```
├── src
│   ├── main
│   │    ├── java
│   │    │    ├── setup
│   │    ├── resources
│   │    │    
│   ├── test
│   │    ├── java
│   │    │    ├── pintutest
│   │    ├── resources
│   │    │    ├── pintutest
```
