package functions;

public class findhighorlow {

    // Simple java function to find the minimum of an array
    public void findMin(int[] array) {

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
            }
        }

        System.out.println(minVal);
    }

    // A simple java function to fing the highest number in an array.
    public void findHigh(int[] array) {

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        System.out.println(maxVal);
    }
}
