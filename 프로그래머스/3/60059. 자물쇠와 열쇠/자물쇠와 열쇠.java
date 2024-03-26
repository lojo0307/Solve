import java.util.*;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        
        
        for (int t = 0; t < 4; t++) {
            
            int[][] temp = new int[key.length][key[0].length];
            for (int r = 0; r < key.length; r++) temp[r] = Arrays.copyOf(key[r], key[r].length);

            for (int r = 0; r < key.length; r++) {
                for (int c = 0; c < key[0].length; c++) {
                    key[r][c] = temp[c][key.length - 1 - r];
                }
            }

            for (int r = 0; r < key.length; r++) System.out.println(Arrays.toString(key[r]));
            
            int k1 = -1 * key.length + 1;
            int k2 = -1 * key[0].length + 1;
            
            for (int tr = k1; tr < lock.length; tr++) {
                for (int tc = k2; tc < lock[0].length; tc++) {
                    // key의 왼쪽 위 맞닿는 위치가 tr, tc
                    boolean flag = true;
                    loop : for (int r = 0; r < lock.length; r++) {
                        for (int c = 0; c < lock[0].length; c++) {
                            if (r - tr >= 0 && r - tr < key.length && c - tc >= 0 && c - tc < key[0].length) {
                                if (key[r-tr][c-tc] == lock[r][c]) {
                                    flag = false;
                                    break loop;
                                }
                            } else {
                                if (lock[r][c] == 0) {
                                    flag = false;
                                    break loop;
                                }
                            }
                        }
                    }
                    if (flag) return true;
                }
            }
        }
        return false;
    }
}