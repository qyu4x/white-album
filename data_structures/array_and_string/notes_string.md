## Introduction

Mastering arrays and strings is crucial for solving a wide range of problems in coding interviews.

## String

Strings are considered a data type in general and are typically represented as arrays of bytes (or words) that store a sequence of characters. Strings are defined as an array of characters. The difference between a character array and a string is the string is terminated with a special character ‘\0’ - Geeks for geeks
- Strings in JDK 9, Java internally optimizes the representation of strings. If a String contains only ISO-8859-1/Latin-1 characters, it can be stored as a byte array rather than a char array to save memory.
- For example, the string "Hello" in UTF-8 encoding would be represented by the byte array [72, 101, 108, 108, 111].
- If you had characters that required more than one byte in UTF-8 (e.g., "こんにちは"), each character might take multiple bytes.


## Example

Here's a simple example to illustrate the concept:

```java
public class StringExample {
    public static void main(String[] args) {
        String example = "Hello";

        // Convert the string to a byte array [72, 101, 108, 108, 111]
        byte[] byteArray = example.getBytes();

        // Print the byte array
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
        

        // Convert the bytes array to String "Hello"
        String data = new String(byteArray);
        
    }
}