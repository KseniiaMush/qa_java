package animal;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean expectedMane;

    public LionParamTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

        @Test
                public void hasManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualMane = lion.doesHaveMane();
            Assert.assertEquals(expectedMane, actualMane);

        }

}
