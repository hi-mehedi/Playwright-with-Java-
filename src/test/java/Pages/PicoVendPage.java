package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PicoVendPage {
    private Page page;
    private Locator heading;

    public PicoVendPage(Page page){
        this.page = page;
        this.heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("PicoVend. Powerful cashless"));
    }

    public Locator isHeadingVisible(){
        return heading;
    }
}
