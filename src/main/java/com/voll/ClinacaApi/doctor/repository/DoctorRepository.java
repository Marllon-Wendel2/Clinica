package com.voll.ClinacaApi.doctor.repository;

import com.voll.ClinacaApi.doctor.dtos.Especialidade;
import com.voll.ClinacaApi.doctor.model.Doctor;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("""
            select d from Doctors d
            where
            d.especialidade = :especialidade
            and
            d.id not in(
                select c.doctor.id from Consult c
                where
                c.data = :data
            )
            order by rand()
            limit 1
            """)
    Doctor choiceRandomFreeDoctor(Especialidade especialidade, @NotNull @Future LocalDateTime data);
}
