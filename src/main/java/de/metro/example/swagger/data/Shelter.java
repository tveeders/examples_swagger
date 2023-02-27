package de.metro.example.swagger.data;

import de.metro.example.swagger.model.AnimalType;
import de.metro.example.swagger.model.Color;
import de.metro.example.swagger.model.Pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shelter {

    private Map<String, Pet> animals = new HashMap<String, Pet>();

    public Shelter() {
        animals.put( "Carl", Pet.builder()
                .animalType( AnimalType.DOG )
                .age( 5 )
                .color( List.of( Color.BLACK ) )
                .name( "Carl" )
                .hungry( true )
                .thirsty( false )
                .owner( "Carl-Heinz")
                .build() );

        animals.put( "Siggi", Pet.builder()
                .animalType( AnimalType.DOG )
                .age( 5 )
                .color( List.of( Color.WHITE, Color.BLACK ) )
                .name( "Siggi" )
                .hungry( false )
                .thirsty( false )
                .owner( "Siegfried" )
                .build() );

        animals.put( "Nelly", Pet.builder()
                .animalType( AnimalType.CAT )
                .age( 5 )
                .color( List.of( Color.BROWN, Color.DARK_BROWN ) )
                .name( "Nelly" )
                .hungry( true )
                .thirsty( true )
                .owner( "Julia" )
                .build() );
    }

    public Pet getAnimal( final String name ) {
        return animals.get( name );
    }

    public Collection<Pet> getAnimals() {
        return animals.values();
    }

    public void addAnimal( final String name, final Pet pet ) {
        animals.put( name, pet );
    }
}
