#include<iostream>
//#include<iomanip>
using namespace std;

int main(){

    int n;
    cout<<"Enter readings between 1 & 100";
    cin>> n;

    //if user lacks common sense or cant read basic instructions

    if(n<1 || n>100){
        cout<<"You lack reading and cognitive skills. You entered a number that is not between 1 & 100" <<endl;
        return 0;
    }

    double temp_vals[100];
    for (int i=0; i<n;i++){
        cin>>temp_vals[i];
    }
    cout<< "Readings entered: " << n << endl;
    cout<< "Valid readings: ";

    //2nd requirement -- Print all valid readings — skip values below 0 (sensor error) using continue

    int error_cnt = 0;
    for(int i=0;i<n;i++)
    {
        if(temp_vals[i] < 0){
            error_cnt++;
            continue;
        }
        cout<< temp_vals[i]<<" ";
    }

    cout<<"Skipped (errors): "<< error_cnt << endl;
    
    //Scan for the first reading at or above 45°C — print its index and stop scanning using break

    bool frst_crit = false;
    for (int i=0; i<n; i++){
        if(temp_vals[i]>= 45.0){
            cout<<"First Critical: " << "Index" <<i << "->" << temp_vals[i]<<endl;
            frst_crit =true;
            break;
        }
        if(!frst_crit){
            cout << "First CRITICAL   : None" << endl;
        }
    }

    //Compute min, max, and average in one single loop pass
    double min =0, max=0, sum=0;
    int normal =0, warning =0, critical =0, shutdown = 0;

    int eval=0;

    for(int i=0; i<n; i++){
        if (temp_vals[i] < 0.0) continue; // Only process valid readings
        if (eval == 0) {
        min = temp_vals[i];
        max = temp_vals[i];
        }
        else{
        if (temp_vals[i] < min) min = temp_vals[i];
        if (temp_vals[i] > max) max = temp_vals[i];
        }
        sum+= temp_vals[i];
        eval++;

        if (temp_vals[i] <= 29.0) normal++;
        else if (temp_vals[i] <= 44.0) warning++;
        else if (temp_vals[i] <= 59.0) critical++;
        else shutdown++;
    }

    if(eval>0){
        double avg = sum/eval;
        cout << "Min: " << min << " C  Max: " << max << " C  Avg: " << avg << " C" << endl;
    }
    
    cout << "Normal: " << normal 
         << "  Warning: " << warning
         << "  Critical: " << critical
         << "  Shutdown: " << shutdown << endl;

    return 0;
}


