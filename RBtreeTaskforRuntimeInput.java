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
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        int choice = 1;
        while (choice != 3) {
            System.out.println("1.For inserting type '1'");
            System.out.println("2.For deleting type '2'");
            System.out.println("3.For ending the operation type '3'");
            choice = scan1.nextInt();
            switch (choice) {

                case 1:
                    for (;;) {
                        System.out.println("Insert the key(to end just type the word 'end'): ");
                        String x = scan.nextLine();
                        if (x.equals("end")) {
                            break;
                        }
                        int y = Integer.parseInt(x);
                        t.insert(y);
                        System.out.println();
                        t.printer(t.root, 5);
                        System.out.println();
                        System.out.println("Root key is:" + t.root.key);
                    }
                    break;

                case 2:
                    for (;;) {
                        System.out.println("Insert the key to delete(to end just type the word 'end'): ");
                        String x1 = scan.nextLine();
                        if (x1.equals("end")) {
                            break;
                        }
                        int y = Integer.parseInt(x1);
                        t.delete(y);
                        System.out.println();
                        t.printer(t.root, 5);
                        System.out.println();
                        System.out.println("Root key is:" + t.root.key);
                    }
                    break;

            }
        }

        scan.close();
        scan1.close();
    }

}
