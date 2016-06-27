package co.za.codecol.emusic.service;


import co.za.codecol.emusic.domain.Product;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {

    /**
     * Admin service to persist a product
     *
     * @param product
     * @return A persisted Product
     */
    Product addProduct(Product product);

    /**
     * Admin service to update a persisted product
     *
     * @param product
     * @return An updated Product
     */
    Product updateProduct(Product product);


    /**
     * Service to return a product by its product code
     *
     * @param code
     * @return product
     */
    Product selectProduct(String code);

    /**
     * Service to get a product by its ID
     *
     * @param productId
     * @return
     */
    Product selectProduct(long productId);

    /**
     * Service to return a list of Products
     *
     * @return a List of Products
     */
    List<Product> selectProducts();

}
