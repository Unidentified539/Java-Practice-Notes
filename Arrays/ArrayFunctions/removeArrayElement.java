public class removeArrayElement {
    public void removeElement(int[] array, int removeIndex) {
        for (int i = removeIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }

}
