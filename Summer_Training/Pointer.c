#include<stdio.h>
#include<math.h>
void kthCustomFibo(){
  int k,first,second;
  printf("Enter values k ,first ,second : ");
  scanf("%d %d %d",&k,&first,&second);
  if((k<1 || k>10)|| (first<1 || first>100) || (second<1 || second>100)){
    printf("Entered value is not in range");
    return;
  }
  int fib[k+2];
  fib[0]=first;
  fib[1]=second;
  for(int i=2;i<k+2;i++){
    int sum=first+second;
    fib[i]=sum;
    first=second;
    second=sum;
  }
  for(int i=0;i<k+2;i++){
    printf("%d,",fib[i]);
  }
}
int checkNumber(int x){
  int a=x,b=x,digit=0,sum=0;
  while(a!=0){
    int lbit=a%10;
    digit++;
    a /=10;
  }
  while(b!=0){
    int lsb=b%10;
    sum=sum+pow(lsb,digit);
    b=b/10;
  }
  return sum;
}
// void armstrongNumber(){
//   int si,ei;
//   printf("Enter range si ,ei : "); // this
//   scanf("%d%d",&si,&ei);
//   for(int i=si;i<=ei;i++){
//     int no=checkNumber(i);
//     if(no==i){
//       printf("%d,",no);
//     }
//   }
// }

// void armStrong(){
//   int si,ei,x,sum;
//   printf("Enter a range : ");
//   scanf("%d%d",si,ei);
//   for(int i=si;i<=ei;i++){
//     x=i,sum=0;
//     while(x!=0 && x<999){
//       int lsb=x%10;
//       sum +=lsb*lsb*lsb;
//       x /=10;
//     }
//     while(x!=0 && x>999){
//         x=i,sum=0;
//         int lsb=x%10;
//         sum +=lsb*lsb*lsb*lsb;
//         x /=10;
//     }
//     if(sum==i){
//       printf("%d,",i);
//     }
//   }
// }

void fibo(){
  int k,f,s;
  scanf("%d%d%d",&k,&f,&s);
  printf("%d,%d",f,s);
  for(int i=0;i<k;i++){
    int sum=f+s;
    printf(",%d",sum);
    f=s;
    s=sum;
  }
}
int main(void){
  // int n=-10;
  // char *x="abcd";
  // printf("\nLength of no : %d",printf("%d",abs(n)));
  // printf("\n");
  // printf("\nLength of string : %d",printf("%s",x));
  // char a[6][5]={"byt","BYTE","BYTEX"};
  // printf("%d",sizeof(a+8));
  // printf("\nOK");
  // char c[10];
  // printf("Enter string : ");
  // scanf("%s",c);
  // printf("%s",c);
  //kthCustomFibo();
   //armstrongNumber();
  //int n=pow(2,5);
  // int a=3456,digit=0;
  //  while(a!=0){
  //   int lbit=a%10;s
  //   digit++;
  //   a /=10;
  // }
  // printf("%d",digit);
  // armStrong();
  fibo();
  return 0;
}