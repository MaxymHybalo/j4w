package ua.application.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ua.application.builder.Configuration.*;

public class Builder {

    File path;
    ArrayList<File> files;

    public Builder(String rootPath){
        files = new ArrayList<>();
        path = new File(rootPath+"/");
    }

    public void build(){
        if(isValidPath(path)) {
            getFiles(path, imageExtensions);
            zip(new File(outputDirectory + File.separator + imageZipName), files);
            files.clear();

            getFiles(path, audioExtensions);
            zip(new File(outputDirectory + File.separator + audioZipName), files);
            files.clear();

            getFiles(path, videoExtensions);
            zip(new File(outputDirectory + File.separator+videoZipName), files);
            files.clear();
        }
    }

    private void zip(File file, ArrayList<File> files){
        try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));) {
            for (File f : files) {
                String entryName = f.getAbsolutePath().replaceFirst(path.getAbsolutePath(), "");
                System.out.println(file.getName()+" added: " + entryName);
                ZipEntry entry = new ZipEntry(entryName);
                out.putNextEntry(entry);
                write(out, f);
            }
            System.out.println("To " + file.getName() + " added: " + files.size() +" files");
            out.closeEntry();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void getFiles(File path,String ... extension){
        File [] files = path.listFiles(file -> file.isDirectory() || extensionMatches(file.getName(),extension));
        for(File f: files){
            if(f.isFile()) this.files.add(f);
            if(f.isDirectory()) getFiles(f,extension);
        }
    }

    private boolean extensionMatches(String currentExtension,String [] extensions){
        for(String e:extensions) {
            if(currentExtension.endsWith(e)) return true;
        }
        return false;
    }

    private boolean isValidPath(File file){
        return file.isDirectory() & file.exists();
    }

    private void write(ZipOutputStream stream, File file){
        byte [] buffer = new byte[2048];
        try(FileInputStream readStream = new FileInputStream(file);) {
            int length;
            while ((length = readStream.read(buffer))>1){
                stream.write(buffer,0,length);
            }
            readStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
