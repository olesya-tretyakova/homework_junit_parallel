package com.my_company;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public static String url = "https://www.wildberries.kz";

    @BeforeEach
    public void beforeEach() {
        open(url);
    }
}
