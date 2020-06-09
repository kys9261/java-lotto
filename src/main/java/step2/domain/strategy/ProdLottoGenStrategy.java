package step2.domain.strategy;

import java.util.Random;

public class ProdLottoGenStrategy implements LottoGenStrategy {
    private Random random = new Random();

    @Override
    public int getLottoNumber() {
        return random.nextInt(44) + 1;
    }
}
