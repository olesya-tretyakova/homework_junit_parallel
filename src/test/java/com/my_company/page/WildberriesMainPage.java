package com.my_company.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class WildberriesMainPage {
    private static SelenideElement openMenuBtn = $(".j-menu-burger-btn");
    private static SelenideElement menuList = $(".j-menu-active");
    private static SelenideElement pageTitle = $(".catalog-title");

    public WildberriesMainPage choseTab(String tabName) {
        openMenuBtn.click();
        menuList.$(byText(tabName)).click();
        return this;
    }

    public WildberriesMainPage checkTitleName(String tabName) {
        pageTitle.shouldHave(text(tabName));
        return this;
    }
}
