//import com.microsoft.playwright.APIRequest;
//import com.microsoft.playwright.APIRequestContext;
//import com.microsoft.playwright.APIResponse;
//import com.microsoft.playwright.Playwright;
//import com.microsoft.playwright.options.RequestOptions;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Demo {
//    private Playwright playWright;
//    private APIRequestContext request;
//    void createPlayWright(){
//        playWright=Playwright.create();
//    }
////    int brandID;
////    String productTypeCode="PHONE_CREDIT";
////    String cartID="40d5edd5-25b7-4ff7-8ddf-dd327916cce5@blibli";
////    String defaultProviderId;
////    String defaultProviderName;
////    String skuCode;
////    String paymentMethod;
//
//    void createAPIRequestContext(String url){
//        Map<String,String> headers=new HashMap<>();
//        headers.put("accept","application/json");
//        headers.put("Content-Type","application/json");
//        request=playWright.request().newContext(new APIRequest.NewContextOptions().setBaseURL(url).setExtraHTTPHeaders(headers));
//
//    }
//
//    @Test(priority = 1)
//    public void getItemMapping(){
//
//        createPlayWright();
//        Map<String,String> headers=new HashMap<>();
//        headers.put("accept","application/json");
//        headers.put("Content-Type","application/json");
//        request=playWright.request().newContext(new APIRequest.NewContextOptions().setBaseURL().setExtraHTTPHeaders(headers));
//
//        createAPIRequestContext("http://digital-catalog.qa2-sg.cld/digital-catalog/");
//
//        APIResponse response=request
//                .get("api/itemMapping/findAll", RequestOptions.create().setQueryParam("storeId",10001).setQueryParam("requestId","RANDOM").setQueryParam("channelId","pulsa-web").setQueryParam("clientId","pulsa").setQueryParam("username","username"));
//
//        JSONObject jsonResponse = new JSONObject(response.text());
//        JSONArray contentArray = jsonResponse.getJSONArray("content");
//        for (int i = 0; i < contentArray.length(); i++) {
//            JSONObject item = contentArray.getJSONObject(i);
//            JSONObject brand = item.getJSONObject("brand");
//            JSONObject productType = item.getJSONObject("productType");
//            if ("PHONE_CREDIT".equals(productType.getString("productTypeCode")) &&
//                    "Indosat".equals(brand.getString("brandName"))) {
//                System.out.println("brandId: " + brand.getInt("brandId"));
//                brandID=brand.getInt("brandId");
//            }
//        }
//
//    }
//
//    @Test(priority = 2)
//    public void GetDefaultProviderId(){
//        createPlayWright();
//        createAPIRequestContext("http://digital-catalog.qa2-sg.cld/digital-catalog/");
//        APIResponse response=request
//                .get("api/itemMapping/findOne", RequestOptions.create().setQueryParam("storeId",10001).setQueryParam("requestId","RANDOM").setQueryParam("channelId","pulsa-web").setQueryParam("clientId","pulsa").setQueryParam("username","username").setQueryParam("brandId",brandID).setQueryParam("productTypeCode",productTypeCode));
//
//        JSONObject jsonResponse = new JSONObject(response.text());
//        JSONObject value = jsonResponse.getJSONObject("value");
//        defaultProviderId = value.getString("defaultProviderId");
//        defaultProviderName = value.getString("defaultProviderName");
//        System.out.println("Default Provider Id :"+defaultProviderId);
//        System.out.println("Default Provider Name :"+defaultProviderName);
//    }
//
//    @Test(priority = 3)
//    public void SaveItemMapping(){
//        createPlayWright();
//        createAPIRequestContext("http://digital-catalog.qa2-sg.cld/digital-catalog/");
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("active", true);
//        requestBody.put("autoSwitch", "false");
//        requestBody.put("brandId", 4);
//        requestBody.put("defaultProviderId", "BLP-25978");
//        requestBody.put("defaultProviderName", "NARINDO");
//        requestBody.put("msisdn", "0814,0815,0816,0855,0856,0857,0858");
//        requestBody.put("productTypeCode", "PHONE_CREDIT");
//
//        APIResponse response=request
//                .post("api/itemMapping/save", RequestOptions.create().setQueryParam("storeId", 10001)
//                        .setQueryParam("requestId", "RANDOM")
//                        .setQueryParam("channelId", "pulsa-web")
//                        .setQueryParam("clientId", "pulsa")
//                        .setQueryParam("username", "username")
//                        .setData(requestBody.toString()));
//
//        Assert.assertEquals(response.status(), 200, "Expected status code 200 OK");
//        String jsonResponse = response.text();
//        System.out.println("-------save Item Mapping------- \n"+jsonResponse);
//        Assert.assertTrue(jsonResponse.contains("\"requestId\":\"RANDOM\""), "Response should contain requestId");
//        Assert.assertTrue(jsonResponse.contains("\"success\":true"), "Response should indicate success");
//        Assert.assertTrue(jsonResponse.contains("\"defaultProviderId\":\"BLP-25978\""), "Response should contain defaultProviderId");
//        Assert.assertTrue(jsonResponse.contains("\"defaultProviderName\":\"NARINDO\""), "Response should contain defaultProviderName");
//        Assert.assertTrue(jsonResponse.contains("\"productTypeCode\":\"PHONE_CREDIT\""), "Response should contain productTypeCode");
//
//    }
//
//
//    @Test(priority = 4)
//    public void deleteExistingCart(){
//        createPlayWright();
//        createAPIRequestContext("http://x-pulsa.qa2-sg.cld/x-pulsa/api/");
//        APIResponse response=request.
//                delete("pulsaCart/deletePulsaCart",RequestOptions.create()
//                        .setQueryParam("storeId", 10001)
//                        .setQueryParam("requestId", "RANDOM")
//                        .setQueryParam("channelId", "pulsa-web")
//                        .setQueryParam("clientId", "pulsa")
//                        .setQueryParam("username", "username")
//                        .setQueryParam("cartId",cartID));
//        System.out.println(response.text());
//        Assert.assertEquals(response.status(), 200, "Expected status code 200 OK");
//    }
//
//    @Test(priority = 5)
//    public void getSkuCode(){
//        createPlayWright();
//        createAPIRequestContext("http://digital-catalog.qa2-sg.cld/digital-catalog/");
//
//        APIResponse response=request
//                .get("api/merchantDigitalSku/getProductListByFilter", RequestOptions.create().setQueryParam("storeId",10001).setQueryParam("requestId","RANDOM").setQueryParam("channelId","pulsa-web").setQueryParam("clientId","pulsa").setQueryParam("username","username")
//                        .setQueryParam("productType","PHONE_CREDIT").setQueryParam("brandName","Indosat"));
//        JSONObject jsonResponse = new JSONObject(response.text());
//        JSONArray contentArray = jsonResponse.getJSONArray("content");
//
//        for (int i = 0; i < contentArray.length(); i++) {
//            JSONObject product = contentArray.getJSONObject(i);
//            JSONObject digitalProduct = product.getJSONObject("digitalProduct");
//            String internalName = digitalProduct.optString("internalName");
//
//            if ("Umroh Haji Internet 45hr".equals(internalName)) {
//                JSONArray merchantSkuList = product.getJSONArray("merchantDigitalSkuList");
//                if (!merchantSkuList.isEmpty()) {
//                    JSONObject merchantSku = merchantSkuList.getJSONObject(0);
//                    skuCode = merchantSku.optString("skuCode");
//                    break;
//                }
//            }
//        }
//        System.out.println(skuCode);
//    }
//
//    @Test(priority = 6)
//    public void doCheckOut(){
//        createPlayWright();
//        createAPIRequestContext("http://x-pulsa.qa2-sg.cld/x-pulsa/api/");
//        APIResponse response= request
//                .post("pulsaCart/doCheckout",RequestOptions.create()
//                        .setQueryParam("storeId", 10001)
//                        .setQueryParam("requestId", "RANDOM")
//                        .setQueryParam("channelId", "pulsa-web")
//                        .setQueryParam("clientId", "pulsa")
//                        .setQueryParam("username", "username")
//                        .setQueryParam("cartId",cartID)
//                        .setQueryParam("customerLogonId",cartID)
//                        .setQueryParam("cartOwnershipType","MEMBER"));
//        System.out.println(response.text());
//        Assert.assertEquals(response.status(), 200, "Expected status code 200 OK");
//    }
//
//    @Test(priority = 7)
//    public void setPulsaCart(){
//        HashMap<String,Object> reqBody= new HashMap<>();
//        reqBody.put("itemSku",skuCode);
//        reqBody.put("operatorCode","Indosat");
//        reqBody.put("providerName",defaultProviderName);
//
//        createPlayWright();
//        createAPIRequestContext("http://x-pulsa.qa2-sg.cld/x-pulsa/api/");
//        APIResponse response= request
//                .post("pulsaCart/setPulsaCartMsisdn",RequestOptions.create()
//                        .setQueryParam("storeId", 10001)
//                        .setQueryParam("requestId", "RANDOM")
//                        .setQueryParam("channelId", "pulsa-web")
//                        .setQueryParam("clientId", "pulsa")
//                        .setQueryParam("username", "username")
//                        .setQueryParam("cartId",cartID)
//                        .setQueryParam("msisdn","085765160652")
//                        .setQueryParam("productType",productTypeCode)
//                        .setData(reqBody));
//        System.out.println(response.text());
//
//    }
//
//    @Test(priority =8)
//    public void addToCart(){
//        HashMap<String,Object> reqBody= new HashMap<>();
//        reqBody.put("productType",productTypeCode);
//        reqBody.put("itemSku","BLP-25978-XDP-0007904");
//        reqBody.put("cartId",cartID);
//        reqBody.put("operatorName","Indosat");
//        reqBody.put("deviceId","00d57723-464d-455b-ab81-1cd22f4dda31");
//
//        createPlayWright();
//        createAPIRequestContext("http://x-pulsa.qa2-sg.cld/x-pulsa/api/");
//        APIResponse response= request
//                .post("pulsaCart/addToCart",RequestOptions.create()
//                        .setQueryParam("storeId", 10001)
//                        .setQueryParam("requestId", "RANDOM")
//                        .setQueryParam("channelId", "pulsa-web")
//                        .setQueryParam("clientId", "pulsa")
//                        .setQueryParam("username", "username")
//                        .setData(reqBody));
//
//        System.out.println(response.text());
//
//    }
//
//    @Test(priority = 9)
//    public void changePaymentMethod(){
//        createPlayWright();
//        createAPIRequestContext("http://x-pulsa.qa2-sg.cld/x-pulsa/api/");
//        APIResponse response= request
//                .post("pulsaCart/changePayment",RequestOptions.create()
//                        .setQueryParam("storeId", 10001)
//                        .setQueryParam("requestId", "RANDOM")
//                        .setQueryParam("channelId", "pulsa-web")
//                        .setQueryParam("clientId", "pulsa")
//                        .setQueryParam("username", "username")
//                        .setQueryParam("cartId",cartID)
//                        .setQueryParam("paymentMethod",paymentMethod));
//
//        System.out.println(response.text());
//    }
//
//
//
//}
//