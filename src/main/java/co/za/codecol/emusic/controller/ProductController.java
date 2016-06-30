package co.za.codecol.emusic.controller;

import co.za.codecol.emusic.domain.Cart;
import co.za.codecol.emusic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Cart cart;

    @RequestMapping(value = {"/", "/catalog"}, method = RequestMethod.GET)
    public String productList(Model model) {
        model.addAttribute("products", productService.selectProducts());
        model.addAttribute("cart", cart);
        return "index";
    }

//    @RequestMapping(name = "/customer/show")
//    public String showAccount() {
//        return "customer-account";
//    }

}
