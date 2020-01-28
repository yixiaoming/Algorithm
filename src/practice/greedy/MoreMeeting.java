package practice.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 19.10.22.
 *
 * 安排最多的会议
 *
 * 给定两个数组 start[1,2,3], end[2,3,4],存储一个会议的起始和结束时间，每个时间段最多
 * 只能有一个会议。求整个时间段内最多能开多少个会议。
 */
public class MoreMeeting {

  public static void main(String[] args) {
    int[] starts = new int[]{3, 1, 2, 5, 1};
    int[] ends = new int[]{6, 6, 5, 6, 11};
    int from = 1;
    int to = 24;
    System.out.println("from:" + from + ",to:" + to);
    System.out.println("count:" + getMeetingCount(starts, ends, from, to));
  }

  private static class Metting {
    int start;
    int end;

    public Metting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "Metting{" +
        "start=" + start +
        ", end=" + end +
        '}';
    }
  }

  public static int getMeetingCount(int[] starts, int[] ends, int begin, int to) {
    PriorityQueue<Metting> queue = new PriorityQueue<>(new MyComparator());
    for (int i = 0; i < starts.length; i++) {
      queue.add(new Metting(starts[i], ends[i]));
    }
    int now = begin;
    int last = begin;
    int i = 0;
    int count = 0;
    Metting metting;
    while (now <= to && queue.size() > 0) {
      metting = queue.poll();
      if (now <= metting.end && last <= metting.start) {
        count++;
        last = metting.end;
        System.out.printf("第:%d场,%s,now:%d,last:%d,to:%d\n", i, metting.toString(), now, last, to);
        i++;
      } else {
        System.out.printf("第:%d场,%s,now:%d,last:%d,to:%d - 安排不上\n", i, metting.toString(), now, last, to);
      }
      now++;
    }
    return count;
  }

  private static class MyComparator implements Comparator<Metting> {

    @Override
    public int compare(Metting o1, Metting o2) {
      return o1.end - o2.end;
    }
  }
}
