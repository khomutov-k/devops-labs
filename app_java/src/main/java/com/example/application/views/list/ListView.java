package com.example.application.views.list;

import com.example.application.controller.VisitsController;
import com.example.application.services.DateService;
import com.example.application.services.FileWritingService;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.IOException;

@PageTitle("Hello DevOps")
@Route(value = "")
public class ListView extends VerticalLayout {
    DateService dateService;
    FileWritingService writeService;

    public ListView(DateService dateService, FileWritingService writeService) throws IOException {
        setSpacing(false);
        String currentTimeString = dateService.getCurrentTimeString();
        String moscowTime = dateService.getMoscowLocalTime();
        add(new H2("Current local date and time  " + currentTimeString));
        add(new H2("Moscow Time Zone date and time is " + moscowTime));
        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);
        writeService.writeToFile(moscowTime);
        add(new H2("This place intentionally left empty"));
        add(new Paragraph("🤗"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        VisitsController.counter += 1;
        this.writeService = writeService;
        this.dateService = dateService;
    }
}
