package practice.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 19.10.19.
 * <p>
 * 给定一个字符串数组，求将所有字符串拼接在一起，按字典序最小的字符串。
 * <p>
 * ["ac","b","bad"] -> ac bad b
 * 贪心策略
 * <p>
 * a+b <= b+a  -> ab
 *
 * 不能直接对比两个string的字典序，因为 "ba","b"这种会得到结果 bba, 而正确结果为 bab
 */
public class MinSliceStrings {

  public static void main(String[] args) {
    String[] strs = {"ad", "b", "ba", "abc"};
    Arrays.sort(strs, new C());
    for (String item : strs) {
      System.out.printf("%s,", item);
    }
  }

  public static class C implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      return (o1 + o2).compareTo(o2 + o1);
    }
  }
}
