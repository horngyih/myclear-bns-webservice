var messageValidation = require( "../model/MyClearMessageValidation" );
var headerValidation = require( "../model/MyClearMessageHeaderVAlidation" );

function validateField( prop, target, validation ){
    var result = target;
    if( prop ){
        if( validation ){
            var validator = validation[prop];
            if( validator ){
                if( target ){
                    if( typeof target === validator.type ){
                        if( validator.type === "string" ){
                            if( validator.length !== null ){
                                var targetLength = target.trim().length;
                                if( targetLength >= 0 && targetLength <= validator.length ){
                                    result = target;
                                }
                                else{
                                    throw { "error" : "INVALID_LENGTH", "errormessage" : prop + " has an invalid length of " + targetLength + ". Expected length is " + validator.length }
                                }
                            }
                        }
                    }
                }
                else{
                    if( validator.required === true ){
                        throw { "error" : "IS_REQUIRED", "errormessage" : prop + " is required" };
                    }
                }
            }
        }
    }
    return result;
}

function validate( target, validation ){
    var result = target;
    if( target ){
        if( validation ){
            for( var prop in target ){
                validateField( prop, target[prop], validation );
            }
        }
    }
    return result;
}

function checkHeader( msgBody ){
    var result = null;
    if( msgBody ){
        if( msgBody.header ){
            result = validate( msgBody.header, headerValidation );
        }
    }
    return ( result !== null );
}

function parseMessage( msg ){
    var result = {
        payerbanknum : msg.payerbanknum || null,
        payerbankname : msg.payerbankname || null,
        billerbanknum : msg.billerbanknum || null,
        billerbankname : msg.billerbankname || null,
        accounttype : msg.accounttype || null,
        billercode : msg.billercode || null,
        billercodename : msg.billercodename || null,
        nbpsref : msg.nbpsref || null,
        channel : msg.channel || null,
        debittimestamp : msg.debittimestamp || null,
        repeatmsg : msg.repeatmsg || null,
        rrn : msg.rrn || null,
        rrn2 : msg.rrn2 || null,
        currencycode : msg.currencycode || null,
        amount : msg.amount || null,
        extdata : msg.extdata || null
    };
    validate( result, messageValidation );
    return result;
}

function handleIncomingMessage( msgBody ){
    var response = {};
    try{
        if( checkHeader( msgBody ) ){
            var notification = parseMessage( msgBody.body );
            response = {
                result : "Y",
                errorcode : "",
                errormessage : "",
                resend: ""
            };
            processNotification( notification );
        }
        else{
            throw { error : "INVALID_HEADER", }
        }
    } catch( error ){
        response = {
            result : "N",
            errorcode : error.error || "UNKNOWN_ERROR",
            errormessage : error.errormessage || "Server encountered an unknown error",
            resend : "Y"
        };
    }

    return response;
}

function use( processor ){
    if( typeof processor === "function" ){
        notificationProcessors.push( processor );
    }
}

var notificationProcessors = [];

function processNotification( notification ){
    if( notificationProcessors ){
        if( notificationProcessors.length > 0 ){
            for( var i = 0; i < notificationProcessors.length; i++ ){
                var processor = notificationProcessors[i];
                processor( notification );
            }
        }
    }
    return notification;
}

module.exports = {
    handleIncomingMessage : handleIncomingMessage,
    use: use
};