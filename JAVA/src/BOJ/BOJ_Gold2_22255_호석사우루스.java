package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_Gold2_22255_호석사우루스 {
    static int N, M;
    static int[][] map;
    static int[] start, end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        start = new int[]{sc.nextInt() - 1, sc.nextInt() - 1};
        end = new int[]{sc.nextInt() - 1, sc.nextInt() - 1};

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(slove());
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static int slove() {
        int[][][] memo = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    memo[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[0] - arg1[0];
            }
        });

        pq.add(new int[]{map[start[0]][start[1]], start[0], start[1], 1});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[1] == end[0] && now[2] == end[1]) {
                return now[0];
            }

            int score = now[0];
            int r = now[1];
            int c = now[2];
            int time = now[3];

            int k = time % 3;
            int s, e;
            if (k == 0) {
                // 3K 번째 이동 시에는 상, 하, 좌, 우로 인접한 곳 중 한 칸으로 이동할 수 있다.
                s = 0;
                e = 3;
            } else if (k == 1) {
                // 3K+1 번째 이동 시에는 상, 하로 인접한 곳 중 한 칸으로 이동할 수 있다.
                s = 0;
                e = 1;
            } else {
                // 3K+2 번째 이동 시에는 좌, 우로 인접한 곳 중 한 칸으로 이동할 수 있다.
                s = 2;
                e = 3;
            }

            for (int dir = s; dir <= e; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (isRange(nr, nc) && map[nr][nc] != -1 && memo[nr][nc][k] > score + map[nr][nc]) {
                    memo[nr][nc][k] = score + map[nr][nc];
                    pq.add(new int[]{score + map[nr][nc], nr, nc, time + 1});
                }
            }
        }
        return -1;
    }

    private static boolean isRange(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < M;
    }
}