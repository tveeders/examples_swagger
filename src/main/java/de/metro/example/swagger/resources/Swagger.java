package de.metro.example.swagger.resources;

import com.google.common.io.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.nio.charset.StandardCharsets;

@Path( "/static_openapi.yaml" )
public class Swagger {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSwagger() {
        return getSwaggerDefinition( "openapi.yaml" );
    }
    public String getSwaggerDefinition( final String resourcePath ) {
        final String definition;
        try {
            definition = Resources.toString(
                    Resources.getResource( resourcePath ),
                    StandardCharsets.UTF_8 );
        } catch ( final Exception ex ) {
            throw new RuntimeException( ex );
        }
        return definition;
    }
}
