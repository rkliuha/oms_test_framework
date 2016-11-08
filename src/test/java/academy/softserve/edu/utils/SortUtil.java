package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Orderliness;
import com.google.common.collect.Ordering;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static academy.softserve.edu.enums.Orderliness.DESCENT;

public final class SortUtil {

    private SortUtil() {

    }

    public static final boolean isListSorted(final List<WebElement> elementsList, Orderliness order) {

        final List<String> gridsColumnValues = elementsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        if (order == DESCENT) {
            return Ordering
                    .natural()
                    .reverse()
                    .isOrdered(gridsColumnValues);
        } else {
            return Ordering.natural()
                    .isOrdered(gridsColumnValues);
        }
    }


    public final static boolean isDoubleListSorted(final List<WebElement> elementsList, Orderliness order) {

        final ArrayList<Double> gridsColumnDoubleValues = elementsList.stream()
                .map(WebElement::getText).map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayList::new));

        if (order == DESCENT) {
            return Ordering
                    .natural()
                    .reverse()
                    .isOrdered(gridsColumnDoubleValues);
        } else {
            return Ordering.natural()
                    .isOrdered(gridsColumnDoubleValues);
        }
    }


}

