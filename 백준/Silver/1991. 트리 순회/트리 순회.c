#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    struct node* parent;
    struct node* left;
    struct node* right;
    char myname;
}node;

node* TreeArr[27];

node* add_node(char myname){
    node* Nnode = (node*)malloc(sizeof(node));
    Nnode->left = NULL;
    Nnode->right = NULL;
    Nnode->myname = myname;
    return Nnode;
}

void add(){
    char current;
    char left;
    char right;
    scanf("%c %c %c",&current,&left,&right);
    getchar();
    node* mynode;
    if(current == 'A') {
        mynode = add_node(current);
        TreeArr[current-'A'] = mynode;
    }
    else
        mynode = TreeArr[current-'A'];
    
    if(left != '.') {
        mynode->left = add_node(left);
        TreeArr[left-'A'] = mynode->left;
    }
    
    if(right != '.') {
        mynode->right = add_node(right);
        TreeArr[right-'A'] = mynode->right;
    }
}

void preorder(node* root){
    printf("%c",root->myname);
    if(root->left != NULL)
        preorder(root->left);
    if(root->right != NULL)
        preorder(root->right);
}

void inorder(node* root){
    if(root->left != NULL)
        inorder(root->left);
    printf("%c",root->myname);
    if(root->right != NULL)
        inorder(root->right);
}

void postorder(node* root){
    if(root->left != NULL)
        postorder(root->left);
    if(root->right != NULL)
        postorder(root->right);
    printf("%c",root->myname);
}

int main(){
    int TC; scanf("%d",&TC);
    getchar();
    while(TC--){
        add();
    }
    preorder(TreeArr[0]);
    printf("\n");
    inorder(TreeArr[0]);
    printf("\n");
    postorder(TreeArr[0]);
    printf("\n");
}