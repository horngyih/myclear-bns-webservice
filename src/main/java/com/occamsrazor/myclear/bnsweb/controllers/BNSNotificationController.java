package com.occamsrazor.myclear.bnsweb.controllers;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.occamsrazor.myclear.bnsweb.model.BNSNotification;
import com.occamsrazor.myclear.bnsweb.model.BNSNotificationMessage;
import com.occamsrazor.myclear.bnsweb.model.BNSNotificationResponse;
import com.occamsrazor.myclear.bnsweb.processors.NotificationProcessor;
import com.occamsrazor.myclear.bnsweb.transformers.JSONUtil;
import spark.Route;
import spark.Request;
import spark.Response;

import java.util.LinkedList;

public class BNSNotificationController{
    Gson gson = new Gson();
    LinkedList<NotificationProcessor> processors;

    public BNSNotificationController(){
        get( "/", ( req, res ) -> "These are not the droids you're looking for." );
        post( "/", getMainRoute(), JSONUtil.json());
    }

    public void use( NotificationProcessor processor ){
        if( this.processors == null ){
            this.processors = new LinkedList<>();
        }
        this.processors.add( processor );
    }

    public Object handleMessage( Request req, Response res ){
       BNSNotificationMessage message = gson.fromJson( req.body(), BNSNotificationMessage.class );
       BNSNotification notification = message.getBody();
       if( this.processors != null ){
           for( NotificationProcessor processor : this.processors ){
               notification = processor.process( notification );
           }
       }
       return new BNSNotificationResponse();
    }

    protected Route getMainRoute(){
        return new Route(){
            public Object handle( Request req, Response res ){
                return handleMessage( req, res );
            }
        };
    }
}