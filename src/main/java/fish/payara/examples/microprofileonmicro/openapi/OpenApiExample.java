package fish.payara.examples.microprofileonmicro.openapi;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASModelReader;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.PathItem;

/**
 *
 * @author Andrew Pielage <andrew.pielage@payara.fish>
 */
public class OpenApiExample implements OASModelReader {

    @Override
    public OpenAPI buildModel() {
        return OASFactory.createObject(OpenAPI.class).path("/api/fake/read", OASFactory.createObject(PathItem.class)
                .GET(OASFactory.createObject(Operation.class).operationId("fake read resource")));
    }
    
}
