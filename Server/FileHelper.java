package Server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHelper {
    private String serverfilepath;

    public FileHelper(){
        serverfilepath = "D:\\Users\\Gibson\\Desktop\\Project\\"; //Change this to your file path used to save server files
    }

    public void uploadFile(byte[] input, String message){
        String [] splitmessage = message.split("str-1splitter");
        System.out.println(splitmessage[0]);
        System.out.println(splitmessage[1]);
        String [] fileinfo = splitmessage[1].split("\\.(?=[^\\.]+$)");
        String fileName = fileinfo[0];
        String fileExtension = ".".concat(fileinfo[1]);
        File newFile = new File(serverfilepath + fileName + fileExtension);
        try{
            if(!newFile.exists())
                newFile.createNewFile();
            FileOutputStream writer = new FileOutputStream(newFile);
            BufferedOutputStream bos = new BufferedOutputStream(writer);
            bos.write(input);
            bos.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
