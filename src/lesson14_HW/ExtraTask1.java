package lesson14_HW;

import java.io.File;

public class ExtraTask1 {
    public static void main(String[] args) {
        File dir = new File("src");
        printDirStruct(dir, 0);
    }

    public static void printDirStruct(File dir, int indent){
        if(!dir.exists() || !dir.isDirectory())
            return;
        printWithIndent(dir.getName(), 0);
        File[] files = dir.listFiles();
        if(files!=null){
            for (File file : files) {
                if (file.isDirectory())
                    printDirStruct(file, indent+1);
                else
                    printWithIndent(file.getName(), indent+1);
            }
        }
    }

    public static void printWithIndent(String name, int indent){
        for(int i = 0; i<indent; i++)
            System.out.print(" ");
        System.out.println(name);
    }
}
