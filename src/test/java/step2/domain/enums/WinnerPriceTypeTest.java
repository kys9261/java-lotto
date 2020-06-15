package step2.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("우승상금 Enum 테스트")
class WinnerPriceTypeTest {

    @DisplayName("우승상금 계산하기")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"3:15000", "5:25000"})
    void calculatePrice(int winCount, int price) {
        assertThat(WinnerPriceType.MATCH_3.calculateulatePrice(winCount)).isEqualTo(price);
    }
}