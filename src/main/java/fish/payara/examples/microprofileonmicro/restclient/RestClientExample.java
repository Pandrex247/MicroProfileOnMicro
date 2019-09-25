package fish.payara.examples.microprofileonmicro.restclient;

import java.util.concurrent.CompletionStage;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author Andrew Pielage <andrew.pielage@payara.fish>
 */
@Path("/api/RestClient")
@RegisterRestClient
@ApplicationScoped
public interface RestClientExample {
    
    @Path("/Hello")
    @GET
    String hello();
    
    @Path("/HelloAsync")
    @GET
    CompletionStage<String> asyncHello();
    
}
