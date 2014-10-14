package itis.group302.files;

import java.io.*;

public class DirsAndFiles {
    public static void main(String... args) {
        File dir = new File("c:" + File.separator + "dir");
        countDirFiles(dir);
        createDirAndFile(dir);
    }

    public static void countDirFiles(File dir) {
        if (dir.isDirectory()) {
            int fileCount = 0;
            int dirCount = 0;
            String[] list = dir.list();
            File item = null;
            for (String listItem : list) {
                item = new File(dir, listItem);
                if (item.isFile())
                    ++fileCount;
                else if (item.isDirectory()) {
                    ++dirCount;
                    countDirFiles(item);
                }
            }
            System.out.println(dir.getPath() + " files count: " + fileCount);
            System.out.println(dir.getPath() + " directories count: " + dirCount);
        } else {
            throw new IllegalArgumentException("Not a directory");
        }
    }

    public static void createDirAndFile(File dir) {
        File dirs = new File("\\dir\\dir3");
        System.out.println(dirs.mkdirs() == true ? "Directory has created" : "");
        File file = new File(dirs, "MyText.txt");
        if (!file.exists())
            try {
                System.out.println(file.createNewFile() == true ? "File has created" : "");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}