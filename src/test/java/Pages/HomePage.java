package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

    private Page page;
    private Locator allowAllBtn;
    private Locator chooseLanguage;
    private Locator selectLanguageSp;
    private Locator selectLanguageEng;
    private Locator solutions;
    private Locator solutionsLearnMore;
    private Locator pointOfSale;
    private Locator picoVend;
    private Locator account;


    public HomePage(Page page){
        this.page = page;
        this.allowAllBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all"));
        this.chooseLanguage =page.locator("button[aria-label= 'Open content']");
        this.selectLanguageSp =page.getByText("Español");
        this.selectLanguageEng = page.getByText("English (US)");
        this.solutions = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Solutions"));
        this.solutionsLearnMore = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Secure Micro Markets A"));
        this.pointOfSale = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Point of Sale"));
        this.picoVend = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PicoVend"));
        this.account = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Your 365Pay Account"));
    }

    public void  clickAllowAll(){
        allowAllBtn.click();
    }

    public void clickChooseLanguage(){
        chooseLanguage.click();
    }

    public void  clickSelectLanguageSp(){
        selectLanguageSp.click();
    }

    public String getSelectLanguageSp(){
        return chooseLanguage.innerText();
    }

    public void clickSelectLanguageEng(){
        selectLanguageEng.click();
    }

    public void scrollDownToPrivacy(){
        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollTop(){
        page.evaluate("window.scrollTo(0, 0)");
    }

    public void clickSolution(){
        solutions.click();
    }

    public Locator isLearnMoreSolutionBtnVisible(){
        return solutionsLearnMore;
    }

    public void clickLearnMoreSolutionBtn(){
        solutionsLearnMore.click();
    }

    public void clickPointOfSale(){
        pointOfSale.click();
    }

    public void clickPicoVend(){
        picoVend.click();
    }

    public Page clickAccount(){
        return page.waitForPopup(() -> {
            account.click();
        });
    }

}
