package co.za.codecol.emusic.service;

import co.za.codecol.emusic.repository.ProductRepository;
import co.za.codecol.emusic.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product selectProduct(String code) {
        return productRepository.findByCode(code);
    }

    @Override
    public Product selectProduct(long productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public List<Product> selectProducts() {
        return productRepository.findAll();
    }
}
