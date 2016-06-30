package co.za.codecol.emusic.controller;

import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.domain.Cart;
import co.za.codecol.emusic.dto.SignupForm;
import co.za.codecol.emusic.service.AccountService;
import co.za.codecol.emusic.support.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SignupController {

    private static final String SIGNUP_VIEW_NAME = "signup";

	@Autowired
	private AccountService accountService;

	@Autowired
	private Cart cart;

	@RequestMapping(value = "/signup")
	public String signup(Model model) {
		model.addAttribute(new SignupForm());
        model.addAttribute("cart", cart);
        return SIGNUP_VIEW_NAME;
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return SIGNUP_VIEW_NAME;
		}
		Account account = accountService.save(signupForm.createAccount());
		accountService.signin(account);
        MessageHelper.addSuccessAttribute(ra, "signup.success");
		return "redirect:/";
	}
}
