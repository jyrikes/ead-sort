package ordenacao.algoritms;

import ordenacao.Sorter;
import java.util.Arrays;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] elements) {
        this.sorting(elements, 0, elements.length);
        int[] sorted = elements.clone();
        return sorted;
    }
    
  private int[] sorting(int[] elements, int init, int end){
    int[] merged;
    int median = (init + end)/2;
    if(end - init > 1){  

      sorting(elements, init, median); // ordena a sublista da esquerda
      sorting(elements, median, end); // ordena a sublista da direita
      merged = merge(Arrays.copyOfRange(elements, init, median),
      Arrays.copyOfRange(elements, median, end));
      
      // copia os elementos ordenados para o array original
      int i = init, j = 0;
      while (i < end && j < merged.length) {
        elements[i++] = merged[j++];
      }
      
      return merged;
    }
    return null;
}


  public int[] merge(int[] a, int[] b) {

    int[] merged = new int[a.length + b.length];
    int i = 0;
    int j = 0;
    int k = 0;

    while (k < merged.length) {

        if (i < a.length && (j == b.length || a[i] <= b[j])) {
            merged[k] = a[i];
            i++;
        } else {
            merged[k] = b[j];
            
              j++;
            
            
        }
        k++;
    }
    return merged;
  }

    @Override
    public String getName() {
        return "MergeSort";
    }

}
