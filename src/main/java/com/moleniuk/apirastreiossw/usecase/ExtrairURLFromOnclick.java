package com.moleniuk.apirastreiossw.usecase;

import org.springframework.stereotype.Component;

@Component
public class ExtrairURLFromOnclick {

    public String execute(String onclickValue) {
        String[] parts = onclickValue.split("'");
        return parts[1];
    }
}
