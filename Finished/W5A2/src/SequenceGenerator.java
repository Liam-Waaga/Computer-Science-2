import java.math.BigInteger;
import java.util.ArrayList;

public abstract class SequenceGenerator {

    protected int currentIndex = -1;
    protected ArrayList<BigInteger> numCache = new ArrayList<BigInteger>();

    public abstract BigInteger next();

    public BigInteger previous() throws Exception {
        if (--currentIndex >= 0)
            return numCache.get(currentIndex);
        else
            throw new Exception("Can't get -1 index");
    }
    
    public BigInteger current() {
        return numCache.get(currentIndex);
    }
    
    public int index() {
        return currentIndex;
    }
}