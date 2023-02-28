package de.metro.example.swagger.resources;

import de.metro.example.swagger.data.Shelter;
import de.metro.example.swagger.model.Pet;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/pet")
public class PetResource {

    private Shelter shelter;
    public PetResource(final Shelter shelter ) {
        this.shelter = shelter;
    }

    @Operation( operationId = "Fetch pet by name", responses = {
            @ApiResponse( responseCode = "200", description = "Pet details.", content = @Content( schema = @Schema( implementation = Pet.class ) ) ),
            @ApiResponse( responseCode = "404", description = "Pet not found" ) } )
    @GET
    @Path("/{name}")
    @Produces( MediaType.APPLICATION_JSON + "; charset=UTF-8" )
    public Pet fetch(@PathParam("name") String petName ) {
        final Pet pet = shelter.getAnimal( petName );
        if( pet != null ) {
            return pet;
        }
        throw new NotFoundException( "Pet with name " + petName + " does not belong to our shelter" );
    }

    @Operation( operationId = "Fetch all pets", responses = {
            @ApiResponse( responseCode = "200", description = "All pet details." ) } )
    @GET
    @Path("/")
    @Produces( MediaType.APPLICATION_JSON + "; charset=UTF-8" )
    public Collection<Pet> fetchAll() {
        return shelter.getAnimals();
    }

    @Operation( operationId = "Add another pet to the ", responses = {
            @ApiResponse( responseCode = "200", description = "All pet details." ) } )
    @PUT
    @Path("/")
    @Consumes( MediaType.APPLICATION_JSON + "; charset=UTF-8" )
    public void giveBirth( Pet newborn ) {
        shelter.addAnimal( newborn.getName(), newborn );
    }
}
