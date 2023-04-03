package bai1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFile(File source, File dest)
            throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING
        );
    }


    private static void copyFileUsrSteam(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter source file:");
        String sourcePath = scanner.nextLine();
        System.out.printf("Enter destination file:");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFile(sourceFile, destFile);
            System.out.println("copy complete");
        } catch (IOException ioe) {
            System.out.println("Cant copy that file ");
            System.out.println(ioe.getMessage());
        }
    }
}