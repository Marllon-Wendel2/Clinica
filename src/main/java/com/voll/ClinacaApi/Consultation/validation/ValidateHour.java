package com.voll.ClinacaApi.Consultation.validation;

import com.voll.ClinacaApi.Consultation.dtos.DataConsult;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidateHour implements ValidatorConsult {

    public void validate(DataConsult dataConsult) {
        var dateConsult = dataConsult.data();

        var sunday = dateConsult.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var prevOpen = dateConsult.getHour() < 7;
        var afterClesed = dateConsult.getHour() > 18;

        if(sunday || prevOpen || afterClesed) {
            throw new ValidationException("Consulta fora do horário da clínica");
        }
    }
}
