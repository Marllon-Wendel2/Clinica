package com.voll.ClinacaApi.patient.model;

import com.voll.ClinacaApi.Address.model.Address;
import com.voll.ClinacaApi.patient.dtos.DataUpadatePatient;
import com.voll.ClinacaApi.patient.dtos.PatientData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "patient")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Boolean ativo;

    @Embedded
    private Address endereco;

    public Patient(PatientData patientData) {
        this.nome = patientData.nome();
        this.email = patientData.email();
        this.telefone = patientData.telefone();
        this.cpf = patientData.cpf();
        this.endereco = new Address(patientData.endereco());
    }

    public void updateInformation(DataUpadatePatient data) {
        if(data.nome() != null) {
            this.nome = data.nome();
        }
        if (data.telefone() != null) {
            this.telefone = data.telefone();
        }
    }

    public void deletePatient() {
        this.ativo = false;
    }
}
