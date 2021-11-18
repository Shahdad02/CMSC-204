import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Shahdad Parsi
 * MorseCodeConverter class
 * Converts Mmrse code to english
 */
public class MorseCodeConverter {
    private static final MorseCodeTree hello = new MorseCodeTree();

    /**
     * returns string with the data in LNR order
     * @return data from tree in LNR order
     */
    public static String printTree() {
        StringBuilder str = new StringBuilder();
        ArrayList<String> list = hello.toArrayList();

        for (String s : list) {
            str.append(s).append(" ");
        }
        return str.toString();
    }

    /**
     * Convert morse code into english
     * @param code
     * @return english translation
     */
    public static String convertToEnglish(String code) {
        String[] words;
        String[] letters;
        StringBuilder str = new StringBuilder();

        words = code.split("/");
        for(int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
            letters = words[i].split(" ");

            for (String letter : letters) {
                str.append(hello.fetch(letter));
            }
            str.append(" ");
        }
        str = new StringBuilder(str.toString().trim());
        return str.toString();
    }

    /**
     * converts a file into english from more code
     * @param codeFile
     * @return english translation
     * @throws FileNotFoundException
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        Scanner scan = new Scanner(codeFile);
        String str = "";

        while(scan.hasNext()) {
            str += convertToEnglish(scan.nextLine());
        }
        scan.close();
        return str;
    }
}
