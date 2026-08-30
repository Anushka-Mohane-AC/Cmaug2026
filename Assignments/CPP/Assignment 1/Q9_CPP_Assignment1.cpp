#include <iostream>
#include <cmath>
using namespace std;

const double PI = 3.14159265359;

inline double distanceBetween(double x1, double y1, double x2, double y2) {
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

inline double toRadians(double degrees) {
    return degrees * (M_PI / 180.0);
}

inline double clamp(double value, double minVal, double maxVal) {
    if (value < minVal) return minVal;
    if (value > maxVal) return maxVal;
    return value;
}

inline bool isInSafeZone(double x, double y, double cx, double cy, double radius) {
    return distanceBetween(x, y, cx, cy) <= radius;
}

int main() {
    double homeX = 0.0, homeY = 0.0;
    double safeRadius = 50.0;

    double waypoints[3][2] = {
        {15.0, 20.0},
        {40.0, 35.0},
        {30.0, -45.0}
    };

    for (int i = 0; i < 3; i++) {
        double wx = waypoints[i][0];
        double wy = waypoints[i][1];
        double dist = distanceBetween(homeX, homeY, wx, wy);
        bool safe = isInSafeZone(wx, wy, homeX, homeY, safeRadius);

        cout << "Waypoint " << (i + 1) << " (" << wx << ", " << wy << "): "
             << "Distance = " << dist << " units | "
             << "Safe Zone: " << (safe ? "INSIDE" : "OUTSIDE") << endl;
    }

    return 0;
}