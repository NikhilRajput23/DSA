class Solution {
    public int[] getNoZeroIntegers(int n) {
        int arr[]=new int[2];
        for(int i=1;i<n;i++){
            int not=0;
            int a=i;
            int b=n-i;
            if(a+b==n){
                while(a!=0){
             if(a%10==0){
              not=1;
                    }
                    a/=10;
                }
                a=i;
                while(b!=0){
                    if(b%10==0){
                        not=1;
                    }
                    b/=10;
                }
                b=n-i;
                if(not==0){
                    arr[0]=a;
                    arr[1]=b;
                }
            }
        }
        return arr;
    }
}