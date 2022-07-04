package com.example.application.views.list;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/visits")
public class VisitsView extends VerticalLayout {
    public static int counter = 0;
    public VisitsView() {

        add(new H2("Conter: "+ counter));
    }
}
