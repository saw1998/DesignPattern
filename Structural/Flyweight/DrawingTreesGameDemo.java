package Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

/*
 * Instead of creating 10 different TreeType objects, we created only 2 and reused them.
 */

/*
 * Flyweight Interface
 */
interface Tree{
    void draw(int x,int y); //extrinsic state : position
}

/*
 * concrete Flyweight : stores intrinsic state (shared properties)
 */
class TreeType implements Tree{
    private String name; //intrinsic
    private String color; //intrinsic
    private String texture; //intrinsic

    public TreeType(String name, String color, String texture){
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void draw(int x, int y){
        System.out.println("Drawing tree [" + name + ", " + color + ", " + texture + "] at (" + x + ", " + y + ")");
    }
}

/*
 * Flyweight Factory : to manage and reuse TreeType objects
 */
class TreeFactory{
    private static Map<String, TreeType> treeMap = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture){
        String key = name + "_" + color + "_" + texture;

        if(!treeMap.containsKey(key)){
            System.out.println("Creating new TreeType: " + key);
            treeMap.put(key, new TreeType(name, color, texture));
        }

        return treeMap.get(key);
    }
}

/*
 * Client
 */
public class DrawingTreesGameDemo {
    public static void main(String[] args){
        //Draw many tree without wasting memory
        for(int i=0;i<5;i++){
            TreeType oak = TreeFactory.getTreeType("Oak", "Green", "Rough");
            oak.draw(i*10, i*20);
        }

        for(int i=0;i<5;i++){
            TreeType pine = TreeFactory.getTreeType("Pine", "Dark Green", "Smooth");
            pine.draw(i*15, i*25);
        }
    }    
}
