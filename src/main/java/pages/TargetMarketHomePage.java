package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TargetMarketHomePage extends BasePage {
    @FindBy(css = " li.splide__slide.is-active.is-visible:nth-child(1)      div.nav-item")
    WebElement allTab;
    @FindBy(css = " li.splide__slide.is-visible.is-next:nth-child(2) > div.nav-item")
    WebElement smartphonesTab;
    @FindBy(css = " li.splide__slide.is-visible:nth-child(3) > div.nav-item")
    WebElement laptopsTab;
    @FindBy(css = " li.splide__slide.is-active.is-visible:nth-child(4)      div.nav-item")
    WebElement skincareTab;
    @FindBy(css = " li.splide__slide.is-active.is-visible:nth-child(5)      div.nav-item")
    WebElement groceriesTab;
    @FindBy(css = " li.splide__slide.is-active.is-visible:nth-child(6)      div.nav-item")
    WebElement homeDecorationTab;
    @FindBy(css = " li.splide__slide.is-active.is-visible:nth-child(7)      div.nav-item")
    WebElement furnitureTab;
    @FindBy(css = " li.splide__slide.is-active.is-visible:nth-child(8)      div.nav-item")
    WebElement topsTab;
    @FindBy(css = " li.splide__slide.is-active.is-visible:nth-child(9)      div.nav-item")
    WebElement womensDressesTab;
    @FindBy(css = " li.splide__slide.is-active.is-visible:nth-child(10)      div.nav-item")
    WebElement womensShoesTab;

    @FindBy(css = "h5.display-5")
    WebElement welcomeText;

    public String getWelcomeText() {
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return welcomeText.getText();
    }

    private All_Page allPage;
    private Smartphone_Page smartphonesPage;
    private Laptops_Page laptopsPage;
    private Skincare_Page skincarePage;
    private Groceries_Page groceriesPage;
    private HomeDecoration_Page homeDecorationPage;
    private Furniture_Page furniturePage;
    private Tops_Page topsPage;
    private WomensDresses_Page womensDressesPage;
    private WomensShoes_Page womensShoesPage;

    public All_Page getAllTab() {
        return new All_Page();
    }

    public Smartphone_Page getSmartphonesPage() {
        return new Smartphone_Page();
    }

    public Laptops_Page getLaptopsPage() {
        return new Laptops_Page();
    }

    public Skincare_Page getSkincarePage() {
        return new Skincare_Page();
    }

    public Groceries_Page getGroceriesPage() {
        return new Groceries_Page();
    }

    public HomeDecoration_Page getHomeDecorationPage() {
        return new HomeDecoration_Page();
    }

    public Furniture_Page getFurniturePage() {
        return new Furniture_Page();
    }

    public Tops_Page getTopsPage() {
        return new Tops_Page();
    }

    public WomensDresses_Page getWomensDressesPage() {
        return new WomensDresses_Page();
    }

    public WomensShoes_Page getWomensShoesPage() {
        return new WomensShoes_Page();
    }

    public TargetMarketHomePage() {
        this.allPage = new All_Page();
        this.furniturePage = new Furniture_Page();
        this.groceriesPage = new Groceries_Page();
        this.homeDecorationPage = new HomeDecoration_Page();
        this.skincarePage = new Skincare_Page();
        this.topsPage = new Tops_Page();
        this.laptopsPage = new Laptops_Page();
        this.womensDressesPage = new WomensDresses_Page();
        this.womensShoesPage = new WomensShoes_Page();
        this.smartphonesPage = new Smartphone_Page();
    }

    public void clickOnAllTab() {
        allTab.click();
    }

    public void clickOnSmartphonesTab() {
        smartphonesTab.click();
    }

    public void clickOnLaptopsTab() {
        laptopsTab.click();
    }

    public void clickOnSkincareTab() {
        skincareTab.click();
    }

    public void clickOnGroceriesTab() {
        groceriesTab.click();
    }

    public void clickOnHomeDecorationTab() {
        homeDecorationTab.click();
    }

    public void clickOnFurnitureTab() {
        furnitureTab.click();
    }

    public void clickOnTopsTab() {
        topsTab.click();
    }

    public void clickOnWomensDressesTab() {
        womensDressesTab.click();
    }

    public void clickOnWomensShoesTab() {
        womensShoesTab.click();
    }
}

