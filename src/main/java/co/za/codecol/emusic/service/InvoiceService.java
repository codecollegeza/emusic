package co.za.codecol.emusic.service;

import co.za.codecol.emusic.domain.Account;
import co.za.codecol.emusic.domain.Invoice;
import co.za.codecol.emusic.domain.LineItem;

import java.util.List;

/**
 * Created by user on 27/06/2016.
 */
public interface InvoiceService {
    Invoice displayInvoice(Account account, List<LineItem> lineItem);
}
