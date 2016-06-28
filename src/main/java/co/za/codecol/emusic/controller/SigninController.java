package co.za.codecol.emusic.controller;

import co.za.codecol.emusic.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

	@RequestMapping(value = "signin")
	public String signin(Model model) {
        model.addAttribute("account", new Account("", "", "", "ROLE_USER"));
        return "signin";
    }
}
