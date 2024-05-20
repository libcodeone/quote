package libcode.quote.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import libcode.quote.entities.Quote;
import libcode.quote.services.DataService;

/**
 *
 * @author 
 */
@Path("hi")
public class JakartaEE10Resource {
    
    @Inject
    private DataService service;
    
    @POST
    public Response saveQuote(Quote quote){
        
        service.saveQuote(quote);
        
        return Response
                .ok("Saved")
                .build();
    }
}
