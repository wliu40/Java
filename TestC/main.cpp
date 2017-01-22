#include <iostream>

using namespace std;
void show(int *arr)
{
	//for (int i = 0; i < sizeof(arr)/sizeof(int); i++)
	cout<< "in the show function: "<< sizeof(arr) << endl;

}

int main()
{
	int arr[10] = {1,5,2,14,55,100,6,8};
	cout<<"in the main function: " << sizeof(arr) <<endl;
	show(arr);
}
