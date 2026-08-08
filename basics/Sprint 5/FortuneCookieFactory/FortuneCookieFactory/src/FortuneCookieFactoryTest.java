import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class FortuneCookieFactoryTest {

    private static FortuneCookieFactory fortuneCookieFactory;

    @BeforeEach
    public void beforeEach() {
        FortuneConfig fortuneConfig = new FortuneConfig(true);
        ArrayList<String> positive = new ArrayList<>(List.of("хорошо", "супер", "класс"));
        ArrayList<String> negative = new ArrayList<>(List.of("плохо", "ужасно", "грустно"));
        fortuneCookieFactory = new FortuneCookieFactory(fortuneConfig, positive, negative);
        fortuneCookieFactory.bakeFortuneCookie();
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        assertEquals(1, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        fortuneCookieFactory.bakeFortuneCookie();
        assertEquals(2, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        fortuneCookieFactory.resetCookiesCreated();
        assertEquals(0, fortuneCookieFactory.getCookiesBaked());
    }
}