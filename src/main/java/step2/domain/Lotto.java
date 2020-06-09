package step2.domain;

import step2.domain.strategy.LottoGenStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final int MAX_LOTTO_NUMBER_SIZE = 6;
    private List<String> lottoNumbers = new ArrayList<>();
    private LottoGenStrategy lottoGenStrategy;

    public Lotto(LottoGenStrategy lottoGenStrategy) {
        this.lottoGenStrategy = lottoGenStrategy;
    }

    public void generateNumber() {
        while (lottoNumbers.size() < MAX_LOTTO_NUMBER_SIZE) {
            String lottoNum = String.valueOf(lottoGenStrategy.getLottoNumber());

            if (!lottoNumbers.contains(lottoNum))
                lottoNumbers.add(lottoNum);
        }

        shuffleLottoNumber();
    }

    private void shuffleLottoNumber() {
        Collections.shuffle(lottoNumbers);
    }

    public List<String> getLottoNumbers() {
        return lottoNumbers.stream().map(String::valueOf).collect(Collectors.toList());
    }

    public int getMatchCount(List<String> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }
}
