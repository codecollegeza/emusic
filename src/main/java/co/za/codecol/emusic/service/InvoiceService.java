package co.za.codecol.emusic.service;

import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.domain.Invoice;
import co.za.codecol.emusic.domain.LineItem;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface InvoiceService {
    Invoice displayInvoice(Account account, List<LineItem> lineItem);
}
