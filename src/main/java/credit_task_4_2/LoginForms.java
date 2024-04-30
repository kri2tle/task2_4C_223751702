package credit_task_4_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class LoginForms {
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void bypassCloudfare(WebDriver driver) {
		String cloudfareCookies = "[{\"domain\":\"www.bunnings.com.au\",\"hostOnly\":true,\"httpOnly\":false,\"name\":\"resPass\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":true,\"storeId\":null,\"value\":\"https://login.bunnings.com.au/oauth2/v1/authorize/redirect?okta_key=mEs7aDXBPHXDv_4z1lk1yn7dJsK9xc70--pdVyreXII\"},{\"domain\":\".bunnings.com.au\",\"expirationDate\":1714510974.102045,\"hostOnly\":false,\"httpOnly\":true,\"name\":\"__cf_bm\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"yoMeB1zHyeC2er7AHwzUoWDvK9yboD6s1rUBKR2Xc3s-1714509177-1.0.1.1-z.eNcOiERURCi7JiG0v6Bo6mLhJOqe0Ulj6I.KXUk0IRnmM5aSUlo4mo7iB5Ks1TFddmUyUMgUTrtloJm9OjJ1Z2eYqPNJD0F1D671XqkiI\"},{\"domain\":\"www.bunnings.com.au\",\"expirationDate\":1715113974.456271,\"hostOnly\":true,\"httpOnly\":false,\"name\":\"defaultRegionCode\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"VICMetro\"},{\"domain\":\"www.bunnings.com.au\",\"expirationDate\":1714510855.16338,\"hostOnly\":true,\"httpOnly\":true,\"name\":\"AccessTokenCookie\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"%7B%22tokenvalue%22%3A%22973bc728-04ab-49b8-a1b7-a992a3a568f8-1714509179%22%2C%22lastchecktime%22%3A%224%2F30%2F2024%208%3A33%3A01%20PM%22%7D\"},{\"domain\":\"www.bunnings.com.au\",\"hostOnly\":true,\"httpOnly\":false,\"name\":\"uSessionId\",\"path\":\"/\",\"sameSite\":null,\"secure\":true,\"session\":true,\"storeId\":null,\"value\":\"d3c2fa50-0730-11ef-9802-7928a33a9354\"},{\"domain\":\"www.bunnings.com.au\",\"hostOnly\":true,\"httpOnly\":false,\"name\":\"returningVisitor\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":true,\"storeId\":null,\"value\":\"true\"},{\"domain\":\"www.bunnings.com.au\",\"expirationDate\":1730061965.847477,\"hostOnly\":true,\"httpOnly\":false,\"name\":\"Bunnings.Platform\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"V2\"},{\"domain\":\"www.bunnings.com.au\",\"expirationDate\":1714941176,\"hostOnly\":true,\"httpOnly\":false,\"name\":\"guest-token-storage\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"{\\\"expires\\\":1714941176670,\\\"s\\\":432000,\\\"token\\\":\\\"eyJhbGciOiJSUzI1NiIsImtpZCI6IkJGRTFEMDBBRUZERkVDNzM4N0E1RUFFMzkxNjRFM0MwMUJBNzVDODciLCJ4NXQiOiJ2LUhRQ3VfZjdIT0hwZXJqa1dUandCdW5YSWMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2J1bm5pbmdzLmNvbS5hdS8iLCJuYmYiOjE3MTQ1MDkxNzksImlhdCI6MTcxNDUwOTE3OSwiZXhwIjoxNzE0OTQxMTc5LCJhdWQiOlsiQ2hlY2tvdXQtQXBpIiwiY3VzdG9tZXJfYnVubmluZ3MiLCJodHRwczovL2J1bm5pbmdzLmNvbS5hdS9yZXNvdXJjZXMiXSwic2NvcGUiOlsiY2hrOmV4ZWMiLCJjbTphY2Nlc3MiLCJlY29tOmFjY2VzcyIsImNoazpwdWIiXSwiYW1yIjpbImV4dGVybmFsIl0sImNsaWVudF9pZCI6ImJ1ZHBfZ3Vlc3RfdXNlcl9hdSIsInN1YiI6Ijk3M2JjNzI4LTA0YWItNDliOC1hMWI3LWE5OTJhM2E1NjhmOCIsImF1dGhfdGltZSI6MTcxNDUwOTE3OSwiaWRwIjoibG9jYWxsb29wYmFjayIsImItaWQiOiI5NzNiYzcyOC0wNGFiLTQ5YjgtYTFiNy1hOTkyYTNhNTY4ZjgiLCJiLXJvbGUiOiJndWVzdCIsImItdHlwZSI6Imd1ZXN0IiwibG9jYWxlIjoiZW5fQVUiLCJiLWNvdW50cnkiOiJBVSIsImFjdGl2YXRpb25fc3RhdHVzIjoiRmFsc2UiLCJ1c2VyX25hbWUiOiI5NzNiYzcyOC0wNGFiLTQ5YjgtYTFiNy1hOTkyYTNhNTY4ZjgiLCJiLXJiYWMiOlt7ImFzYyI6IjEyMGNhYTU5LTE0MDUtNDhjZC1hOTBmLTk3ZWE5NmI1OThjNCIsInR5cGUiOiJDIiwicm9sIjpbIkNISzpHdWVzdCJdfV0sInNpZCI6IjMxOUJFMTM0MTczRjQ3OEU2MURGQzVDM0QzOUQwNkZBIiwianRpIjoiQ0ZFOEU4QjA0MUU2Q0I0MjE4OEE4NzNEOEU4Q0NDMTYifQ.yB-VuzOrjsL2ktzn-dWnZfal5sjJN3YLoNUA2DoQqMEYD0X509DjAh6H3yg1tkvnGs0kRdMxnbAfUF0CPsubk_DQEYgMRKFguVovbVKFtHIKCO7Flwdy6v9wYD8bj0C161_RI6mU1AdjVwTwlmGd-JZO9_ctcoY_Aa3j96dtvaK4JICwXbk5a1TxxoY6isXuQIluJDiT36rfk--2jR6Txp-MtP1eP3rWB9Z_CM-Iv4coNVkVIny_SdFzSZ5fQL9izPZqbbHkrXGTrDWPPJ1RgBgDfvLLBDbQOftqpe4pid_hBXv3Lh9pIEZU9Yo-Xv43mpDKnDiJ-kZ6t0dnxY_7rw\\\",\\\"clientToken\\\":true}\"},{\"domain\":\".www.bunnings.com.au\",\"expirationDate\":1714511765.847608,\"hostOnly\":false,\"httpOnly\":true,\"name\":\"__cf_bm\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"oUIO4jnzL2X8TnAg2znPSZNHmo9hspuIS7fWyQRSKWA-1714509969-1.0.1.1-YzZy9uiSz3_hXmFyFw7xgTY1kHpF92uN1F_4x.iteW58.BjWN0X_CeMtqwH8q.CPphz1_Hotr0VC5Ut_qQtlUQ\"},{\"domain\":\"www.bunnings.com.au\",\"hostOnly\":true,\"httpOnly\":false,\"name\":\"budp_au#lang\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":true,\"storeId\":null,\"value\":\"en\"},{\"domain\":\".bunnings.com.au\",\"hostOnly\":false,\"httpOnly\":true,\"name\":\"_cfuvid\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":true,\"storeId\":null,\"value\":\"SotDB_DczddIrINY7ANzVvNE2e3DV.Xn89Jf0yEgm3U-1714509177660-0.0.1.1-604800000\"},{\"domain\":\".www.bunnings.com.au\",\"hostOnly\":false,\"httpOnly\":true,\"name\":\"_cfuvid\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":true,\"storeId\":null,\"value\":\"wp.YX1RP4TnWSlKuVGQEjVvHOIbJ4eCrob4O4XYf_ao-1714509969444-0.0.1.1-604800000\"},{\"domain\":\"www.bunnings.com.au\",\"hostOnly\":true,\"httpOnly\":true,\"name\":\"ASP.NET_SessionId\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":true,\"storeId\":null,\"value\":\"bmi3fqzfjmelsmm4sjgku0zc\"},{\"domain\":\"www.bunnings.com.au\",\"expirationDate\":1730061965.847578,\"hostOnly\":true,\"httpOnly\":false,\"name\":\"Bunnings.Platform.Fallback\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"V2\"},{\"domain\":\".www.bunnings.com.au\",\"expirationDate\":1730061951.697547,\"hostOnly\":false,\"httpOnly\":true,\"name\":\"cf_clearance\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"gxl.334xGJDe.apgDbdH.PQ31IHTDK3RboGlGY1DGTU-1714509955-1.0.1.1-cppWvMCBw4a95F8iBllvNw.dloB3EsaK9iZiZVGCBBhPXfn_0GWmV2eqivpwGFw1U85m9yV5d6U2N_951G1pIQ\"},{\"domain\":\".bunnings.com.au\",\"hostOnly\":false,\"httpOnly\":false,\"name\":\"clientLoginUrl\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":true,\"storeId\":null,\"value\":\"https://www.bunnings.com.au/login\"},{\"domain\":\"www.bunnings.com.au\",\"expirationDate\":1715113974.455994,\"hostOnly\":true,\"httpOnly\":false,\"name\":\"defaultStoreID\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"6400\"},{\"domain\":\"www.bunnings.com.au\",\"expirationDate\":1716929155.163235,\"hostOnly\":true,\"httpOnly\":false,\"name\":\"personalization_session_id\",\"path\":\"/\",\"sameSite\":null,\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"d3c32160-0730-11ef-9802-7928a33a9354\"},{\"domain\":\"www.bunnings.com.au\",\"expirationDate\":1730061955.163458,\"hostOnly\":true,\"httpOnly\":true,\"name\":\"SC_ANALYTICS_GLOBAL_COOKIE\",\"path\":\"/\",\"sameSite\":\"no_restriction\",\"secure\":true,\"session\":false,\"storeId\":null,\"value\":\"e09fb245cdff43778bbde6ab6880e175%7CFalse\"}]";
        try {
            JSONArray jsonArray = new JSONArray(cloudfareCookies);
//            System.out.println(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String value = jsonObject.getString("value");
                Cookie cookie = new Cookie(name, value);
                driver.manage().addCookie(cookie);
//                System.out.println(name + " " + value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
	}
	
	public static String bunnings_login(String email, String password) {
		email = (email == null) ? "" : email;
		password = (password == null) ? "" : password;
		String url = "https://www.bunnings.com.au/login";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bksol\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		sleep(2);
		driver.get(url);
		bypassCloudfare(driver);
		
		WebElement emailElement = driver.findElement(By.id("okta-signin-username"));
		emailElement.sendKeys(email);
		
		WebElement passElement = driver.findElement(By.id("okta-signin-password"));
		passElement.sendKeys(password);
		
		WebElement submitElement = driver.findElement(By.id("okta-signin-submit"));
		submitElement.click();
		
		sleep(10);
		
		String currUrl = driver.getCurrentUrl();
		String homePageBunningUrl = "https://www.bunnings.com.au/";
		String returnString = null;
		if(currUrl.equals(homePageBunningUrl)) {
			returnString = "Success";
		}else {
			WebElement spanElement = driver.findElement(By.className("error-16"));
			WebElement errorMessage = spanElement.findElement(By.xpath("following-sibling::p"));
			returnString = errorMessage.getText();
		}
		driver.close();
		return returnString;
	}
	
	public static String drfrost_login(String email, String password) {
		email = (email == null) ? "" : email;
		password = (password == null) ? "" : password;
		String url = "https://www.drfrost.org/login.php";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bksol\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		sleep(2);
		driver.get(url);
		
		WebElement emailElement = driver.findElement(By.name("login-email"));
		emailElement.sendKeys(email);
		
		WebElement passElement = driver.findElement(By.name("login-password"));
		passElement.sendKeys(password);
		
		WebElement submitElement = driver.findElement(By.id("login-submit-button"));
		submitElement.click();
		
		sleep(2);
		
		String currUrl = driver.getCurrentUrl();
		
		String homePageDrFrostUrl = "https://www.drfrost.org/dashboard.php";
		
		String returnString = null;
		
		if(currUrl.equals(homePageDrFrostUrl)) {
			returnString = "Success";
		}else {
			WebElement modal = driver.findElement(By.className("modal"));
	        WebElement firstP = modal.findElement(By.cssSelector("p:first-child"));
			returnString = firstP.getText();
		}
		driver.close();
		return returnString;
	}
}
