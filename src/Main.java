public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String parentheses) {
        int result = 0;
        for (int i=0;i<parentheses.length();i++){
            if(parentheses.charAt(i)=='('){
                result+=1;
            }else{
                result-=1;
            }
        }
        return result==0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int a) {
        String result = "";
        String a_str = a + "";

        for (int i = 0; i < a_str.length(); i++) {
            result = result + a%10;
            a = a/10;
        }
        return result;
    }
    // 3. encryptThis
    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        StringBuilder encryptedText = new StringBuilder();

        for (String word : words) {
            if (word.length()==0) {
                encryptedText.append(" ");
                continue;
            }
            StringBuilder encryptedWord = new StringBuilder(String.valueOf((int) word.charAt(0)));
            if (word.length() > 2) {
                encryptedWord.append(word.charAt(word.length() - 1));
                encryptedWord.append(word, 2, word.length() - 1);
                encryptedWord.append(word.charAt(1));
            } else if (word.length() == 2) {
                encryptedWord.append(word.charAt(1));
            }
            encryptedText.append(encryptedWord).append(" ");
        }
        return encryptedText.toString().trim();
    }
// 4. decipherThis
public static String decipherThis(String text) {
    StringBuilder decodedText = new StringBuilder();
    String[] words = text.split(" ");

    for (String word : words) {
        StringBuilder decodedWord = new StringBuilder();
        int asciiCodeEndIndex = findFirstDigitIndex(word);
        int asciiCode = Integer.parseInt(word.substring(0, asciiCodeEndIndex));
        decodedWord.append((char) asciiCode);

        String remaining = word.substring(asciiCodeEndIndex);
        if (remaining.length() > 1) {
            decodedWord.append(remaining.charAt(remaining.length() - 1));
            decodedWord.append(remaining.substring(2, remaining.length() - 1));
            decodedWord.append(remaining.charAt(1));
        } else if (remaining.length() == 1) {
            decodedWord.append(remaining.charAt(0));
        }

        decodedText.append(decodedWord).append(" ");
    }

    return decodedText.toString().trim();
}

    private static int findFirstDigitIndex(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) return i;
        }
        return -1;
    }

}