package step2.domain;

import step2.domain.strategy.LottoGenStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private int lottoAmount = 0;
    private Lottos lottos;
    private List<Integer> winCount;

    public LottoGenerator(int lottoAmount, LottoGenStrategy lottoGenStrategy) {
        this.lottoAmount = lottoAmount;
        this.lottos = new Lottos(Stream.generate(() -> new Lotto(lottoGenStrategy))
                .limit(lottoAmount)
                .collect(Collectors.toList()));
        this.winCount = new ArrayList<>();
    }

    public void generate() {
        lottos.generateLotto();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int[] getLottoWinCount(List<String> winningNumbers) {
         return lottos.getWinCount(winningNumbers);
    }
}
