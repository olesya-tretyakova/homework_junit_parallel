package com.my_company;

import com.codeborne.selenide.Configuration;
import com.my_company.page.WildberriesMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class WildberriesTestWithAnnotation {
    private WildberriesMainPage wbMainPage = new WildberriesMainPage();

    @CsvSource(value = {
            "Женщинам",
            "Мужчинам",
            "Детям"
    })

    @ResourceLock("SelenideConfig")
    @ParameterizedTest(name = "Проверка названия вкладки {0}")
    void wildberriesTabNameTestWithCsvSource(String tabName, TestInfo testInfo) {
        Configuration.startMaximized = false;
        wbMainPage.openMainPage()
                .choseTab(tabName)
                .checkTitleName(tabName);
        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized);
    }


    @Test
    @ResourceLock("SelenideConfig")
    @DisplayName("Проверка названия вкладки Обувь")
    void wildberriesTabNameShoes(TestInfo testInfo) {
        Configuration.startMaximized = true;
        wbMainPage.openMainPage()
                .choseTab("Обувь")
                .checkTitleName("Обувь");
        System.out.println("Config for test: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.startMaximized);
    }
}