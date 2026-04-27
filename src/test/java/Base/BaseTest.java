package Base;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Utils.ExtentManager;
import Utils.ScreenshotUtil;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected ExtentReports extent;
    protected ExtentTest test;

    protected final String BASE_URL = "https://365retailmarkets.com/";
    protected final boolean HEADLESS = false;
    protected final int SLOW_MO = 1000;
    protected final int DEFAULT_TIMEOUT = 10000;

    @BeforeMethod
    public void setUp(Method method) {

        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(HEADLESS)
                        .setSlowMo(SLOW_MO)
        );

        context = browser.newContext();

        page = context.newPage();

        page.setDefaultTimeout(DEFAULT_TIMEOUT);

        page.navigate(BASE_URL);

        test.info("Browser launched and navigated to: " + BASE_URL);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.FAILURE) {

                test.fail(result.getThrowable());

                String base64Screenshot = ScreenshotUtil.takeScreenshot(page, result.getName());

                test.fail("Failure Screenshot",
                        MediaEntityBuilder
                                .createScreenCaptureFromBase64String(base64Screenshot)
                                .build());

            } else if (result.getStatus() == ITestResult.SUCCESS) {

                test.pass("Test Passed Successfully");

            } else if (result.getStatus() == ITestResult.SKIP) {

                test.skip("Test Skipped");

            }

        } catch (Exception e) {
            System.out.println("Error during report generation: " + e.getMessage());
        }

        extent.flush();

        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}