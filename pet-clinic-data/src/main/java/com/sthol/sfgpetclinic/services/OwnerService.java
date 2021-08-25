package com.sthol.sfgpetclinic.services;

import com.sthol.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService <Owner,Long> {

    Owner findByLastName(String lastName);

}
