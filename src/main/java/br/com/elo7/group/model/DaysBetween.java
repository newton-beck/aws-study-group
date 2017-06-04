package br.com.elo7.group.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DaysBetween {

    private final String begin;

    private final String end;

    private final long daysBetween;

    public DaysBetween(LocalDate begin, LocalDate end, long daysBetween) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.begin = begin.format(formatter);
        this.end = end.format(formatter);
        this.daysBetween = daysBetween;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public long getDaysBetween() {
        return daysBetween;
    }

}
