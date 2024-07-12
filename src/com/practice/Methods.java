package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Methods {

    // sphenic number(not completed)

    // Method to reverse the digits of an integer
    static int reverseDigits(int number) {
        int reversedNumber = 0;

        // Loop to reverse the digits of the number
        for (int currentNumber = number; currentNumber > 0; currentNumber /= 10) {
            reversedNumber *= 10;
            reversedNumber += currentNumber % 10;
        }

        return reversedNumber;
    }

    // Method to check if a string contains any non-digit characters
    static boolean containsNonDigit(String inputString) {
        // Check each character in the string
        for (int i = 0; i < inputString.length(); i++) {
            // If the character is not a digit, return true, using ASCII code
            if ((int) inputString.charAt(i) < 48 || (int) inputString.charAt(i) > 57) {
                return true;
            }
        }
        return false;
    }

    // Method to check if a string contains any digit characters
    static boolean containsDigit(String inputString) {
        // Check each character in the string
        for (int i = 0; i < inputString.length(); i++) {
            // If the character is a digit, return true
            if ((int) inputString.charAt(i) >= 48 && (int) inputString.charAt(i) <= 57) {
                return true;
            }
        }
        return false;
    }

    // Method to convert an ArrayList of integers to an array of integers
    static int[] convertListToArray(ArrayList<Integer> integerList) {
        int[] integerArray = new int[integerList.size()];

        // Copy each element from the list to the array
        for (int i = 0; i < integerList.size(); i++) {
            integerArray[i] = integerList.get(i);
        }

        return integerArray;
    }

    // Method to convert an array of integers to an ArrayList of integers
    static ArrayList<Integer> convertArrayToList(int[] integerArray) {
        ArrayList<Integer> integerList = new ArrayList<>();

        // Copy each element from the array to the list
        for (int number : integerArray) {
            integerList.add(number);
        }

        return integerList;
    }

    // Method to reverse the elements of an integer array
    static int[] reverseArray(int[] integerArray) {
        int[] reversedArray = new int[integerArray.length];

        // Reverse the elements of the array
        for (int i = integerArray.length - 1, j = 0; i >= 0; i--, j++) {
            reversedArray[j] = integerArray[i];
        }

        return reversedArray;
    }

    // Method to count the number of digits in an integer
    private static int countDigits(int number) {
        int digitCount = 0;

        // Count the digits by dividing the number by 10 repeatedly
        for (int currentNumber = number; currentNumber > 0; currentNumber /= 10) {
            digitCount++;
        }

        return digitCount;
    }

    // Overloaded method to count the number of digits in a long integer
    private static int countDigits(long number) {
        int digitCount = 0;

        // Count the digits by dividing the number by 10 repeatedly
        for (long currentNumber = number; currentNumber > 0; currentNumber /= 10) {
            digitCount++;
        }

        return digitCount;
    }

    // Method to return the digits of an integer as an array
    private static int[] getDigits(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        int indexCounter = 0;

        // Extract each digit from the number
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[indexCounter] = number / (int) Math.pow(10, i);
            number %= (int) Math.pow(10, i);
            indexCounter++;
        }

        return digits;
    }

    // Overloaded method to return the digits of a long integer as an array
    private static int[] getDigits(long number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        int indexCounter = 0;

        // Extract each digit from the number
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[indexCounter] = (int) (number / (int) Math.pow(10, i));
            number %= (int) Math.pow(10, i);
            indexCounter++;
        }

        return digits;
    }

    // Method to calculate the sum of the digits of an integer
    private static int sumOfDigits(int number) {
        int[] digits = getDigits(number);
        int sum = 0;

        // Sum all the digits
        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }

    // Method to convert an integer to its binary representation
    static int[] convertToBinary(int number) {
        ArrayList<Integer> binaryList = new ArrayList<>();

        // Convert the number to binary
        for (int currentNumber = number; currentNumber > 0; currentNumber /= 2) {
            int remainder = currentNumber % 2;
            binaryList.add(remainder);
        }

        int[] binaryArray = new int[binaryList.size()];

        // Reverse the binary digits to get the correct order
        for (int i = binaryList.size() - 1, j = 0; i >= 0; i--, j++) {
            binaryArray[j] = binaryList.get(i);
        }

        // Return the binary digits as an array
        return binaryArray;
    }

    // Method to generate the first 50 numbers in the Fibonacci sequence
    static long[] generateFibonacciSeries() {
        long[] fibonacciSeries = new long[50];
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;

        // Generate the Fibonacci series
        for (int i = 2; i < fibonacciSeries.length; i++) {
            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
        }

        return fibonacciSeries;
    }

    // Method to check if a number is prime
    static boolean isPrime(int number) {
        // Check divisibility of the number from 2 to number-1
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a palindrome
    static boolean isPalindrome(int number) {
        return number == reverseDigits(number);
    }

    // Method to calculate the factorial of a number
    static long calculateFactorial(int number) {
        long result = 1;

        // Calculate the factorial
        for (int i = number; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    // Method to check if a number is an Armstrong number
    static boolean isArmstrongNumber(int number) {
        int digitCount = countDigits(number);
        int sum = 0;

        // Calculate the sum of the digits each raised to the power of digitCount
        for (int digit : getDigits(number)) {
            sum += (int) Math.pow(digit, digitCount);
        }

        return number == sum;
    }

    // Method to return the ASCII value of a character
    static int getAsciiValue(char character) {
        return character;
    }

    // Method to check if a number is an Automorphic number
    static boolean isAutomorphicNumber(int number) {
        int digitCount = countDigits(number);
        return (number * number) % (int) Math.pow(10, digitCount) == number;
    }

    // Method to check if a number is a Peterson number
    static boolean isPetersonNumber(int number) {
        int sum = 0;

        // Calculate the sum of the factorials of the digits
        for (int digit : getDigits(number)) {
            sum += calculateFactorial(digit);
        }

        return sum == number;
    }

    // Method to check if a number is a Sunny number
    static boolean isSunnyNumber(int number) {
        return Math.sqrt(number + 1) % 1.0 == 0.0;
    }

    // Method to check if a number is a Tech number
    static boolean isTechNumber(int number) {
        int digitCount = countDigits(number);

        // Check if the number of digits is even
        if ((digitCount % 2) == 0) {
            // Split the number into two equal parts
            int part1 = number % (int) Math.pow(10, digitCount / 2);
            int part2 = number / (int) Math.pow(10, digitCount / 2);

            // Check if the square of the sum of the two parts equals the original number
            return (int) Math.pow(part1 + part2, 2) == number;
        } else {
            return false;
        }
    }

    // Method to check if a number is a Fascinating number
    static boolean isFascinatingNumber(int number) {
        int multipliedBy2 = number * 2;
        int multipliedBy3 = number * 3;
        String concatenated = "" + number + multipliedBy2 + multipliedBy3;
        boolean[] digitsPresent = new boolean[9];

        // Check if all digits from 1 to 9 are present exactly once
        for (int i = 0; i < concatenated.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(concatenated.charAt(i)));
            if (digitsPresent[digit - 1]) {
                return false;
            } else {
                digitsPresent[digit - 1] = true;
            }
        }

        for (boolean present : digitsPresent) {
            if (!present) {
                return false;
            }
        }

        return true;
    }

    // Method to check if a number is a Keith number
    static boolean isKeithNumber(int number) {
        int digitCount = countDigits(number);
        int[] digits = Arrays.copyOf(getDigits(number), 20);
        int indexCounter = digitCount;

        // Generate the Keith series
        for (int i = 0; i < digits.length; i++) {
            int sum = 0;
            for (int j = i; j < digitCount + i; j++) {
                sum += digits[j];
            }

            digits[indexCounter] = sum;
            indexCounter++;

            if (sum == number) {
                return true;
            } else if (sum > number) {
                return false;
            }
        }
        return false;
    }

    // Method to check if a number is a Neon number
    static boolean isNeonNumber(int number) {
        int sum = 0;

        // Calculate the sum of the digits of the square of the number
        for (int digit : getDigits(number * number)) {
            sum += digit;
        }

        return sum == number;
    }

    // Method to check if a number is a Spy number
    static boolean isSpyNumber(int number) {
        int[] digits = getDigits(number);
        int sum = 0;
        int product = 1;

        // Calculate the sum and product of the digits
        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }

        return sum == product;
    }

    // Method to check if a number is an Emirp number
    static boolean isEmirpNumber(int number) {
        return isPrime(number) && isPrime(reverseDigits(number));
    }

    // Method to check if a number is a Sphenic number
    static boolean isSphenicNumber(int number) {
        return number == 0;  // Placeholder logic, replace with actual logic
    }

    // Method to check if a number is a Buzz number
    static boolean isBuzzNumber(int number) {
        return number % 10 == 7 || number % 7 == 0;
    }

    // Method to check if a number is a Duck number
    static boolean isDuckNumber(String numberString) {
        // Check if the number starts with a zero
        if (numberString.charAt(0) == '0') {
            return false;
        }

        // Check if the number contains a zero
        for (int i = 1; i < numberString.length(); i++) {
            if (numberString.charAt(i) == '0') {
                return true;
            }
        }

        return false;
    }

    // Method to check if a number is an Evil number
    static boolean isEvilNumber(int number) {
        int[] binary = convertToBinary(number);
        int countOfOnes = 0;

        // Count the number of 1s in the binary representation
        for (int bit : binary) {
            if (bit == 1) {
                countOfOnes++;
            }
        }

        // An evil number has an even number of 1s in its binary representation
        return countOfOnes % 2 == 0;
    }

    // Method to check if a number is a valid ISBN number
    static boolean isIsbnNumber(long number) {
        int index = 1;
        int sum = 0;

        // ISBN numbers must have exactly 10 digits
        if (countDigits(number) != 10) {
            return false;
        }

        // Calculate the sum using the ISBN formula
        for (int digit : getDigits(number)) {
            sum += digit * index;
            index++;
        }

        // An ISBN number is valid if the sum is divisible by 11
        return sum % 11 == 0;
    }

    // Method to check if a number is a Bouncy number
    static boolean isBouncyNumber(int number) {
        if (number < 0) {
            return false;
        }

        boolean increasing = false;
        boolean decreasing = false;
        int[] digits = getDigits(number);

        // Check if the number is both increasing and decreasing
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] > digits[i - 1]) {
                increasing = true;
            } else if (digits[i] < digits[i - 1]) {
                decreasing = true;
            }
        }

        // A bouncy number is both increasing and decreasing
        return increasing && decreasing;
    }

    // Method to check if a number is a Mystery number
    static boolean isMysteryNumber(int number) {
        // Check if there exists a number whose reverse added to itself equals the given number
        for (int i = number; i >= 0; i--) {
            if (reverseDigits(i) + i == number) {
                return true;
            }
        }

        return false;
    }

    // Method to check if a number is a Smith number
    static boolean isSmithNumber(int number) {
        // A Smith number must be a composite number
        if (isPrime(number)) {
            return false;
        }

        ArrayList<Integer> primeFactors = new ArrayList<>();

        // Get all prime factors of the number
        for (int i = 2; i <= number; i++) {
            if (number % i == 0 && isPrime(i)) {
                primeFactors.add(i);
            }
        }

        int sumOfDigits = sumOfDigits(number);
        int sumOfPrimeDigits = 0;

        // Sum the digits of all prime factors
        for (int primeFactor : primeFactors) {
            for (int digit : getDigits(primeFactor)) {
                sumOfPrimeDigits += digit;
            }
        }

        // A Smith number has equal sum of its digits and the sum of digits of its prime factors
        return sumOfDigits == sumOfPrimeDigits;
    }

    // Method to check if a number is a Strontio number
    static boolean isStrontioNumber(int number) {
        // A Strontio number must have exactly 4 digits
        if (countDigits(number) != 4) {
            return false;
        }

        int doubled = number * 2;
        doubled /= 10;  // Remove the ones digit
        int tensPlace = doubled % 10;
        doubled /= 10;
        int hundredsPlace = doubled % 10;

        // A Strontio number has the same tens and hundreds place digits when doubled
        return tensPlace == hundredsPlace;
    }

    // Method to check if a number is a Xylem or Phloem number
    static boolean isXylemOrPhloemNumber(int number) {
        int[] digits = getDigits(number);
        int firstDigit = digits[0];
        int lastDigit = digits[digits.length - 1];
        int sumOfMiddleDigits = 0;

        // Sum all digits except the first and last
        for (int i = 1; i < digits.length - 1; i++) {
            sumOfMiddleDigits += digits[i];
        }

        // A Xylem number has the sum of its middle digits equal to the sum of the first and last digit
        return sumOfMiddleDigits == (firstDigit + lastDigit);
    }

    /**
     * Array problems start here
     */

