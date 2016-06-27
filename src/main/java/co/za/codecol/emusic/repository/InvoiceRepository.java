package co.za.codecol.emusic.repository;


import co.za.codecol.emusic.domain.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    List<Invoice> findByIsProcessedTrue();

    List<Invoice> findByIsProcessedFalse();

    @Override
    List<Invoice> findAll();


}
