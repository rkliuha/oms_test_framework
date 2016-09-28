package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.Product;

public interface ProductDao {

    void createProduct(final Product product);

    Product getLastProduct();

    void deleteProduct(final int productId);
}
