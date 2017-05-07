package com.occamsrazor.myclear.bnsweb.model;

import lombok.Data;

public @Data class BNSNotificationMessage{

    BNSNotificationHeader header;
    BNSNotification body;

    public static @Data class BNSNotificationHeader{
        String sig;
        String timestamp;
    }
}