package step2.view;

import step2.domain.Lottos;
import step2.domain.enums.WinCountPriceEnum;

public class ResultView {

    public void showLottos(Lottos lottos) {
        lottos.getLottoList().forEach(lotto -> {
            String lottoNumberStr = String.join(", ", lotto.getLottoNumbers());
            System.out.println("[" + lottoNumberStr + "]");
        });
        System.out.println();
    }

    public void showWinResult(int lottoAmount, int[] lottoWinCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        int idx = 0;
        int totalPrice = 0;
        for (WinCountPriceEnum priceEnum : WinCountPriceEnum.values()) {
            System.out.println(priceEnum.getResultGuide() + lottoWinCount[idx]+"개");
            totalPrice += priceEnum.calculate(lottoWinCount[idx]);
            idx++;
        }
        System.out.println("총 수익률은 " + calcPriceRatio(lottoAmount, totalPrice) + "입니다.");
    }

    private String calcPriceRatio(int lottoAmount, int totalPrice) {
        return String.format("%.2f", (double) totalPrice / (double) (lottoAmount * 1000));
    }
}
