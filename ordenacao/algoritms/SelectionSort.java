package ordenacao.algoritms;

import ordenacao.Sorter;

public class SelectionSort implements Sorter{

    @Override
    public int[] sort(int[] elements) {
        
        for(int init = 0 ; init < elements.length-1; init++){
        int smallerElement = this.findSmallerNumber(elements, init);
        int temp = elements[init];
        elements[init] = elements[smallerElement];
        elements[smallerElement]= temp;
      }   
        int [] sorted = elements.clone();
        return sorted;
    }

    @Override
    public String getName() {
        return "SelectionSort";
    }
    public int findSmallerNumber(int[] elements, int indexInit ){
        int smaller = elements[indexInit];
        int index = indexInit;
        for(int i = indexInit ; i < elements.length; i++){
            if(elements[i]< smaller){
                smaller = elements[i];
                index = i;
        }
      }
      return index;
    }
}
