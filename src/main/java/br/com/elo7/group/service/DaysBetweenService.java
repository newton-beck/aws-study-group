package br.com.elo7.group.service;

import br.com.elo7.group.model.DaysBetween;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DaysBetweenService {

    public DaysBetween calculate(final LocalDate begin, final LocalDate end) {
        long days = 0;
        LocalDate anyDate = begin;
        while (anyDate.isBefore(end)) {
            anyDate = anyDate.plusDays(1);
            days++;
        }
        return new DaysBetween(begin, end, days);
    }

}
