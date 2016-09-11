package academy.softserve.edu.pageobjects;

import org.openqa.selenium.WebDriver;

public class AdministrationPage extends PageObject {

    public static final String ADMINISTRATION_PAGE_URL
            = "http://192.168.56.101:8080/oms5/users.htm";

    public AdministrationPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage clickUserInfoTab() {
        driver.findElement(UserInfoPage.USER_INFO_LINK).click();
        return new UserInfoPage(driver);
    }
}
