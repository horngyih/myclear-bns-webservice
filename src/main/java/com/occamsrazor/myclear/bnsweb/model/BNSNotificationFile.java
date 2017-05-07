package com.occamsrazor.myclear.bnsweb.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

/**
 * Created by horngyih on 5/7/2017.
 */
public class BNSNotificationFile {
    protected @Getter @Setter String header;
    protected @Getter @Setter String footer;

    protected @Getter @Setter LinkedList<BNSNotification> notifications;
    protected @Getter @Setter LinkedList<String> rawNotification;
}
