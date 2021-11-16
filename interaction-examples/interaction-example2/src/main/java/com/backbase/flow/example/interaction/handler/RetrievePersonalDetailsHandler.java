package com.backbase.flow.example.interaction.handler;


import com.backbase.flow.example.interaction.dto.PersonSearchCriteriaDTO;
import com.backbase.flow.example.interaction.dto.PersonalDetailsDTO;
import com.backbase.flow.interaction.engine.action.ActionHandler;
import com.backbase.flow.interaction.engine.action.ActionResult;
import com.backbase.flow.interaction.engine.action.InteractionContext;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component("retrieve-personal-details")
@RequiredArgsConstructor
public class RetrievePersonalDetailsHandler implements ActionHandler<PersonSearchCriteriaDTO, PersonalDetailsDTO> {


    @Override
    public ActionResult<PersonalDetailsDTO> handle(PersonSearchCriteriaDTO personSearchCriteria, InteractionContext interactionContext) {

        PersonalDetailsDTO personalDetails = null;
        personalDetails = this.retrievePersonalDetails(personSearchCriteria.getIdNumber());

        return new ActionResult<>(personalDetails);
    }


    private PersonalDetailsDTO retrievePersonalDetails(String idNumber) {
        PersonalDetailsDTO personalDetails = new PersonalDetailsDTO();
        personalDetails.setIdNumber(idNumber);

        if (idNumber.equals("12345678")) {
            personalDetails.setFirstName("Joe");
            personalDetails.setLastName("Soap");
        }

        return personalDetails;
    }


}