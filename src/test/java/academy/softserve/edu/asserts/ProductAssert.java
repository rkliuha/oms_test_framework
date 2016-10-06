package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.Product;
import org.assertj.core.api.AbstractAssert;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

public class ProductAssert extends AbstractAssert<ProductAssert, Product> {

    ProductAssert(final Product actual) {
        super(actual, ProductAssert.class);
    }

    public static final ProductAssert assertThat(final Product actual) {
        return new ProductAssert(actual);
    }

    public final ProductAssert productEquals(final Product condition) {

        isNotNull();

        if (!condition.equals(actual)) {

            failWithMessage("Product {%s} \n should equal \n {%s} !",
                    actual, condition);
            logFail("Product {" + actual + "} \n should equal \n {" + condition + "} !");
        } else {
            logPass("Products are equal");
        }
        return this;
    }

    public final ProductAssert nameEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getProductName())) {
            failWithMessage("Product's {id=%s} name {%s} should equal {%s} !",
                    actual.getId(), actual.getProductName(), condition);
            logFail("Product's {id=" + actual.getId() + "} name {" + actual.getProductName() +
                    "} should equal {" + condition + "} !");
        } else {
            logPass("Product's {id=" + actual.getId() + "} name equals {" + condition + "}");
        }
        return this;
    }

    public final ProductAssert descriptionEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getProductDescription())) {
            failWithMessage("Product's {id=%s} description {%s} should equal {%s} !",
                    actual.getId(), actual.getProductDescription(), condition);
            logFail("Product's {id=" + actual.getId() + "} description {" + actual.getProductDescription() +
                    "} should equal {" + condition + "} !");
        } else {
            logPass("Product's {id=" + actual.getId() + "} description equals {" + condition + "}");
        }
        return this;
    }

    public final ProductAssert priceEquals(final String condition) {

        isNotNull();

        if (Double.parseDouble(condition) != actual.getProductPrice()) {
            failWithMessage("Product's {id=%s} price {%s} should equal {%s} !",
                    actual.getId(), actual.getProductPrice(), condition);
            logFail("Product's {id=" + actual.getId() + "} price {" + actual.getProductPrice() +
                    "} should equal {" + condition + "} !");
        } else {
            logPass("Product's {id=" + actual.getId() + "} price equals {" + condition + "}");
        }
        return this;
    }

    @Override
    public final ProductAssert isNotNull() {

        if (actual == null) {

            failWithMessage("Required product should be not null !");
            logFail("Required product should be not null !");
        }
        return this;
    }

    public final void isNull() {

        if (!(actual == null)) {

            failWithMessage("Required product should be null !");
            logFail("Required product should be null !");
        }
    }
}
