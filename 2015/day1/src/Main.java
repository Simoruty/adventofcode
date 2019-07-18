public class Main {

    public static void main(String[] args) {

        int tot = 0;

        char[] inputChar = Common.readFromFile("./input").toCharArray();

        for (char c : inputChar) {
            if (c == '(')
                tot++;
            if (c == ')')
                tot--;
        }
        System.out.println(tot);

        tot = 0;
        int basement = 1;
        for (int i = 0; i < inputChar.length; i++) {
            char c = inputChar[i];
            if (c == '(')
                tot++;
            if (c == ')')
                tot--;
            if (tot == -1) {
                basement = i + 1;
                break;
            }
        }
        System.out.println(basement);

    }
}
