package academy.softserve.edu.elements.locatorstype;

import org.openqa.selenium.By;

public enum LocatorsType {

    BY_CLASS_NAME {
        @Override
        public By getBy(final String locator) {
            return By.className(locator);
        }
    },

    BY_ID {
        @Override
        public By getBy(final String locator) {
            return By.id(locator);
        }
    },


    BY_NAME {
        @Override
        public By getBy(final String locator) {
            return By.name(locator);
        }
    },

    BY_XPATH {
        @Override
        public By getBy(final String locator) {
            return By.xpath(locator);
        }
    },

    BY_CSS {
        @Override
        public By getBy(final String locator) {
            return By.cssSelector(locator);
        }
    },

    BY_LINK {
        @Override
        public By getBy(final String locator) {
            return By.linkText(locator);
        }
    };

    public abstract By getBy(final String locator);

}
