package com.voll.ClinacaApi.Consultation.controller;

import com.voll.ClinacaApi.Consultation.dtos.DataConsult;
import com.voll.ClinacaApi.Consultation.dtos.DatailsOfConsult;
import com.voll.ClinacaApi.patient.service.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultation")
public class ConsultController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    @Transactional
    public ResponseEntity setTimetoConsult(@RequestBody @Valid DataConsult data) {
        var dto = agendaService.agendar(data);
        return ResponseEntity.ok(dto);
    }
}
