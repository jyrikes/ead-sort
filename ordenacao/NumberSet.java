package ordenacao;

import java.util.Random;

public class NumberSet {
    int[][] setElements;
    int columns;

    public NumberSet(int columns){
        this.columns = columns;
        setElements = new int [100][columns];
        Random dice = new Random();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < columns; j++) {
                setElements [i][j] = dice.nextInt();
            }
        }
    }

    public int[] getLine(int lineIndex){
        return setElements[lineIndex].clone();
    }

    public int getColumns(){
        return columns;
    }
}
