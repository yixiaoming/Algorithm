import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] 常数时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {

    ArrayList<Integer> arr;
    HashMap<Integer, Integer> map;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastVal = arr.get(arr.size()-1);
        arr.set(index, lastVal);
        map.put(lastVal, index);
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end