// Method to convert a comma-separated string to an array of integers
    static int[] convertStringToArray(String str) {
        ArrayList<Integer> list = new ArrayList<>();
        int number = 0;
        boolean isNegative = false;

        // Parse the string to extract integers
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                list.add(number);
                number = 0;
                isNegative = false;
            } else if (str.charAt(i) != ' ') {
                if (str.charAt(i) != '-') {
                    number *= 10;
                    int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
                    number += isNegative ? -digit : digit;

                    // Add the number if it's the last character in the string
                    if (i == str.length() - 1) {
                        list.add(number);
                    }
                } else {
                    isNegative = true;
                }
            }
        }

        return convertListToArray(list);
    }

    // Method to find the frequency of an element in an array
    static int getElementFrequency(int[] array, int element) {
        int frequency = 0;

        // Count occurrences of the element in the array
        for (int value : array) {
            if (value == element) {
                frequency++;
            }
        }

        return frequency;
    }

    // Method to find duplicate elements in an array
    static int[] getDuplicates(int[] array) {
        ArrayList<Integer> uniqueElements = new ArrayList<>();
        ArrayList<Integer> duplicateElements = new ArrayList<>();

        // Find and store duplicate elements
        for (int value : array) {
            if (uniqueElements.contains(value)) {
                duplicateElements.add(value);
            } else {
                uniqueElements.add(value);
            }
        }

        return convertListToArray(duplicateElements);
    }

    // Method to find the largest element in an array
    static int findLargest(int[] array) {
        int largest = array[0];

        // Find the largest element in the array
        for (int num : array) {
            if (num > largest) {
                largest = num;
            }
        }

        return largest;
    }

    // Method to find the smallest element in an array
    static int findSmallest(int[] array) {
        int smallest = array[0];

        // Find the smallest element in the array
        for (int num : array) {
            if (num < smallest) {
                smallest = num;
            }
        }

        return smallest;
    }

    // Method to get the number of elements in an array
    static int numberOfElements(int[] array) {
        return array.length;
    }

    // Method to compute the sum of all elements in an array
    static String sumOfElements(int[] array) {
        int sum = 0;

        // Calculate the sum of all elements in the array
        for (int num : array) {
            sum += num;
        }

        return "Sum of all the elements of the array is " + sum;
    }

    // Method to sort an array in ascending order using Bubble Sort
    static int[] sortInAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    // Method to sort an array in descending order
    static int[] sortInDescending(int[] array) {
        // Sort the array in ascending order first
        int[] sortedArray = sortInAscending(array);

        // Reverse the sorted array to get descending order
        return reverseArray(sortedArray);
    }

    // Method to remove duplicate elements from an array
    static int[] removeDuplicates(int[] array) {
        // Convert array to ArrayList and sort it in ascending order
        ArrayList<Integer> arrayList = convertArrayToList(sortInAscending(array));
        int size = arrayList.size() - 1;

        // Remove duplicates from the sorted ArrayList
        for (int i = 0; i < size; ) {
            if (Objects.equals(arrayList.get(i), arrayList.get(i + 1))) {
                arrayList.remove(i + 1);
                size--;
            } else {
                i++;
            }
        }

        return convertListToArray(arrayList);
    }

    /**
     * String manipulation methods start here
     */

