package libcode.quote.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.UUID;
import libcode.quote.entities.*;
import libcode.quote.services.DataService;
import lombok.Data;
import org.primefaces.convert.DateTimeConverter;

/**
 *
 * @author luisibarra
 */
@Named
@SessionScoped
@Data
public class QuoteController implements Serializable {

    private List<DetailQuote> details;

    private DetailQuote detail;

    private Quote quote;

    @Inject
    private DataService servicio;

    @PostConstruct
    public void loadObj() {

        this.details = new ArrayList<>();

        this.detail = new DetailQuote();
       
        this.quote = new Quote();
        quote.setDate(new Date());
    }

    public void saveQuote() {

        quote.setDetails(details);
        servicio.saveQuote(quote);
        detail = new DetailQuote();
        details = new ArrayList<>();
        quote = new Quote();

    }

    public void addDetail() {
        DetailQuote detailSave = new DetailQuote(null, detail.getProductName(),
                detail.getPrice(), detail.getQuantity(), detail.getParcialTotal(), null, UUID.randomUUID().toString());
        details.add(detailSave);
        detail = new DetailQuote();

    }

    public void calculateTotalParcial() {
        detail.setParcialTotal(
                (detail.getPrice() != null ? detail.getPrice() : 0.0)
                * (detail.getQuantity() != null ? detail.getQuantity() : 0));
    }

    public void deleteDetail(DetailQuote detail) {
        details.remove(details.stream().filter(e -> e.getTempId().equals(detail.getTempId())).toList().get(0));
    }


}
