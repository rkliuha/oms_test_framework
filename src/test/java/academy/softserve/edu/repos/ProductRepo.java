package academy.softserve.edu.repos;

import academy.softserve.edu.domains.Product;

public class ProductRepo {

    private ProductRepo() {

    }

    public static Product productRepo() {

        return Product.newBuilder()
                .setId(0)
                .setProductActive(1)
                .setProductDescription("Original Irish Cream")
                .setProductName("Baileys")
                .setProductPrice(500.0)
                .build();
    }
}
