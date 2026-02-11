public class Solution {

    public static int countElements(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean found = false;

            for (int j = 0; j < arr.length && !found; j++) {
                for (int k = j + 1; k < arr.length && !found; k++) {

                    if (i != j && i != k) {
                        if (arr[j] + arr[k] == arr[i]) {
                            count++;
                            found = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}

