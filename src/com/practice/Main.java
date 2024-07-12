package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import static com.practice.Methods.*;

public class Main {

    private static TextArea number1TextArea;
    // private static TextArea number2TextArea;
    private static TextArea stringTextArea;
    private static JTextArea answer;
    private static TextArea documentation;

    private static TextField number1Field;
    // private static TextField number2Field;
    private static TextField stringField;

    private static ComboBox methodMenuNumber;
    private static ComboBox methodMenuArray;
    private static ComboBox methodMenuString;
    private static ComboBox checkOrLoop;

    // Index selected from the method menu
    private static int indexSelected;

    // Index selected from the check or loop combo box.
    private static int index = 0;

    // Index selected from the num type check box
    private static int indexType = 0;

    private static String isTrueOrFalse(int num, boolean result, String type){

        if (result){

            return num+" is a "+type+" number";
        } else {

            return num+" is not a "+type+" number";
        }
    }

    private static String isTrueOrFalse(long num, boolean result, String type){

        if (result){

            return num+" is a "+type+" number";
        } else {

            return num+" is not a "+type+" number";
        }
    }

    private static void number1Enable(boolean res){

        number1Field.setEnabled(res);
        number1TextArea.setEnabled(res);
    }

    private static void stringEnable(boolean res){

        stringField.setEnabled(res);
        stringTextArea.setEnabled(res);
    }

