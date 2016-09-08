package academy.softserve.edu.utils;

import academy.softserve.edu.pageobjects.*;
import org.openqa.selenium.WebDriver;

public class ExtraPageParser {

    public static final PageObject getExtraPage(final String userType,
                                                final WebDriver driver) {
        final PageObject extraPage;
        switch (userType) {
            case "Administrator":
                extraPage = new AdministrationPage(driver);
                break;
            case "Merchandiser":
                extraPage = new MerchandiserOrderingPage(driver);
                break;
            case "Customer":
                extraPage = new CustomerOrderingPage(driver);
                break;
            case "Supervisor":
                extraPage = new ItemManagementPage(driver);
                break;
            default:
                extraPage = null;
        }
        return extraPage;
    }

}