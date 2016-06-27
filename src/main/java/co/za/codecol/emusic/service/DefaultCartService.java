package co.za.codecol.emusic.service;


import co.za.codecol.emusic.domain.Cart;
import co.za.codecol.emusic.domain.LineItem;
import co.za.codecol.emusic.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DefaultCartService implements CartService {

    @Autowired
    private Cart cart;

    @Autowired
    private ProductService productService;

    @Override
    public void setItems(List<LineItem> items) {
        cart.setItems(items);
    }

    @Override
    public List<LineItem> getItems() {
        return cart.getItems();
    }

    @Override
    public int getCount() {
        return cart.getCount();
    }

    @Override
    public void addItem(String productCode) {
        cart.addItem(getProductAsLineItem(productCode));
    }

    @Override
    public void removeItem(String productCode) {
        cart.removeItem(getProductAsLineItem(productCode));
    }

    private LineItem getProductAsLineItem(String productCode) {
        Product product = productService.selectProduct(productCode);
        LineItem lineItem = new LineItem();
        if (product != null) {
            lineItem.setProduct(product);
        }
        return lineItem;
    }
}
