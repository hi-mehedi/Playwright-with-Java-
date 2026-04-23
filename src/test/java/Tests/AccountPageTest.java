package Tests;

import Base.BaseTest;
import Pages.AccountPage;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {
    String email = "mehedi@gmail.com";

    @Test
    public void testAccountPage(){
        HomePage homePage = new HomePage(page);
        test.info("Navigate Home Page");
        page.navigate("https://365retailmarkets.com/");
        test.info("Click Account Tab");
        Page accountTab = homePage.clickAccount();
        AccountPage accountPage = new AccountPage(accountTab);
        test.info("Click Sing up Page");
        Page signUpTab = accountPage.clickSignUp();
        AccountPage signUpPage = new AccountPage(signUpTab);
        test.info("Type email");
        signUpPage.typeEmail(email);
    }
}
