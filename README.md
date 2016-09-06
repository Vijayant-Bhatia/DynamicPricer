# DynamicPricer

Below are the steps in order to run the project:

1.  Download the zip file of the project and extract it.
2.  Import the project as existing maven project.
3.  Java version 8 is used in the project, so use that only as i have used some features of java 8.
4.  Run jUnit test cases in order to test the application.
5.  Run the Application.java as Java application
6.  On any Rest client run below url with specified method types

In order to run the rules dynamically on different servers: <br/>
1.  Add the argument --spring.config.location=file:{some-location-of your-property-file}/application.properties <br/>
2.  In application.properties file specify the rule.directory in which you are putting the ProductIdealPriceRule.js, which contains the formula for calculating the ideal price. <br/>
3.  And then run the Application.java application. <br/>

-------------------------------------------------------------------------------------------------------------
Functionality: For Fetching all the ProductsPrices. <br/>
Method Type : "GET" url : http://localhost:8080/productSurvey

-------------------------------------------------------------------------------------------------------------
Functionality: For Fetching all the Products. <br/>
Method Type : "GET" url : http://localhost:8080/product

-------------------------------------------------------------------------------------------------------------
Functionality: For Fetching ProductsPrice by product survey id. <br/>
Method Type : "GET" url : http://localhost:8080/productSurvey/{id}

-------------------------------------------------------------------------------------------------------------
Functionality: For Fetching the Product by Id. <br/>
Method Type : "GET" url : http://localhost:8080/product/{id}

-------------------------------------------------------------------------------------------------------------
Functionality: For saving the Product. <br/>
Method Type : "GET" url : http://localhost:8080/product <br/>
Headers : Content-Type : application/json and Accept : application/json <br/>
JSON Request :{"barcode": "B1234ETY454", "name": "Test Product 1"}

-------------------------------------------------------------------------------------------------------------
Functionality: For Saving ProductsPrice by product survey id. <br/>
Method Type : "POST" url : http://localhost:8080/productSurvey <br/>
Headers : Content-Type : application/json and Accept : application/json <br/>
JSON Request : {"productId": 1, "storeName": "Store 1", "price": "25.7", "notes": "Test notes"}

-------------------------------------------------------------------------------------------------------------
Functionality: For Getting product price details by barcode <br/>
Method Type : "GET" url : http://localhost:8080/getProductPriceDetails/B12A333434 

