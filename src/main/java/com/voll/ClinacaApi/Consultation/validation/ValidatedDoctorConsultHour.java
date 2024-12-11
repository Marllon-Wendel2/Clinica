package com.voll.ClinacaApi.Consultation.validation;

import com.voll.ClinacaApi.Consultation.dtos.DataConsult;
import com.voll.ClinacaApi.Consultation.repository.ConsultRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatedDoctorConsultHour implements ValidatorConsult{

    @Autowired
    private ConsultRepository consultRepository;

    public void validate(DataConsult dataConsult) {
        var doctorHaveConsult = consultRepository.existsByDoctorIdAndData(dataConsult.idDoctor(), dataConsult.data());
        if(doctorHaveConsult) {
            throw new ValidationException("Médico já possui outra consulta agendada.");
        }
    }
}
