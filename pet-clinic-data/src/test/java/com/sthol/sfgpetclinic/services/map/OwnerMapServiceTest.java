package com.sthol.sfgpetclinic.services.map;

import com.sthol.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final Long ownerID = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(ownerID);
        owner.setLastName(lastName);
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerID);

        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = new Owner();
        owner2.setId(id);
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {
        Owner owner2 = new Owner();
        Owner savedOwner = ownerMapService.save(owner2);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerID);

        assertEquals(ownerID, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastName);

        assertNotNull(smith);
        assertEquals(ownerID, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerMapService.findByLastName("foo");

        assertNull(smith);
    }
}