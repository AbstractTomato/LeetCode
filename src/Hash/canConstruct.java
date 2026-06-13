package Hash;


/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class canConstruct {
    public boolean canConstruct(String ransomNote, String magazine){
        if (magazine == null || magazine.isEmpty() || magazine.length() < ransomNote.length()){
            return false;
        }

        int[] charArr1 = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            charArr1[ransomNote.charAt(i) - 'a']++;
        }

        int[] charArr2 = new int[26];
        for (int i = 0; i < magazine.length(); i++){
            charArr2[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < charArr1.length; i++) {
            if (charArr2[i] < charArr1[i]){
                return false;
            }
        }

        return true;
    }
}
