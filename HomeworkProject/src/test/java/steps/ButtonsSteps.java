package steps;

import com.codeborne.selenide.Condition;
import common.PageFactory;
import common.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@Feature("Click Me Button Functionally")
public class ButtonsSteps extends BaseTest {
    PageManager pageManager=new PageManager();

    @BeforeMethod
    @Step("Initialize the Buttons page")
    public void before(){
        PageFactory.buildButtons();
    }

    @Given("Buttons page opens")
    @Step("Open the Buttons page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Open the Buttons page and verify that it is loaded correctly")
    public void openButtonsPage(){
        pageManager.buttons.button.click();
        Assertions.assertThat(pageManager.buttons.getUrl()).isEqualTo("https://demoqa.com/buttons");
    }

    @When("User clicks the Click Me button")
    @Step("Click 'the Click Me' button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Click the 'Click Me' button on the Buttons page")
    public void clickClickMeButton() {
        pageManager.buttons.clickToClickMe();
    }

    @Then("The dynamic message is displayed")
    @Step("Verify the dynamic message is displayed")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if the dynamic message appears after clicking the button")
    public void dynamicClickIsDisplayed(){
        pageManager.buttons.dynamicMessage.should(Condition.appear, Duration.ofSeconds(10));
        Assertions.assertThat(pageManager.buttons.dynamicMessage.getText())
                .isEqualTo("You have done a dynamic click");
    }
}
