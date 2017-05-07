var _paymentChannels = require( "../model/PaymentChannel" );
var _accountType = require( "../model/AccountType" );
var _bank_details = require( "../model/BankDetails" );

var mappings = [
    _paymentChannels,
    _accountType,
    _bank_details
];

function map( property, value, mapping ){
    var result = value;
    if( mapping ){
        if( mapping.mapping ){
            var targets = [];
            if( typeof mapping.maptarget === "string" ){
                targets.push( mapping.maptarget );
            }
            else if( Array.isArray( mapping.maptarget ) ){
                targets = mapping.maptarget;
            }

            if( targets.indexOf( property ) >= 0 ){
                console.log( typeof property );
                console.log( mapping.mapping[property] );
                result = mapping.mapping[property] || value;
            }
        }
    }
    return result;
}

function mapValue( property, value ){
    var result = value;
    if( property ){
        if( Array.isArray( mappings ) ){
            for( var i = 0; i < mappings.length; i++ ){
                map( property, value, mappings[i] );
            }
        }
    }
    console.log( property + " -> " + result );
    return result;
}

function mapValues( notification ){
    var result = {};
    if( result ){
        for( var prop in notification ){
            result[prop] = mapValue( prop, notification[prop] );
        }
    }
    return result;
}

function transformToText( notification ){
    var result = "";
    for( var prop in notification ){
        result += notification[prop] + "|";
    }
    console.log( result );
    return result;
}

module.exports = {
    transformToText : transformToText,
    mapValues : mapValues
}