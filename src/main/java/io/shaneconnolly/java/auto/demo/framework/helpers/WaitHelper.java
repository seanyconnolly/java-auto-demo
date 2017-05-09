package io.shaneconnolly.java.auto.demo.framework.helpers;

import org.apache.log4j.Logger;

/**
 * Created by ubuntu on 09/05/17.
 */
public class WaitHelper {

    final static Logger logger = Logger.getLogger(WaitHelper.class);

    public static void staticWait(int secs){
        logger.info("STATIC WAITING FOR SECS ::: " + secs);
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.trace(e.getMessage());
        }
    }

}
