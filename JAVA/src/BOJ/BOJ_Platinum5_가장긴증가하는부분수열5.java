package BOJ;

import java.util.Scanner;

public class BOJ_Platinum5_가장긴증가하는부분수열5 {
    static int N;
    static int[] arr, lis, idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 1<=N<=1,000
        arr = new int[N];
        lis = new int[N];
        idx = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int len = 0;
        lis[0] = arr[0];
        for (int i = 1; i < N; i++) {
            if (lis[len] < arr[i]) {
                lis[++len] = arr[i];
                idx[i] = len;
            } else {
                int k = binarySearch(0, len, arr[i]);
                lis[k] = arr[i];
                idx[i]  = k;
            }
        }

        int[] ans = new int[len+1];
        for (int i = N-1; i >=0 ; i--) {
            if(idx[i]==len){
                ans[len--] = arr[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.length).append("\n");
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int binarySearch(int left, int right, int target) {

        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}