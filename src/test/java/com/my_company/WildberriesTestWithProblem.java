package com.my_company;

import com.codeborne.selenide.Configuration;
import com.my_company.page.WildberriesMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class WildberriesTestWithProblem {
    TestBase testBase = new TestBase();
    WildberriesMainPage wbMainPage = new WildberriesMainPage();

    @CsvSource(value = {
            "Женщинам",
            "Мужчинам",
            "Детям"
    })

    @ParameterizedTest(name = "Проверка названия вкладки {0}")
    void wildberriesTabNameTestWithCsvSource(String tabName, TestInfo testInfo) {
        Configuration.startMaximized = true;
        testBase.beforeEach();
                wbMainPage.choseTab(tabName)
                .checkTitleName(tabName);
        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized);
    }

    @Test
    @DisplayName("Проверка названия вкладки Обувь")
    void wildberriesTabNameTestWithEnumSource(TestInfo testInfo) {
        Configuration.startMaximized = false;
        testBase.beforeEach();
        wbMainPage.choseTab("Обувь")
                .checkTitleName("Обувь");
        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized);
    }
}