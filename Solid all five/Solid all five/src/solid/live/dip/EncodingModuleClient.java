package solid.live.dip;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:20:57 AM
 * To change this template use File | Settings | File Templates.
 */
//public class EncodingModuleClient {
//    public static void main(String[] args) throws IOException {
//        EncodingModule encodingModule  = new EncodingModule();
//        encodingModule.encodeWithFiles();
//        encodingModule.encodeBasedOnNetworkAndDatabase();
//    }
//}

public class EncodingModuleClient {
    public static void main(String[] args) {
        String inputFile = "/Users/goyalamit/Sandbox/training/src/solid_2011/live/dip/beforeEncryption.txt";
        String outputFile = "/Users/goyalamit/Sandbox/training/src/solid_2011/live/dip/afterEncryption.txt";
        Encoder fileEncoder = new FileEncoder();
        EncodingModule fileEncodingModule = new EncodingModule(fileEncoder);
        fileEncodingModule.encodeAndWriteData(inputFile, outputFile);

        String protocol = "http";
        String host = "myfirstappwith.appspot.com";
        String path = "index.html";
        Encoder networkEncoder = new NetworkEncoder();
        EncodingModule networkEncodingModule = new EncodingModule(networkEncoder);
        networkEncodingModule.encodeAndWriteData(protocol, host, path);
    }
}
