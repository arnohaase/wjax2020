package com.ajjpj.javalib.io;

import java.io.*;

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

    int uebung1(InputStream in) throws Exception {
        int count = 0;
        int b;
        while((b = in.read()) != -1) {
            if (b == 99) {
                count += 1;
            }
        }

        return count;
    }

    void uebung2(InputStream in) throws IOException {
        try(OutputStream even = new FileOutputStream("even.bin");
                OutputStream odd = new FileOutputStream("odd.bin")) {
            int b;
            while((b = in.read()) != -1) {
                if (b%2 == 0) {
                    even.write(b);
                }
                else {
                    odd.write(b);
                }
            }
        }
    }
}
