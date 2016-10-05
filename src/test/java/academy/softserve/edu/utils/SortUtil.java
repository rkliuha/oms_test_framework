package academy.softserve.edu.utils;


import academy.softserve.edu.elements.wrappers.Element;
import com.google.common.collect.Ordering;

import java.util.LinkedList;
import java.util.List;


public class SortUtil {

    public static final boolean isListSortedByAsc(final Element abstractElement) {

        final List<String> gridsColumnValues = new LinkedList<>();

        for (int i = 0; i < abstractElement.getElements().size(); i++) {
            gridsColumnValues.add(i, abstractElement.getElements().get(i).getText());
        }
        return Ordering
                .natural()
                .isOrdered(gridsColumnValues);
    }

    //Pull Double to List from list of elements.
    public final static boolean isListDoubleSortedByDescend(final Element abstractElement) {

        List<Double> gridsColumnDoubleValues = new LinkedList<>();

        for (int i = 0; i < abstractElement.getElements().size(); i++) {
            gridsColumnDoubleValues
                    .add(i, Double
                            .parseDouble(abstractElement
                                    .getElements()
                                    .get(i)
                                    .getText()));
        }
        return Ordering
                .natural()
                .reverse()
                .isOrdered(gridsColumnDoubleValues);
    }
}

