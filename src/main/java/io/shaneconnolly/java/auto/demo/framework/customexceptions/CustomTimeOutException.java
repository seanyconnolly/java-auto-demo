package io.shaneconnolly.java.auto.demo.framework.customexceptions;

import org.apache.log4j.Logger;

/**
 * Created by ubuntu on 09/05/17.
 */
public class CustomTimeOutException extends Exception {

    static Logger logger = Logger.getLogger(CustomTimeOutException.class);

    public CustomTimeOutException(String message) {
        super(message);
        logger.info("THROWING EXCEPTION");
    }


}
