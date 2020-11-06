package com.ajjpj.javalib.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

/**
 * @author arno
 */
public class Readers {
    @Test
    void testReader() throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        charset = Charset.forName("iso-8859-15");

        try (Reader in = new FileReader("README.md", charset)) {
            int i;
            while((i = in.read()) != -1) {
                char ch = (char)i;

                System.out.println(ch);
            }

//            in.transferTo()
        }
    }

    @Test
    void testWriter() throws IOException {
        Writer w = new OutputStreamWriter(System.out, StandardCharsets.UTF_8);
        w.write('a');
    }

    @Test
    void testPrintWriter() throws IOException {
        Writer w = new OutputStreamWriter(System.out, StandardCharsets.UTF_8);
        PrintWriter out = new PrintWriter(w);

        out.println("Hallo");
    }

    @Test
    void testTryWithResource() throws IOException {
        try (Reader r = new FileReader("README.md", StandardCharsets.UTF_8);
                Writer w = new FileWriter("out.txt", StandardCharsets.UTF_8)) {
            //...
        }
    }

    /*
    Ausprägungen:
    * File...
    * StringReader / Writer (analog ByteArray... bei Stream)
    * BufferedReader / Writer
    * InputStreamReader / OutputStreamWriter -> immer mit explizitem Encoding!
     */


    // Übung: Textdatei anlegen (in utf-8) und konvertiert sie streaming nach iso-8859-1 (oder andersherum, wenn
    //  das bequemer ist)
}
