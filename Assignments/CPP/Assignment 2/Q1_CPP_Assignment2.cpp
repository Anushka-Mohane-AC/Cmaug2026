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
        cout << "Enter Product ID: ";
        cin >> productId;
        cout << "Enter Product Name: ";
        cin.ignore();
        getline(cin, name);
        cout << "Enter Price: ";
        cin >> price;
        cout << "Enter Quantity: ";
        cin >> quantity;
    }

    void displayDetails() const {
        cout << productId << "\t" 
             << name << "\t\t" 
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

    string getName() const {
        return name;
    }

    int getQuantity() const {
        return quantity;
    }
};

// ==================== Part B: Function Overloading ====================
// Overload 1: Integer quantity
double reorderCost(int qty, double unitPrice) {
    return qty * unitPrice;
}

// Overload 2: Fractional quantity (by weight)
double reorderCost(double qty, double unitPrice) {
    return qty * unitPrice;
}

// Overload 3: Quantity with tax rate
double reorderCost(int qty, double unitPrice, double taxRate) {
    double base = qty * unitPrice;
    return base + (base * (taxRate / 100.0));
}

// Function with default argument (10% discount default)
double applyDiscount(double price, double discountPercent = 10.0) {
    return price - (price * (discountPercent / 100.0));
}

int main() {
    // --- Part A Demo ---
    const int SIZE = 5;
    Product inventory[SIZE];

    cout << "=== Enter Details for 5 Products ===" << endl;
    for (int i = 0; i < SIZE; i++) {
        cout << "\n--- Product " << (i + 1) << " ---" << endl;
        inventory[i].acceptDetails();
    }

    cout << "\n===== INVENTORY REPORT =====" << endl;
    cout << "ID\tName\t\tPrice\tQty\tTotal Value" << endl;
    cout << "--------------------------------------------------------" << endl;
    for (int i = 0; i < SIZE; i++) {
        inventory[i].displayDetails();
    }

    // Find highest value product
    int maxIdx = 0;
    for (int i = 1; i < SIZE; i++) {
        if (inventory[i].totalValue() > inventory[maxIdx].totalValue()) {
            maxIdx = i;
        }
    }
    cout << "\nHighest Value Product: " << inventory[maxIdx].getName() 
         << " (Rs. " << inventory[maxIdx].totalValue() << ")" << endl;

    // Filter low stock
    int threshold;
    cout << "\nEnter low-stock threshold: ";
    cin >> threshold;
    cout << "Low Stock (threshold: " << threshold << "): ";
    bool foundLow = false;
    for (int i = 0; i < SIZE; i++) {
        if (inventory[i].isLowStock(threshold)) {
            cout << inventory[i].getName() << " (Qty: " << inventory[i].getQuantity() << ") ";
            foundLow = true;
        }
    }
    if (!foundLow) cout << "None";
    cout << "\n" << endl;

    // --- Part B Demo ---
    cout << "===== REORDER COST & DISCOUNT DEMO =====" << endl;
    cout << "Reorder (int qty: 50, price: 100): Rs. " 
         << reorderCost(50, 100.0) << endl;
    cout << "Reorder (double qty: 12.5 kg, price: 40): Rs. " 
         << reorderCost(12.5, 40.0) << endl;
    cout << "Reorder with 18% Tax (qty: 50, price: 100): Rs. " 
         << reorderCost(50, 100.0, 18.0) << endl;
    cout << "Price 500 with default 10% discount: Rs. " 
         << applyDiscount(500.0) << endl;
    cout << "Price 500 with custom 25% discount: Rs. " 
         << applyDiscount(500.0, 25.0) << endl;

    return 0;
}