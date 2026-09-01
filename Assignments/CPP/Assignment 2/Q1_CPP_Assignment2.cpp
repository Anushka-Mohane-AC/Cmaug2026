#include <iostream>
#include <string>

using namespace std;

class Product {
private:
    int productId;
    string name;
    double price;
    int quantity;

public:
    void acceptDetails() {
        cin >> productId;
        cin.ignore();
        getline(cin, name);
        cin >> price;
        cin >> quantity;
    }

    void displayDetails() const {
        cout << productId << "\t" 
             << name << "\t" 
             << price << "\t" 
             << quantity << "\t" 
             << totalValue();
        if (isLowStock(10)) {
            cout << "\tLOW STOCK";
        }
        cout << endl;
    }

    double totalValue() const {
        return price * quantity;
    }

    bool isLowStock(int threshold) const {
        return quantity < threshold;
    }

    string getName() const { return name; }
};

double reorderCost(int qty, double unitPrice) {
    return qty * unitPrice;
}

double reorderCost(double qty, double unitPrice) {
    return qty * unitPrice;
}

double reorderCost(int qty, double unitPrice, double taxRate) {
    double base = qty * unitPrice;
    return base + (base * (taxRate / 100.0));
}

double applyDiscount(double price, double discountPercent = 10.0) {
    return price - (price * (discountPercent / 100.0));
}

int main() {

    Product inventory[5];

    for (int i = 0; i < 5; i++) {
        inventory[i].acceptDetails();
    }

    cout << "\n===== INVENTORY REPORT =====" << endl;
    cout << "ID\tName\tPrice\tQty\tTotal Value" << endl;
    for (int i = 0; i < 5; i++) {
        inventory[i].displayDetails();
    }

    int maxIdx = 0;
    for (int i = 1; i < 5; i++) {
        if (inventory[i].totalValue() > inventory[maxIdx].totalValue()) {
            maxIdx = i;
        }
    }
    cout << "\nHighest Value Product: " << inventory[maxIdx].getName() 
         << " (Rs. " << inventory[maxIdx].totalValue() << ")" << endl;

    int threshold;
    cin >> threshold;
    cout << "Low Stock (threshold: " << threshold << "): ";
    for (int i = 0; i < 5; i++) {
        if (inventory[i].isLowStock(threshold)) {
            cout << inventory[i].getName() << ", ";
        }
    }
    cout << endl;

    cout << reorderCost(10, 250.0) << endl;
    cout << reorderCost(12.5, 40.0) << endl;
    cout << reorderCost(10, 250.0, 18.0) << endl;
    cout << applyDiscount(500.0) << endl;
    cout << applyDiscount(500.0, 20.0) << endl;

    return 0;
}