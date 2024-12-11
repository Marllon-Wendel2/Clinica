package com.voll.ClinacaApi.Consultation.validation;

import com.voll.ClinacaApi.Consultation.dtos.DataConsult;
import com.voll.ClinacaApi.patient.repository.PatientRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatedPacientAtiv implements ValidatorConsult{

    @Autowired
    private PatientRepository patientRepository;

    public void validate(DataConsult data) {
        if(data.idPacient() == null) {
            return;
        }

        var pacient = patientRepository.findById(data.idPacient());
        var pacientTrue = pacient.get();
        if(!pacientTrue.getAtivo()) {
            throw new ValidationException("Paciente não está ativo.");
        }
    }
}
