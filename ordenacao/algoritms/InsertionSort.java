package ordenacao.algoritms;

import ordenacao.Sorter;

public class InsertionSort implements Sorter{

    @Override
    public int[] sort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            this.findPosition(elements, elements[i], i - 1);
          }
      
          int[] sorted = elements.clone();
          return sorted;
    }
    public void findPosition(int[] elements, int key, int indexOrdenated) {
        for (int j = indexOrdenated; j >= 0; j--) {
          if (elements[j] > key) {
            elements[j + 1] = elements[j];
            elements[j] = key;
          } else {
            break;
          }
        }
      }

    @Override
    public String getName() {
        return "InsertionSort";
    }

}
