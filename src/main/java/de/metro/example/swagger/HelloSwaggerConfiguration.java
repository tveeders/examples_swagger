package de.metro.example.swagger;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class HelloSwaggerConfiguration extends Configuration {
    public SwaggerBundleConfiguration swagger;
    public OpenAPI openAPI;
}
