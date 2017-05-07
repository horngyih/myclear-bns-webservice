var _express = require( 'express' );
var _bodyParser = require( 'body-parser' );
var server = _express();

server.use( _bodyParser.json() );

var myClearController = require( './myClearController' );
var myClearNotificationTransformer = require( "../transformers/MyClearNotificationTransformer" );

myClearController.use( myClearNotificationTransformer.mapValues);
myClearController.use( myClearNotificationTransformer.transformToText );

var rootPath = process.env.SERVER_ROOT || "";
var serverPort = process.env.PORT || 9897;
serverPort = ( typeof serverPort === "number" )? serverPort : parseInt( serverPort );

function path( subpath ){
    var result = rootPath + "/";
    if( subpath ){
        result += subpath + "/";
    }
    return result;
}

server.get( path(), function( req, res ){
    res.send( "The Droids You're Looking For are not here." );
});

server.post( path(), function( req, res ){
    //console.log( new Date() + " : ", req.body );
    var response = myClearController.handleIncomingMessage( req.body );
    res.status(200).json( response );
});

server.listen( serverPort, function(){
    console.log( "Root Path : " + rootPath );
    console.log( "Server Port : " + serverPort );
    console.log( "Listening on ... " + serverPort );
});