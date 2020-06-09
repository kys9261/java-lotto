package step2.domain;

import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;
    private int[] winCount;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.winCount = new int[]{0, 0, 0, 0};
    }

    public void generateLotto() {
        lottoList.forEach(lotto -> {
            lotto.generateNumber();
        });
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int[] getWinCount(List<String> winningNumbers) {
        lottoList.forEach(lotto -> {
            int count = lotto.getMatchCount(winningNumbers);
            if (count > 2)
                winCount[count - 3]++;
        });
        return winCount;
    }
}
