# DynamicPricer

Below are the steps in order to run the project:

1.  Download the zip file of the project and extract it.
2.  Import the project as existing maven project.
3.  Run jUnit test cases in order to test the application.
4.  Run the Application.java as Java application
5.  On any Rest client run below url with specified method types

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

