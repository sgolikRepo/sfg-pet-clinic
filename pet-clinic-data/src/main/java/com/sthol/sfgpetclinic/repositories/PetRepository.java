package com.sthol.sfgpetclinic.repositories;

import com.sthol.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
