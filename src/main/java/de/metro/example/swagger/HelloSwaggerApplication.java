package de.metro.example.swagger;

import de.metro.example.swagger.data.Shelter;
import de.metro.example.swagger.resources.PetResource;
import de.metro.example.swagger.resources.Swagger;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

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

    @Override
    public void run(final HelloSwaggerConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new PetResource( new Shelter() ) );
        environment.jersey().register(new Swagger());
    }

}
