#include <stdio.h>
#include <iostream>
using namespace std;



struct node
{
    char ch;
    int i,j;
    node *next;
};

class linked_list
{
private:
    node *tail;
public:
    node *head;
    linked_list()
    {
        head = NULL;
        tail = NULL;
    }

    void add_node(char ch, int i, int j)
    {
        node *tmp = new node;
        tmp->ch = ch;
        tmp->i = i;
        tmp->j = j;
        tmp->next = NULL;

        if(head == NULL)
        {
            head = tmp;
            tail = tmp;
        }
        else
        {
            tail->next = tmp;
            tail = tail->next;
        }
    }
};

int main(void) 
{
    
	int rows, cols;
    scanf("%ld %ld",&rows, &cols);
    char all[rows][cols];
	linked_list notstars;
    notstars.add_node('o', -1, -1);
    // ios_base::sync_with_stdio (false);
    string temp;
    
    int os = 0;

    for(int i = 0; i < rows ; i++){
        cin >> temp;
        for(int j = 0; j < cols; j++){
            all[i][j] = temp[j];
            if (temp[j] == 'o'){
                notstars.add_node(temp[j], i, j);
                os++;
            }
        }
        //getchar();
       
    }
    int del = 1;
    
    node *perv = new node;
    node *t = new node;
    int c = 0;
    int i,j;
    while (del){
        del = 0;
        perv = notstars.head;
        for(t = notstars.head->next; t != NULL; t = t->next ){
            i = t->i;
            j = t->j;
            c = 0;
            try
            {
                if (i != 0 && all[i - 1][j] == '*')
                    c++;

                if (i != (rows - 1) && all[i + 1][j] == '*')
                    c++;

                if ((j != 0) && all[i][j-1] == '*')
                    c++;

                if ((j != cols - 1) && all[i][j+1] == '*')
                    c++;

                if (c > 1){ //all[i][j] != '*' && 
                    del = 1;
                    all[i][j] = '*';
                    perv->next = t->next;
                    os--;
                } else
                    perv = perv->next;
            }
            catch(const std::exception& e)
            {
                
            }
            
        }
        
        
    }
    cout << rows*cols - os << endl;
    

    
    return 0;
}
