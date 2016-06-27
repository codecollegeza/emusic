package co.za.codecol.emusic.controller;

import co.za.codecol.emusic.domain.Cart;
import co.za.codecol.emusic.domain.LineItem;
import co.za.codecol.emusic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private Cart cart;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/cart/addItem", method = RequestMethod.POST)
    public String addToCart(@RequestParam(name = "productCode") String productCode, Model model) {
        LineItem lineItem = new LineItem();
        lineItem.setProduct(productService.selectProduct(productCode));
        cart.addItem(lineItem);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping(value = "/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping(value = "/cart/removeItem", method = RequestMethod.POST)
    public String removeItem(@RequestParam(name = "productCode") String productCode, Model model) {
        LineItem lineItem = new LineItem();
        lineItem.setProduct(productService.selectProduct(productCode));
        cart.removeItem(lineItem);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping(value = "/cart/updateItem", method = RequestMethod.POST)
    public String updateItem(@RequestParam(name = "productCode") String productCode,
                             @RequestParam(name = "quantity") String quantity, Model model) {
        cart.getItems();
        LineItem lineItem = new LineItem();
        lineItem.setProduct(productService.selectProduct(productCode));
        int newQty = Integer.parseInt(quantity);
        lineItem.setQuantity(newQty);
        cart.addItem(lineItem);
        model.addAttribute("cart", cart);
        return "cart";
    }
}
