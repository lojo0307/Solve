import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Queue<Music>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            Queue<Music> q = map.get(genres[i]);
            if (q == null) {
                map.put(genres[i], new PriorityQueue<Music>((o1, o2) -> o2.play - o1.play));
                q = map.get(genres[i]);
            }
            q.offer(new Music(plays[i], i));
        }
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        
        map.forEach((genre, queue) -> {
            int[] temp = new int[3];
            Music music = queue.poll();
            temp[1] = music.idx;
            temp[0] += music.play;
            if (!queue.isEmpty()) {
                music = queue.poll();
                temp[2] = music.idx;
                temp[0] += music.play;
                
            } else temp[2] = -1;
            while (!queue.isEmpty()) temp[0] += queue.poll().play;
            pq.offer(temp);
        });
        
        int[] ans = new int[plays.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            ans[i++] = temp[1];
            if (temp[2] >= 0) ans[i++] = temp[2];
        }
        
        return Arrays.copyOfRange(ans, 0, i);
    }
}

class Music {
    int play;
    int idx;
    Music(int play, int idx){
        this.play = play;
        this.idx = idx;
    };
}