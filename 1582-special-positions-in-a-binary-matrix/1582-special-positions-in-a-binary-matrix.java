class Solution {
    public int numSpecial(int[][] mat){
        int count=0;
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                if (mat[i][j]==1){
                    int rowcount=0;
                    int columncount=0;
                    for (int k=0; k<mat[0].length; k++){
                        if (mat[i][k]==1){
                            rowcount++;
                        }
                    }
                    for (int k=0; k<mat.length; k++){
                        if (mat[k][j]==1){
                            columncount++;
                        }
                    }
                    if(rowcount==1 && columncount==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}