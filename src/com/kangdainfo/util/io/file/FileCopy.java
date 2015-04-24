package com.kangdainfo.util.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import com.kangdainfo.util.io.FileIO;

public class FileCopy {

	private static final int BLKSIZ = FileIO.BLKSIZ;	
	
    public static void copyFile(File inFile, File outFile) throws IOException {
    	copyFile(inFile.getAbsolutePath(),outFile.getAbsolutePath());
    }

    public static void copyFile(String inFilePath, String outFilePath) throws IOException {
        BufferedInputStream is =
                new BufferedInputStream(new FileInputStream(inFilePath));
        BufferedOutputStream os =
                new BufferedOutputStream(new FileOutputStream(outFilePath));
        copyFile(is, os);
    }


    public static void copyFile(InputStream is, OutputStream os)  throws IOException {
        int b;				// the byte read from the file
        while ((b = is.read()) != -1) {
            os.write(b);
        }
        is.close();
        os.close();
    }

    public static void copyFile(InputStream is, OutputStream os, boolean closeIs, boolean closeOs) throws IOException {
        int b;				// the byte read from the file
        while ((b = is.read()) != -1) {
            os.write(b);
        }
        if(closeIs) {
        	is.close();
        }
        if(closeOs) {
        	os.close(); 	
        }
    }
    
    public static void copyFile(Reader is, Writer os) throws IOException {
        int b;				
        while ((b = is.read()) != -1) {
            os.write(b);
        }
        is.close();
        os.close();
    }

    public static void copyFile(Reader reader, Writer writer, boolean closeReader, boolean closeWriter) throws IOException {
        int b;				
        while ((b = reader.read()) != -1) {
        	writer.write(b);
        }
        if(closeReader) {
        	reader.close();
        }
        if(closeWriter) {
        	writer.close(); 	
        }
    }
    
    
    public static void copyFile(String inFilePath, PrintWriter pw, boolean closePw) throws IOException {
        BufferedReader is = new BufferedReader(new FileReader(inFilePath));
        copyFile(is, pw,true,closePw);
    }


    public static void copyFileBuffered(String inFilePath, String outFilePath) throws IOException {
        InputStream is = new FileInputStream(inFilePath);
        OutputStream os = new FileOutputStream(outFilePath);
        int count = 0;		// the byte count
        byte b[] = new byte[BLKSIZ];	// the bytes read from the file
        while ((count = is.read(b)) != -1) {
            os.write(b, 0, count);
        }
        is.close();
        os.close();
    }
    
}
