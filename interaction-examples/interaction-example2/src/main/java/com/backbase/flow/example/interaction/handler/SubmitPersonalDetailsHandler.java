package com.backbase.flow.example.interaction.handler;


import com.backbase.flow.example.casedata.CustomerOnboarding;
import com.backbase.flow.example.casedata.InterActionState;
import com.backbase.flow.example.casedata.PersonalDetails;
import com.backbase.flow.example.interaction.dto.PersonalDetailsDTO;
import com.backbase.flow.interaction.engine.action.ActionHandler;
import com.backbase.flow.interaction.engine.action.ActionResult;
import com.backbase.flow.interaction.engine.action.InteractionContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component("submit-personal-details")
@RequiredArgsConstructor
public class SubmitPersonalDetailsHandler implements ActionHandler<PersonalDetailsDTO, PersonalDetailsDTO> {


    @Override
    public ActionResult<PersonalDetailsDTO> handle(PersonalDetailsDTO personalDetailsDTO, InteractionContext interactionContext) {

        CustomerOnboarding customerOnboarding = new CustomerOnboarding();

        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName(personalDetailsDTO.getFirstName());
        personalDetails.setLastName(personalDetailsDTO.getLastName());
        personalDetails.setIdNumber(personalDetailsDTO.getIdNumber());

        InterActionState interActionState = new InterActionState();
        interActionState.setIsPersonalDetailsCaptured(true);

        customerOnboarding.setPersonalDetails(personalDetails);
        customerOnboarding.setInterActionState(interActionState);

        interactionContext.saveCaseDataToReadCaseData(customerOnboarding);

        return new ActionResult<>(personalDetailsDTO);
    }


}