package animal;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

@Mock
Feline feline;

@Test
    public void getFoodTest() throws Exception {
    Lion lion = new Lion("Самец", feline);
    lion.getFood();Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");


}

    @Test
    public void getKittenTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(5);
        int actualKittens = lion.getKittens();
        Assert.assertEquals(5, actualKittens);
    }

    @Test (expected = java.lang.Exception.class)
    public void invalidSexLion () throws Exception {
    Lion lion = new Lion("Неопределено", feline);
    lion.doesHaveMane();

    }
}
