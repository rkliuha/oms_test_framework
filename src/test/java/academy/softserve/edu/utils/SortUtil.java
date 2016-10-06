package academy.softserve.edu.utils;


import com.google.common.collect.Ordering;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class SortUtil {

    public static final boolean isListSortedByAsc(final List<WebElement> elementsList) {

        final List<String> gridsColumnValues = new LinkedList<>();

        gridsColumnValues.addAll(elementsList
                        .stream()
                        .map(WebElement::getText)
                        .collect(Collectors
                                .toList()));

        return Ordering
                .natural()
                .isOrdered(gridsColumnValues);
    }

    //TODO re-consider
    //Pull Double to List from list of elements.
    public final static boolean isListDoubleSortedByDescend(final List<WebElement> elementsList) {

        List<Double> gridsColumnDoubleValues = new LinkedList<>();

        for (int i = 0; i < elementsList.size(); i++) {
            gridsColumnDoubleValues
                    .add(i, Double
                            .parseDouble(elementsList
                                    .get(i)
                                    .getText()));
        }
        return Ordering
                .natural()
                .reverse()
                .isOrdered(gridsColumnDoubleValues);
    }
}

