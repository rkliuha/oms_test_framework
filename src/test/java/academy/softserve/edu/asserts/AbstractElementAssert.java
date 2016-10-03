package academy.softserve.edu.asserts;

import academy.softserve.edu.elements.wrappers.AbstractElement;
import academy.softserve.edu.elements.wrappers.Element;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.PageObject;
import com.google.common.collect.Ordering;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

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

            failWithMessage("Element {%s} with locator {%s} should be displayed !",
                    actual.getLocatorName(), actual.getLocatorValue());
            logFail("Element {" + actual.getLocatorName() + "} with locator {" +
                    actual.getLocatorValue() + "} should be displayed !");
        } else {
            logPass("Element {" + actual.getLocatorName() + "} is displayed");
        }
        return this;
    }

    public final AbstractElementAssert textContains(final String condition) {

        isNotNull();

        if (!actual.getText()
                .contains(condition)) {

            failWithMessage("Element's {%s} text {%s} with locator {%s} should contain {%s} !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue(), condition);
            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should contain {" +
                    condition + "} !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text contains {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert textEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getText())) {

            failWithMessage("Element's {%s} text {%s} with locator {%s} should equal {%s} !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue(), condition);
            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should equal {"
                    + condition + "} !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text equals {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert textNotEqual(final String condition) {

        isNotNull();

        if (condition.equals(actual.getText())) {

            failWithMessage("Element's {%s} text {%s} with locator {%s} should not equal {%s} !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue(), condition);
            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should not equal {" +
                    condition + "} !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text does not equal {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert valueContains(final String condition) {

        isNotNull();

        if (!actual.getValue()
                .contains(condition)) {

            failWithMessage("Element's {%s} attribute 'value' {%s} with locator {%s} should contain {%s} !",
                    actual.getLocatorName(), actual.getValue(), actual.getLocatorValue(), condition);
            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' {" + actual.getValue() +
                    "} with locator {" + actual.getLocatorValue() + "} should contain {" + condition + "} !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' contains {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert valueEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getValue())) {

            failWithMessage("Element's {%s} attribute 'value' {%s} with locator {%s} should equal {%s} !",
                    actual.getLocatorName(), actual.getValue(), actual.getLocatorValue(), condition);
            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' {" + actual.getValue() +
                    "} with locator {" + actual.getLocatorValue() + "} should equal {" + condition + "} !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' equals {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert valueNotEqual(final String condition) {

        isNotNull();

        if (condition.equals(actual.getValue())) {

            failWithMessage("Element's {%s} attribute 'value' {%s} with locator {%s} should not equal {%s} !",
                    actual.getLocatorName(), actual.getValue(), actual.getLocatorValue(), condition);
            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' {" + actual.getValue() +
                    "} with locator {" + actual.getLocatorValue() + "} should not equal {" + condition + "} !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' does not equal {"
                    + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert isValueEmpty() {

        isNotNull();

        if (!actual.getValue()
                .isEmpty()) {

            failWithMessage("Element's {%s} attribute 'value' {%s} with locator {%s} should be empty !",
                    actual.getLocatorName(), actual.getValue(), actual.getLocatorValue());
            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' {" + actual.getValue()
                    + "} with locator {" + actual.getLocatorValue() + "} should be empty !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' is empty");
        }
        return this;
    }

    public final AbstractElementAssert isValueNotEmpty() {

        isNotNull();

        if (actual.getValue()
                .isEmpty()) {

            failWithMessage("Element's {%s} attribute 'value' with locator {%s} should not be empty !",
                    actual.getLocatorName(), actual.getLocatorValue());
            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' with locator {" +
                    actual.getLocatorValue() + "} should not be empty !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' is not empty");
        }
        return this;
    }

    public final AbstractElementAssert isTextBold() {

        isNotNull();

        if (!"700".equals(actual
                .getElement()
                .getCssValue("font-weight"))) {

            failWithMessage("Element's {%s} text {%s} with locator {%s} should be bold !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue());
            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should be bold !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text is bold");
        }
        return this;
    }

    public final AbstractElementAssert isTextEmpty() {

        isNotNull();

        if (!actual.getText()
                .isEmpty()) {

            failWithMessage("Element's {%s} text {%s} with locator {%s} should be empty !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue());
            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should be empty !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text is empty");
        }
        return this;
    }

    public final AbstractElementAssert isTextNotEmpty() {

        isNotNull();

        if (actual.getText()
                .isEmpty()) {

            failWithMessage("Element's {%s} text with locator {%s} should not be empty !",
                    actual.getLocatorName(), actual.getLocatorValue());
            logFail("Element's {" + actual.getLocatorName() + "} text with locator {" +
                    actual.getLocatorValue() + "} should not be empty !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text is not empty");
        }
        return this;
    }

    public final AbstractElementAssert isEnabled() {

        isNotNull();

        if (!actual.isEnabled()) {

            failWithMessage("Element {%s} with locator {%s} should be enabled !",
                    actual.getLocatorName(), actual.getLocatorValue());
            logFail("Element {" + actual.getLocatorName() + "} with locator {" +
                    actual.getLocatorValue() + "} should be enabled !");
        } else {
            logPass("Element {" + actual.getLocatorName() + "} is enabled");
        }
        return this;
    }

    public final AbstractElementAssert isDisabled() {

        isNotNull();

        if (actual.isEnabled()) {

            failWithMessage("Element {%s} with locator {%s} should be disabled !",
                    actual.getLocatorName(), actual.getLocatorValue());
            logFail("Element {" + actual.getLocatorName() + "} with locator {" +
                    actual.getLocatorValue() + "} should be disabled !");
        } else {
            logPass("Element {" + actual.getLocatorName() + "} is disabled");
        }
        return this;
    }

    public final AbstractElementAssert selectedDropdownEquals(final String condition) {

        isNotNull();

        if (!condition.equals
                (new Select(actual.getElement())
                        .getFirstSelectedOption()
                        .getText())) {

            failWithMessage("Element's {%s} selected dropdown value with locator {%s} should equal {%s} !",
                    actual.getLocatorName(), actual.getLocatorValue(), condition);
            logFail("Element's {" + actual.getLocatorName() + "} selected dropdown value with locator {" +
                    actual.getLocatorValue() + "} should equal {" + condition + "} !");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} selected dropdown value equals {" +
                    condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert selectedDropdownEqualsIgnoreCase(final String condition) {

        isNotNull();

        if (!condition.equalsIgnoreCase
                (new Select(actual.getElement())
                        .getFirstSelectedOption()
                        .getText())) {

            failWithMessage("Element's {%s} selected dropdown value with locator {%s} should equal {%s}" +
                    " (case is ignored)!", actual.getLocatorName(), actual.getLocatorValue(), condition);
            logFail("Element's {" + actual.getLocatorName() + "} selected dropdown value with locator {" +
                    actual.getLocatorValue() + "} should equal {" + condition + "} (case is ignored)!");
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} selected dropdown value equals {" +
                    condition + "} (case is ignored)");
        }
        return this;
    }

    public final AbstractElementAssert isSortedByAscent() {

        final List<String> gridsColumnValues = new LinkedList<>();

        for (int i = 0; i < actual.getElements().size(); i++) {
            gridsColumnValues.add(i, ((WebElement)(actual.getElements().get(i))).getText());
        }
        if (!Ordering
                .natural()
                .isOrdered(gridsColumnValues)) {
            failWithMessage("Element's {%$} data should be sorted by ascent ", actual.getLocatorName());
            logFail("Element's {" + actual.getLocatorName() + "} data should be sorted by ascent ");
        }
        return this;
    }

    public final AbstractElementAssert isMoreThan(int quantity) {
        if (actual.getElements().size() <= quantity) {
            failWithMessage("Element's {%$} data should be more, than {%$} ", actual.getLocatorName(), quantity);
            logFail("Element's {" + actual.getLocatorName() + "} data should be more than {"+quantity+ "}");
        }
        return this;
    }

    public final AbstractElementAssert isLessOrEqualsThan(int quantity) {
        if (actual.getElements().size() > quantity) {
            failWithMessage("Element's {%$} data should be less or equals, than {%$} ",
                    actual.getLocatorName(),quantity);
            logFail("Element's {" + actual.getLocatorName() + "} data should be less or equals" +
                    " than {"+quantity+ "}");
        }
        return this;
    }

    public final AbstractElementAssert isEqualTo(int quantity) {
        if (actual.getElements().size() != quantity) {
            failWithMessage("Element's {%$} data should be equal {%$} ", actual.getLocatorName(), quantity);
            logFail("Element's {" + actual.getLocatorName() + "} data should be equal {"+quantity+ "}");
        }
        return this;
    }

    public final AbstractElementAssert isParseEqualTo(int quantity){
        if(Integer.parseInt(actual.getText()) != quantity){
            failWithMessage("Element's {%$} data should be equal {%$} ", actual.getLocatorName(), quantity);
            logFail("Element's {" + actual.getLocatorName() + "} data should be equal {"+quantity+ "}");
        }
        return this;
    }

    public final AbstractElementAssert isParseMoreThan(int quantity){
        if(Integer.parseInt(actual.getText()) <= quantity){
            failWithMessage("Element's {%$} data should be more, than {%$} ", actual.getLocatorName(), quantity);
            logFail("Element's {" + actual.getLocatorName() + "} data should be more, than {"+quantity+ "}");
        }
        return this;
    }

    @Override
    public final AbstractElementAssert isNotNull() {

        if (actual == null) {

            failWithMessage("Required Element should be not null !");
            logFail("Required Element should be not null !");
        }
        return this;
    }

}
