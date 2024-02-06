import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            arr.add(input.nextInt());
        }

        if(arr.size() == 0) System.out.println(0);
        System.out.println(helper(arr).longValue() - 1);

    }
    public static BigInteger helper(List<Integer> nums) {
        if(nums.size() <= 2) return BigInteger.ONE;
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i=1; i<nums.size(); i++) {
            if(nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        BigInteger count = combination(nums.size() - 1, left.size());
        BigInteger leftCount = helper(left);
        BigInteger rightCount = helper(right);
        return count.multiply(leftCount).multiply(rightCount).mod(BigInteger.valueOf(MOD));
    }

    public static BigInteger combination(int total, int num) {
        num = Math.min(num, total - num);
        if(num == 0) return BigInteger.ONE;

        BigInteger res = BigInteger.ONE;
        int limit = num;
        long multi = total;
        long did = 1;
        for(int i=0; i<limit; i++) {
            res = res.multiply(BigInteger.valueOf(multi--));
            res = res.divide(BigInteger.valueOf(did++));
        }

        return res;
    }
}