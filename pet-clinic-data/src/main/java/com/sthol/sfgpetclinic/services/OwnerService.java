package com.sthol.sfgpetclinic.services;

import com.sthol.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner Owner);

    Set<Owner> findAll();
}
