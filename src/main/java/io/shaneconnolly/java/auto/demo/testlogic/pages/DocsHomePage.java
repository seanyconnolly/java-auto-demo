package io.shaneconnolly.java.auto.demo.testlogic.pages;

import io.shaneconnolly.java.auto.demo.framework.webdriver.SCWebElement;

/**
 * Created by ubuntu on 09/05/17.
 */
public class DocsHomePage {

    public static SCWebElement btnSheetsApp() throws Exception {
        return new SCWebElement("btnSheetsApp", "body > header > navasdfdf > ul.nav-main > li:nth-child(2) > a");
    }

}
