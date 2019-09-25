package fish.payara.examples.microprofileonmicro.openapi;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 *
 * @author Andrew Pielage <andrew.pielage@payara.fish>
 */
@ApplicationScoped
@Path("/OpenApi")
public class OpenApiEndpoints {
    
    @GET
    @Path("/Wobbles")
    @Operation(operationId = "Wibbles", summary = "Wibs", description = "Wibbles to and fro")
    public String wobbles() {
        return "Wibbly Wobbly!";
    }
}
