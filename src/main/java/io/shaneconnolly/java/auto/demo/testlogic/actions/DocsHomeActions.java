package io.shaneconnolly.java.auto.demo.testlogic.actions;

import io.shaneconnolly.java.auto.demo.framework.customassertions.CustomerAssertions;
import io.shaneconnolly.java.auto.demo.testlogic.pages.DocsHomePage;
import org.apache.log4j.Logger;

/**
 * Created by ubuntu on 09/05/17.
 */
public class DocsHomeActions {

    static Logger logger = Logger.getLogger(DocsHomeActions.class);

    public static void selectSheets() throws Exception {
        CustomerAssertions.assertClick(DocsHomePage.btnSheetsApp().doClick());

    }
}
