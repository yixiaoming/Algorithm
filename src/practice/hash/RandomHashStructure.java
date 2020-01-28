package practice.hash;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Administrator on 19.10.17.
 * <p>
 * 设计一个结构，使得插入和删除以及随机获取一个值的时间复杂度都为O(1)
 *
 * 主要是增加一个 Map<Integer, T> 这个结构，用于随机获取一个值。
 * 在删除的时候，需要注意及那个最后一个数直接复制给删除值的index，以确定随机的时候不会出现空洞
 */
public class RandomHashStructure {

  public static void main(String[] args) {
    RandomHashMap<String> map = new RandomHashMap<>();
    map.insert("a");
    map.insert("b");
    map.insert("c");
    map.insert("d");
    map.printContents();

    String data = map.random();
    System.out.println("delete:" + data);
    map.delete(data);
    map.printContents();

    data = map.random();
    System.out.println("delete:" + data);
    map.delete(data);
    map.printContents();

    data = map.random();
    System.out.println("delete:" + data);
    map.delete(data);
    map.printContents();

    data = map.random();
    System.out.println("delete:" + data);
    map.delete(data);
    map.printContents();
  }

  public static class RandomHashMap<T> {
    private HashMap<T, Integer> datas = new HashMap<>();
    private HashMap<Integer, T> indexes = new HashMap<>();

    private int maxIndex = 0;

    public void insert(T t) {
      if (datas.get(t) == null) {
        datas.put(t, maxIndex);
        indexes.put(maxIndex, t);
        maxIndex++;
      }
    }

    public void delete(T t) {
      Integer index = datas.get(t);
      if (index != null) {
        T swapData = indexes.get(maxIndex - 1);
        datas.put(swapData, index);
        datas.remove(t);
        indexes.put(index, swapData);
        indexes.remove(maxIndex - 1);
        maxIndex--;
      }
    }

    public T random() {
      if (maxIndex == 0) {
        return null;
      }
      int randomIndex = new Random().nextInt(maxIndex);
      return indexes.get(randomIndex);
    }

    public void printContents() {
      System.out.println(datas.entrySet());
      System.out.println(indexes.entrySet());
      System.out.println();
    }

  }
}
