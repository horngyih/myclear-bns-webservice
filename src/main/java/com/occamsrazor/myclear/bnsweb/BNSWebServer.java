package com.occamsrazor.myclear.bnsweb;

import static spark.Spark.*;

import com.occamsrazor.myclear.bnsweb.controllers.BNSNotificationController;
import com.occamsrazor.myclear.bnsweb.processors.PrintNotificationProcessor;

public class BNSWebServer{
    public static void main( String[] args ){
        BNSNotificationController mainController = new BNSNotificationController();
        mainController.use( new PrintNotificationProcessor() );
    }
}