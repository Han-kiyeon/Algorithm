import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;

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
                String str = br.readLine();
                boolean ans = false;
                for (int i = 0; i < 5 && !ans; i++) {
                    for (int j = 0; j < 5 && !ans; j++) {
                        if (map[i][j] != str.charAt(0)) {
                            continue;
                        }
                        ans = DFS(i, j, 0, str);
                    }
                }

                System.out.println(str + (ans ? " YES" : " NO"));

            }
        } //end of TC
    }

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    private static boolean DFS(int i, int j, int idx, String str) {
        System.out.println(map[i][j]);
        if (idx == str.length() - 1) {
            return true;
        }
        boolean ret = false;
        for (int k = 0; k < 8 && !ret; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (isRange(nr, nc) && map[nr][nc] == str.charAt(idx + 1)) {
                ret = DFS(nr, nc, idx + 1, str);
            }
        }
        return ret;
    }

    private static boolean isRange(int nr, int nc) {
        return 0 <= nr && nr < 5 && 0 <= nc && nc < 5;
    }
}

