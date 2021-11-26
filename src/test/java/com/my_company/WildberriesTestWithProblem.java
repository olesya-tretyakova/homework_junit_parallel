package com.my_company;

import com.codeborne.selenide.Configuration;
import com.my_company.page.WildberriesMainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class WildberriesTestWithProblem {
    private WildberriesMainPage wbMainPage = new WildberriesMainPage();

    @CsvSource(value = {
            "Женщинам",
            "Мужчинам",
            "Детям"
    })

    @ParameterizedTest(name = "Проверка названия вкладки {0}")
    void wildberriesTabNameTestWithCsvSource(String tabName, TestInfo testInfo) {
        Configuration.startMaximized = true;
        wbMainPage.openMainPage()
                .choseTab(tabName)
                .checkTitleName(tabName);
        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized);
    }

    // @EnumSource(value = WildberriesMenuItem.class)
    @Test
    void wildberriesTabNameTestWithEnumSource(TestInfo testInfo) {
        Configuration.startMaximized = false;
        wbMainPage.openMainPage()
                .choseTab("Обувь")
                .checkTitleName("Обувь");
        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized);
    }
}