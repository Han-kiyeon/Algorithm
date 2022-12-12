package BOJ;

import java.util.Scanner;

public class BOJ_Silver5_1457_방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] nums = new int[10];
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i) - '0']++;
        }
        int max = -1;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            max = max < nums[i] ? nums[i] : max;
        }
        max = max < (nums[6] + nums[9] + 1) / 2 ? (nums[6] + nums[9] + 1) / 2 : max;
        System.out.println(max);
    }
}