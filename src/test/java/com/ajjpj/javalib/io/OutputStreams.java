package com.ajjpj.javalib.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;

/**
 * @author arno
 */
public class OutputStreams {
    @Test
    void testOutputStream() throws IOException {
        OutputStream os = System.out;

        os.write(65);
        os.write(new byte[] {66, 67, 68});

        os.flush();

        // NICHT für System.out os.close();
    }

    @Test
    void testByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(1);
        baos.write(2);
        baos.write(3);

        baos.close();
        byte[] bytes = baos.toByteArray();

        // auch input stream
    }

    @Test
    void testBuffered() throws IOException {
        BufferedOutputStream os = new BufferedOutputStream(System.out);

        os.write(65);
        System.out.println("hallo");
        os.flush();

        // auch input stream
    }

    /* Ausprägungen von Streams:

    * File...
    * Sockets, Pipes, ...
    * 3rd party: tar, gzip, uuencode, ...

     */


    // Übung:
    // 1. Eine Biärdatei durchsuchen und die Vorkommen von '99' zählen
    // 2. Eine Binärdatei sortieren: alle geraden bytes in eine Datei, die ungeraden in eine andere
}
