#include<iostream>
//#include<iomanip>
using namespace std;

int main(){
    double tempC;
    cout<< "Enter sensor temp in Celsius: ";
    cin>> tempC;

    int statuscode;
    if(tempC<0){
        statuscode = -1;
    }
    else if(tempC<=29){
        statuscode = 0;
    }
    else if(tempC<=44){
        statuscode = 1;
    }
    else if(tempC<=59){
        statuscode = 2;
    }
    else{
        statuscode = 3;
    }

    double f= (tempC * 9 / 5) + 32;

    string relative = (tempC>25) ? "Above Average" : "Below Average";

    cout << "Temperature : " << tempC << "°C / " << f << "°F" << endl;

    
    switch(statuscode)
    {
        case -1: cout<<"Status: Sensor_Error"<<endl; cout<<"Action: Sensor fault — check wiring"<<endl;
        case 0: cout<<"Status: NORMAL"<<endl; cout<<"Action: No action required"<<endl;
        case 1: cout<<"Status: WARNING"<<endl; cout<<"Action: Alert sent to supervisor"<<endl;
        case 2: cout<<"Status: CRITICAL "<<endl; cout<<"Action: Cooling system triggered"<<endl;
        case 3: cout<<"Status: SHUTDOWN"<<endl; cout<<"Action: Emergency shutdown"<<endl;
        
    }
    cout << "Reading: " << relative << endl;
    return 0;
}


