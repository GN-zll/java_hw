import java.math.BigInteger;
import java.util.Arrays;

public class Homework1 {

    public static void main(String[] args) {
        // тут можете тестировать ваш код

        convert(10);
        System.out.println(normalize(721));
        System.out.println(max(10, 12, -14));
        System.out.println(fact(12));
        System.out.println(fact(BigInteger.valueOf(30)));
        multiplTable();
        System.out.println(average(1, 2, 3, 4, 5, 6, 7));
        System.out.println(isMagicSquare(new int[][]{{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 6, 7, 12}, {4, 15, 14, 1}}));
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(sort(new int[]{2, 1, 45, 34, 12, 2})));
        System.out.println(Arrays.toString(removeExtra(new int[]{2, 1, 45, 2, 34, 1, 12, 2}, 2)));
    }

    // task 1
    static void convert(int arg) {
        System.out.println(Long.toBinaryString(arg));
        System.out.println(Long.toOctalString(arg));
        System.out.println(Long.toHexString(arg));
    }


    // task 2
    static int normalize(int angle) {
        angle = angle % 360;
        return angle;
    }


    // task 3
    static int max(int x, int y, int z) {
        if (x > y) {
            if (x > z) {
                return x;
            }
            else {
                return z;
            }
        }
        else {
            if (y > z) {
                return y;
            }
            else {
                return z;
            }
        }
    }


    // task 4
    static int fact(int n) {
        if(n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        else {
            return n * fact(n-1);
        }
    }


    // task 5
    static BigInteger fact(BigInteger n) {
        if(n.equals(BigInteger.ZERO)){
            return n;
        }
        BigInteger factorial = BigInteger.ONE;
        while (n.compareTo(BigInteger.ONE) > 0) {
            factorial = factorial.multiply(n);
            n = n.subtract(BigInteger.valueOf(1));
        }
        return factorial;
    }

    // task 6
    static void multiplTable() {
        int n = 0;
        System.out.print(' ');
        for (int i = 1; i <= 10; ++i){
            System.out.print(' ');
            System.out.print(i);
        }
        System.out.println(' ');
        for (int i = 1; i <= 10; ++i){
            for (int j = 1; j <= 10; ++j){
                System.out.print(i*j);
                System.out.print(' ');
            }
            System.out.println(' ');
        }

    }


    // task 7
    static Double average(int... nums) {
        if(nums == null){
            return null;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (double) sum/nums.length;
    }


    // task 8
    static boolean isMagicSquare(int[][] square) {
        int sum_max = 0;
        int sum_min = 100000000;
        int sum = 0;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                sum += square[i][j];
            }
            if (sum < sum_min) {
                sum_min = sum;
            }
            if (sum > sum_max) {
                sum_max = sum;
            }
            sum = 0;
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                sum += square[j][i];
            }
            if (sum < sum_min) {
                sum_min = sum;
            }
            if (sum > sum_max) {
                sum_max = sum;
            }
            sum = 0;
        }
        sum = square[0][0] + square[1][1] + square[2][2] + square[3][3];
        if (sum < sum_min) {
            sum_min = sum;
        }
        if (sum > sum_max) {
            sum_max = sum;
        }
        sum = square[0][3] + square[1][2] + square[2][1] + square[3][0];
        if (sum < sum_min) {
            sum_min = sum;
        }
        if (sum > sum_max) {
            sum_max = sum;
        }

        if (sum_max == sum_min) {
            return true;
        }
        else {
            return false;
        }
    }


    // task 9
    static int[] reverse(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] = arr[i];
        }
        for (int i = 0; i < arr1.length; ++i) {
            arr[i] = arr1[arr.length - 1 - i];
        }
        return arr;
    }


    // task 10
    static int[] sort(int[] arr) {
        boolean swap = true;
        int n;
        while (swap == true) {
            for (int i = 0; i < arr.length - 1; ++i) {
                swap = false;
                if (arr[i] > arr[i + 1]) {
                    n = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = n;
                    swap = true;
                }
            }
        }
        return arr;
    }


    // task 11
    static int[] removeExtra(int[] arr, int n) {
        int count = 0;
        int a = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == n) {
                count += 1;
            }
        }
        int[] arr1 = new int[arr.length - count];
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != n) {
                arr1[a] = arr[i];
                a += 1;
            }
        }
        return arr1;
    }
}