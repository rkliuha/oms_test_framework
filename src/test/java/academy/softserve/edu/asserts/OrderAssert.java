package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.Order;
import org.assertj.core.api.AbstractAssert;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

public class OrderAssert extends AbstractAssert<OrderAssert, Order> {

    OrderAssert(final Order actual) {
        super(actual, OrderAssert.class);
    }

    public static final OrderAssert assertThat(final Order actual) {
        return new OrderAssert(actual);
    }

    public final OrderAssert orderEquals(final Order condition) {

        isNotNull();

        if (!condition.equals(actual)) {

            failWithMessage("Order {%s} \n should equal \n {%s} !",
                    actual, condition);
            logFail("Order {" + actual + "} \n should equal \n {" + condition + "} !");
        } else {
            logPass("Orders are equal");
        }
        return this;
    }

    public final OrderAssert orderNumberEquals(final int condition) {

        isNotNull();

        if (!(condition == actual.getOrderNumber())) {
            failWithMessage("Order {id=%s} numbers {%s} should equal {%s} !",
                    actual.getId(), actual.getOrderNumber(), condition);
            logFail("Order {id=" + actual.getId() + "} numbers {" + actual.getOrderNumber() +
                    "} should equal {" + condition + "} !");
        } else {
            logPass("Order {id=" + actual.getId() + "} numbers equal {" + condition + "}");
        }
        return this;
    }

    public final OrderAssert orderNotEquals(final Order condition) {

        isNotNull();

        if (condition.equals(actual)) {

            failWithMessage("Order {%s} \n should not equal \n {%s} !",
                    actual, condition);
            logFail("Order {" + actual + "} \n should not equal \n {" + condition + "} !");
        } else {
            logPass("Orders are not equal");
        }
        return this;
    }

    public final OrderAssert orderNumberNotEquals(final int condition) {

        isNotNull();

        if (condition == actual.getOrderNumber()) {
            failWithMessage("Order {id=%s} numbers {%s} should not equal {%s} !",
                    actual.getId(), actual.getOrderNumber(), condition);
            logFail("Order {id=" + actual.getId() + "} numbers {" + actual.getOrderNumber() +
                    "} should not equal {" + condition + "} !");
        } else {
            logPass("Order {id=" + actual.getId() + "} numbers not equal {" + condition + "}");
        }
        return this;
    }

    public final OrderAssert isCreated(final int condition) {

        isNotNull();

        if (!(condition == actual.getOrderStatusReference())) {
            failWithMessage("Order {№%s} status is not Created !",
                    actual.getOrderNumber());
            logFail("Order {№" + actual.getOrderNumber() + "} status is not Created !");
        } else {
            logPass("Order {№" + actual.getOrderNumber() + "} status is Created");
        }
        return this;
    }

    public final OrderAssert isPending(final int condition) {

        isNotNull();

        if (!(condition == actual.getOrderStatusReference())) {
            failWithMessage("Order {№%s} status is not Pending !",
                    actual.getOrderNumber());
            logFail("Order {№" + actual.getOrderNumber() + "} status is not Pending !");
        } else {
            logPass("Order {№" + actual.getOrderNumber() + "} status is Pending");
        }
        return this;
    }

    public final OrderAssert isOrdered(final int condition) {

        isNotNull();

        if (!(condition == actual.getOrderStatusReference())) {
            failWithMessage("Order {№%s} status is not Ordered !",
                    actual.getOrderNumber());
            logFail("Order {№" + actual.getOrderNumber() + "} status is not Ordered !");
        } else {
            logPass("Order {№" + actual.getOrderNumber() + "} status is Ordered");
        }
        return this;
    }

    public final OrderAssert isDelivered(final int condition) {

        isNotNull();

        if (!(condition == actual.getOrderStatusReference())) {
            failWithMessage("Order {№%s} status is not Delivered !",
                    actual.getOrderNumber());
            logFail("Order {№" + actual.getOrderNumber() + "} status is not Delivered !");
        } else {
            logPass("Order {№" + actual.getOrderNumber() + "} status is Delivered");
        }
        return this;
    }

    @Override
    public final OrderAssert isNotNull() {

        if (actual == null) {

            failWithMessage("Required order should be not null !");
            logFail("Required order should be not null !");
        }
        return this;
    }

}
