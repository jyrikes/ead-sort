package ordenacao.algoritms;

import ordenacao.Sorter;
import java.util.Random;

public class QuickSort implements Sorter {

    @Override
    public int[] sort(int[] elements) {
        this.quicksort(elements, 0, elements.length-1);
        int [] sorted = elements.clone();
        return sorted;
    }
    
  private static void quicksort(int[] elements, int lowIndex, int highIndex) {

    if (lowIndex >= highIndex) {
      return;
    }

    int indexPivo = new Random().nextInt(highIndex - lowIndex) + lowIndex;
    int pivo = elements[indexPivo];
    swap(elements, indexPivo, highIndex);

    int leftPointer = partition(elements, lowIndex, highIndex, pivo);

    quicksort(elements, lowIndex, leftPointer - 1);
    quicksort(elements, leftPointer + 1, highIndex);

  }

  private static int partition(int[] elements, int lowIndex, int highIndex, int pivo) {
    int left = lowIndex;
    int right = highIndex - 1;

    while (left < right) {

     
      while (elements[left] <= pivo && left < right) {
        left++;
      }

     
      while (elements[right] >= pivo && left < right) {
        right--;
      }

      swap(elements, left, right);
    }
    
    
    if(elements[left] > elements[highIndex]) {
      swap(elements, left, highIndex);
    }
    else {
      left = highIndex;
    }
    
    return left;
  }

  private static void swap(int[] elements, int i, int j) {
    int temp = elements[i];
    elements[i] = elements[j];
    elements[j] = temp;
  }


    @Override
    public String getName() {
        return "QuickSort";
    }

}
