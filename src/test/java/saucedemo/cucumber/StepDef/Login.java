package saucedemo.cucumber.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("user is on saucedemo page")
    public void user_is_on_saucedemo_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

        String loginpageassert = driver.findElement(By.xpath("//div[1][contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginpageassert, "Swag Labs");

    }

    @When("user input username")
    public void user_input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input password")
    public void user_input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click submit")
    public void user_click_submit() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @Then("user in dasboard page")
    public void user_in_dasboard_page() {
        driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String namaToko = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(namaToko, "Products");
        driver.close();
    }

    @And("user input invalid password")
    public void user_input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("1452");
    }

    @Then("user get error massage")
    public void user_get_error_massage() {
        String errorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}