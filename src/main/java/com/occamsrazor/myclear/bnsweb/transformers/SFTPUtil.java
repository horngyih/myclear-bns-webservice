package com.occamsrazor.myclear.bnsweb.transformers;

import com.jcraft.jsch.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SFTPUtil {
    public static final String USE_STRICT_HOST_KEY = "USE_STRICT_HOST_KEY";

    protected static void initJSch(){
       if( System.getenv( USE_STRICT_HOST_KEY ) != null ){
           String flag = System.getenv( USE_STRICT_HOST_KEY ).trim();
           JSch.setConfig( "StrictHostKeyChecking", flag );
       }
    }

    protected static ChannelSftp createSFTPChannel( String user, String password, String host, int port ){
        ChannelSftp sftp = null;

        initJSch();

        JSch jsch = new JSch();

        try {
            Session session = jsch.getSession(user, host, port);
            if (session != null) {
                session.setPassword( password );
                session.connect();
                if( session.isConnected() ){
                    Channel channel = session.openChannel( "sftp" );
                    sftp = (ChannelSftp) channel;
                    sftp.connect();
                }
            }
        } catch( JSchException jschEx ){
            //log Exception
            System.out.println( jschEx.getMessage() );
        }
        return sftp;
    }

    public static String getFile( String user, String password, String host, int port, String filepath ){
        String fileContent = null;
        ByteArrayOutputStream targetOutput = new ByteArrayOutputStream();
        ChannelSftp sftp = createSFTPChannel( user, password, host, port );
        if( sftp != null && sftp.isConnected() ){
            try {
                sftp.get(filepath, targetOutput );
                targetOutput.flush();
                fileContent = targetOutput.toString();
            } catch( SftpException sftpException ) {
                //log Exception
                System.out.println(sftpException.getMessage());
            } catch( IOException ioEx ){
                //log Exception
                System.out.println( ioEx.getMessage() );
            }
        }
        return fileContent;
    }
}
