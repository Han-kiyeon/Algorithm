#include <algorithm>
#include <iostream>
using namespace std;

int arr[9];
int combi[7];
bool flag;
bool check() {
    int sum = 0;
    for (int i = 0; i < 7; i++) {
        sum += arr[combi[i]];
    }
    return sum == 100 ? true : false;
}
void solve(int start, int depth) {
    if (depth == 7 && !flag) {
        if (check()) {
            for (int i = 0; i < 7; i++) {
                printf("%d\n", arr[combi[i]]);
            }
            flag = true;
        }
        return;
    }
    for (int i = start; i < 9; i++) {
        combi[depth] = i;
        solve(i + 1, depth + 1);
    }
}
int main() {
    for (int i = 0; i < 9; i++) {
        scanf("%d", &arr[i]);
    }
    sort(arr, arr + 9);
    solve(0, 0);
    return 0;
}
