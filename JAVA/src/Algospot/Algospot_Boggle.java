package Algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algospot_Boggle {
    static String word;
    static char[][] map;
    static boolean[][][] memo;
ß
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < C; tc++) {
            map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int N = Integer.parseInt(br.readLine());
            for (int k = 0; k < N; k++) {
                word = br.readLine();
                boolean ans = false;
                memo = new boolean[5][5][word.length()];
                for (int i = 0; i < 5 && !ans; i++) {
                    for (int j = 0; j < 5 && !ans; j++) {
                        if (map[i][j] != word.charAt(0)) {
                            continue;
                        }
                        memo[i][j][0] = true;
                        ans = DFS(i, j, 0);
                    }
                }

                System.out.println(word + (ans ? " YES" : " NO"));

            }
        } // end of TC
    }

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    private static boolean DFS(int i, int j, int idx) {
        if (idx == word.length() - 1) {
            return true;
        }
        for (int k = 0; k < 8; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (isRange(nr, nc) && !memo[nr][nc][idx + 1] && map[nr][nc] == word.charAt(idx + 1)) {
                memo[i][j][idx] = true;
                if (DFS(nr, nc, idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isRange(int nr, int nc) {
        return 0 <= nr && nr < 5 && 0 <= nc && nc < 5;
    }
}