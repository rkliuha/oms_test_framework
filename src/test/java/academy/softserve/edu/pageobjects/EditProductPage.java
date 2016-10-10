package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.TextInputField;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.supervisor.EditProductPageLocators.*;

@Getter
public class EditProductPage extends PageObject<EditProductPage> {
    /**
     * Identification of EditProductPage can be
     * NotNull Attribute 'value' of productNameInput
     */
    private final TextInputField productNameInput = new TextInputField(driver, PRODUCT_NAME_TEXTFIELD);

    private final TextInputField productDescriptionInput = new TextInputField(driver, PRODUCT_DESCRIPTION_TEXTFIELD);

    private final TextInputField productPriceInput = new TextInputField(driver, PRODUCT_PRICE_TEXTFIELD);

    private final Button okButton = new Button(driver, OK_BUTTON);

    private final Button cancelButton = new Button(driver, CANCEL_BUTTON);

    public EditProductPage(final WebDriver driver) {
        super(driver);
    }

}
