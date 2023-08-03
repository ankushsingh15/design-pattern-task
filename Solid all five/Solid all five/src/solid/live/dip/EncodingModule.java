package solid.live.dip;


import net.iharder.Base64;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:05:38 AM
 * To change this template use File | Settings | File Templates.
 */

public interface Encoder {
    void encodeAndWriteData(String inputFile, String outputFile);
}

public class EncodingModule {
    private Encoder encoder;

    public EncodingModule(Encoder encoder) {
        this.encoder = encoder;
    }

    public void encodeAndWriteData(String inputFile, String outputFile) {
        encoder.encodeAndWriteData(inputFile, outputFile);
    }
}

public class FileEncoder implements Encoder {
    @Override
    public void encodeAndWriteData(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String aLine;
            while ((aLine = reader.readLine()) != null) {
                String encodedLine = Base64.encodeBytes(aLine.getBytes());
                writer.write(encodedLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class NetworkEncoder implements Encoder {
    @Override
    public void encodeAndWriteData(String protocol, String host, String path) {
        URL url = null;
        try {
            url = new URL(protocol, host, path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try (InputStream in = url.openStream();
             InputStreamReader reader = new InputStreamReader(in)) {
            StringBuilder inputString1 = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                inputString1.append((char) c);
            }
            String inputString = inputString1.toString();
            String encodedString = Base64.encodeBytes(inputString.getBytes());
            MyDatabase database = new MyDatabase();
            database.write(encodedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
