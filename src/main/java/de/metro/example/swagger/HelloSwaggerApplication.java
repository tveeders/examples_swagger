package de.metro.example.swagger;

import de.metro.example.swagger.data.Shelter;
import de.metro.example.swagger.resources.PetResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
    }

    @Override
    public void run(final HelloSwaggerConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new PetResource( new Shelter() ) );
    }

}
