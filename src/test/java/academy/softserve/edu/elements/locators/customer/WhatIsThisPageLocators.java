package academy.softserve.edu.elements.locators.customer;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum WhatIsThisPageLocators implements ILocator {

    WHAT_IS_CVV2_TITLE("What Is CVV2 Text",
            LocatorsType.BY_XPATH,
            "html/body/p[1]/strong"),

    WHAT_IS_CVV2_EXPLANATION_TEXT("What Is CVV2 Explanation Text",
            LocatorsType.BY_XPATH,
            "html/body/p[2]/span"),

    VISA_TITLE("Visa Title",
            LocatorsType.BY_XPATH,
            "html/body/p[2]/strong"),

    VISA_IMAGE("Visa Image",
            LocatorsType.BY_XPATH,
            "//form[@id='form1']/span/img"),

    VISA_EXPLANATION("Visa Explanation",
            LocatorsType.BY_XPATH,
            "html/body/p[3]"),

    MASTERCARD_TITLE("MasterCard Title",
            LocatorsType.BY_XPATH,
            "html/body/p[4]/strong"),

    MASTERCARD_IMAGE("MasterCard Image",
            LocatorsType.BY_XPATH,
            "html/body/p[5]/img"),

    MASTERCARD_EXPLANATION("MasterCard Explanation",
            LocatorsType.BY_XPATH,
            "html/body/p[6]"),

    AMERICANEXPRESS_TITLE("AmericanExpress Title",
            LocatorsType.BY_XPATH,
            "html/body/p[7]/strong"),

    AMERICANEXPRESS_IMAGE("AmericanExpress Image",
            LocatorsType.BY_XPATH,
            "html/body/p[8]/img"),

    AMERICANEXPRESS_EXPLANATION("AmericanExpress Explanation",
            LocatorsType.BY_XPATH,
            "html/body/p[9]");


    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    WhatIsThisPageLocators(final String elementName,
                           final LocatorsType locatorType, final String locatorValue) {
        this.elementName = elementName;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    @Override
    public String getName() {
        return this.elementName;
    }

    @Override
    public By getBy() {
        By by;
        if (this.modifiedLocator == null) {
            by = this.locatorType.getBy(this.locatorValue);
        } else {
            by = this.locatorType.getBy(this.modifiedLocator);
        }
        return by;
    }

    @Override
    public WhatIsThisPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
