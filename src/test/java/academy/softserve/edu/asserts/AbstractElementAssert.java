package academy.softserve.edu.asserts;

import academy.softserve.edu.elements.wrappers.AbstractElement;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.support.ui.Select;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

//TODO improve logging possibility
public class AbstractElementAssert extends AbstractAssert<AbstractElementAssert, AbstractElement> {

    AbstractElementAssert(final AbstractElement actual) {
        super(actual, AbstractElementAssert.class);
    }

    public static final AbstractElementAssert assertThat(final AbstractElement actual) {
        return new AbstractElementAssert(actual);
    }

    public final AbstractElementAssert isDisplayed() {

        isNotNull();

        if (!actual.isDisplayed()) {

            failWithMessage("Element <%s> is not displayed!",
                    actual.getLocatorName());
            logFail("Assert <isDisplayed> failed: <" +
                    actual.getLocatorName() + "> is not displayed");
        } else {
            logPass("Assert <isDisplayed> passed");
        }
        return this;
    }

    public final AbstractElementAssert textContains(final String condition) {

        isNotNull();

        if (!actual.getText()
                .contains(condition)) {

            failWithMessage("Element <%s> does not contain <%s>",
                    actual.getLocatorName(), condition);
            logFail("Assert <textContains> failed: element's text <"
                    + actual.getLocatorName() + "> does not contain <" + condition + ">");
        } else {
            logPass("Assert <textContain> passed");
        }
        return this;
    }

    public final AbstractElementAssert textEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getText())) {

            failWithMessage("Element <%s> does not equal to <%s>",
                    actual.getLocatorName(), condition);
            logFail("Assert <textEquals> failed: element's text <"
                    + actual.getLocatorName() + "> does not equal to <" + condition + ">");
        } else {
            logPass("Assert <textEquals> passed");
        }
        return this;
    }

    public final AbstractElementAssert valueContains(final String condition) {

        isNotNull();

        if (!actual.getValue()
                .contains(condition)) {

            failWithMessage("Attribute 'Value' of <%s> does not contain <%s> !",
                    actual.getLocatorName(), condition);
            logFail("Assert <valueContains> failed: element's value <"
                    + actual.getLocatorName() + "> does not contain <" + condition + ">");
        } else {
            logPass("Assert <valueContains> passed");
        }
        return this;
    }

    public final AbstractElementAssert valueEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getValue())) {

            failWithMessage("Attribute 'Value' of <%s> does not equal to <%s> !",
                    actual.getLocatorName(), condition);
            logFail("Assert <valueEquals> failed: element's value <"
                    + actual.getLocatorName() + "> does not equal to <" + condition + ">");
        } else {
            logPass("Assert <valueEquals> passed");
        }
        return this;
    }

    public final AbstractElementAssert isValueEmpty() {

        isNotNull();

        if (!actual.getValue()
                .isEmpty()) {

            failWithMessage("Attribute 'Value' of <%s> is not empty !",
                    actual.getLocatorName());
            logFail("Assert <isValueEmpty> failed: element's value <"
                    + actual.getLocatorName() + "> is not empty");
        } else {
            logPass("Assert <isValueEmpty> passed");
        }
        return this;
    }

    public final AbstractElementAssert isTextBold() {

        isNotNull();

        if (!"700".equals(actual
                .getElement()
                .getCssValue("font-weight"))) {

            failWithMessage("Text of <%s> is not bold !",
                    actual.getLocatorName());
            logFail("Assert <isTextBold> failed: element's text <"
                    + actual.getLocatorName() + "> is not bold");
        } else {
            logPass("Assert <isTextBold> passed");
        }
        return this;
    }

    public final AbstractElementAssert isTextEmpty() {

        isNotNull();

        if (!actual.getText()
                .isEmpty()) {

            failWithMessage("Text of <%s> is not empty !",
                    actual.getLocatorName());
            logFail("Assert <isTextEmpty> failed: element's text <"
                    + actual.getLocatorName() + "> is not empty");
        } else {
            logPass("Assert <isTextEmpty> passed");
        }
        return this;
    }

    public final AbstractElementAssert selectedDropDownEquals(final String condition) {

        isNotNull();

        if (!condition.equals
                (new Select(actual.getElement())
                        .getFirstSelectedOption()
                        .getText())) {

            failWithMessage("Selected value of dropdown <%s> does not equal to <%s>",
                    actual.getLocatorName(), condition);
            logFail("Assert <selectedDropDownEquals> failed: dropdown's selected value <"
                    + actual.getLocatorName() + "> does not equal to <" + condition + ">");
        } else {
            logPass("Assert <selectedDropDownEquals> passed");
        }
        return this;
    }

    @Override
    public final AbstractElementAssert isNotNull() {

        if (actual == null) {

            failWithMessage("Required element is null !");
            logFail("Assert <isNotNull> failed: required element is null ");
        } else {
            logPass("Assert <isNotNull> passed");
        }
        return this;
    }

}
