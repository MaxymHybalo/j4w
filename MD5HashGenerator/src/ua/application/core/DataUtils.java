package ua.application.core;

import java.io.*;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class DataUtils {

    public  String filePath;


    public Queue<String> getURLQueue(String filePath){

        this.filePath = filePath;

        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();
        queue.addAll(getLinksFromFile());

        return queue;

    }

    private List<String> getLinksFromFile(){
        List<String> result  = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader reader = null;

        try {
            File file = new File(filePath);
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void writeMD5Hash(String fileName, Map<String,String> content){
        FileWriter fileWriter = null;
        BufferedWriter writer = null;
        try {
            File file = new File(fileName);
            fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);
            Set<String> links = content.keySet();
            for(String link: links){
                writer.write(content.get(link) + " [" + link + "]" );
                writer.newLine();
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            try {
                writer.flush();
                fileWriter.flush();
            }catch (IOException e){e.printStackTrace();}
        }

    }

}
