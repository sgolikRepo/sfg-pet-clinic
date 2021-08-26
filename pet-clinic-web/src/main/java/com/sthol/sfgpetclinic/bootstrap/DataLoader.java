package com.sthol.sfgpetclinic.bootstrap;

import com.sthol.sfgpetclinic.model.Owner;
import com.sthol.sfgpetclinic.model.Pet;
import com.sthol.sfgpetclinic.model.PetType;
import com.sthol.sfgpetclinic.model.Vet;
import com.sthol.sfgpetclinic.services.OwnerService;
import com.sthol.sfgpetclinic.services.PetTypeService;
import com.sthol.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Pet Type Loaded ...");


        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Smith");
        owner1.setAddress("Lisova 2");
        owner1.setCity("Snovyanka");
        owner1.setTelephone("0976985139");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthday(LocalDate.now());
        mikesPet.setName("Pirat");

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John2");
        owner2.setLastName("Smith2");
        owner2.setAddress("Lisova 4");
        owner2.setCity("Kiselovka");
        owner2.setTelephone("0976985136");

        Pet owner2Pet = new Pet();
        owner2Pet.setPetType(cat);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthday(LocalDate.now());
        owner2Pet.setName("Riziy");

        owner2.getPets().add(owner2Pet);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessie");
        vet1.setLastName("Holik");

        System.out.println("Owners Loaded ...");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie2");
        vet2.setLastName("Holik2");

        vetService.save(vet2);

        System.out.println("Vets Loaded ...");
    }
}
