public class iterateAnStringArray {
    public static void main(String[] args) {

        // This is how you iterate through a string in java
        String[] classes = {"Economy", "Premium Economy", "Business", "First Class"};
        String x;
        int i;
        for (i = 0; i < classes.length; i++) {
            x = classes[i];
            System.out.println(x);
        }

    }
}
