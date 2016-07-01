package co.za.codecol.emusic.controller;

import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.domain.Cart;
import co.za.codecol.emusic.domain.Invoice;
import co.za.codecol.emusic.repository.AccountRepository;
import co.za.codecol.emusic.service.AccountService;
import co.za.codecol.emusic.service.DefaultEmailService;
import co.za.codecol.emusic.service.EmailService;
import co.za.codecol.emusic.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.security.Principal;

@Controller
public class CheckoutController {

    @Autowired
    private Cart cart;

    @Autowired
    private Account account;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/checkout/delivery")
    public String comfirmDelivery(Model model, Principal principal) {
        model.addAttribute("account", getAccount(principal));
        model.addAttribute("cart", cart);
        return "checkout2";
    }


    @RequestMapping(value = "/checkout/payment")
    public String comfirmPayment(Model model, Principal principal) {
        model.addAttribute("account", getAccount(principal));
        model.addAttribute("cart", cart);
        return "checkout3";
    }

    @RequestMapping(value = "/checkout/order")
    public String comfirmOrder(Model model, Principal principal) {
        model.addAttribute("account", getAccount(principal));
        model.addAttribute("cart", cart);
        Invoice invoice = invoiceService.displayInvoice(account, cart.getItems());
        model.addAttribute("invoice", invoice);

        return "checkout4";
    }

//    @RequestMapping(name = "/checkout/placeOrder")
    public String placeOrder(Model model, Principal principal) throws MessagingException {
        Account newAcc = getAccount(principal);
        model.addAttribute("account", newAcc);
        if (newAcc.getEmail() != null)
            emailService.sendConfirmationEmail(newAcc.getEmail());
        model.addAttribute("cart", cart);
        return "index";
    }

    @RequestMapping(value = "/checkout")
    public String startCheckout(Model model, Principal principal) {
        model.addAttribute("cart", cart);
        model.addAttribute("account", getAccount(principal));
        return "checkout1";
    }

    private Account getAccount(Principal principal) {
        User user = (User) ((Authentication) principal).getPrincipal();
        return accountService.findOneByEmail(user.getUsername());
    }

    @RequestMapping(value = "/checkout/processUser")
    public String processUser(Model model, @RequestParam(name = "firstName") String firstName,
                              @RequestParam(name = "lastName") String lastName,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "address1") String address1,
                              @RequestParam(name = "address2") String address2,
                              @RequestParam(name = "company") String companyName,
                              @RequestParam(name = "zip") String zip,
                              @RequestParam(name = "country") String country,
                              @RequestParam(name = "state") String state) {

        account.setName(firstName);
        account.setAddress1(address1);
        account.setAddress2(address2);
        account.setEmail(email);
        account.setLastName(lastName);
        account.setCompanyName(companyName);
        account.setZip(zip);
        account.setCountry(country);
        account.setSt(state);

        accountService.save(account);
        return "checkout1";
    }


}
