package co.za.codecol.emusic.controller;

import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.domain.Cart;
import co.za.codecol.emusic.service.EmailService;
import co.za.codecol.emusic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Cart cart;

    @Autowired
    private EmailService emailService;

    @RequestMapping(name = "/email/subscribe", method = RequestMethod.POST)
    public String sendSubsEmail(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "email") String toEmail) {
        emailService.subToEmailList(toEmail, firstName);
        return "index";
    }

    @RequestMapping(value = {"/","/catalog"}, method = RequestMethod.GET)
    public String productList(Model model) {
        model.addAttribute("products", productService.selectProducts());
        model.addAttribute("account", new Account("", "", "", "ROLE_USER"));
        model.addAttribute("cart", cart);
        return "index";
    }

}
