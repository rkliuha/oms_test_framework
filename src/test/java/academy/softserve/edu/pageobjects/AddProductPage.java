package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Element;
import academy.softserve.edu.elements.wrappers.TextInputField;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.supervisor.AddProductPageLocators.*;

@Getter
public class AddProductPage extends PageObject<AddProductPage> {

    /**
     * okButton is an unique element on the AddProductPage,
     * can be used as identification of page;
     */
    private final Button okButton = new Button(driver, OK_BUTTON);

    private final Button cancelButton = new Button(driver, CANCEL_BUTTON);

    private final TextInputField productNameInput = new TextInputField(driver, PRODUCT_NAME_INPUT);

    private final TextInputField productDescriptionInput = new TextInputField(driver, PRODUCT_DESCRIPTION_INPUT);

    private final TextInputField productPriceInput = new TextInputField(driver, PRODUCT_PRICE_INPUT);

    private final Element productNameErrorText = new Element(driver, PRODUCT_NAME_ERROR_TEXT);

    private final Element productDescriptionErrorText = new Element(driver, PRODUCT_DESCRIPTION_ERROR_TEXT);

    private final Element productPriceErrorText = new Element(driver, PRODUCT_PRICE_ERROR_TEXT);

    public AddProductPage(final WebDriver driver) {
        super(driver);
    }

    public final ItemManagementPage clickOkButton() {

        okButton.click();
        return new ItemManagementPage(driver);
    }

    public final ItemManagementPage clickCancelButton() {

        cancelButton.click();
        return new ItemManagementPage(driver);
    }

    public final AddProductPage fillProductNameInput(final String productName) {

        productNameInput.sendKeys(productName);
        return this;
    }

    public final AddProductPage fillProductDescriptionInput(final String productDescription) {

        productDescriptionInput.sendKeys(productDescription);
        return this;
    }

    public final AddProductPage fillProductPriceInput(final String productPrice) {

        productPriceInput.sendKeys(productPrice);
        return this;
    }

}
