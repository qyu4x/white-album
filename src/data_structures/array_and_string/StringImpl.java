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


}


public class StringImpl {
    public static void main(String[] args) {

//        DSAString stringChan = new DSAString();
//        System.out.println(new String(stringChan.behindString("Sukiyo")));
        DSAString stringChan = new DSAString("geeksforgeeks a computer sciencegeeks");
        stringChan.findInString("geeks");
    }
}
