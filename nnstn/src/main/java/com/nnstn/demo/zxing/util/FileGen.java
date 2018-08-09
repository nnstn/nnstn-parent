package com.nnstn.demo.zxing.util;

import java.io.File;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class FileGen {
    public static void main(String []args)throws Exception{   
        String text = "你好";   
        int width = 100;   
        int height = 100;   
        String format = "png";   
        Hashtable hints= new Hashtable();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   
	    BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);   
	    File outputFile = new File("d:/new.png");   
	    MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);   
	        
    }  
}
