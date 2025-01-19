#include<stdio.h>
#include<stdlib.h>
typedef struct node{
  int val;
  struct node *next;
} ll;

ll *createNode(int val){
  ll *newNode=(ll*)malloc(sizeof(ll));
  newNode->next=NULL;
  newNode->val=val;
  return newNode;
}

//Insert at end
ll* insertAtEnd(ll *head,int val){
  ll *temp=head;
  if(temp==NULL){
    temp=createNode(val);
  }else{
    while(temp!=NULL){
      temp=temp->next;
    }
    temp->next=createNode(val);
  }
  return temp;
}

//Display a list
void display(ll *head){
  if(head==NULL){
    printf("List is empty ");
  }
  ll *temp=head;
  while(temp!=NULL){
    printf("%d ",temp->val);
    temp=temp->next;
  }
}
int main(void){
  ll *head=NULL;
  head=insertAtEnd(head,10);
  insertAtEnd(head,20);
  insertAtEnd(head,30);
  display(head);
}