import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomNumber {

    private final RandomIntGenerator randomIntGenerator;

    @Autowired
    public RandomNumber(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    public int getRandom() {
        return randomIntGenerator.getNextRandom();
    }
}
