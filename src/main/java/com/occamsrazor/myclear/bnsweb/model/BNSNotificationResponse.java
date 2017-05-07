package com.occamsrazor.myclear.bnsweb.model;

import lombok.Getter;
import lombok.Setter;

public class BNSNotificationResponse{

    public static final String OK_RESULT = "Y";
    public static final String ERROR_RESULT = "N";
    public static final String RESEND_FLAG = "Y";
    public static final String NORESEND_FLAG = "N";

    @Getter @Setter BNSNotificationResponseBody body;

    public BNSNotificationResponse(){
        this.body = new BNSNotificationResponseBody( OK_RESULT, "", "", NORESEND_FLAG );
    }

    public BNSNotificationResponse( String errorCode, String errorMessage, Boolean resend ){
        boolean isError = ( errorCode == null || "".equalsIgnoreCase( errorMessage.trim() ) );
        String result = ( isError )? ERROR_RESULT : OK_RESULT;
        resend = ( resend != null )? resend && isError : false;

        String resendFlag = ( resend )? RESEND_FLAG : NORESEND_FLAG;

        this.body = new BNSNotificationResponseBody( result, errorCode, errorMessage, resendFlag );
    }

    public class BNSNotificationResponseBody{
        @Getter @Setter String result;
        @Getter @Setter String errorcode;
        @Getter @Setter String errormessage;
        @Getter @Setter String resend;

        public BNSNotificationResponseBody( String result, String errorCode, String errorMessage, String resend ){
            this.result = result;
            this.errorcode = errorCode;
            this.errormessage = errorMessage;
            this.resend = resend;
        }
    }
}