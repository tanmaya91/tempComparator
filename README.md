This project does the following tests.
1. Navigate to weather page of NDTV.com and fetched the weather details of a city.
2. Fetches the temperature details of city via openAPi weather endpoint.
3. Compares the temperature values of the city from UI and from from API.

The UI tests are available in com.uiTests package.
The API tests are available in the com.apiTests package.
The comparison test is available in the com.comparison package.

The file \src\test\resources\testData\data.properties contains configurable data.

Steps to run:
1. Import the project.
2. Select the project >> run as >> Maven Install.
3. Do maven >> update project.
4. Run the testng.xml as testng suite.

