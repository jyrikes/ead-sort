package ordenacao.algoritms;

import ordenacao.Sorter;

public class BubbleSort implements Sorter{

    @Override
    public int[] sort(final int[] array2) {
        int [] sorted = array2.clone();
        for(int i = 0; i<sorted.length; i++){
            for(int j = 0; j<sorted.length-1; j++){
                if(sorted[j] > sorted[j + 1]){
                    int aux = sorted[j];
                    sorted[j] = sorted[j+1];
                    sorted[j+1] = aux;
                }
            }
        }
        return sorted;
    }

    @Override
    public String getName() {
        return "BubbleSort";
    }
    
}
