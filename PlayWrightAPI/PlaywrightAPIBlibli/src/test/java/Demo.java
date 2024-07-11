
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.*;

@Test
public class Demo
{
    private Playwright playWright;
    private APIRequestContext request;
    void createPlayWright(){
        playWright=Playwright.create();
    }

    @Test(priority = 1)
    public void postStorePicker()
    {
        createPlayWright();
        Map<String,String> headers=new HashMap<>();
        headers.put("x-blibli-user-email","grocerypayment@gdn-commerce.com");
        headers.put("Authorization","AT-D8A29021-6700-447A-B8EF-D862E7632AAC");
        headers.put("Content-Type", "application/json");
        request=playWright.request().newContext(new APIRequest.NewContextOptions().setBaseURL("https://wwwuatb.gdn-app.com").setExtraHTTPHeaders(headers));
        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("longitude", 106.60985939999998);
        requestBody.put("latitude", -6.2082174245348094);
        APIResponse response = request.post("backend/store-picker/api/store/nearBy", RequestOptions.create().setData(requestBody));
        System.out.println(response.status());
        System.out.println(response.statusText());
        Assert.assertEquals(200,response.status());
    }

    @Test(priority = 2)
    public void getSearch(){

        createPlayWright();
        Map<String, String> headers = new HashMap<>();
        headers.put("channelId", "ios");
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Build-No", "3457");
        request=playWright.request().newContext(new APIRequest.NewContextOptions().setBaseURL("https://wwwuatb.gdn-app.com").setExtraHTTPHeaders(headers));
        APIResponse response =request
                .get("backend/search/grocery/v1/products", RequestOptions.create()
                        .setQueryParam("sellerGroup","BLIBLI_GO")
                        .setQueryParam("storeCode","PSY-0000000250")
                        .setQueryParam("searchTerm","banana")
                        .setQueryParam("showFacet",true)
                        .setQueryParam("page",1)
                        .setQueryParam("start",0)
                        .setQueryParam("itemPerPage",24));
        System.out.println(response.text());
        Assert.assertEquals(response.status(),200);
    }

    @Test(priority = 3)
    public void addToCart()
    {
        createPlayWright();

        Map<String,String> headers = new HashMap<>();
        headers.put("Accept","application/json");
        headers.put("x-blibli-user-email","grocerypayment@gdn-commerce.com");
        headers.put("Authorization","AT-35F4A4FB-6892-4784-8AB9-730B064A948D");
        request = playWright.request().newContext(new APIRequest.NewContextOptions().setBaseURL("https://wwwuatb.gdn-app.com").setExtraHTTPHeaders(headers));

        Map<String, Object> atcData = new HashMap<>();
        atcData.put("id", "0402db278d5084d1");
        atcData.put("source", "grocery-category-BLIBLI_GO");
        Map<String, Object> itemDetails = new HashMap<>();
        itemDetails.put("merchantCode", "BLT-13446");
        itemDetails.put("quantity", 1);
        itemDetails.put("longitude", 106.9049820676446);
        itemDetails.put("id", "BLT-13446-00549-00001");
        itemDetails.put("pickupPointCode", "PP-3131278");
        itemDetails.put("latitude", -6.1613085692376801);
        itemDetails.put("instantPickup", false);
        itemDetails.put("type", "REGULAR");
        itemDetails.put("warehouseCode", "PSY-0000000250");
        Map<String, Object> orderData = new HashMap<>();
        orderData.put("atcData", atcData);
        orderData.put("items", new Map[] {itemDetails});

        APIResponse response = request.post("backend/retail/checkouts/_add",RequestOptions.create().setData(orderData)
                .setQueryParam("sellerGroup","BLIBLI_GO"));

        System.out.println(response.text());
        Assert.assertEquals(400,response.status());
    }

    @Test(priority = 4)
    public  void checkOut()
    {
        createPlayWright();

        Map<String,String> headers = new HashMap<>();
        headers.put("Accept","application/json");
        headers.put("Authorization","bearer AT-A70B894C-3518-4B3D-B242-A7FA65C43EEE");
        headers.put("x-sessionid","84FB8E63-EED7-49CF-ACF1-EC8D3A1CC15B");
        headers.put("x-requestId","8EB783D8-56B2-4AFA-9903-859D74D1639B-14252-0000424F692699BB");
        headers.put("x-blibli-user-email","grocerypayment@gdn-commerce.com");

        request = playWright.request().newContext(new APIRequest.NewContextOptions().setBaseURL("https://wwwuatb.gdn-app.com").setExtraHTTPHeaders(headers));

        Map<String,Object> checkOutRequestBody = new HashMap<>();
        checkOutRequestBody.put("longitude","106.9731458");
        checkOutRequestBody.put("latitude","-6.1817719017200528");

        APIResponse response = request.post("backend/retail/checkouts/_summary",RequestOptions.create().setData(checkOutRequestBody)
                .setQueryParam("sellerGroup","BLIBLI_GO"));

        System.out.println(response.text());
        Assert.assertEquals(200,response.status());
    }

    @Test(priority = 5)
    public void getPayment()
    {
        createPlayWright();

        Map<String,String> headers = new HashMap<>();
        headers.put("Accept","application/json");
        headers.put("x-blibli-user-email","grocerypayment@gdn-commerce.com");
        headers.put("Authorization","AT-35F4A4FB-6892-4784-8AB9-730B064A948D");
        request = playWright.request().newContext(new APIRequest.NewContextOptions().setBaseURL("https://wwwuatb.gdn-app.com").setExtraHTTPHeaders(headers));

        APIResponse response = request.get("backend/retail/checkouts/668f790347b1422f3434d41f/payments",RequestOptions.create()
                .setQueryParam("sellerGroup","BLIBLI_GO"));

        System.out.println(Arrays.toString(response.body()));
        Assert.assertEquals(200,response.status());
    }

    @Test(priority = 6)
    public void thankYouPage()
    {
        createPlayWright();
        Map<String,String> headers  = new HashMap<>();
        headers.put("Authorization","AT-A70B894C-3518-4B3D-B242-A7FA65C43EEE");
        headers.put("Accept","application/json");
        headers.put("x-blibli-user-email","grocerypayment@gdn-commerce.com");

        request = playWright.request().newContext(new APIRequest.NewContextOptions().setBaseURL("https://wwwuatb.gdn-app.com").setExtraHTTPHeaders(headers));

        APIResponse response = request.get("backend/retail/orders/27006458170",RequestOptions.create());
        Assert.assertEquals(200,response.status());
    }
}