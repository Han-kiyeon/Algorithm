#include <iostream>
bool memo[1000001];
int main() {
    memo[1] = memo[2] = true;
    for (int i = 2; i <= 1000000; i++) {
        if (memo[i]) {  // 자연수 i가 어떤 소수의 배수인 경우
            continue;
        }

        int temp = i + i;  // 소수 i의 배수 찾기
        while (temp <= 1000000) {
            memo[temp] = true;
            temp += i;
        }
    }

    int n;
    while (true) {
        scanf("%d", &n);
        if (n == 0) {
            break;
        }
        bool flag = false;
        for (int i = 3; i <= n >> 1; i++) {
            if (!memo[i] && !memo[n - i]) {
                printf("%d = %d + %d\n", n, i, n - i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            printf("Goldbach's conjecture is wrong.\n");
        }
    }

    return 0;
}