#include <iostream>
#include <algorithm>

using namespace std;

int N, ans;
char map[50][50];

int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

void check() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; j + k < N; k++) {
                if (map[i][j] == map[i][j + k]) {
                    ans = ans < k+1 ? k+1 : ans;
                }else{
                    break;
                }
            }
            for (int s = 0; s + i < N; s++) {
                if (map[i][j] == map[i + s][j]) {
                    ans = ans < s+1 ? s+1 : ans;
                }else{
                    break;
                }
            }
        }
    }
}
bool isRange(int r, int c) { return 0 <= r && r < N && 0 <= c && c < N; }

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map[i][j];
        }
    }

    ans = -1;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < 4; k++) {
                int nr = i + dr[k];
                int nc = j + dc[k];
                if (isRange(nr, nc) && map[i][j] != map[nr][nc]) {
                    swap(map[i][j], map[nr][nc]);
                    check();
                    swap(map[i][j], map[nr][nc]);
                }
            }
        }
    }
    cout << ans << endl;
}