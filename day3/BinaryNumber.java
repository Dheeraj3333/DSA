package day3;

public class BinaryNumber {

    // toBinary contains logic to convert a decimal number to binary number
    public static int toBinary(int num) {

        int rem;
        int position = 0;
        int ans = 0;

        while (num > 0) {
            rem = num % 2;
            num = num / 2;
            ans = ans + rem * (int) Math.pow(10, position);
            position++;

        }
        return ans;
    }

    // toBinary contains logic to convert a binary number to decimal number
    static int toDecimal(int num) {
        int ans = 0;
        int rem;
        int pow = 0;

        while (num > 0) {
            rem = num % 10;
            num /= 10;
            ans = ans + rem * (int) Math.pow(2, pow);
            pow++;
        }

        return ans;

    }

    public static void main(String[] args) {
        for (int i = 2; i <= 10; i++) {
            System.out.println(toBinary(i)); // converts decimal to binary
            System.out.println(toDecimal(toBinary(i))); // converts binary to decimal again
        }
    }
}