class Solution {
    public int romanToInt(String s) {
       int a=0; int b=0; 
       for(int i=s.length()-1;i>=0;i--){
        switch(s.charAt(i)){
           case'I':
           b=1;
           break;
           case 'V':
           b=5;
           break;
           case 'X':
           b=10;
           break;
           case 'L':
           b=50;
           break;
           case 'C':
           b=100;
           break;
           case 'D':
           b=500;
           break;
           case 'M':
           b=1000;
           break;
        }
        if(4*b<a){
        a-=b;
         } else{
            a+=b;
         }
       }
         return a;
        
       }
    
    }
