package BOJ;

import java.util.Scanner;

public class BOJ_Bronze2_2577_숫자의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        String ret = Integer.toString(A * B * C);
        int[] nums = new int[10];
        for (int i = 0; i < ret.length(); i++) {
            nums[ret.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(nums[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}