public class PrimeCheck{
    public static void main(String[] args){
        // 素数判定を行いたい数値（n）．
        Integer number = 133;
        Integer i ;
        for(i=2;i<=number;i++){    

            Boolean prime = true;  
            
            for (Integer count = 2; count<i; count++ ) {
                if (i%count ==0) {
                    prime=false;
                    break;
                }
                
            }



            // for文で繰り返す．
            // ・カウンタの初期値はいくつにすれば良いでしょうか．
            // ・カウンタの加算はいくつにすれば良いでしょうか．
            // iでnが割り切れるか判定する．
     
            if(prime){ // primeの値がtrueの場合．
                System.out.printf(" %d ,", i);
            }
            
        }
                System.out.println("");
    }
}