// Method to count the number of characters in a string
    static int numberOfCharacters(String str) {
        return str.length();
    }

    // Method to count the number of punctuation characters in a string
    static int numberOfPunctuations(String str) {
        int counter = 0;

        // Count punctuation characters in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '.' || ch == '?' || ch == '!' || ch == ',' || ch == ';' || ch == '-' || ch == '(' ||
                    ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']' || ch == '\'' || ch == '\"') {
                counter++;
            }
        }

        return counter;
    }

    // Method to convert a string into a list of characters
    static ArrayList<Character> stringToChar(String str) {
        ArrayList<Character> charList = new ArrayList<>();

        // Convert each character of the string into a list element
        for (int i = 0; i < str.length(); i++) {
            charList.add(str.charAt(i));
        }

        return charList;
    }

    // Method to count vowels and consonants in a string
    static String vowelsAndConsonants(String str) {
        int vowelCounter = 0;
        int consonantCounter = 0;

        str = str.toLowerCase(); // Convert string to lowercase for case insensitivity

        // Count vowels and consonants in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCounter++;
            } else if (ch >= 'b' && ch <= 'z') {
                consonantCounter++;
            }
        }

        return "Number of Vowels : " + vowelCounter + "\nNumber of Consonants : " + consonantCounter;
    }

    // Method to check if two strings are anagrams
    static String anagram(String str1, String str2) {
        ArrayList<Character> str1Chars = stringToChar(str1.toLowerCase());
        ArrayList<Character> str2Chars = stringToChar(str2.toLowerCase());

        // Remove common characters from both lists to check for anagrams
        for (int i = 0; i < str1Chars.size(); i++) {
            for (int j = 0; j < str2Chars.size(); j++) {
                if (str1Chars.get(i).equals(str2Chars.get(j))) {
                    str1Chars.remove(i);
                    str2Chars.remove(j);
                    i--;
                    break;
                }
            }
        }

        // If both lists are empty, strings are anagrams
        if (str1Chars.isEmpty() && str2Chars.isEmpty()) {
            return "Both strings are anagrams";
        } else {
            return "The strings are not anagrams";
        }
    }

    // Method to divide a string into equal parts
    static ArrayList<String> divideString(String str, int num) {
        ArrayList<String> dividedStrings = new ArrayList<>();

        // Check if the length of the string is divisible by num
        if (str.length() % num != 0) {
            dividedStrings.add("Please enter a number which exactly divides the string. The length of the string is " + str.length());
            return dividedStrings;
        } else {
            StringBuilder temp = new StringBuilder();

            // Divide the string into parts of length num
            for (int i = 1; i <= str.length(); i++) {
                temp.append(str.charAt(i - 1));
                if (i % num == 0) {
                    dividedStrings.add(temp.toString());
                    temp = new StringBuilder();
                }
            }
        }

        return dividedStrings;
    }
}