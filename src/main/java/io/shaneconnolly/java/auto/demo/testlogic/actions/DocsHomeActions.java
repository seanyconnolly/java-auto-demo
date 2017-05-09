package io.shaneconnolly.java.auto.demo.testlogic.actions;

import io.shaneconnolly.java.auto.demo.framework.customassertions.CustomerAssertions;
import io.shaneconnolly.java.auto.demo.framework.customexceptions.CustomElementNoFoundException;
import io.shaneconnolly.java.auto.demo.testlogic.pages.DocsHomePage;

/**
 * Created by ubuntu on 09/05/17.
 */
public class DocsHomeActions {

    public static void selectSheets() throws Exception {
        CustomerAssertions.assertClick(DocsHomePage.btnSheetsApp().doClick());
    }
}
