package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountPage{
    private Page page;

    private Locator email;
    private Locator singUpBtn;

    public AccountPage(Page page){
        this.page = page;
        this.email = page.locator("input[inputmode='email']");
        this.singUpBtn = page.getByTestId("qa_btn_Sign_Up");
    }

    public Page clickSignUp(){
        return page.waitForPopup(() -> {
            singUpBtn.click();
        });
    }

    public void typeEmail(String emailIn){
        email.fill(emailIn);
    }
}
