package data_structures.array_and_string;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class DSAString {

    // string is bytes of array
    public byte[] behindString(String kata) {
        byte[] bytes = kata.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        return bytes;
    }


}


public class StringImpl {
    public static void main(String[] args) {

        DSAString stringChan = new DSAString();
        System.out.println(new String(stringChan.behindString("Sukiyo")));

    }
}
