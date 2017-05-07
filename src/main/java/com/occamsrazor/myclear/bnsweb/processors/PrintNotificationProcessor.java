package com.occamsrazor.myclear.bnsweb.processors;

import com.occamsrazor.myclear.bnsweb.model.BNSNotification;

public class PrintNotificationProcessor
    implements NotificationProcessor{

    @Override
    public BNSNotification process(BNSNotification notification) {
        if( notification != null ){
            System.out.println( notification.toString() );
        } else {
            System.out.println( "No Notification" );
        }
        return notification;
    }
}
