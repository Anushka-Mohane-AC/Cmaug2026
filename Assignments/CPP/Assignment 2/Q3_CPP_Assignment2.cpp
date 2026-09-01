#include <iostream>
#include <string>

using namespace std;

class Entity {
private:
    string name;
    int health;
    int level;
    string type;

public:
    Entity& setName(const string& name) {
        this->name = name;
        return *this;
    }

    Entity& setHealth(int health) {
        this->health = health;
        return *this;
    }

    Entity& setLevel(int level) {
        this->level = level;
        return *this;
    }

    Entity& setType(const string& type) {
        this->type = type;
        return *this;
    }

    string getName() const { return name; }
    int getHealth() const { return health; }
    int getLevel() const { return level; }
    string getType() const { return type; }

    void displayInfo() const {
        cout << "[" << type << "] " << name 
             << " | Level: " << level 
             << " | Health: " << health << endl;
    }
};

namespace Physics {
    double clamp(double val, double min, double max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    double lerp(double a, double b, double t) {
        return a + t * (b - a);
    }
}

namespace GameMath {
    int clamp(int val, int min, int max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    double lerp(double a, double b, double t) {
        return a + t * (b - a);
    }
}

int main() {
    Entity player, enemy, item;
    player.setName("Aragorn").setHealth(100).setLevel(10).setType("Player");
    enemy.setName("Orc").setHealth(60).setLevel(5).setType("Enemy");
    item.setName("HealthPotion").setHealth(0).setLevel(1).setType("Item");

    player.displayInfo();
    enemy.displayInfo();
    item.displayInfo();

    cout << Physics::clamp(120.5, 0.0, 100.0) << endl;
    cout << GameMath::clamp(150, 0, 100) << endl;

    {
        using namespace GameMath;
        cout << lerp(0.0, 100.0, 0.5) << endl;
    }

    int R, C;
    cin >> R >> C;

    int** map = new int*[R];
    for (int i = 0; i < R; i++) {
        map[i] = new int[C];
    }

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> map[i][j];
        }
    }

    cout << "===== GAME MAP (" << R << " x " << C << ") =====" << endl;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cout << map[i][j] << " ";
        }
        cout << endl;
    }
    cout << "Legend: 0=Grass 1=Water 2=Mountain 3=Forest 4=Dungeon" << endl;

    int grass = 0, water = 0, mountain = 0, forest = 0, dungeon = 0;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (map[i][j] == 0) grass++;
            else if (map[i][j] == 1) water++;
            else if (map[i][j] == 2) mountain++;
            else if (map[i][j] == 3) forest++;
            else if (map[i][j] == 4) dungeon++;
        }
    }

    cout << "Tile Count:" << endl;
    cout << "Grass   : " << grass << endl;
    cout << "Water   : " << water << endl;
    cout << "Mountain: " << mountain << endl;
    cout << "Forest  : " << forest << endl;
    cout << "Dungeon : " << dungeon << endl;

    for (int i = 0; i < R; i++) {
        delete[] map[i];
    }
    delete[] map;

    return 0;
}