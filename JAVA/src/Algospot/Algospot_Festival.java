package Algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_Festival {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < C; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] sum = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            double min = Double.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                for (int j = i + L - 1; j <= N; j++) {
                    int cost = sum[j] - sum[i - 1];
                    int size = j - i + 1;
                    min = Math.min(min, cost / (double) size);
                }
            }
            System.out.println(min);
        }
    }
}
