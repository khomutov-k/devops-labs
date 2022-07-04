package com.example.application.services;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class DateService {
    public String getMoscowLocalTime() {
        return LocalDateTime.now(ZoneId.of("Europe/Moscow"))
                .format(DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm 'hr'"));
    }

    public String getCurrentTimeString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
