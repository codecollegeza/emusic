package co.za.codecol.emusic.controller;


import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.domain.Cart;
import co.za.codecol.emusic.service.AccountService;
import co.za.codecol.emusic.service.EmailService;
import co.za.codecol.emusic.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;

@Controller
public class EmailController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private Cart cart;

    @Autowired
    private Account account;

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private EmailService emailService;

   // @RequestMapping(name = "/checkout/placeOrder")
    public String placeOrder(Model model) throws MessagingException {

        if (account.getEmail() != null) {
            emailService.sendConfirmationEmail(account.getEmail());
        }
        model.addAttribute("account", account);
        model.addAttribute("cart", cart);
        return "index";
    }

}
