package a2_sorting_algo.Problems;

public class p02_CheckPanagram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        char[] ch_arr = sentence.toCharArray();

        int pointer = 0;

        while (pointer <= ch_arr.length-1) {
            // second condition avoid infinite looping
            if (ch_arr[pointer] == pointer+97 || 
            ch_arr[ch_arr[pointer]-97] == ch_arr[pointer]) {
                pointer++;
            } else {
                char temp = ch_arr[ch_arr[pointer]-97];
                ch_arr[ch_arr[pointer]-97] = ch_arr[pointer];
                ch_arr[pointer] = temp;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (ch_arr[i] != i+97) {
                return false;
            }
        }
        return true;
    }
}
