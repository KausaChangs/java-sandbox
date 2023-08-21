  @FunctionalInterface
        interface Ball{
            void hit();
        }


public class LambdaBall{
    public static void main(String[] args){
        Ball b = ()->{System.out.println("You hit it!");};

        b.hit();

      

    }
}