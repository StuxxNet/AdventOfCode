package day01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SumFirstAndLastNumbers {
    
    private String challengeInput;

    public SumFirstAndLastNumbers(){
        try {
            Path filePath = Path.of("/Users/A59508662/Documents/aoc/day01/aoc1.txt");
            this.challengeInput = Files.readString(filePath);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sumFirstAndLastNumber() {
        Integer totalSum = 0;

        for (String input : this.challengeInput.split(("\n"))) {
            totalSum += Integer.parseInt(this.getNumbers(input));
        }
        System.out.println("Challenge 1: " + totalSum);
    }

    public void sumFirstAndLastNumberInChar() {
        Integer totalSum = 0;

        for (String input : this.challengeInput.split(("\n"))) {
            String convertedInput = convertTextNumbers(input);
            totalSum += Integer.parseInt(this.getNumbers(convertedInput));
        }
        System.out.println("Challenge 2: " + totalSum);
    }

    private String getNumbers(String input) {
        char firstNumber = ' ', lastNumber = ' ';
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                if(firstNumber == ' ')
                    firstNumber = input.charAt(i);
                lastNumber = input.charAt(i);
            }
        }
        return Character.toString(firstNumber) + Character.toString(lastNumber);
    }

    private String convertTextNumbers(String input) {
        Map<Integer, String> containedNumbers = new TreeMap<Integer, String>();
        Map<String, Character> allNumbers = new HashMap<String, Character>();
        allNumbers.put("one", '1');
        allNumbers.put("two", '2');
        allNumbers.put("three", '3');
        allNumbers.put("four", '4');
        allNumbers.put("five", '5');
        allNumbers.put("six", '6');
        allNumbers.put("seven", '7');
        allNumbers.put("eight", '8');
        allNumbers.put("nine", '9');

        StringBuilder inputBuilder = new StringBuilder(input);

        for (Map.Entry<String, Character> Number : allNumbers.entrySet()){
            if(input.contains(Number.getKey())){
                var first = input.indexOf(Number.getKey());
                var last = input.lastIndexOf(Number.getKey());
                containedNumbers.put(first, Number.getKey());
                containedNumbers.put(last, Number.getKey());
            }
        }

        for(Map.Entry<Integer, String> Number : containedNumbers.entrySet()) {
            inputBuilder.setCharAt(Number.getKey(), allNumbers.get(Number.getValue()));
        }

        return inputBuilder.toString();
    }

    public static void main(String[] args) {
        SumFirstAndLastNumbers sumFirstAndLastNumbers = new SumFirstAndLastNumbers();
        sumFirstAndLastNumbers.sumFirstAndLastNumber();
        sumFirstAndLastNumbers.sumFirstAndLastNumberInChar();
    }

}
