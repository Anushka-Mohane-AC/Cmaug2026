#include <iostream>
#include <string>

using namespace std;

class Employee {
private:
    int empId;
    string name;
    string department;
    char grade;
    double basicSalary;
    bool isActive;

    static int employeeCount;

public:
    Employee() {
        employeeCount++;
        empId = 1000 + employeeCount;
        name = "Unknown";
        department = "Engineering";
        grade = 'D';
        basicSalary = 15000.0;
        isActive = true;
    }

    void setName(const string& n) {
        if (!n.empty()) {
            name = n;
        } else {
            cout << "ERROR: Name cannot be empty." << endl;
        }
    }

    void setDepartment(const string& dept) {
        if (dept == "Engineering" || dept == "HR" || dept == "Finance" || dept == "Operations") {
            department = dept;
        } else {
            cout << "ERROR: '" << dept << "' is not a registered department." << endl;
        }
    }

    void setGrade(char g) {
        if (g == 'A' || g == 'B' || g == 'C' || g == 'D') {
            grade = g;
        } else {
            cout << "ERROR: Invalid grade '" << g << "'. Accepted values: A, B, C, D." << endl;
        }
    }

    void setBasicSalary(double salary) {
        if (salary > 10000.0 && salary < 500000.0) {
            basicSalary = salary;
        } else {
            cout << "ERROR: Salary must be between Rs.10,000 and Rs.5,00,000. Value rejected." << endl;
        }
    }

    void deactivate() {
        isActive = false;
    }

    int getEmpId() const { return empId; }
    string getName() const { return name; }
    string getDepartment() const { return department; }
    char getGrade() const { return grade; }
    double getBasicSalary() const { return basicSalary; }
    bool getIsActive() const { return isActive; }

    double computeAllowances() const {
        if (grade == 'A') return 0.40 * basicSalary;
        if (grade == 'B') return 0.30 * basicSalary;
        if (grade == 'C') return 0.20 * basicSalary;
        return 0.10 * basicSalary;
    }

    double computeGrossSalary() const {
        return basicSalary + computeAllowances();
    }

    double computeTax() const {
        double gross = computeGrossSalary();
        if (gross <= 50000.0) return 0.0;
        if (gross <= 100000.0) return 0.10 * (gross - 50000.0);
        return 5000.0 + (0.20 * (gross - 100000.0));
    }

    double computeNetSalary() const {
        return computeGrossSalary() - computeTax();
    }

    void printPayslip() const {
        cout << "\n==============================================" << endl;
        cout << "               EMPLOYEE PAYSLIP               " << endl;
        cout << "                   AUG 2026                   " << endl;
        cout << "==============================================" << endl;
        cout << "Emp ID          : " << empId << endl;
        cout << "Name            : " << name << endl;
        cout << "Department      : " << department << endl;
        cout << "Grade           : " << grade << endl;
        cout << "Status          : " << (isActive ? "Active" : "Inactive") << endl;
        cout << "Basic Salary    : Rs. " << basicSalary << endl;
        cout << "Allowances      : Rs. " << computeAllowances() << endl;
        cout << "Gross Salary    : Rs. " << computeGrossSalary() << endl;
        cout << "Tax Deduction   : Rs. " << computeTax() << endl;
        cout << "Net Salary      : Rs. " << computeNetSalary() << endl;
        cout << "==============================================" << endl;
    }

    static int getEmployeeCount() {
        return employeeCount;
    }

    void acceptDetails() {
        string inName, inDept;
        char inGrade;
        double inSalary;

        cout << "\nEnter Employee Details:" << endl;
        cout << "Enter name: ";
        cin.ignore();
        getline(cin, inName);
        setName(inName);

        cout << "Enter department: ";
        cin >> inDept;
        setDepartment(inDept);

        cout << "Enter grade (A/B/C/D): ";
        cin >> inGrade;
        setGrade(inGrade);

        cout << "Enter basic salary: ";
        cin >> inSalary;
        setBasicSalary(inSalary);
    }
};


int Employee::employeeCount = 0;

int main() {
    Employee e1;
    Employee* e2 = new Employee();
    Employee* e3 = new Employee();

    e1.acceptDetails();
    e2->acceptDetails();
    e3->acceptDetails();

    

    e1.printPayslip();
    e2->printPayslip();
    e3->printPayslip();

   
    e3->deactivate();
    if (!e3->getIsActive()) {
        cout << "\n" << e3->getName() << " is no longer active. Payroll skipped." << endl;
    }

    cout << "Total Employees : " << Employee::getEmployeeCount() << endl;

    delete e2;
    delete e3;
    return 0;
}