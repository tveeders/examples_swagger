package de.metro.example.swagger;

import de.metro.example.swagger.data.Shelter;
import de.metro.example.swagger.resources.PetResource;
import de.metro.example.swagger.resources.Swagger;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.v3.jaxrs2.integration.JaxrsAnnotationScanner;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.SwaggerConfiguration;

import java.util.Collections;

public class HelloSwaggerApplication extends Application<HelloSwaggerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloSwaggerApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloSwagger";
    }

    @Override
    public void initialize(final Bootstrap<HelloSwaggerConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<HelloSwaggerConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(HelloSwaggerConfiguration configuration) {
                return configuration.swagger;
            }
        });
    }

    private void setupSwagger(
            final HelloSwaggerConfiguration configuration,
            final Environment environment ) {

        final SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration()
                .openAPI( configuration.openAPI )
                .prettyPrint( true )
                .scannerClass( JaxrsAnnotationScanner.class.getName() )
                .resourceClasses( Collections.singleton( PetResource.class.getName() ) );

        environment.jersey().register( new OpenApiResource().openApiConfiguration( swaggerConfiguration ) );
    }

    @Override
    public void run(final HelloSwaggerConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new PetResource( new Shelter() ) );
        environment.jersey().register(new Swagger());
        setupSwagger( configuration, environment );
    }

}
