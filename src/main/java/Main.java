import javax.sound.midi.Soundbank;
import java.awt.font.NumericShaper;
import java.lang.management.PlatformLoggingMXBean;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(1, -1));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0;
        if(dividend == 0) return 0;
        int plus = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;
        if(dividend == 1) return dividend*plus;
        if(divisor == -1){
            if(dividend>Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }
        if (dividend < 0) {
            dividend = -dividend;
            divisor = -divisor;
        }

        while (dividend >= 0) {
            result++;
            if (divisor > 0) {
                dividend -= divisor;
            } else {
                dividend += divisor;
            }
        }
        return (result - 1) * plus;
    }
}