#include <iostream>
#include <cmath>

using namespace std;


double computeRMS(double* signal, int n) {
    double sumSquares = 0.0;
    double* ptr = signal;
    for (int i = 0; i < n; i++) {
        sumSquares += (*(ptr + i)) * (*(ptr + i));
    }
    return sqrt(sumSquares / n);
}

void normalise(double* signal, int n) {
    double maxAbs = 0.0;
    double* ptr = signal;
    for (int i = 0; i < n; i++) {
        double val = fabs(*(ptr + i));
        if (val > maxAbs) {
            maxAbs = val;
        }
    }

    if (maxAbs > 0.0) {
        for (int i = 0; i < n; i++) {
            *(ptr + i) = *(ptr + i) / maxAbs;
        }
    }
}

int countZeroCrossings(double* signal, int n) {
    int crossings = 0;
    double* ptr = signal;
    for (int i = 0; i < n - 1; i++) {
        if ((*(ptr + i) * (*(ptr + i + 1))) < 0.0) {
            crossings++;
        }
    }
    return crossings;
}

void applyGain(double* signal, int n, double gainFactor) {
    double* ptr = signal;
    for (int i = 0; i < n; i++) {
        *(ptr + i) *= gainFactor;
    }
}

void printSignal(double* signal, int n) {
    for (int i = 0; i < n; i++) {
        cout << *(signal + i) << " ";
    }
    cout << endl;
}

int main() {
    double testSignal[] = {0.5, -1.2, 0.8, -0.3, 1.0, -0.9, 0.1};
    int n = sizeof(testSignal) / sizeof(testSignal[0]);

    cout << "Original Signal: ";
    printSignal(testSignal, n);

    cout << "RMS Value: " << computeRMS(testSignal, n) << endl;
    cout << "Zero Crossings: " << countZeroCrossings(testSignal, n) << endl;

    normalise(testSignal, n);
    cout << "After Normalise: ";
    printSignal(testSignal, n);

    applyGain(testSignal, n, 2.0);
    cout << "After Apply Gain (2.0x): ";
    printSignal(testSignal, n);

    return 0;
}