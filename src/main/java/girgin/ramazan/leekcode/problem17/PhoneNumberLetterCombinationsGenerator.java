package girgin.ramazan.leekcode.problem17;

import java.util.*;

public class PhoneNumberLetterCombinationsGenerator {

    private static Map<Character, char[]> numberMap = new HashMap<>();

    static {
        initMap();
    }

    private static void initMap() {
        addToMap('2', 'a', 'b', 'c');
        addToMap('3', 'd', 'e', 'f');
        addToMap('4', 'g', 'h', 'i');
        addToMap('5', 'j', 'k', 'l');
        addToMap('6', 'm', 'n', 'o');
        addToMap('7', 'p', 'q', 'r', 's');
        addToMap('8', 't', 'u', 'v');
        addToMap('9', 'w', 'x', 'y', 'z');
    }

    private static void addToMap(char digit, char... letters) {
        numberMap.put(digit, letters);
    }

    public List<String> generate(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        initMap();
        List<String> resultList = new ArrayList<>();
        executeLevel(resultList, "", digits.toCharArray(), 0);
        return resultList;
    }

    private void executeLevel(List<String> resultList, String input, char[] chars, int index) {
        if (index == chars.length) {
            resultList.add(input);
            return;
        }
        char[] digitLetters = numberMap.get(chars[index]);
        for (Character digitLetter : digitLetters) {
            executeLevel(resultList, input + digitLetter, chars, index + 1);
        }
    }
}
