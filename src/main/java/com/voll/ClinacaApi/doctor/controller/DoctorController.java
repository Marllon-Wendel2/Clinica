package com.voll.ClinacaApi.doctor.controller;

import com.voll.ClinacaApi.doctor.dtos.DataDetailsDoctor;
import com.voll.ClinacaApi.doctor.dtos.DataUpdateDoctor;
import com.voll.ClinacaApi.doctor.dtos.DoctorData;
import com.voll.ClinacaApi.doctor.dtos.DoctorListData;
import com.voll.ClinacaApi.doctor.model.Doctor;
import com.voll.ClinacaApi.doctor.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DoctorData doctorData, UriComponentsBuilder uriComponentsBuilder){
        var doctor = new Doctor(doctorData);
        repository.save(doctor);

        var uri = uriComponentsBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();

        return  ResponseEntity.created(uri).body(new DataDetailsDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListData>> listing(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
       var page = repository.findAll(pageable).map(DoctorListData::new);
       return ResponseEntity.ok(page);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInfo(data);
        return ResponseEntity.ok(new DataDetailsDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
