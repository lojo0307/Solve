import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		long sum1 = 0;
		long sum2 = 0;
		for (Integer i : queue1) {
			q1.offer(i);
			sum1 += i;
		}
		for (Integer i : queue2) {
			q2.offer(i);
			sum2 += i;
		}
		
		if ((sum1 + sum2) % 2 != 0) return -1;
		else if (sum1 == sum2) return 0;
		int max = (queue1.length + queue2.length)*4;
		
		int res = -1;
		int cnt = 0;
		while (cnt <= max) {
			cnt++;
			if (sum1 < sum2) {
				int tmp = q2.poll();
				sum2 -= tmp;
				sum1 += tmp;
				if (sum1 == sum2) {
					res = cnt;
					break;
				}
				q1.offer(tmp);
			} else {
				int tmp = q1.poll();
				sum1 -= tmp;
				sum2 += tmp;
				if (sum1 == sum2) {
					res = cnt;
					break;
				}
				q2.offer(tmp);
			}
		}
		return res;
	}
}