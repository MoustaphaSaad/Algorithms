import com.AIDSA.*;
import com.AIDSA.Stack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer[] data = new Integer[100000000];
        Random rand = new Random(System.nanoTime());
        for(int i=0;i<data.length;i++)
            data[i] = rand.nextInt(100);

        Stopwatch watch = new Stopwatch();
        Comparable[] sorted = Sorting.mergeSort(data);
        System.out.printf("FINISHED SORTING IN : %f\n",watch.elapsedTime());
        /*for(int i=0;i<sorted.length;i++){
            System.out.print(sorted[i]+" ");
        }*/
        //Stack_Test();
    }
    private static void Stack_Test()
    {
        com.AIDSA.Stack<String> s = new Stack<String>();
        s.push("Moustapha");
        s.push("Saad");
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");

        System.out.printf("Size = %d\n",s.size());
        System.out.println(s.isEmpty());
        while(s.size()>0)
            System.out.printf("%s\n",s.pop());

    }
    private static void QuickUnion_Test(){
        QuickUnion<String> qu = new QuickUnion<String>();
        qu.add("1");
        qu.add("2");
        qu.add("3");
        qu.add("4");
        qu.union("3","4");
        System.out.println(qu.get_tree_size("3"));
        qu.union("1","4");
        System.out.println(qu.get_tree_size("3"));
        qu.union("2","3");
        System.out.println(qu.get_tree_size("3"));
        System.out.println(qu.connected("1","2"));
        System.out.println(qu.connected("1","3"));
    }
    private static void QuickFind_Test(){
        QuickFind<String> qu = new QuickFind<String>();
        qu.add("1");
        qu.add("2");
        qu.add("3");
        qu.add("4");
        qu.union("3","4");
        qu.union("1","4");
        qu.union("2","3");
        System.out.println(qu.connected("1","2"));
        System.out.println(qu.connected("1","3"));
    }
}
