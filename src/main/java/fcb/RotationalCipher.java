package fcb;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class RotationalCipher {
    // Add any helper functions you may need here

    private static final Map<Integer, Character> lowerCharMap = new HashMap<>();
    private static final Map<Character, Integer> lowerValMap = new HashMap<>();
    private static final Map<Integer, Character> upperCharMap = new HashMap<>();
    private static final Map<Character, Integer> upperValMap = new HashMap<>();

    static {
        for (int i = 1; i < 27; i++) {
            upperCharMap.put(i, (char) (i + 64));
            upperValMap.put((char) (i + 64), i);
            lowerCharMap.put(i, (char) (i + 96));
            lowerValMap.put((char) (i + 96), i);
        }
    }

    String rotationalCipher(String input, int rotationFactor) {

        return input.chars()
                .mapToObj(el -> (char) el)
                .map(el -> String.valueOf(rotate.apply(el, rotationFactor)))
                .collect(Collectors.joining());
    }

    BiFunction<Character, Integer, Character> rotate = (in, factor) -> {
        if (isDigit(in)) {
            int rotated = (int) in + factor % 10;
            if (rotated > 57) {
                return (char) (rotated - 10);
            } else {
                return (char) rotated;
            }
        } else if (isLetter(in)) {
            if(lowerValMap.get(in) != null) {
                int rotated = factor % 26 + lowerValMap.get(in);
                if (rotated > 26) {
                    return lowerCharMap.get(rotated - 26);
                } else {
                    return lowerCharMap.get(rotated);
                }
            } else {
                int rotated = factor % 26 + upperValMap.get(in);
                if (rotated > 26) {
                    return upperCharMap.get(rotated - 26);
                } else {
                    return upperCharMap.get(rotated);
                }
            }
        } else {
            return in;
        }
    };


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        String input_3 = "Zebra-493?";
        int rotationFactor_3 = 3;
        String expected_3 = "Cheud-726?";
        String output_3 = rotationalCipher(input_3, rotationFactor_3);
        check(expected_3, output_3);

        String input_4 = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        int rotationFactor_4 = 39;
        String expected_4 = "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
        String output_4 = rotationalCipher(input_4, rotationFactor_4);
        check(expected_4, output_4);

    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }
}
