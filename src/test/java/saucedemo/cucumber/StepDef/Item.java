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

public class Item {

    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("user login in web")
        public void user_login_in_web(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);
        String loginpageassert = driver.findElement(By.xpath("//div[1][contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginpageassert,"Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

    }

    @When("click a product")
    public void click_a_product() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();

    }
    @And("Click a cart")
    public void click_a_cart() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("user in dasboar cart")
    public void user_in_dasboar_cart() {
        String namaToko = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]")).getText();
        Assert.assertEquals(namaToko,"Your Cart");
        driver.close();

    }
}
