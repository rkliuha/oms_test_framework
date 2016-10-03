package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.PAGE_NUMBER_TEXT;
import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserOrderingPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class MerchandiserOrderingPage extends PageObject<MerchandiserOrderingPage> {

    public final List<Double> GridsColumnDoubleValues = new ArrayList<>();

    //TODO remove
    public static final String MERCHANDISER_ORDERING_PAGE_URL = "http://192.168.56.101:8080/oms5/order.htm";
    public MerchandiserOrderingPage(final WebDriver driver) {
        super(driver);
    }
    // searchByText is unique MerchandiserOrderingPage element
    private final TextLabel searchByText = new TextLabel(driver, SEARCH_BY_TEXT);
    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);
    private final Dropdown searchDropdown = new Dropdown(driver, SEARCH_DROPDOWN);
    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);
    private final Button applyButton = new Button(driver, APPLY_BUTTON);

  

}
