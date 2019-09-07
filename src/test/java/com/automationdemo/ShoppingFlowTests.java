package com.automationdemo;
import com.automationdemo.pages.*;
import com.automationdemo.support.DriverManager;
import com.automationdemo.support.SeleniumSupportMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ShoppingFlowTests {

    private static final String EXPECTEDSEARCHSTRING = "PRINTED";
    private static final String LIGHTBLUECOLOR = "color_14";
    private static WebDriver driver;
    private static String searchPageItemPrice;
    private static String productTitleDetailedView;
    private static String userEmail;
    private static String userPassword = "automation";
    private static String phone = "0831835560";
    private static String totalPrice;

    @Test
    public void test1() {
        driver = DriverManager.setup(driver);
        HomePage homePage = new HomePage(driver);

        homePage.openHomePage();
        System.out.println(" ------------------- Testing HOME PAGE TITLE ------------------- ");
        assertEquals("My Store", homePage.getTitleText());
        System.out.println("Expected Title : My Store" + " --- Actual Title : "+  homePage.getTitleText());
        homePage.searchForProduct(EXPECTEDSEARCHSTRING);
    }

    @Test
    public void test2() {
        SearchResultsPage searchPage = new SearchResultsPage(driver);
        System.out.println(" ------------------- Testing if Search Query String matches to title's of listed products ------------------- ");
        List<String> productNames = new ArrayList<String>();
        productNames = searchPage.getAllSearchResults();
        for (String productName : productNames) {
            assertTrue(productName.toUpperCase().contains("PRINTED"));
        }
        searchPageItemPrice = searchPage.getFirstElementPrice();
        searchPage.openFirstProductDetail();
    }

    @Test
    public void test3() {
        ProductDetailPage detailPage = new ProductDetailPage(driver);
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        SearchResultsPage searchPage = new SearchResultsPage(driver);
        System.out.println(" ------------------- Comparing Price from SearchResultPage view to ProductDetailPage Price ------------------- ");
        System.out.println("Price from Search Result Page : " + searchPageItemPrice);
        System.out.println("Price from Detailed Result Page : " + detailPage.getProductPrice());
        assertEquals(searchPageItemPrice, detailPage.getProductPrice());
        productTitleDetailedView = detailPage.getProductName();
        detailPage.selectColor(LIGHTBLUECOLOR);
        detailPage.clickAddToCart();
        detailPage.clickToContinueShopping();
        detailPage.clickOnViewCart();
        // Item price comparision to final item price in cart
        System.out.println(" ------------------- Comparing Product Price from SearchResultPage view to ViewCartPage Price ------------------- ");
        assertEquals(searchPageItemPrice, viewCartPage.firstItemCost());
        System.out.println("Expected Price : " + searchPageItemPrice + " --- Actual price : " +viewCartPage.firstItemCost());
        //viewCartPage.navigateToHomePage();
        viewCartPage.clickToCheckout();
    }

    @Test
    public void test4() throws InterruptedException {
        AuthPage authPage = new AuthPage(driver);
        PersonalInfoFormPage personalInfoFormPage = new PersonalInfoFormPage(driver);
        SeleniumSupportMethods seleniumSupportMethods = new SeleniumSupportMethods();
        AddressesPage addressesPage = new AddressesPage(driver);
        userEmail = seleniumSupportMethods.generateRandomEmail() + "@gmail.com";
        System.out.println(userEmail);
        authPage.enterEmailAddressAuthPage(userEmail);
        authPage.clickOnCreateAnAccountAuthPage();
        // Filling the form
        personalInfoFormPage.selectTitle();
        String firstName = seleniumSupportMethods.generateRandomText(4);
        personalInfoFormPage.setFirstName(firstName);
        String lastName = seleniumSupportMethods.generateRandomText(6);
        personalInfoFormPage.setLastName(lastName);
        personalInfoFormPage.setPassword(userPassword);
        String address = seleniumSupportMethods.generateRandomText(8);
        personalInfoFormPage.setAddress(address);
        personalInfoFormPage.setCity("City Of Lights");
        personalInfoFormPage.selectState("California");
        personalInfoFormPage.setPostcode("00000");
        personalInfoFormPage.setPhone(phone);
        personalInfoFormPage.clickRegisterButton();
        Thread.sleep(2000);
        System.out.println("Expected Name : " + firstName.toLowerCase() + " " + lastName.toLowerCase() + " ---  Actual Name: " + addressesPage.getFullName());
        System.out.println("Expected Phone : " + phone + " --- Actual Phone :" + addressesPage.getPhoneNumber());
        System.out.println("Expected Address : " + address.toLowerCase() + " --- Actual Address :" + addressesPage.getAddress());
        Assert.assertEquals(firstName.toLowerCase() + " " + lastName.toLowerCase(), addressesPage.getFullName());
        Assert.assertEquals(address.toLowerCase(), addressesPage.getAddress());
        Assert.assertEquals(phone, addressesPage.getPhoneNumber());
        Thread.sleep(2000);
        addressesPage.clickProceedCheckout();
    }

    @Test
    public void test5() throws InterruptedException {
        ShippingPage shippingPage = new ShippingPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        shippingPage.clickCheckboxTerms();
        Thread.sleep(1000);
        shippingPage.clickToProceed();
        Assert.assertEquals(productTitleDetailedView.toLowerCase(), paymentPage.getDressName().toLowerCase());
        System.out.println("Expected Dress Title : " + paymentPage.getDressName() + " --- Actual Title : "  + productTitleDetailedView);
    }

    @Test
    public void test6() throws InterruptedException {
        BankWirePayPage bankWirePayPage = new BankWirePayPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        totalPrice = paymentPage.getTotalPrice();
        paymentPage.clickBankWireButton();
        Assert.assertEquals(totalPrice,bankWirePayPage.getFinalAmount());
        System.out.print("Expected Amount : " + totalPrice + " --- Actual Amount : " +  bankWirePayPage.getFinalAmount());
        Assert.assertEquals(totalPrice,bankWirePayPage.getFinalAmount());
        bankWirePayPage.clickConfirmOrder();
        Thread.sleep(10000);
        DriverManager.closeSession(driver);
    }
}