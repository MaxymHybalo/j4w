import ua.application.builder.Builder;
import ua.application.builder.Configuration;

import java.io.*;


public class Application {

    Application(String workPath) throws IOException{
         new Builder(workPath).build();
    }
    public static void main(String[] args) {
        try {
            new Application(Configuration.workingDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
