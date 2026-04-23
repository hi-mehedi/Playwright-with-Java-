package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.PicoVendPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePage(){
        HomePage homePage = new HomePage(page);
        PicoVendPage picoVendPage = new PicoVendPage(page);
        test.info("Navigate Page");
        page.navigate("https://365retailmarkets.com/");
        test.info("Click Allow all");
        homePage.clickAllowAll();
        test.info("Choose Language");
        homePage.clickChooseLanguage();
        test.info("Select Spanish Language");
        homePage.clickSelectLanguageSp();
        String actualText = homePage.getSelectLanguageSp();
        test.info("Expected text is visible");
        assert actualText.contains("Cambiar ubicación");
        test.info("Reload Page");
        page.reload();
        test.info("Scroll Down");
        homePage.scrollDownToPrivacy();
        test.info("Scroll Top");
        homePage.scrollTop();
        test.info("Choos Language");
        homePage.clickChooseLanguage();
        test.info("Select English Language");
        homePage.clickSelectLanguageEng();
        test.info("Scroll Down");
        homePage.scrollDownToPrivacy();
        test.info("Scroll Top");
        homePage.scrollTop();
        test.info("CLick Solution");
        homePage.clickSolution();
        test.info("When click solution Learn more is visible");
        assertThat(homePage.isLearnMoreSolutionBtnVisible()).isVisible();
        test.info("Click Learn More Solution Button");
        homePage.clickLearnMoreSolutionBtn();
        test.info("Click Point Of Sale");
        homePage.clickPointOfSale();
        test.info("Click pico Vend");
        homePage.clickPicoVend();
        test.info("Heading is displayed");
        assertThat(picoVendPage.isHeadingVisible()).isVisible();
    }
}
