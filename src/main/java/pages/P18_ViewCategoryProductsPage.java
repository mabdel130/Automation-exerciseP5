package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class P18_ViewCategoryProductsPage extends BasePage {
    public P18_ViewCategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By category_Text = By.xpath("//h2[normalize-space()='Category']");
    private final By women_Item = By.xpath("//a[normalize-space()='Women']");
    private final By assertonnameofsubcategory = By.xpath("//h2[contains(text(),'Women -')]");
    private final By clickonmen_Button = By.xpath("//a[normalize-space()='Men']");


    public static String ActualCategory;
    public static String expectedCategory = "CATEGORY";

    // TODO: public action methods
    public P18_ViewCategoryProductsPage Verifythatcategoriesarevisibleonleftsidebar() {
        ActualCategory = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((category_Text))).getText();
        return new P18_ViewCategoryProductsPage(driver);
    }

    public P18_ViewCategoryProductsPage clickonWomenItem() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((women_Item))).click();
        return new P18_ViewCategoryProductsPage(driver);
    }

    public P18_ViewCategoryProductsPage clickonSubWOMENItems() {
        List<WebElement> subCategories = driver.findElements(By.cssSelector("div#Women a"));

        Random rand = new Random();
        int randomIndex = rand.nextInt(subCategories.size());
        WebElement randomSubCategory = subCategories.get(randomIndex);

        shortWait(driver).until(ExpectedConditions.visibilityOf(randomSubCategory));
        randomSubCategory.click();

        return new P18_ViewCategoryProductsPage(driver);
    }
    public P18_ViewCategoryProductsPage clickonmenItem() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((clickonmen_Button))).click();
        return new P18_ViewCategoryProductsPage(driver);
    }


}