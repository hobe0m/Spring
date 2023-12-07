package proxyex;

public class ImplCaculator implements Calculator{
    @Override
    public long factorial(long num) {
        long total = 1L;

        for(long i = 1L; i <= num; i++) {
            total *= i;
        }

        return total;
    }
}
