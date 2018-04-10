package Server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import SharedDataObjects.Assignment;
import SharedDataObjects.ServerMessage;

import java.io.*;
import java.sql.Struct;

/**
 * Helps server receive files
 * @author Evan Mcphee
 *
 */
public class FileHelper {
	/**
	 * path to send file in sever.
	 */
    private String serverfilepath;

    public FileHelper(){
        serverfilepath = "D:\\Users\\Gibson\\Desktop\\Project\\"; //Change this to your file path used to save server files
    }
    /**
     * uploads file to server
     * @param input
     * @param message
     */
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

    public void uploadSubmission(byte [] input, String message){
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

    public ServerMessage getAssignmentFile(Assignment assignment){
        File filetosend = new File(serverfilepath+assignment.getTitle()+assignment.getPath());
        long length = filetosend.length();
        byte[] content = new byte[(int) length]; // Converting Long to Int
        try {
            FileInputStream fis = new FileInputStream(filetosend);
            BufferedInputStream bos = new BufferedInputStream(fis);
            bos.read(content, 0, (int)length);
        } catch (FileNotFoundException g) {
            g.printStackTrace();
        } catch(IOException f){
            f.printStackTrace();
        }
        ServerMessage returnmessage = new ServerMessage(content,assignment.getTitle()+assignment.getPath());
        return returnmessage;
    }
}
