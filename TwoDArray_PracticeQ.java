public class TwoDArray_PracticeQ {

    public static int duplicates(int array[][], int key){
        int count = 0;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                if(key == array[i][j]){
                    count++;
                }
            }
        }
        return count;
    }


    public static int sumOfSecondRow(int nums[][]){
        int sum = 0;
        for(int j=0; j<nums[0].length; j++){
            sum += nums[1][j];
        }
        return sum;
    }

    public static void transposeMatrix(int matrix[][]){
        int Tmatrix[][] = new int[matrix[0].length][matrix.length];

        for(int i=0; i<Tmatrix.length; i++){
            for(int j=0; j<Tmatrix[0].length; j++){
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        // First Problem
        // int array[][] = {{4,7,8},
        //                     {8,8,7}};
        
        // int key = 7;
        // System.out.println(duplicates(array, key));

        // Second problem
        // int nums[][] = {{1,4,9},
        //                     {11,4,3},
        //                     {2,2,3}};
        // System.out.println(sumOfSecondRow(nums));

        // Third Problem
        int matrix[][] = {{11,12,13},
                            {21,22,23}};

        transposeMatrix(matrix);
        
    }
}
