class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        map = new int[cityMap.length][cityMap[0].length];
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) map[r][c] = cityMap[r][c];
        }
        
        return drive(0, 0, true);
    }
    
    static int[][] map;
    public int drive(int r, int c, boolean dir) { // true면 왼->오 false면 위->아래
        if (r == map.length - 1 && c == map[0].length - 1) return 1;
        if (map[r][c] == 1) return 0;
        if (map[r][c] == 2) {
            if (dir) {
                if (c + 1 == map[0].length) return 0;
                return drive(r, c+1, true);
            } else {
                if (r + 1 == map.length) return 0;
                return drive(r+1, c, false);
            }
        }
        
        int temp = 0;
        if (r != map.length - 1) temp += drive(r+1, c, false);
        if (c != map[0].length - 1) temp += drive(r, c+1, true);
        return temp % MOD;
    }
}