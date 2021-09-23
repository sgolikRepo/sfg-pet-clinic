package com.sthol.sfgpetclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseEntity{
    private String userName;
    private String password;
    private boolean enabled;
}
