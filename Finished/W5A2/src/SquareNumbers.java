import java.math.BigInteger;

public class SquareNumbers extends SequenceGenerator {

    private BigInteger nextToAdd = BigInteger.valueOf(3);

    public SquareNumbers() {
        this.numCache.add(BigInteger.valueOf(0));
        this.numCache.add(BigInteger.valueOf(1));
    }

    public BigInteger next() {
        currentIndex++;
        if (numCache.size() == currentIndex) {
            this.numCache.add(this.numCache.get(currentIndex - 1).add(nextToAdd));
            nextToAdd = nextToAdd.add(BigInteger.valueOf(2));
        }
        return this.numCache.get(currentIndex);
    }
}