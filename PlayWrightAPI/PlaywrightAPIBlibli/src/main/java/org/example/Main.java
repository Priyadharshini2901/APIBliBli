package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
            //        Assert.assertEquals("Status code should be 200", 200, response.status());
//        String responseBody = response.text();
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonNode = mapper.readTree(responseBody);
//
//        Assert.assertEquals("Response code should be 200", 200, jsonNode.get("code").asInt());
//        Assert.assertEquals("Response status should be OK", "OK", jsonNode.get("status").asText());
//
//        JsonNode dataArray = jsonNode.get("data");
//        Assert.assertNotNull("Data should not be null", dataArray);
//        Assert.assertTrue("Data should be an array", dataArray.isArray());
//
//        for (JsonNode item : dataArray) {
//            String groupName = item.get("groupName").asText();
//            switch (groupName) {
//                case "BLIBLI_GO":
//                    Assert.assertEquals("Group display name should be Fresh by Bliblimart", "Fresh by Bliblimart", item.get("groupDisplayName").asText());
//                    Assert.assertEquals("Group type should be WAREHOUSE", "WAREHOUSE", item.get("groupType").asText());
//                    Assert.assertEquals("Code should be MOD-0000000001", "MOD-0000000001", item.get("code").asText());
//                    Assert.assertTrue("Available should be true", item.get("available").asBoolean());
//                    Assert.assertFalse("Selected should be false", item.get("selected").asBoolean());
//                    break;
//                case "Automation":
//                    Assert.assertEquals("Group display name should be QAAutomation", "QAAutomation", item.get("groupDisplayName").asText());
//                    Assert.assertEquals("Group type should be STORE", "STORE", item.get("groupType").asText());
//                    Assert.assertFalse("Available should be false", item.get("available").asBoolean());
//                    Assert.assertFalse("Selected should be false", item.get("selected").asBoolean());
//                    break;
//                case "testing1":
//                    Assert.assertEquals("Group display name should be qatesting", "qatesting", item.get("groupDisplayName").asText());
//                    Assert.assertEquals("Group type should be STORE", "STORE", item.get("groupType").asText());
//                    Assert.assertFalse("Available should be false", item.get("available").asBoolean());
//                    Assert.assertFalse("Selected should be false", item.get("selected").asBoolean());
//                    break;
//                default:
//                    Assert.fail("Unexpected groupName: " + groupName);
//            }
//        }

//import com.microsoft.playwright.APIRequest;
//import com.microsoft.playwright.APIRequestContext;
//import com.microsoft.playwright.Playwright;
//import org.testng.annotations.Test;
//import java.util.*;
//
//@Test
//public class BliBliAPI {
//    private Playwright playwright;
//    private APIRequestContext apiRequestContext;
//    public String baseUrl = "";
//
//    void createPlayWright() {
//        playwright = Playwright.create();
//    }
//     //        headers.put("x-userid", "E1721345-5009-4F99-AA54-276DB8B7FB17");
////        headers.put("User-Agent", "BliBliMobile/11.4.0(3457) E1721345-5009-4F99-AA54-276DB8B7FB17 (x86_64; iOS 15.2; Scale/3.00)");
//        //        headers.put("Authorization", "AT-3D551498-ACC1-4E48-8237-E98BCC19DEAC");
////        headers.put("x-sessionid", "977D7A1B-F6BD-4F4A-8C39-CCD105F09428");
////        headers.put("x-requestId", "1200C72A-ACAE-495A-A0EC-3DD8F0463705-8182-0000C1A289EC90F5");
////        headers.put("x-blibli-user-email", "grocerypayment@gdn-commerce.com");
////        headers.put("Accept-Language", "id");
////        headers.put("Accept-Encoding", "gzip, deflate, br");
//    void createAPIRequestContext( ) {
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Accept", "application/json");
//        headers.put("x-blibli-user-email","grocerypayment@gdn-commerce.com");
//        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions().setBaseURL(baseUrl).setExtraHTTPHeaders(headers));
//    }
//
//}
//
//}
//
//    @BeforeAll
//    public void setUp() {
//
//    }
//
//    @After
//    public void tearDown() {
//        if (playWright != null) {
//            playWright.close();
//        }
//    }

        }
    }
}