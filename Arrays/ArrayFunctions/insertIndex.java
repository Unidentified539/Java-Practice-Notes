import java.util.Arrays;

public class insertIndex {

    public void insert(int[] array, int index, int value) {
        int insertIndex = index;
        int newValue  = value;

        for(int i=array.length-1; i > insertIndex; i--){
            array[i] = array[i-1];
        }

        array[index] = newValue;
        System.out.println(Arrays.toString(array));

    }
}
