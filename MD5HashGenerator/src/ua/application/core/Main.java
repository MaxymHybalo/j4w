package ua.application.core;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;


public class Main {

    public static final String LINKS_FILE_NAME = "links.txt";

    public static final short POLL_SIZE = 12;

    public static final String OUTPUT_FILE_NAME = "output.txt";

    Map<String,String> container = new ConcurrentHashMap<>();

    Main() throws InterruptedException{

        Queue<String> queue = new DataUtils().getURLQueue(LINKS_FILE_NAME);
        ExecutorService executorService = Executors.newFixedThreadPool(POLL_SIZE);

        for (int i = 0; i < POLL_SIZE; i++) {
            if (!queue.isEmpty())
                executorService.execute(() -> grab(queue));
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS);

        DataUtils.writeMD5Hash(OUTPUT_FILE_NAME, container);

    }

    public static void main(String[] args) throws IOException{

        try {
            new Main();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void grab(Queue<String> queue){
        while(!queue.isEmpty()){
            String url = queue.poll();
            System.out.println("[" + Thread.currentThread().getName() + "]" + url+" ,MD5: " + MD5Factory.getResourceMD5(url));
            container.put(url,MD5Factory.getResourceMD5(url));
        }
    }


}
