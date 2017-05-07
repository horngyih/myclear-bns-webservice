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
    public void testSFTPUtil() {
        JSch.setConfig("StrictHostKeyChecking", "no");
        String fileContent = SFTPUtil.getFile("bnsuser", "password1", "localhost", 2222, "./bns/1001/1705/BNS-170507-01.dat");
        assertNotNull("Should return a non-null String representation of the File Content", fileContent);
        String[] lines = fileContent.split("\n");
        assertEquals("Should return the expected lines of text", 12, lines.length);
        for (int i = 0; i < lines.length; i++) {
            System.out.println(i + 1 + " : " + lines[i]);
        }
    }
}