    private static void textArea(String num1str, String str){

        number1TextArea.set(num1str);
        stringTextArea.set(str);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("NumWizard");
        frame.setSize(520, 630);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


        documentation = new TextArea(frame, new Rectangle(330, 95, 150, 250), "Reverse the given number.");

        number1TextArea = new TextArea(frame, new Rectangle(30, 140, 80, 30), "Number : ");
        number1Field = new TextField(frame, new Rectangle(120, 140, 170, 30), "0");

        stringTextArea = new TextArea(frame, new Rectangle(30, 190, 80, 40), "Number / Char : ");
        stringField = new TextField(frame, new Rectangle(120, 190, 170, 30), "0");
        stringEnable(false);

        TextArea methodTag = new TextArea(frame, new Rectangle(30, 90, 80, 30), "Methods : ");

        // 1 represents the 1st field, 2 represents string field, 3 represents both fields
        String[] itemsForNumber = {"Reverse Number", "Print Fibonacci", "Prime Number", "Palindrome Number", "Factorial Number", "Armstrong Number", "Print ASCII", "Automorphic Number", "`Peter`son Number", "Sunny Number", "Tech Number", "Fascinating Number", "Keith Number", "Neon Number", "Spy Number", "Emirp Number", "Sphenic Number", "Buzz Number", "Duck Number", "Evil Number", "ISBN Number", "Bouncy Number", "Mystery Number", "Smith Number", "Strontio Number", "Xylem and Phloem"};
        byte[] fieldsReqForNumber = {1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1};
        String[] defForNumber = {"Reverse the given number.",
                "In fibonacci series, next number is the sum of previous two numbers.",
                "Prime number is a number that is greater than 1 and can be divided by 1 or itself only.",
                "A palindrome number is a number that is same after reverse.",
                "Factorial of a number is the product of all positive descending integers.",
                "An Armstrong number is a positive m-digit number that is equal to the sum of the mth powers of their digits.",
                "ASCII is a 7-bit character set, which represents the numerical value fo a character.",
                "A number is called an automorphic number if the square of the given number ends with the same number itself.",
                "A number is said to be Peterson if the sum of factorials of each digit is equal to the sum of the number itself.",
                "A number is called a sunny number if the number next to the given number is a perfect square.",
                "A number is called a tech number if it can be divided exactly into two parts from the middle, and the square of the sum of the digits is equal to the original number.",
                "A number is called a fascinating number when it is multiplied by 2 and 3, and when both these are concatenated with the original number, then it results in all digits from 1 to 9 present exactly once.",
                "Keith number is a number n with k digits such that when a sequence is created such that the first k terms are the k digits of n and each subsequent term is the sum of the previous k terms, n is part of the sequence.",
                "A positive integer whose sum of digits of its square is equal to the number itself is called a neon number.",
                "A positive integer is called a spy number if the sum and product of its digits are equal.",
                "A number is called an emirp number if we get another prime number on reversing the number itself.",
                "A positive integer n is called a sphenic number if the product of factors of the given number is exactly three and all factors are prime.",
                "Buzz number is another special number in Java that ends with digit 7 or divisible by 7.",
                "Duck number is another special positive non-zero number that contains zero in it. The digit zero should not be presented at the starting of the number.",
                "The Evil number is another special positive whole number in Java that has an even number of 1's in its binary equivalent.",
                "ISBN stands for the International Standard Book Number that is carried by almost each every book. The ISBN is a ten-digit unique number.",
                "A positive integer's digits that is neither in increasing nor decreasing order is called a bouncy number. It means they bounce between increasing and decreasing.",
                "A number is said to be a mystery number if the number can be expressed in two numbers; These two numbers must be the reverse of each other.",
                "A Smith number is a composite number whose sum of digits equals to the sum of digits of its prime factors, excluding 1.",
                "Strontio numbers are those four digits numbers when multiplied by 2 give the same digit at the hundreds and tens place.",
                "A number N will be a xylem number if the sum of its extreme (first and last) digits is equal to the sum of mean (all digits except first and last) digits. Otherwise, the number is called phloem number."
        };

        String[] itemsForArray = {"Frequency Of Element", "Find Duplicate Elements", "Find Largest Element", "Find Smallest Element", "Number of Elements", "Sum of all items", "Sort in ascending order", "Sort in descending order", "Remove Duplicate Elements"};
        byte[] fieldsReqForArray = {2, 1, 1, 1, 1, 1, 1, 1, 1};
        String[] defForArray = {"Finds the frequency of the element specified in the array",
                "Finds all the duplicate items in the array",
                "Finds the largest element in the array",
                "Finds the smallest element in the array",
                "Finds the number of elements in the array",
                "Finds the sum of all items in the array",
                "Sorts the array in ascending order(from smallest to largest)",
                "Sorts the array in descending order(from largest to smallest)",
                "Removes all the duplicate items present in the array"
        };

        String[] itemsForString = {"Number of characters", "Number of punctuation", "Vowels and Consonants", "Anagram", "Divide the string"};
        byte[] fieldsReqForString = {1, 1, 1, 2, 2};
        String[] defForString = {"Finds the total number of characters in the string",
                "Finds the total number of punctuation characters in the string",
                "Finds the number of vowels and consonants in a string",
                "Finds if two strings are anagrams. Two Strings are called the anagram if they contain the same characters.",
                "Divides the string into 'N' equal parts of characters"
        };

        ComboBox numberType  = new ComboBox(frame, new Rectangle(30, 20, 300, 30), new String[]{"Number Problems", "Array Problems", "String Problems"});
        ActionListener actionForType = e -> {

            indexType = numberType.getSelectedIndex();

            if (indexType == 0){

                methodMenuNumber.setEnabled(true);
                checkOrLoop.setEnabled(true);

                methodMenuArray.setEnabled(false);
                methodMenuString.setEnabled(false);

                number1TextArea.set("Number : ");
                stringTextArea.set("Number / Char : ");

                number1Enable(true);
                stringEnable(false);

            } else if (indexType == 1){

                methodMenuNumber.setEnabled(false);
                checkOrLoop.setEnabled(false);

                methodMenuArray.setEnabled(true);
                methodMenuString.setEnabled(false);

                number1TextArea.set("Array : ");
                stringTextArea.set("Number : ");

                // It is enabled by default as frequency of element is the first method, and it requires both fields
                number1Enable(true);
                stringEnable(true);

            } else {

                methodMenuNumber.setEnabled(false);
                checkOrLoop.setEnabled(false);

                methodMenuArray.setEnabled(false);

                methodMenuString.setEnabled(true);

                number1TextArea.set("String : ");
                stringTextArea.set("Number : ");

                number1Enable(true);
                stringEnable(false);
            }
        };
        numberType.addActionListener(actionForType);

        methodMenuNumber = new ComboBox(frame, new Rectangle(120, 90, 170, 30), itemsForNumber);
        ActionListener actionForNumber = e -> {

            indexSelected = methodMenuNumber.getSelectedIndex();

            // Changes the text of the defForNumber according to the function selected
            documentation.set(defForNumber[indexSelected]);

            // If the number is to be checked
            if (index == 0) {

                if (fieldsReqForNumber[indexSelected] == 0) {

                    number1Enable(false);
                    stringEnable(false);
                } else if (fieldsReqForNumber[indexSelected] == 1) {

                    number1Enable(true);
                    stringEnable(false);
                } else if (fieldsReqForNumber[indexSelected] == 2) {

                    number1Enable(false);
                    stringEnable(true);
                }
            }
            // If the check or loop option is selected to looping
            else if (index == 1){

                number1Enable(true);
                stringEnable(true);
            }
        };
        methodMenuNumber.addActionListener(actionForNumber);
        methodMenuNumber.setEnabled(true);

        methodMenuArray = new ComboBox(frame, new Rectangle(120, 90, 170, 30), itemsForArray);
        ActionListener actionForArray = e -> {

            indexSelected = methodMenuArray.getSelectedIndex();

            documentation.set(defForArray[indexSelected]);

            if (fieldsReqForArray[indexSelected] == 1){

                number1Enable(true);
                stringEnable(false);
            } else if (fieldsReqForArray[indexSelected] == 2){

                number1Enable(true);
                stringEnable(true);
            }
        };
        methodMenuArray.addActionListener(actionForArray);
        methodMenuArray.setEnabled(false);

        methodMenuString = new ComboBox(frame, new Rectangle(120, 90, 170, 30), itemsForString);
        ActionListener actionForString = e -> {

            indexSelected = methodMenuString.getSelectedIndex();

            documentation.set(defForString[indexSelected]);

            if (fieldsReqForString[indexSelected] == 1){

                number1Enable(true);
                stringEnable(false);
            } else if (fieldsReqForString[indexSelected] == 2){

                number1Enable(true);
                stringEnable(true);
            }
        };
        methodMenuString.addActionListener(actionForString);
        methodMenuString.setEnabled(false);

        checkOrLoop = new ComboBox(frame, new Rectangle(30, 270, 100, 30), new String[]{"Check", "Loop"});
        ActionListener actionForCheck = e -> {

            index = checkOrLoop.getSelectedIndex();

            if (index == 0){

                number1TextArea.set("Number : ");
                stringTextArea.set("String / Char : ");

                if (fieldsReqForNumber[indexSelected] == 0) {

                    number1Enable(false);
                    stringEnable(false);
                } else if (fieldsReqForNumber[indexSelected] == 1) {

                    number1Enable(true);

                    stringEnable(false);
                } else if (fieldsReqForNumber[indexSelected] == 2) {

                    number1Enable(false);
                    stringEnable(true);
                }

            } else {

                number1TextArea.set("From ");
                stringTextArea.set("To : ");

                number1Enable(true);
                stringEnable(true);
            }
        };
        checkOrLoop.addActionListener(actionForCheck);

        JButton submit = new JButton();
        submit.setBounds(150, 270, 100, 30);
        submit.setFocusable(false);
        submit.setText("Submit");
        frame.add(submit);
        submit.addActionListener(e -> {

            if (indexType == 0) {

                int num1 = 0;
                long num2 = Long.parseLong(number1Field.returnText());

                // If the number does not exceed the value that can be stored in an integer
                if (num2 < 2147483647)
                    num1 = Integer.parseInt(number1Field.returnText());

                String str = stringField.returnText();

                if (num1 < 0 || num2 < 0) {

                    answer.setText("Please enter a positive integer");
                } else {

                    // If the number is to be checked
                    if (index == 0) {

                        switch (indexSelected) {

                            case 0 -> answer.setText("The reversed number of " + num1 + " is : " + reverseDigits(num1));
                            case 1 -> answer.setText("Fibonacci series : " + Arrays.toString(generateFibonacciSeries()));
                            case 2 -> answer.setText(isTrueOrFalse(num1, isPrime(num1), "prime"));
                            case 3 -> answer.setText(isTrueOrFalse(num1, isPalindrome(num1), "palindrome"));
                            case 4 -> answer.setText("Factorial number of " + num1 + " is : " + calculateFactorial(num1));
                            case 5 -> answer.setText(isTrueOrFalse(num1, isArmstrongNumber(num1), "armstrong"));
                            case 6 -> answer.setText("ASCII value of " + str + " is : " + getAsciiValue(str.charAt(0)));
                            case 7 -> answer.setText(isTrueOrFalse(num1, isAutomorphicNumber(num1), "automorphic"));
                            case 8 -> answer.setText(isTrueOrFalse(num1, isPetersonNumber(num1), "peterson"));
                            case 9 -> answer.setText(isTrueOrFalse(num1, isSunnyNumber(num1), "sunny"));
                            case 10 -> answer.setText(isTrueOrFalse(num1, isTechNumber(num1), "tech"));
                            case 11 -> answer.setText(isTrueOrFalse(num1, isFascinatingNumber(num1), "fascinating"));
                            case 12 -> answer.setText(isTrueOrFalse(num1, isKeithNumber(num1), "keith"));
                            case 13 -> answer.setText(isTrueOrFalse(num1, isNeonNumber(num1), "neon"));
                            case 14 -> answer.setText(isTrueOrFalse(num1, isSpyNumber(num1), "spy"));
                            case 15 -> answer.setText(isTrueOrFalse(num1, isEmirpNumber(num1), "emirp"));
                            case 16 -> answer.setText(isTrueOrFalse(num1, isSphenicNumber(num1), "sphenic"));
                            case 17 -> answer.setText(isTrueOrFalse(num1, isBuzzNumber(num1), "buzz"));
                            case 18 -> {

                                boolean res = isDuckNumber(str);

                                // If the user types a character between the number, the number is not checked for duck number and the user is warned.
                                if (containsNonDigit(str)) {

                                    answer.setText("There is a character in the number! Please enter a valid number!");
                                    break;
                                }

                                if (res)
                                    answer.setText(str + " is a duck number");
                                else
                                    answer.setText(str + " is not a duck number");
                            }
                            case 19 -> answer.setText(isTrueOrFalse(num1, isEvilNumber(num1), "evil"));
                            case 20 -> answer.setText(isTrueOrFalse(num2, isIsbnNumber(num2), "ISBN"));
                            case 21 -> answer.setText(isTrueOrFalse(num1, isBouncyNumber(num1), "bouncy"));
                            case 22 -> answer.setText(isTrueOrFalse(num1, isMysteryNumber(num1), "mystery"));
                            case 23 -> answer.setText(isTrueOrFalse(num1, isSmithNumber(num1), "smith"));
                            case 24 -> answer.setText(isTrueOrFalse(num1, isStrontioNumber(num1), "strontio"));
                            case 25 -> {

                                if (isXylemOrPhloemNumber(num1))
                                    answer.setText(num1 + " is a xylem number.");
                                else
                                    answer.setText(num1 + " is a phloem number.");
                            }
                        }
                    }

                    // If the method is set to loop
                    else {

                        ArrayList<Integer> values = new ArrayList<>();
                        String methodType = "";

                        for (int i = num1; i <= Integer.parseInt(str); i++) {

                            switch (indexSelected) {

                                case 0 -> values.add(reverseDigits(i));
                                case 1 -> answer.setText("Fibonacci series : " + Arrays.toString(generateFibonacciSeries()));
                                case 2 -> {
                                    if (isPrime(i)) {
                                        values.add(i);
                                        methodType = "Prime";
                                    }
                                }
                                case 3 -> {
                                    if (isPalindrome(i)) {
                                        values.add(i);
                                        methodType = "Palindrome";
                                    }
                                }
                                case 4 -> {
                                    values.add((int) calculateFactorial(i));
                                    methodType = "Factorial";
                                }
                                case 5 -> {
                                    if (isArmstrongNumber(i)) {
                                        values.add(i);
                                        methodType = "Armstrong";
                                    }
                                }
                                case 6 -> answer.setText("Please use check option to check any particular character for its ASCII value.");

                                case 7 -> {
                                    if (isAutomorphicNumber(i)) {
                                        values.add(i);
                                        methodType = "Automorphic";
                                    }
                                }
                                case 8 -> {
                                    if (isPetersonNumber(i)) {
                                        values.add(i);
                                        methodType = "Peterson";
                                    }
                                }
                                case 9 -> {
                                    if (isSunnyNumber(i)) {
                                        values.add(i);
                                        methodType = "Sunny";
                                    }
                                }
                                case 10 -> {
                                    if (isTechNumber(i)) {
                                        values.add(i);
                                        methodType = "Tech";
                                    }
                                }
                                case 11 -> {
                                    if (isFascinatingNumber(i)) {
                                        values.add(i);
                                        methodType = "Fascinating";
                                    }
                                }
                                case 12 -> {
                                    if (isKeithNumber(i)) {
                                        values.add(i);
                                        methodType = "Keith";
                                    }
                                }
                                case 13 -> {
                                    if (isNeonNumber(i)) {
                                        values.add(i);
                                        methodType = "Neon";
                                    }
                                }
                                case 14 -> {
                                    if (isSpyNumber(i)) {
                                        values.add(i);
                                        methodType = "Spy";
                                    }
                                }
                                case 15 -> {
                                    if (isEmirpNumber(i)) {
                                        values.add(i);
                                        methodType = "Emirp";
                                    }
                                }
                                case 16 -> {
                                    if (isSphenicNumber(i)) {
                                        values.add(i);
                                        methodType = "Sphenic";
                                    }
                                }
                                case 17 -> {
                                    if (isBuzzNumber(i)) {
                                        values.add(i);
                                        methodType = "Buzz";
                                    }
                                }
                                case 18 -> {
                                    if (isDuckNumber(String.valueOf(i))) {
                                        values.add(i);
                                        methodType = "Duck";
                                    }
                                }
                                case 19 -> {
                                    if (isEvilNumber(i)) {
                                        values.add(i);
                                        methodType = "evil";
                                    }
                                }
                                case 20 -> {
                                    if (isIsbnNumber(i)) {
                                        values.add(i);
                                        methodType = "ISBN";
                                    }
                                }
                                case 21 -> {
                                    if (isBouncyNumber(i)) {
                                        values.add(i);
                                        methodType = "Bouncy";
                                    }
                                }
                                case 22 -> {
                                    if (isMysteryNumber(i)) {
                                        values.add(i);
                                        methodType = "Mystery";
                                    }
                                }
                                case 23 -> {
                                    if (isSmithNumber(i)) {
                                        values.add(i);
                                        methodType = "Smith";
                                    }
                                }
                                case 24 -> {
                                    if (isStrontioNumber(i)) {
                                        values.add(i);
                                        methodType = "Strontio";
                                    }
                                }
                                case 25 -> {

                                    if (isXylemOrPhloemNumber(i)) {
                                        values.add(i);
                                        methodType = "Xylem";
                                    }
                                }
                            }
                        }

                        StringBuilder finalString = new StringBuilder(methodType + " Number : ");
                        finalString.append(values.get(0));

                        for (int i = 1; i < values.size(); i++) {

                            finalString.append(", ").append(values.get(i));
                        }

                        answer.setText(String.valueOf(finalString));

                        // Clears all the values of the array
                        values.clear();
                    }
                }
            }
            else if (indexType == 1){

                int[] array = convertStringToArray(number1Field.returnText());
                int num  = Integer.parseInt(stringField.returnText());

                switch (indexSelected){

                    case 0 -> answer.setText("The frequency of element "+num+" in the array is "+getElementFrequency(array, num));
                    case 1 -> answer.setText("Duplicate elements : "+ Arrays.toString(getDuplicates(array)));
                    case 2 -> answer.setText("The largest element of the array is "+findLargest(array));
                    case 3 -> answer.setText("The smallest element of the array is "+findSmallest(array));
                    case 4 -> answer.setText("Number of elements in the array is "+numberOfElements(array));
                    case 5 -> answer.setText(sumOfElements(array));
                    // case 6 -> answer.setText(""+ Arrays.toString(Ascending.sortInAscending(array)));
                    case 6 -> answer.setText("" + Arrays.toString(sortInAscending(array)));
                    case 7 -> answer.setText(""+ Arrays.toString(sortInDescending(array)));
                    case 8 -> answer.setText(""+ Arrays.toString(removeDuplicates(array)));
                }

            }
            else if (indexType == 2){

                String str = number1Field.returnText();
                int num = 0;
                if (indexSelected != 3)
                    num = Integer.parseInt(stringField.returnText());

                switch (indexSelected){

                    case 0 -> answer.setText("Number of characters in the string is "+numberOfCharacters(str));
                    case 1 -> answer.setText("Number of punctuations in the string is "+numberOfPunctuations(str));
                    case 2 -> answer.setText(vowelsAndConsonants(str));
                    case 3 -> answer.setText(anagram(str, stringField.returnText()));
                    case 4 -> answer.setText(""+divideString(str, num));
                }
            }
        });

        answer = new JTextArea();
        answer.setBounds(10, 320, frame.getWidth() - 80, 200);
        answer.setLineWrap(true);
        answer.setFocusable(false);
        answer.setFont(new Font("SansSerif", Font.PLAIN, 13));
        answer.setEditable(false);
        answer.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(answer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(30, 350, frame.getWidth() - 60, 200);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}