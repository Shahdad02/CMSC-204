public class ArraySum {
    public int sumOfArray(Integer[] myArray, int i) {
        int sum;

        if(i == 0){
            sum = myArray[i];
        }else{
            sum = myArray[i] + sumOfArray(myArray, i-1);
        }
        return sum;
    }
}
