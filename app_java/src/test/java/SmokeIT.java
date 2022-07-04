import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SmokeIT {

    private final ZoneId moscowZone = ZoneId.of("Europe/Moscow");
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver()
                .setup();
    }

    @AfterClass
    public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testApp() {
        driver.get("http://localhost:8080/");
        By pathOfTitle = By.xpath("//*/*[contains(text(),'Moscow')]");
        WebElement h2TitleMessage = new WebDriverWait(driver, Duration.ofMinutes(5))
                .pollingEvery(Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(pathOfTitle));
        String text = h2TitleMessage.getText();
        LocalDateTime parsedDate = LocalDateTime.from(getParsedValue(text));
        assertThat(parsedDate.isBefore(LocalDateTime.now(moscowZone)), is(true));
    }

    private TemporalAccessor getParsedValue(String text) {
        try {
            String date = text.replaceAll("^(\\D)*", "");
            return DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm 'hr'")
                    .withZone(moscowZone)
                    .parse(date);
        } catch (DateTimeParseException exception) {
            throw new AssertionError("The string doesn't satisfies the pattern");
        }
    }
}