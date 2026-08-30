#include<iostream>
using namespace std;

int main(){

    double grid[3][3];
    cout << "Enter readings for 3 floors (3 rooms per floor):\n";
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            cin >> grid[i][j];
        }
    }
    cout << "\n\tRoom 1\tRoom 2\tRoom 3\n";
    for (int i = 0; i < 3; i++) {
        cout << "Floor " << (i + 1) << " :";
        for (int j = 0; j < 3; j++) {
            cout << "\t" << grid[i][j];
        }
        cout << endl;
    }

    // Baseline: Assume the first room is the hottest
    double maxTemp = grid[0][0];
    int maxFloor = 1, maxRoom = 1;
    int warningCount = 0;

    int highestAvgFloor = 1;
    double highestAvg = 0.0;

    for (int i = 0; i < 3; i++) {
        double floorSum = 0.0;
        for (int j = 0; j < 3; j++) {
            double temp = grid[i][j];
            floorSum += temp;

            if (temp > maxTemp) {
                maxTemp = temp;
                maxFloor = i + 1;
                maxRoom = j + 1;
            }

            if (temp >= 30.0) {
                warningCount++;
            }
        }

        double floorAvg = floorSum / 3.0;

        // Initialize with floor 1 on i == 0, then update on higher averages
        if (i == 0 || floorAvg > highestAvg) {
            highestAvg = floorAvg;
            highestAvgFloor = i + 1;
        }
    }

    cout << "\nHottest Room             : Floor " << maxFloor << ", Room " << maxRoom << " -> " << maxTemp << " C" << endl;
    cout << "Hottest Floor            : Floor " << highestAvgFloor << " (avg " << highestAvg << " C)" << endl;
    cout << "Rooms at WARNING or above: " << warningCount << endl;

    return 0;
}


