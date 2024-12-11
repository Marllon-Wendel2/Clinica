package com.voll.ClinacaApi.Consultation.validation;

import com.voll.ClinacaApi.Consultation.dtos.DataConsult;
import com.voll.ClinacaApi.Consultation.repository.ConsultRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidtedPatientHaveOtherConsult implements ValidatorConsult{

    private ConsultRepository consultRepository;

    public void validate(DataConsult data) {
        var firsHours = data.data().withHour(7);
        var lastHours = data.data().withHour(18);
        var patientHaveConsult = consultRepository.existsByPatientIdAndDataBetween(data.idPacient(), firsHours, lastHours);
    }
}
