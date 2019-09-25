package fish.payara.examples.microprofileonmicro.restclient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletionStage;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author Andrew Pielage <andrew.pielage@payara.fish>
 */
@Path("/RestClient")
@ApplicationScoped
public class RestClientEndpoints {
    
    @Inject
    @RestClient
    private RestClientExample restClientExample;
    
    @GET
    @Path("/SayHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return restClientExample.hello();
    }
    
    @GET
    @Path("/Hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Why Hello!";
    }
    
    @GET
    @Path("/SayHelloAsync")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> sayHelloAsync() {
        return restClientExample.asyncHello();
    }
    
    @GET
    @Path("/HelloAsync")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> helloAsync() {
        return restClientExample.asyncHello();
    }
    
    @GET
    @Path("/Greetings")
    public String greetings() throws URISyntaxException {
        RestClientExample remoteApi = RestClientBuilder.newBuilder()
                .baseUri(new URI("http://localhost:8080/RestClient"))
                .build(RestClientExample.class);
        
        return remoteApi.hello();
    }
    
}