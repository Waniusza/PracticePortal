package com.gut.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class LogetTest  {
 
  static final Logger logger = LogManager.getLogger(LogetTest.class);
    
    @Test
    public void loggerTest(){
        logger.entry();
        logger.debug("debug - Entering application. trace");
        logger.info("info - Entering application. trace");
        logger.fatal("fatal - Entering application. trace");
        logger.trace("trace - Entering application. trace");
        logger.error("error - Didn't do it.");
        logger.warn("warn - Exiting application.");
        logger.exit();
        
    }
    
    
}
