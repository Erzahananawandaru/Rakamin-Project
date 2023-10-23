package saucedemo.cucumber.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Checkout {

    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("user login in  web")
    public void userLoginInWeb() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }
    @When("click menu Checkout")
    public void open_menu_checkout() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @And("input data credencial")
    public void input_data_credencial() {
        driver.findElement(By.id("first-name")).sendKeys("opyan");
        driver.findElement(By.id("last-name")).sendKeys("twiz");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("45156");
    }

    @And("user click continue")
    public void user_click_continue() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Then("user in dasbord page overview")
    public void user_in_dasbord_page_overview() {
        String namaToko = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]")).getText();
        Assert.assertEquals(namaToko,"Checkout: Overview");
        driver.close();
    }

}
