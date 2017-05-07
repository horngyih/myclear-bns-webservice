package com.occamsrazor.myclear.bnsweb.processors;

import com.occamsrazor.myclear.bnsweb.model.BNSNotification;
import com.occamsrazor.myclear.bnsweb.model.BNSNotificationFile;

import java.io.File;

public interface  NotificationFileProcessor {
    BNSNotificationFile process( File file, String secretKey );
}
