package com.occamsrazor.myclear;

import static org.junit.Assert.*;

import com.jcraft.jsch.*;
import com.occamsrazor.myclear.bnsweb.transformers.SFTPUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Vector;

public class TestFilerReader {
    @Before
    public void buildMeUp() {

    }

    @After
    public void letMeDown() {

    }

    @Test
    public void testSFTPUtil(){
        JSch.setConfig( "StrictHostKeyChecking", "no" );
        String fileContent = SFTPUtil.getFile( "bnsuser", "password1", "localhost", 2222, "./bns/1001/1705/BNS-170507-01.dat" );
        assertNotNull( "Should return a non-null String representation of the File Content", fileContent );
        String[] lines = fileContent.split( "\n" );
        assertEquals( "Should return the expected lines of text", 12, lines.length );
        for( int i = 0; i < lines.length; i++ ){
            System.out.println( i + 1 + " : " + lines[i] );
        }
    }

    public void test()
    {
        try {
            JSch jsch = new JSch();
            JSch.setConfig( "StrictHostKeyChecking", "no" );

            Session session = jsch.getSession("bnsuser", "localhost", 2222);
            session.setPassword( "password1" );
            assertNotNull( "Session should not be null", session);
            System.out.println( "Session created" );

            session.connect();
            assertTrue( "Session should be connected", session.isConnected() );
            System.out.println( "Session connected" );

            Channel channel = session.openChannel( "sftp" );
            assertNotNull( "Channel should not be null", channel );
            System.out.println( "Channel opened" );

            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.connect();
            System.out.println( "SFTP Channel is opened : " + sftpChannel.isConnected() );

            ls( "./bns/1001/1705", sftpChannel );

            ByteArrayOutputStream target = new ByteArrayOutputStream();

            sftpChannel.get( "./bns/1001/1705/BNS-170507-01.dat", target );

            target.flush();

            String fileContent = target.toString();
            String[] lines = fileContent.split( "\n" );
            for( int i = 0; i < lines.length; i++ ){
                System.out.println( i + 1 + " : " + lines[i] );
            }
        } catch( Exception ex ){
            System.out.println( ex.getMessage() );
            ex.printStackTrace();
            assertNull( "Should not encounter an exception during the test ", ex );
        }
    }

    protected void cd( String path, ChannelSftp sftp ) throws Exception {
        path = ( path != null )? path : ".";
        if( sftp != null ) {
            if( !sftp.isConnected() ){
                return;
            }
            sftp.cd(path);
        }
    }

    protected void ls( String path, ChannelSftp sftp  ) throws Exception {
        path = ( path != null )? path : ".";
        if( sftp != null ) {
            if( !sftp.isConnected() ){
                return;
            }
            Vector list = sftp.ls(path);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            System.out.println();
        }
    }
}
