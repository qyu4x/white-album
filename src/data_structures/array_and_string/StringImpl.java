package data_structures.array_and_string;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class DSAString {

    private String data;

    public DSAString(String data) {
        this.data = data;
    }

    public DSAString() {
    }

    // string is bytes of array
    public byte[] behindString(String kata) {
        byte[] bytes = kata.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        return bytes;
    }

    public void findInString(String kata) {
        int lengthOfKata = kata.length();
        byte[] bytesOfKata = kata.getBytes();
        byte[] bytesOfData = this.data.getBytes();

        int indexKata = 0;
        int foundCounterKata = 0;
        int startIndex = 0;
        for (int i = 0; i < this.data.length(); i++) {
            if (bytesOfKata[indexKata] == bytesOfData[i]) {
                if (foundCounterKata == 0) startIndex = i;
                foundCounterKata++;
                indexKata++;

                if (foundCounterKata == lengthOfKata) {
                    System.out.println(String.format("Found at index: %s", startIndex));
                    foundCounterKata = 0;
                    indexKata = 0;
                    startIndex = 0;
                }
            } else {
                foundCounterKata = 0;
                indexKata = 0;
                startIndex = 0;
            }
        }
    }

    public void printRotateString() {
        byte[] bytesOfData = this.data.getBytes();

        int length = this.data.length();
        int left = 0;
        int right = (length - 1) - left;

        byte[] kataLine = new byte[length];

        int currentIndex = left;
        int indexKata = 0;

        int loop = 0;
        for (int i = 0; i < (length * length) - 1; i++) {
            loop++;
            if ((currentIndex - 1) == length-1) {
                currentIndex = 0;
            }

            kataLine[indexKata] = bytesOfData[currentIndex];
            indexKata++;
            currentIndex++;

            if (loop == length) {
                kataLine = new byte[length];

                left++;
                right++;
                indexKata = 0;
                currentIndex = left;
                loop = 0;
            }

            if (right == length - 1) {
                right = 0;
            }
        }
    }


}


public class StringImpl {
    public static void main(String[] args) {

//        DSAString stringChan = new DSAString();
//        System.out.println(new String(stringChan.behindString("Sukiyo")));
        DSAString stringChan = new DSAString("geeks");
        stringChan.findInString("geeks");

        stringChan.printRotateString();
    }
}
