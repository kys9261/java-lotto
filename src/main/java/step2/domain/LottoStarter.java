package step2.domain;

import step2.domain.strategy.ProdLottoGenStrategy;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoStarter {
    public static void main(String[] args) {
        InputView input = new InputView();
        int lottoAmount = input.getLottoAmount();

        LottoGenerator lottoGenerator = new LottoGenerator(lottoAmount, new ProdLottoGenStrategy());
        lottoGenerator.generate();

        ResultView resultView = new ResultView();
        resultView.showLottos(lottoGenerator.getLottos());

        resultView.showWinResult(lottoAmount, lottoGenerator.getLottoWinCount(input.getWinningNumbers()));
    }
}
