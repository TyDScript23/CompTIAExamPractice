public class ParityBitExample {
    public static void main(String[] args) {

        //##########################################################
        //EVEN PARITY BIT CALCULATION
        //##########################################################

        int[] data = {1, 0, 1, 1, 0, 1, 0}; // Example data bits
        int[]data2 = {1, 0, 1, 1, 0, 1, 1}; // Example data bits with odd number of 1s
        int data3[] = {0, 0, 0, 0, 0, 0, 0}; // Example data bits with no 1s

        int parityBit = calculateEvenParityBit(data); // Calculate parity bit for data
        int parityBit2 = calculateEvenParityBit(data2); // Calculate parity bit for data3
        int parityBit3 = calculateEvenParityBit(data3); // Calculate parity bit for data3

        System.out.println("===================================");
        System.out.println("Even Parity Bit Calculation:");
        System.out.println("Data bits: ");
        for (int bit : data) {
            System.out.print(bit + " ");
        }
        System.out.println("\nCalculated Even Parity Bit: " + parityBit);

        System.out.println("\nData bits: ");
        for (int bit : data2) {
            System.out.print(bit + " ");
        }

        System.out.println("\nCalculated Even Parity Bit: " + parityBit2);

        System.out.println("\nData bits: ");
        for (int bit : data3) {
            System.out.print(bit + " ");
        }
        System.out.println("\nCalculated Even Parity Bit: " + parityBit3);

        //##########################################################
        //ODD PARITY BIT CALCULATION
        //##########################################################

        int oddParityBit = calculateOddParityBit(data); // Calculate parity bit for data2
        int oddParityBit2 = calculateOddParityBit(data2); // Calculate parity bit for data2
        int oddParityBit3 = calculateOddParityBit(data3); // Calculate parity bit for

        System.out.println("\n-----------------------------------");
        System.out.println("Odd Parity Bit Calculation:");
        System.out.println("\nData bits: ");
        for (int bit : data) {
            System.out.print(bit + " ");
        }
        System.out.println("\nCalculated Odd Parity Bit: " + oddParityBit);
        System.out.println("\nData bits: ");
        for (int bit : data2) {
            System.out.print(bit + " ");
        }
        System.out.println("\nCalculated Odd Parity Bit: " + oddParityBit2);
        System.out.println("\nData bits: ");
        for (int bit : data3) {
            System.out.print(bit + " ");
        }
        System.out.println("\nCalculated Odd Parity Bit: " + oddParityBit3);
    }

    // Function to calculate even parity bit
    public static int calculateEvenParityBit(int[] data) {
        int countOfOnes = 0;
        for (int bit : data) {
            if (bit == 1) {
                countOfOnes++;
            }
        }
        // If count of 1s is even, parity bit is 0; if odd, parity bit is 1
        return (countOfOnes % 2 == 0) ? 0 : 1;
    }

    // Function to calculate odd parity bit
    public static int calculateOddParityBit(int[] data) {
        int countOfOnes = 0;
        for (int bit : data) {
            if (bit == 1) {
                countOfOnes++;
            }
        }
        // If count of 1s is odd, parity bit is 0; if even, parity bit is 1
        return (countOfOnes % 2 == 1) ? 0 : 1;
    }
}
