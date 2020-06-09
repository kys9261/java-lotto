package step2.domain.enums;

import java.util.function.Function;

public enum WinCountPriceEnum {
    MATCH_3(count -> count * 5000, "3개 일치 (5000원) - "),
    MATCH_4(count -> count * 50000, "4개 일치 (50000원) - "),
    MATCH_5(count -> count * 1500000, "5개 일치 (1500000원) - "),
    MATCH_6(count -> count * 2000000000, "6개 일치 (2000000000원) - ");

    private Function<Integer, Integer> expression;
    private String resultGuide;

    WinCountPriceEnum(Function<Integer, Integer> expression, String resultGuide) {
        this.expression = expression;
        this.resultGuide = resultGuide;
    }

    public int calculate(int count) {
        return expression.apply(count);
    }

    public String getResultGuide() {
        return resultGuide;
    }
}
