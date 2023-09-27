
package controller;

import common.Algorithm;
import view.Menu;

public class Manager extends Menu{
    
    Algorithm al = new Algorithm();
    ScannerFactory sc = new ScannerFactory();
    public Manager(){
        super("Normalize Texy", new String[]{"Input file content","Write file","Read file","Exit"});
    }
    

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> {
                System.out.println("Enter the content");
                String text = sc.getScanner().nextLine();
                al.writeFile(text, "input");
            }
            case 2 -> {
                System.out.println("Normalize File");
                al.writeFile(al.Normalize(al.readFile("input")),"output");
            }
            case 3 -> {
                System.out.println("View file");
                System.out.println(al.readFile("output"));
            }
        }
    }
   
}
