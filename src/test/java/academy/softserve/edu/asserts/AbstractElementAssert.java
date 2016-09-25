package academy.softserve.edu.asserts;

import academy.softserve.edu.elements.wrappers.AbstractElement;
import academy.softserve.edu.utils.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Reporter.log;

public class AbstractElementAssert extends AbstractAssert<AbstractElementAssert, AbstractElement> {

    private final AbstractElement element;

    AbstractElementAssert(final AbstractElement element) {
        super(element, AbstractElementAssert.class);
        this.element = element;
    }

    public static final AbstractElementAssert assertThat(final AbstractElement element) {
        return new AbstractElementAssert(element);
    }

    public final AbstractElementAssert isDisplayed() {

        isNotNull();

        if (!element.isDisplayed()) {

            failWithMessage("Element <%s> is not displayed!",
                    element.getLocatorName());
            log(Logger.logInfo("Assert <isDisplayed> failed: <" +
                    element.getLocatorName() + "> is not displayed"));
        } else {
            log(Logger.logInfo("Assert <isDisplayed> passed"));
        }
        return this;
    }

    public final AbstractElementAssert textContains(final String condition) {

        isNotNull();

        if (!element.getText()
                .contains(condition)) {

            failWithMessage("Element <%s> does not contain <%s>",
                    element.getLocatorName(), condition);
            log(Logger.logInfo("Assert <textContains> failed: element's text <"
                    + element.getLocatorName() + "> does not contain <" + condition + ">"));
        } else {
            log(Logger.logInfo("Assert <textContain> passed"));
        }
        return this;
    }

    public final AbstractElementAssert textEquals(final String condition) {

        isNotNull();

        if (!element.getText()
                .equals(condition)) {

            failWithMessage("Element <%s> does not equal to <%s>",
                    element.getLocatorName(), condition);
            log(Logger.logInfo("Assert <textEquals> failed: element's text <"
                    + element.getLocatorName() + "> does not equal to <" + condition + ">"));
        } else {
            log(Logger.logInfo("Assert <textEquals> passed"));
        }
        return this;
    }

    public final AbstractElementAssert valueContains(final String condition) {

        isNotNull();

        if (!element.getValue()
                .contains(condition)) {

            failWithMessage("Attribute 'Value' of <%s> does not contain <%s> !",
                    element.getLocatorName(), condition);
            log(Logger.logInfo("Assert <valueContains> failed: element's value <"
                    + element.getLocatorName() + "> does not contain <" + condition + ">"));
        } else {
            log(Logger.logInfo("Assert <valueContains> passed"));
        }
        return this;
    }

    public final AbstractElementAssert valueEquals(final String condition) {

        isNotNull();

        if (!element.getValue()
                .equals(condition)) {

            failWithMessage("Attribute 'Value' of <%s> does not equal to <%s> !",
                    element.getLocatorName(), condition);
            log(Logger.logInfo("Assert <valueEquals> failed: element's value <"
                    + element.getLocatorName() + "> does not equal to <" + condition + ">"));
        } else {
            log(Logger.logInfo("Assert <valueEquals> passed"));
        }
        return this;
    }

    public final AbstractElementAssert isValueEmpty() {

        isNotNull();

        if (!element.getValue()
                .isEmpty()) {

            failWithMessage("Attribute 'Value' of <%s> is not empty !",
                    element.getLocatorName());
            log(Logger.logInfo("Assert <isValueEmpty> failed: element's value <"
                    + element.getLocatorName() + "> is not empty"));
        } else {
            log(Logger.logInfo("Assert <isValueEmpty> passed"));
        }
        return this;
    }

    public final AbstractElementAssert isTextBold() {

        isNotNull();

        if (!element.getElement()
                .getCssValue("font-weight")
                .equals("700")) {

            failWithMessage("Text of <%s> is not bold !",
                    element.getLocatorName());
            log(Logger.logInfo("Assert <isTextBold> failed: element's text <"
                    + element.getLocatorName() + "> is not bold"));
        } else {
            log(Logger.logInfo("Assert <isTextBold> passed"));
        }
        return this;
    }

    public final AbstractElementAssert isTextEmpty() {

        isNotNull();

        if (!element.getText()
                .isEmpty()) {

            failWithMessage("Text of <%s> is not empty !",
                    element.getLocatorName());
            log(Logger.logInfo("Assert <isTextEmpty> failed: element's text <"
                    + element.getLocatorName() + "> is not empty"));
        } else {
            log(Logger.logInfo("Assert <isTextEmpty> passed"));
        }
        return this;
    }

    public final AbstractElementAssert selectedDropDownEquals(final String condition) {

        isNotNull();

        if (!new Select(element.getElement())
                .getFirstSelectedOption()
                .getText()
                .equals(condition)) {

            failWithMessage("Selected value of dropdown <%s> does not equal to <%s>",
                    element.getLocatorName(), condition);
            log(Logger.logInfo("Assert <selectedDropDownEquals> failed: dropdown's selected value <"
                    + element.getLocatorName() + "> does not equal to <" + condition + ">"));
        } else {
            log(Logger.logInfo("Assert <selectedDropDownEquals> passed"));
        }
        return this;
    }

    @Override
    public final AbstractElementAssert isNotNull() {

        if (element == null) {

            failWithMessage("Required element is null !");
            log(Logger.logInfo("Assert <isNotNull> failed: required element is null "));
        } else {
            log(Logger.logInfo("Assert <isNotNull> passed"));
        }
        return this;
    }

}
