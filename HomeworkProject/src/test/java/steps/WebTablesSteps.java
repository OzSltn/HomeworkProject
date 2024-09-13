package steps;

import com.codeborne.selenide.Condition;
import common.PageFactory;
import common.PageManager;
import driver.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Map;

@Feature("Web Tables Functionality")
public class WebTablesSteps {

    PageManager pageManager = new PageManager();

    @BeforeMethod
    @Step("Initialize the Web Tables page")
    public void before() {
        PageFactory.buildWebTables();
    }

    @Given("User is on the Web Tables page")
    @Step("Ensure the Web Table Pages is loaded")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure the user is on the Web Tables page")
    public void userIsOnWebTablesPage() {
        Assertions.assertThat(pageManager.webTables.getUrl()).isEqualTo("https://demoqa.com/webtables");
    }

    @When("User clicks 'addbtn' button")
    @Step("Click the 'addbtn' button to open the form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Scroll down and click the Add button on the Web Tables page")
    public void addButtonClick(){
        new Actions(DriverFactory.currentDriver()).scrollByAmount(0, 200).perform();
        pageManager.webTables.addbtn.click();
    }

    @And("User fills in the form with the following details")
    @Step("Fill in the form with provided data and submit")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fill out the form on the Web Tables page and submit it")
    public void fillTheFormAndSubmit(DataTable dataTable) {
        List<Map<String, String>> data=dataTable.asMaps(String.class, String.class);
        for (Map<String, String> form : data) {
            pageManager.webTables.fillTheForm(
                    form.get("firstName"),
                    form.get("lastName"),
                    form.get("email"),
                    form.get("age"),
                    form.get("salary"),
                    form.get("department")
            );
        }
    }

    @And("User clicks 'Edit' button")
    @Step("Click the 'Edit' button")
    @Severity(SeverityLevel.NORMAL)
    @Description("Click the Edit button on the Web Tables page")
    public void clickEditButton() {
        pageManager.webTables.clickEditBtn();
    }

    @And("User edits the first name to 'Merve'")
    @Step("Edit name in Web Tables page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Update the name field on the Web Tables page")
    public void editNameInWebTablesPage(){
        pageManager.webTables.editName("Merve");
    }

    @Then("New row's first column should display 'Merve'")
    @Step("Verify that the new row's first column displays the new name")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if the updated name appears in the Web Tables page")
    public void editedRowInTheWebTablesPage() {
        pageManager.webTables.editedRow.should(Condition.visible);
        Assertions.assertThat(pageManager.webTables.editedRow.getText()).isEqualTo("Merve");
    }
}
