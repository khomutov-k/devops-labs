package com.example.application.views.list;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@PageTitle("Hello DevOps")
@Route(value = "")
public class ListView extends VerticalLayout {

    public ListView() {
        setSpacing(false);
        String currentTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String moscowTime = LocalDateTime.now(ZoneId.of("Europe/Moscow"))
                .format(DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm 'hr'"));

        add(new H2("Current local date and time  " + currentTimeString));
        add(new H2("Moscow Time Zone date and time is " + moscowTime));
        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        add(new H2("This place intentionally left empty"));
        add(new Paragraph("🤗"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
