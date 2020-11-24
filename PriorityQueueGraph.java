
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
 * class Task *
 */
class Task {

    //String job;
    double priority;

    /**
     * Constructor *
     */
    public Task(double priority) {
        //this.job = job;
        this.priority = priority;
    }

    /**
     * toString() *
     */
    public String toString() {
        return "Priority : " + priority;
    }
}

/**
 * Class PriorityQueue *
 */
class PriorityQueue {

    private Task[] heap;
    private int heapSize, capacity;

    /**
     * Constructor *
     */
    public PriorityQueue(int capacity) {
        this.capacity = capacity + 1;
        heap = new Task[this.capacity];
        heapSize = 0;
    }

    /**
     * function to clear *
     */
    public void clear() {
        heap = new Task[capacity];
        heapSize = 0;
    }

    /**
     * function to check if empty *
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * function to check if full *
     */
    public boolean isFull() {
        return heapSize == capacity - 1;
    }

    /**
     * function to get Size *
     */
    public int size() {
        return heapSize;
    }

    /**
     * function to insert task *
     */
    public void insert(double priority) {
        Task newJob = new Task(priority);

        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.priority > heap[pos / 2].priority) {
            heap[pos] = heap[pos / 2];
            pos /= 2;
        }
        heap[pos] = newJob;

    }

    /**
     * function to remove task *
     */
    public Task remove() {
        int parent, child;
        Task item, temp;
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        }

        item = heap[1];
        temp = heap[heapSize--];

        parent = 1;
        child = 2;
        while (child <= heapSize) {
            if (child < heapSize && heap[child].priority < heap[child + 1].priority) {
                child++;
            }
            if (temp.priority >= heap[child].priority) {
                break;
            }

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;

        return item;
    }

    public void printer() {

        for (int i = 1; i <= heapSize; i++) {
            System.out.println(heap[i].priority);
        }
    }
}

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
        //Scanner scan = new Scanner(System.in);
        ArrayList<Double> tAdd = new ArrayList<Double>();
        ArrayList<Double> tDel = new ArrayList<Double>();
        ArrayList<Double> yAdd = new ArrayList<Double>();
        ArrayList<Double> yDel = new ArrayList<Double>();
        //System.out.println("Priority Queue Test\n");   

        //System.out.println("Enter size of priority queue ");
        //PriorityQueue pq = new PriorityQueue(scan.nextInt());
        PriorityQueue pq = new PriorityQueue(10500);
        Random rn = new Random();

        char ch;
        /*  Perform Priority Queue operations */
        /*do {
         System.out.println("\nPriority Queue Operations\n");
         System.out.println("1. insert");
         System.out.println("2. remove");
         System.out.println("3. check empty");
         System.out.println("4. check full");
         System.out.println("5. clear");
         System.out.println("6. size");

         int choice = scan.nextInt();
         switch (choice) {
         case 1:
         System.out.println("Enter the total number of data points you want to insert into the priority queue:");
         int i = scan.nextInt();*/
        int x;
        double elapsedSecondsfinalAdd = 0.0;
        double elapsedSecondsfinalDel = 0.0;
        //long tStart;
        for (int i = 100; i <= 10000; i = i + 100) {

            long tStart = System.currentTimeMillis();
            for (int j = 1; j <= 100; j++) {
                x = rn.nextInt();
                pq.insert(x);
            }

            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            double elapsedSeconds = tDelta / 1000.0;
            elapsedSecondsfinalAdd = elapsedSecondsfinalAdd + elapsedSeconds;
            //System.out.println(elapsedSecondsfinalAdd);
            tAdd.add(elapsedSecondsfinalAdd);
        }
        //pq.printer();
        System.out.println(tAdd);
        tAddwriter.println(tAdd);
        tAddwriter.close();
        //System.out.println(tAdd.get(49));
        double Cadd = (double) ((tAdd.get(49) * Math.log(2)) / (5000 * Math.log(5000)));
        //break;
        //case 2:
        for (int i = 100; i <= 10000; i = i + 100) {

            long tStartDel = System.currentTimeMillis();
            for (int j = 1; j <= 100; j++) {
                Task head = pq.remove();
                ///double st = head.priority;
                //System.out.println(st);
            }
            long tEndDel = System.currentTimeMillis();
            long tDeltaDel = tEndDel - tStartDel;
            double elapsedSecondsDel = tDeltaDel / 1000.0;
            elapsedSecondsfinalDel = elapsedSecondsfinalDel + elapsedSecondsDel;
            tDel.add(elapsedSecondsfinalDel);
        }

        System.out.println(tDel);
        tDelwriter.println(tDel);
        tDelwriter.close();
        //System.out.println(tDel.get(49));
        double Cdel = (double) ((tDel.get(49) * Math.log(2)) / (5000 * Math.log(5000)));

        for (int i = 100; i <= 10000; i = i + 100) {
            yAdd.add(Cadd * i * Math.log(i) / Math.log(2));
            yDel.add(Cdel * i * Math.log(i) / Math.log(2));
        }

        System.out.println(yAdd);
        System.out.println(yDel);
        yAddwriter.println(yAdd);
        yAddwriter.close();
        yDelwriter.println(yDel);
        yDelwriter.close();
        //writer.close();
        //PrintWriter writer = new PrintWriter("C:\\Users\\Mahedi Hasan\\Desktop\\output.txt", "UTF-8");
        /*System.out.println("Enter the total number of data points you want to remove from the priority queue and write to output file:");
         int j = scan.nextInt();
         for (int l = 0; l < j; l++) {
         Task head = pq.remove();
         double st = head.priority;
         //Double.toString(st);
         System.out.println(st);
         //String str=Double.toString(st);
         writer.println(st);
         }

         //System.out.println("\nJob removed \n\n" + pq.remove());
         //break;
         /*case 3:
         System.out.println("\nEmpty Status : " + pq.isEmpty());
         break;
         case 4:
         System.out.println("\nFull Status : " + pq.isFull());
         break;
         case 5:
         System.out.println("\nPriority Queue Cleared");
         pq.clear();
         break;
         case 6:
         System.out.println("\nSize = " + pq.size());
         break;
         default:
         System.out.println("Wrong Entry \n ");
         break;
         }

         System.out.println("\nDo you want to continue (Type y or n) \n");
         ch = scan.next().charAt(0);
         } while (ch == 'Y' || ch == 'y');*/
        //input.close();
        //writer.close();
    }
}
