import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class FortuneCookieControllerTest {

    private static FortuneCookieController goodFactoryController;
    private static FortuneCookieController badFactoryController;

    @BeforeAll
    public static void beforeAll() {
        FortuneConfig fortuneConfig = new FortuneConfig(true);
        ArrayList<String> positive = new ArrayList<>(List.of("хорошо", "супер", "класс"));
        ArrayList<String> negative = new ArrayList<>(List.of("плохо", "ужасно", "грустно"));
        FortuneCookieFactory fortuneCookieFactory = new FortuneCookieFactory(fortuneConfig, positive, negative);
        goodFactoryController = new FortuneCookieController(fortuneCookieFactory);
        badFactoryController = new FortuneCookieController(fortuneCookieFactory);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        assertEquals("хорошо", goodFactoryController.tellFortune().getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        assertEquals("плохо", goodFactoryController.tellFortune().getFortuneText());
    }
}