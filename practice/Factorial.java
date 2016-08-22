public class Factorial{
    void run(){
        Integer number = 10;
        Integer factorialValue = factorial(number);// factorialメソッドの呼び出し．
        System.out.printf("%d! = %d%n", number, factorialValue);
    }

    Integer factorial(Integer number){
        // numberの階乗を計算して返す．
        Integer result =1;
        for (Integer i= 1;i<=number ;i++ ) {
            result=result*i;
        }

           return result;
    }
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        factorial.run();
    }
}