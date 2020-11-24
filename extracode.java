/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueuegraphsol;

/**
 ** Java Program to implement Priority Queue
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.lang.Math.*;


/**
 * Class PriorityQueueTest *
 */
public class PriorityQueueGraph {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Scanner input = new Scanner(new FileInputStream("C:\\Users\\Mahedi Hasan\\Desktop\\input.txt")).useDelimiter("\n");
        PrintWriter tAddwriter = new PrintWriter("C:\\Users\\Mahedi Hasan\\Desktop\\tAdd.txt", "UTF-8");
        PrintWriter tDelwriter = new PrintWriter("C:\\Users\\Mahedi Hasan\\Desktop\\tDel.txt", "UTF-8");
        PrintWriter yAddwriter = new PrintWriter("C:\\Users\\Mahedi Hasan\\Desktop\\yAdd.txt", "UTF-8");
        PrintWriter yDelwriter = new PrintWriter("C:\\Users\\Mahedi Hasan\\Desktop\\yDel.txt", "UTF-8");
        PrintWriter Nwriter = new PrintWriter("C:\\Users\\Mahedi Hasan\\Desktop\\N.txt", "UTF-8");
        //Scanner scan = new Scanner(System.in);
        ArrayList<Long> tAdd = new ArrayList<Long>();
        ArrayList<Long> tDel = new ArrayList<Long>();
        ArrayList<Double> yAdd = new ArrayList<Double>();
        ArrayList<Double> yDel = new ArrayList<Double>();
        ArrayList<Integer> N = new ArrayList<Integer>();

        PriorityQueue pq = new PriorityQueue(10500);
        Random rn = new Random();

        char ch;

        //int x;
        long elapsedSecondsfinalAdd=0;
        long elapsedSecondsfinalDel=0;
        //long tStart;
        for (int i = 100; i <= 10000; i = i + 100) {


            long tStartAdd=System.nanoTime();
            for (int j = 1; j <= 100; j++) {
                int x = rn.nextInt();
                pq.push(x);
            }


            long tEndAdd = System.nanoTime();

            long tDeltaAdd = tEndAdd - tStartAdd;
            elapsedSecondsfinalAdd = elapsedSecondsfinalAdd + tDeltaAdd;
            tAdd.add(elapsedSecondsfinalAdd);
        }

            for (int i = 100; i <= 10000; i = i + 100) {


            long tStartDel = System.nanoTime();
            for (int j = 1; j <= 100; j++) {
                NodeCreation head = pq.pull();
            }
            //long tEndDel = System.currentTimeMillis();
            long tEndDel = System.nanoTime();
            long tDeltaDel = tEndDel - tStartDel;
            //long elapsedSecondsDel = tDeltaDel / 1000;
            elapsedSecondsfinalDel = elapsedSecondsfinalDel + tDeltaDel;
            tDel.add(elapsedSecondsfinalDel);
        }
        //System.out.println(tAdd);
        tAddwriter.println(tAdd);
        //tAddwriter.close();
        System.out.println(tAdd);
        tDelwriter.println(tDel);
        //tDelwriter.close();
        System.out.println(tDel);
        double Cadd = (double) ((tAdd.get(49) * Math.log(2)) / (5000 * Math.log(5000)));
        double Cdel = (double) ((tDel.get(49) * Math.log(2)) / (5000 * Math.log(5000)));

        for (int i = 100; i <= 10000; i = i + 100) {
            yAdd.add(Cadd * i * Math.log(i) / Math.log(2));
            yDel.add(Cdel * i * Math.log(i) / Math.log(2));
            N.add(i);
        }

        System.out.println(yAdd);
        System.out.println(yDel);
        yAddwriter.println(yAdd);
        //yAddwriter.close();
        yDelwriter.println(yDel);
        //yDelwriter.close();
        Nwriter.println(N);
        Nwriter.close();
        tDelwriter.close();
        tAddwriter.close();
        yAddwriter.close();
        yDelwriter.close();

    }
}
