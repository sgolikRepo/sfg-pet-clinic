package com.sthol.sfgpetclinic.formatters;

import com.sthol.sfgpetclinic.model.PetType;
import com.sthol.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Controller
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String s, Locale locale) throws ParseException {
        Collection<PetType> petTypes = petTypeService.findAll();
        for (PetType petType: petTypes) {
            if (petType.getName().equals(s)) {
                return petType;
            }
        }

        throw new ParseException("type not found " + s, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
