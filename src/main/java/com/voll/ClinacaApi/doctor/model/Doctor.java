package com.voll.ClinacaApi.doctor.model;

import com.voll.ClinacaApi.Address.model.Address;
import com.voll.ClinacaApi.doctor.dtos.DataUpdateDoctor;
import com.voll.ClinacaApi.doctor.dtos.DoctorData;
import com.voll.ClinacaApi.doctor.dtos.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "doctors")
@Entity(name = "Doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Address endereco;

    public Doctor(DoctorData data) {
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Address(data.endereco());
    }

    public void updateInfo(DataUpdateDoctor dataUpdateDoctor) {
        if(dataUpdateDoctor.nome() != null) {
            this.nome = dataUpdateDoctor.nome();
        }
        if(dataUpdateDoctor.telefone() != null) {
            this.telefone = dataUpdateDoctor.telefone();
        }
        if(dataUpdateDoctor.endereco() != null) {
            this.endereco.updateInfo(dataUpdateDoctor.endereco());
        }
    }
}
