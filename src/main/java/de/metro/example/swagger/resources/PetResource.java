package de.metro.example.swagger.resources;

import de.metro.example.swagger.data.Shelter;
import de.metro.example.swagger.model.Pet;

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

    @GET
    @Path("/")
    @Produces( MediaType.APPLICATION_JSON + "; charset=UTF-8" )
    public Collection<Pet> fetchAll() {
        return shelter.getAnimals();
    }

    @PUT
    @Path("/")
    @Consumes( MediaType.APPLICATION_JSON + "; charset=UTF-8" )
    public void giveBirth( Pet newborn ) {
        shelter.addAnimal( newborn.getName(), newborn );
    }
}
