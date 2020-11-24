/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblacktreesol;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mahedi Hasan
 */
public class Task {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RBTree t = new RBTree();
        Scanner input = new Scanner(new FileInputStream("C:\\Users\\Mahedi Hasan\\Desktop\\inputs.txt")).useDelimiter("\n");
        Scanner input1 = new Scanner(new FileInputStream("C:\\Users\\Mahedi Hasan\\Desktop\\inputs.txt")).useDelimiter("\n");
        int q = 0;
        for (int i = 0; i < 100; i++) {
            String nextToken = input.next();
            nextToken = nextToken.replaceAll("\\r", "");
            int y = Integer.parseInt(nextToken);
            t.insert(y);
            q = i;
        }

        t.printer(t.root, 5);
        System.out.println("Root key is:" + t.root.key);
        System.out.println("/////////////////////RBTree100 has been printed out///////////////////////////////");
        for (int i = 0; i < 50; i++) {
            String nextToken = input1.next();
            nextToken = nextToken.replaceAll("\\r", "");
            int y = Integer.parseInt(nextToken);
            t.delete(y);
        }
        t.printer(t.root, 5);
        System.out.println("Root key is:" + t.root.key);
        System.out.println("/////////////////////RBTree50 has been printed out///////////////////////////////");
        for (int i = q + 1; i < 125; i++) {
            String nextToken = input.next();
            nextToken = nextToken.replaceAll("\\r", "");
            int y = Integer.parseInt(nextToken);
            t.insert(y);
        }
        t.printer(t.root, 5);
        System.out.println("Root key is:" + t.root.key);
        System.out.println("/////////////////////RBTree075 has been printed out///////////////////////////////");
        input.close();
        input1.close();
    }

}
