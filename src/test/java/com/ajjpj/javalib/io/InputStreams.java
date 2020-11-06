package com.ajjpj.javalib.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class InputStreams {
    @Test
    void testReadInputStream() throws IOException {
        try (InputStream in = new FileInputStream("README.md")) {
            int b;
            while ((b = in.read()) != -1) {
                System.out.println(b);
            }
        }
    }

    @Test
    void testBulkReadInputStream() throws IOException {
        try (InputStream in = new FileInputStream("README.md")) {
            byte[] buf = new byte[1024];

            long numRead;
            do {
                numRead = in.read(buf);

                for (int i=0; i<numRead; i++) {
                    System.out.println(buf[i]);
                }
            }
            while (numRead > 0);
        }
    }

    @Test
    void testConvenienceApi() throws IOException {
        try (InputStream in = new FileInputStream("README.md")) {
//            byte[] bytes = in.readNBytes(100);
//            bytes = in.readAllBytes();
            in.transferTo(System.out);
        }
    }

    @Test
    void testFileHandlesExhausted() throws FileNotFoundException {
        while (true) {
            new FileInputStream("README.md");
        }
    }
}


