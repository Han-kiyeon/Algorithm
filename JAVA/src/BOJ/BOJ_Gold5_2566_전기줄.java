package BOJ;

import java.util.Scanner;

public class BOJ_Gold5_2566_전기줄 {
    final static int Size = 501;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[Size];
        for (int i = 0; i < N; i++) {
            arr[sc.nextInt()] = sc.nextInt();
        }

        int max = -1;

        int[] dp = new int[Size];
        dp[1] = 1;

        for (int i = 2; i < Size; i++) {
            if (arr[i] == 0) {
                continue;
            }
            int temp = 0;
            for (int j = 1; j < i; j++) {
                if (arr[j] == 0) {
                    continue;
                } else if (arr[j] < arr[i]) {
                    temp = Math.max(dp[j], temp);
                }
            }
            dp[i] = temp + 1;
            max = Math.max(dp[i], max);
        }

        System.out.println(N - max);
    }
}