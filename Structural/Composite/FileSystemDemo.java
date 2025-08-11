package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

/*
 * Component : common interface for both leaf and composite
 */

interface FileSystemItem{
    void showDetails(); //Operation to be performed on both files and folders
}

/*
 * Leaf
 */
class File implements FileSystemItem{
    private String name;
    public File(String name){
        this.name = name;
    }
    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

/*
 * Composite : can hold leaf and other composite
 */
class Folder implements FileSystemItem{
    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    //add a file or folder
    public void addItem(FileSystemItem item){
        items.add(item);
    }

    //remove a file or folder
    public void removeItem(FileSystemItem item){
        items.remove(item);
    }

    @Override
    public void showDetails(){
        System.out.println("Folder : " + name);
        for(FileSystemItem item : items){
            item.showDetails();
        }
    }
}

/*
 * client
 */

public class FileSystemDemo {
    public static void main(String[] args){
        //create files
        File file1 = new File("Resume.docx");
        File file2 = new File("Photos.png");
        File file3 = new File("Notes.txt");

        //create folder and add files
        Folder documents = new Folder("Documents");
        documents.addItem(file1);
        documents.addItem(file3);

        Folder pictures = new Folder("Pictures");
        pictures.addItem(file2);

        Folder root = new Folder("root");
        root.addItem(pictures);
        root.addItem(documents);

        root.showDetails();
    }
}
