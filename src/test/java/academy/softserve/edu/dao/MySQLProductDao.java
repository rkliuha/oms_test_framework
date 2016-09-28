package academy.softserve.edu.dao;

import academy.softserve.edu.dao.interfaces.ProductDao;
import academy.softserve.edu.domains.Product;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class MySQLProductDao implements ProductDao {

    private static final String CREATE_PRODUCT_QUERY = "INSERT INTO Products(IsProductActive," +
            " ProductDescription, ProductName, ProductPrice) VALUES(?, ?, ?, ?);";
    private static final String GET_LAST_PRODUCT_QUERY = "SELECT ID, IsProductActive," +
            " ProductDescription, ProductName, ProductPrice FROM Products ORDER BY ID DESC LIMIT 1;";
    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM Products WHERE ID = ?;";

    private final Connection connection;

    @Override
    public final void createProduct(final Product product) {

        try (final PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT_QUERY)) {
            preparedStatement.setInt(1, product.getProductActive());
            preparedStatement.setString(2, product.getProductDescription());
            preparedStatement.setString(3, product.getProductName());
            preparedStatement.setDouble(4, product.getProductPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final Product getLastProduct() {

        Product product = null;
        try (final PreparedStatement preparedStatement = connection.prepareStatement(GET_LAST_PRODUCT_QUERY)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            product = Product.newBuilder()
                    .setId(resultSet.getInt("ID"))
                    .setProductActive(resultSet.getInt("IsProductActive"))
                    .setProductDescription(resultSet.getString("ProductDescription"))
                    .setProductName(resultSet.getString("ProductName"))
                    .setProductPrice(resultSet.getDouble("ProductPrice"))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public final void deleteProduct(final int productId) {

        try (final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
