package com.occamsrazor.myclear.bnsweb.processors;

import com.occamsrazor.myclear.bnsweb.model.BNSNotification;

public interface NotificationProcessor {
    BNSNotification process( BNSNotification notification );
}
