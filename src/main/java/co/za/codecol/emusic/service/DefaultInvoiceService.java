package co.za.codecol.emusic.service;

import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.domain.Invoice;
import co.za.codecol.emusic.domain.LineItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DefaultInvoiceService implements InvoiceService{

    @Override
    public Invoice displayInvoice(Account account, List<LineItem> lineItem) {
        Date today = new Date();
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(today);
        invoice.setUser(account);
        invoice.setLineItems(lineItem);
        return invoice;
    }
}
