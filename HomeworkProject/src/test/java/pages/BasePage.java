package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import utils.PropertyManager;

public class BasePage {
    protected String pageUrl;

    public BasePage(String pageUrl){
        this.pageUrl=pageUrl;
    }

    public String getUrl(){
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public void open(){
        String url=PropertyManager.getProperty("APP_URL");
        Selenide.open(url);
    }
}
