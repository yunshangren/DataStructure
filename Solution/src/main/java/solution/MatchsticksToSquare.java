package solution;

import org.junit.Test;

import java.util.HashMap;

public class MatchsticksToSquare {
    public boolean makeSquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if ((sum & (-sum) & 0x55555555) != sum) {
            return false;
        }
        int len = sum >> 2;
        for (int matchstick : matchsticks) {
            if (matchstick > len) {
                return false;
            }
        }

        return false;
    }

    public boolean judgeCircle(String moves){
        int row = 0;
        int col = 0;
        for(int i = 0; i < moves.length(); i++){
            char c = moves.charAt(i);
            if(c == 'U'){
                row++;
            }else if(c == 'D'){
                row--;
            }else if(c == 'L'){
                col--;
            }else{
                col++;
            }
        }
        return row == 0 && col == 0;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(!map.containsKey(c) || map.get(c) == 0){
                return false;
            }
            map.put(c,map.get(c) - 1);
        }
        return true;
    }

    @Test
    public void test() {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote,magazine));
    }
}
