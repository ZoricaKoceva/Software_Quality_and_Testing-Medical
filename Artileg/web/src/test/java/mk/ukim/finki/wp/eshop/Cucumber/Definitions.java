package mk.ukim.finki.wp.eshop.Cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class Definitions {

    WebDriver driver;

    @Given("^Open the Chrome and launch the application$")
    public void open_the_chrome_and_launch_the_application() throws Throwable {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:9091/");
    }

    @And("^Welcome page will be displayed$")
    public void verify_welcome_page() throws Throwable {
        String actualString = driver.findElement(By.className("welcome_text")).getText();
        assertTrue(actualString.contains("Welcome to home page!"));
    }

    @When("^User visit products list$")
    public void enter_the_Username_and_Password() throws Throwable {
        driver.get("http://localhost:9091/products");
        driver.findElement(By.className("create_link")).click();
    }

    @Then("^User input and submit user form$")
    public void enter_and_submit_form() throws Throwable {
        driver.findElement(By.id("username")).sendKeys("Zorica9");
        driver.findElement(By.id("password")).sendKeys("programiranje");
//        driver.findElement(By.className("btn-default")).click();
        driver.findElement(By.id("submit")).click();
    }

    @Then("^Admin will see products list page$")
    public void verify_redirect_to_products__listpage() throws Throwable {
        String actualString = driver.findElement(By.className("nav-link active")).getText();
        assertTrue(actualString.contains("Products"));
        driver.close();
    }

}