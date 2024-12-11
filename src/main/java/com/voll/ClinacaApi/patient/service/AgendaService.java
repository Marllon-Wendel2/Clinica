package com.voll.ClinacaApi.patient.service;

import com.voll.ClinacaApi.Consultation.dtos.DataConsult;
import com.voll.ClinacaApi.Consultation.dtos.DatailsOfConsult;
import com.voll.ClinacaApi.Consultation.model.Consultion;
import com.voll.ClinacaApi.Consultation.repository.ConsultRepository;
import com.voll.ClinacaApi.Consultation.validation.ValidatorConsult;
import com.voll.ClinacaApi.doctor.model.Doctor;
import com.voll.ClinacaApi.doctor.repository.DoctorRepository;
import com.voll.ClinacaApi.patient.repository.PatientRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private ConsultRepository consultRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private List<ValidatorConsult> validators;

    public DatailsOfConsult agendar(DataConsult dataConsult) {
        if(dataConsult.idDoctor() == null) {
            choiceRandomDoctor(dataConsult);
            verifyPatient(dataConsult.idPacient());
        } else {
        verifyDoctor(dataConsult.idDoctor());
        verifyPatient(dataConsult.idPacient());
        }

        validators.forEach(v -> v.validate(dataConsult));

        var patient = patientRepository.findById(dataConsult.idPacient()).get();
        var doctor = doctorRepository.findById(dataConsult.idDoctor()).get();

        var consult = new Consultion(null, doctor, patient, dataConsult.data());

        consultRepository.save(consult);

        return new DatailsOfConsult(consult);
    }

    private Doctor choiceRandomDoctor(DataConsult dataConsult) {
        if(dataConsult.especialidade() == null) {
            throw new ValidationException("Informe um médico ou especilidade que deseja");
        }

        return doctorRepository.choiceRandomFreeDoctor(dataConsult.especialidade(), dataConsult.data());
    }

    private Boolean verifyDoctor(Long id) {
        var result = doctorRepository.existsById(id);
        if(!result) {
            throw new ValidationException("Id do médico não existe");
        } else {
            return result;
        }

    }



    private Boolean verifyPatient(Long id) {
        var result = patientRepository.existsById(id);
        if(!result) {
            throw new ValidationException("Id do paciente não existe");
        } else {
            return result;
        }

    }
}
