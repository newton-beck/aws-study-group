package br.com.elo7.group.controller;

import br.com.elo7.group.model.DaysBetween;
import br.com.elo7.group.service.DaysBetweenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DaysBetweenController {

    private final DaysBetweenService service;

    @Autowired
    public DaysBetweenController(DaysBetweenService service) {
        this.service = service;
    }

    @GetMapping(value = "/days-between", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DaysBetween calculate(@RequestParam("begin") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate begin,
                                 @RequestParam("end") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate end) {
        return service.calculate(begin, end);
    }

}
