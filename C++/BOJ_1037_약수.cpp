#include <iostream>
using namespace std;

int main() {
    int min = INT_MAX, max = INT_MIN;

    int n;
    cin >> n;
    
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        if (min > temp) {
            min = temp;
        }
        if (max < temp) {
            max = temp;
        }
    }
    cout << min * max << endl;
    return 0;
}