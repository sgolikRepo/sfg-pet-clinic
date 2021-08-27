package com.sthol.sfgpetclinic.services.springdatajpa;

import com.sthol.sfgpetclinic.model.Owner;
import com.sthol.sfgpetclinic.repositories.OwnerRepository;
import com.sthol.sfgpetclinic.repositories.PetRepository;
import com.sthol.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    String lastName = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner owner1;
    final Long owner1Id = 1L;

    Owner owner2;
    final Long owner2Id = 2L;

    @BeforeEach
    void setUp() {
        owner1 = new Owner();
        owner1.setId(owner1Id);
        owner1.setLastName(lastName);

        owner2 = new Owner();
        owner2.setId(owner2Id);
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner1));

        Owner owner = ownerSDJpaService.findById(owner1Id);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findById(owner1Id);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        when(ownerRepository.save(any())).thenReturn(owner1);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner1);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(owner1Id);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner1);
        Owner smith = ownerSDJpaService.findByLastName(lastName);

        assertEquals(lastName , smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}