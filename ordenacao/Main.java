package ordenacao;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import ordenacao.algoritms.BubbleSort;
import ordenacao.algoritms.InsertionSort;
import ordenacao.algoritms.MergeSort;
import ordenacao.algoritms.QuickSort;
import ordenacao.algoritms.SelectionSort;

public class Main {
    public static void main(String[] args) {
        NumberSet ns10 = new NumberSet (10);
        NumberSet ns100 = new NumberSet (100);
        NumberSet ns1000 = new NumberSet (1000);
        //NumberSet ns10000 = new NumberSet (10000);
        try (FileWriter myWriter = new FileWriter("resultado.txt")) {
            myWriter.write("==============="+ System.lineSeparator());
            runSet(new BubbleSort(),ns10, myWriter);
            runSet(new BubbleSort(),ns100, myWriter);
            runSet(new BubbleSort(),ns1000, myWriter);
            //runSet(new BubbleSort(),ns10000, myWriter);
            System.gc();

            myWriter.write("==============="+ System.lineSeparator());
            runSet(new SelectionSort(),ns10, myWriter);
            runSet(new SelectionSort(),ns100, myWriter);
            runSet(new SelectionSort(),ns1000, myWriter);
            System. gc();

            myWriter.write("==============="+ System.lineSeparator());
            runSet(new InsertionSort(),ns10, myWriter);
            runSet(new InsertionSort(),ns100, myWriter);
            runSet(new InsertionSort(),ns1000, myWriter);
            System.gc();

            myWriter.write("==============="+ System.lineSeparator());
            runSet(new MergeSort(),ns10, myWriter);
            runSet(new MergeSort(),ns100, myWriter);
            runSet(new MergeSort(),ns1000, myWriter);
            System.gc();

            myWriter.write("==============="+ System.lineSeparator());
            runSet(new QuickSort(),ns10, myWriter);
            runSet(new QuickSort(),ns100, myWriter);
            runSet(new QuickSort(),ns1000, myWriter);
            System.gc();
            myWriter.close();
            System.out.println("FIM");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runSet(Sorter sorter, NumberSet ns, FileWriter myWriter) throws IOException {
        long meanTime;
        try {
            meanTime = localSort(sorter, ns);
            myWriter.write("Time spent in sorting "+ns.getColumns()+" elements with "+ sorter.getName()+ ":"+ System.lineSeparator());
        myWriter.write(meanTime + " in nanoseconds"+ System.lineSeparator());
        } catch (Exception e) {
            myWriter.write("Using sorter " + sorter.getName() + ": " + ns.getColumns()+" elements NOT sorted" + System.lineSeparator());
        }
        
    }

    private static long localSort(Sorter sorter, NumberSet ns) throws Exception {
        long sumTime = 0;
        for (int i = 0; i < 100; i++) {
            int[] unsorted = ns.getLine(i);
            Instant start = Instant.now();  
            int[] sorted = sorter.sort(unsorted);
            Instant finish = Instant.now();
            System.out.println("inicio");
            for (int j : sorted) {
                System.out.println(j);
            }
            System.out.println("fim");
            if (!isSorted(sorted)){
                throw new Exception("Not sorted");
            }
            long timeElapsed = Duration.between(start, finish).toNanos();
            sumTime += timeElapsed;
        }
        long meanTime = sumTime/100;
        return meanTime;
    }

    private static boolean isSorted(int[] r) {
        int previous = r[0];
        for (int i : r) {
            if (previous <= i){
                previous = i;
            } else {
                return false;
            }
        }
        return true;
    }
}
