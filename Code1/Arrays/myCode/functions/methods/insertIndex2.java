package functions.methods;

public class insertIndex2 {

    public void insert(int[] array, int index, int value) {
        int insertIndex = index;
        int newValue = value;

        for (int i = array.length - 1; i > insertIndex; i--) {
            array[i] = array[i - 1];
        }

        array[index] = newValue;

    }

    public void insertStr(String[] array, int index, String value) {

        int insertIndex = index;
        String newValue = value;

        for (int i = array.length - 1; i > insertIndex; i--) {
            array[i] = array[i - 1];
        }

        array[index] = newValue;

    }
}
