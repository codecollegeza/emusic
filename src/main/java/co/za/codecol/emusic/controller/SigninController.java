package co.za.codecol.emusic.controller;

import co.za.codecol.emusic.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

    @Autowired
    private Cart cart;

	@RequestMapping(value = "/signin")
	public String signin(Model model) {
        model.addAttribute("cart", cart);
        return "signin";
    }
}
