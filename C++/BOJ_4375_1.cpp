#include <iostream>
using namespace std;
int main() {
    int n;
    while (cin >> n) {
        int k = 1;
        int ans = 1;
        while (true) {
            if (ans % n == 0) {
                cout << k << endl;
                break;
            } else {
                ans = ans * 10 + 1;
                ans %= n;
                k++;
            }
        }
    }
}