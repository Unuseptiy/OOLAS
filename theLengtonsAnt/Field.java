package theLengtonsAnt;

public class Field {
    int[][] table;

    public Field(int n) {
        this.table = new int[n][n];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                this.table[i][j] = 0;
            }
        }
    }
}
