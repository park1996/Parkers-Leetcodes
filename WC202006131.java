class SubrectangleQueries {
    private int[][] val;
    public SubrectangleQueries(int[][] rectangle) {
        val = new int[rectangle.length][rectangle[0].length];
        for(int i = 0; i < rectangle.length; i++){
            for(int j = 0; j < rectangle[0].length; j++){
                val[i][j]=rectangle[i][j];
            }
        }
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int newRow1 = (row1 >= 0 ? row1 : 0);
        int newRow2 = (row2 < val.length? row2 : val.length - 1);
        int newCol1 = (col1 >= 0 ? col1 : 0);
        int newCol2 = (col2 < val[0].length ? col2 : val[0].length - 1);
        for(int i = newRow1; i <= newRow2; i++){
            for(int j = newCol1; j <=newCol2;i++){
                val[i][j]=newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        int newRow = row;
        if(newRow < 0){
            newRow = 0;
        }
        else if(newRow >= val.length){
            newRow = val.length - 1;
        }
        int newCol = col;
        if(newCol < 0){
            newCol = 0;
        }
        else if(newCol >= val[0].length){
            newCol = val.length - 1;
        }
        return val[newRow][newCol];
    }
}

class WC202006131{
    public static void main(String args[]){
        int[][] input = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueries sq = new SubrectangleQueries(input);
        sq.getValue(0, 2);
        sq.updateSubrectangle(0, 0, 2, 2, 100);
    }
}