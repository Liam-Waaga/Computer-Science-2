import java.math.BigInteger;

public class FibonacciNumbers extends SequenceGenerator {

    public FibonacciNumbers() {
        this.numCache.add(BigInteger.valueOf(0));
        this.numCache.add(BigInteger.valueOf(1));

    }

    public BigInteger next() {
        currentIndex++;
        if (numCache.size() == currentIndex) {
            this.numCache.add(this.numCache.get(currentIndex - 1).add(this.numCache.get(currentIndex - 2)));
        }
        return this.numCache.get(currentIndex);
    }

}