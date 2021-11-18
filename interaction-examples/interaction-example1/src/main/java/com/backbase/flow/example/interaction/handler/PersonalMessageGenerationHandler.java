package com.backbase.flow.example.interaction.handler;


import com.backbase.flow.example.casedata.PersonalMessageState;
import com.backbase.flow.example.interaction.dto.RequestDTO;
import com.backbase.flow.example.interaction.dto.ResponseDTO;
import com.backbase.flow.interaction.engine.action.ActionHandler;
import com.backbase.flow.interaction.engine.action.ActionResult;
import com.backbase.flow.interaction.engine.action.InteractionContext;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component("generate-personal-message")
@RequiredArgsConstructor
public class PersonalMessageGenerationHandler implements ActionHandler<RequestDTO, ResponseDTO> {


    @Override
    public ActionResult<ResponseDTO> handle(RequestDTO requestDTO, InteractionContext interactionContext) {

        String personalMessage = String.format("Hello %s %s!", requestDTO.getFirstName(), requestDTO.getLastName());

        log.info(personalMessage);

        PersonalMessageState messageState = new PersonalMessageState();
        messageState.setFirstName(requestDTO.getFirstName());
        messageState.setLastName(requestDTO.getLastName());

        interactionContext.saveCaseDataToReadCaseData(messageState);

        ResponseDTO response = new ResponseDTO();
        response.setMessage(personalMessage);

        return new ActionResult<>(response);
    }

}