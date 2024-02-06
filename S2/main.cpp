#include <iostream>
#include <queue>
using namespace std;

int main()
{
    int n ,k;
    cin>>n;
    cin>>k;
    int b;
    int a[n];
    queue<int> max;

    for (int i = 0; i < n; i++) {
            cin>>b;
            a[i]=b;
        }


        max.push(a[0]);
        for (int i=0;i<k-2;i++){
              if (max.back() < a[i + 1]) {
                    max.push(a[i + 1]);
                    max.pop();
                }
        }
        cout<<(max.back());
                cout<<(' ');


        int z=1,j=1;
        while (z <= n - k) {
            if (a[z-1] == max.back()) {
                max.push(a[z]);
                max.pop();

                 for (int i=z;j<k;i++){
                  if (max.back() < a[i + 1]) {
                        max.push(a[i + 1]);
                        max.pop();
                    }
                    j++;
                }
            }else{
                if (max.back() < a[z+k-1]) {
                    max.push(a[z+k-1]);
                    max.pop();

              }
            }
                cout<<(max.back());
                cout<<(' ');

                j=1;
                z++;




        }
    return 0;
}
