package girgin.ramazan.leekcode.problem347;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TopKFrequentElementCalculatorTest {

    private final TopKFrequentElementCalculator topKFrequentElementCalculator = new TopKFrequentElementCalculator();

    @Test
    public void shouldCalculateTop2() {
        //given
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        //when
        List<Integer> topK = topKFrequentElementCalculator.calculate(nums, k);

        //then
        assertThat(topK).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    public void shouldCalculateWhenInputLengthIsOne() {
        //given
        int[] nums = {1};
        int k = 1;

        //when
        List<Integer> topK = topKFrequentElementCalculator.calculate(nums, k);

        //then
        assertThat(topK).containsExactlyInAnyOrder(1);
    }
}