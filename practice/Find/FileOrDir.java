import java.io.*;
public class FileOrDir{
    void run(){
        File file = new File("FileOrDir.java");
        System.out.println("FileOrDir.java is file: " + file.isFile());
        System.out.println("FileOrDir.java is directory: " + file.isDirectory());
        File dir  = new File(".");
        System.out.printf(". is file: %s%n", dir.isFile());
        System.out.printf(". is directory: %s%n", dir.isDirectory());
    }

    public static void main(String[] args) {
    	FileOrDir file = new FileOrDir();
    	file.run();
    }
}