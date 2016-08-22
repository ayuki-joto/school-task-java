public class Factorial2{
    void run(){
        Integer number = 4;
        Integer factorialValue = 
            this.factorial(number);
        System.out.printf(
            "%d! = %d%n", number, factorialValue
        );
    }
    Integer factorial(Integer value){
        if(value == 1){
            return 1;
        }
        return value * this.factorial(value - 1);
    }
    public static void main(String[] args) {
        Factorial2 fact= new Factorial2();
        fact.run();
    }
}