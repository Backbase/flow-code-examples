package com.backbase.flow.example.interaction.handler;


import com.backbase.flow.example.interaction.dto.RequestDTO;
import com.backbase.flow.example.interaction.dto.ResponseDTO;
import com.backbase.flow.interaction.engine.action.ActionHandler;
import com.backbase.flow.interaction.engine.action.ActionResult;
import com.backbase.flow.interaction.engine.action.InteractionContext;
import com.backbase.flow.example.casedata.CaseDefinitionExample1;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component("step-one-handler")
@RequiredArgsConstructor
public class StepOneHandler implements ActionHandler<RequestDTO, ResponseDTO> {


    @Override
    public ActionResult<ResponseDTO> handle(RequestDTO requestDTO, InteractionContext interactionContext) {

        String personalMessage = String.format("Hello %s %s!", requestDTO.getFirstName(), requestDTO.getLastName());

        log.info(personalMessage);

        CaseDefinitionExample1 simpleCaseDefinition = new CaseDefinitionExample1();
        simpleCaseDefinition.setFirstName(requestDTO.getFirstName());
        simpleCaseDefinition.setLastName(requestDTO.getLastName());

        interactionContext.saveCaseDataToReadCaseData(simpleCaseDefinition);

        ResponseDTO response = new ResponseDTO();
        response.setMessage(personalMessage);

        return new ActionResult<>(response);
    }

}