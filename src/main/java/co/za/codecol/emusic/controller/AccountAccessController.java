package co.za.codecol.emusic.controller;

import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.domain.Cart;
import co.za.codecol.emusic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class AccountAccessController {

    @Autowired
    private Account account;

    @Autowired
    private AccountService accountService;

    @Autowired
    private Cart cart;

    @RequestMapping(value = "/customer/show")
    public String customer(Model model, Principal principal){
        model.addAttribute("cart", cart);
        model.addAttribute("account", getAccount(principal));
        return "customer-account";
    }


    private Account getAccount(Principal principal) {
        User user = (User) ((Authentication) principal).getPrincipal();
        return accountService.findOneByEmail(user.getUsername());
    }

    @RequestMapping(value="/accountaccess")
    public String saveAccountChanges(Model model, Principal principal,
                                     @RequestParam(name = "firstName") String firstName,
                                     @RequestParam(name = "lastName") String lastName,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "address1") String address1,
                                     @RequestParam(name = "address2") String address2,
                                     @RequestParam(name = "company") String companyName,
                                     @RequestParam(name = "zip") String zip,
                                     @RequestParam(name = "country") String country,
                                     @RequestParam(name = "state") String state){
            account.setName(firstName);
            account.setAddress1(address1);
            account.setAddress2(address2);
            account.setEmail(email);
            account.setLastName(lastName);
            account.setCompanyName(companyName);
            account.setZip(zip);
            account.setCountry(country);
            account.setSt(state);

            accountService.updateAccount(account);
        model.addAttribute("cart", cart);
        model.addAttribute("account", getAccount(principal));
        return "customer-account";
    }


    @RequestMapping(value="/updatePassword")
    public String updatePassword(Model model, Principal principal,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam(name = "newPassword") String newPassword,
                                     @RequestParam(name = "retypedPassword") String retypedpassword
                                 ) throws Exception{

        model.addAttribute("cart", cart);
        model.addAttribute("account", getAccount(principal));
        if(!retypedpassword.equals(newPassword)) {
            return "customer-account";
        }
        Account account = getAccount(principal);
        accountService.updatePassword(account, password, retypedpassword);
        return "customer-account";
    }

}
