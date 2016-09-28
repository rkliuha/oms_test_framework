package academy.softserve.edu.asserts;

import academy.softserve.edu.elements.wrappers.AbstractElement;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.support.ui.Select;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

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
            logFail("Assert <isDisplayed> failed: <" +
                    element.getLocatorName() + "> is not displayed");
        } else {
            logPass("Assert <isDisplayed> passed");
        }
        return this;
    }

    public final AbstractElementAssert textContains(final String condition) {

        isNotNull();

        if (!element.getText()
                .contains(condition)) {

            failWithMessage("Element <%s> does not contain <%s>",
                    element.getLocatorName(), condition);
            logFail("Assert <textContains> failed: element's text <"
                    + element.getLocatorName() + "> does not contain <" + condition + ">");
        } else {
            logPass("Assert <textContain> passed");
        }
        return this;
    }

    public final AbstractElementAssert textEquals(final String condition) {

        isNotNull();

        if (!condition.equals(element.getText())) {

            failWithMessage("Element <%s> does not equal to <%s>",
                    element.getLocatorName(), condition);
            logFail("Assert <textEquals> failed: element's text <"
                    + element.getLocatorName() + "> does not equal to <" + condition + ">");
        } else {
            logPass("Assert <textEquals> passed");
        }
        return this;
    }

    public final AbstractElementAssert valueContains(final String condition) {

        isNotNull();

        if (!element.getValue()
                .contains(condition)) {

            failWithMessage("Attribute 'Value' of <%s> does not contain <%s> !",
                    element.getLocatorName(), condition);
            logFail("Assert <valueContains> failed: element's value <"
                    + element.getLocatorName() + "> does not contain <" + condition + ">");
        } else {
            logPass("Assert <valueContains> passed");
        }
        return this;
    }

    public final AbstractElementAssert valueEquals(final String condition) {

        isNotNull();

        if (!condition.equals(element.getValue())) {

            failWithMessage("Attribute 'Value' of <%s> does not equal to <%s> !",
                    element.getLocatorName(), condition);
            logFail("Assert <valueEquals> failed: element's value <"
                    + element.getLocatorName() + "> does not equal to <" + condition + ">");
        } else {
            logPass("Assert <valueEquals> passed");
        }
        return this;
    }

    public final AbstractElementAssert isValueEmpty() {

        isNotNull();

        if (!element.getValue()
                .isEmpty()) {

            failWithMessage("Attribute 'Value' of <%s> is not empty !",
                    element.getLocatorName());
            logFail("Assert <isValueEmpty> failed: element's value <"
                    + element.getLocatorName() + "> is not empty");
        } else {
            logPass("Assert <isValueEmpty> passed");
        }
        return this;
    }

    public final AbstractElementAssert isTextBold() {

        isNotNull();

        if (!"700".equals(element
                .getElement()
                .getCssValue("font-weight"))) {

            failWithMessage("Text of <%s> is not bold !",
                    element.getLocatorName());
            logFail("Assert <isTextBold> failed: element's text <"
                    + element.getLocatorName() + "> is not bold");
        } else {
            logPass("Assert <isTextBold> passed");
        }
        return this;
    }

    public final AbstractElementAssert isTextEmpty() {

        isNotNull();

        if (!element.getText()
                .isEmpty()) {

            failWithMessage("Text of <%s> is not empty !",
                    element.getLocatorName());
            logFail("Assert <isTextEmpty> failed: element's text <"
                    + element.getLocatorName() + "> is not empty");
        } else {
            logPass("Assert <isTextEmpty> passed");
        }
        return this;
    }

    public final AbstractElementAssert selectedDropDownEquals(final String condition) {

        isNotNull();

        if (!condition.equals
                (new Select(element.getElement())
                        .getFirstSelectedOption()
                        .getText())) {

            failWithMessage("Selected value of dropdown <%s> does not equal to <%s>",
                    element.getLocatorName(), condition);
            logFail("Assert <selectedDropDownEquals> failed: dropdown's selected value <"
                    + element.getLocatorName() + "> does not equal to <" + condition + ">");
        } else {
            logPass("Assert <selectedDropDownEquals> passed");
        }
        return this;
    }

    @Override
    public final AbstractElementAssert isNotNull() {

        if (element == null) {

            failWithMessage("Required element is null !");
            logFail("Assert <isNotNull> failed: required element is null ");
        } else {
            logPass("Assert <isNotNull> passed");
        }
        return this;
    }

}
