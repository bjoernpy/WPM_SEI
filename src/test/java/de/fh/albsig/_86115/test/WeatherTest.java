/**
 *
 */
package de.fh.albsig._86115.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import de.fh.albsig._86115.Weather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author bjoern
 *
 */
public class WeatherTest {

    private static Logger log = LogManager.getLogger(WeatherTest.class);
    @Mock
    private Weather testWeather;

    @BeforeEach
    void init() {
        log.info("=====BeforeEach");
        testWeather = Mockito.mock(Weather.class);
    }

    @Test
    void testCountry() {
        log.info("=====Start Test 1");
        Mockito.when(testWeather.getCountry()).thenReturn("Germany");
        assertEquals("Germany", testWeather.getCountry());
        log.info("=====End Test 1");
    }

    @Test
    void testCondition() {
        log.info("=====Start Test 2");
        Mockito.when(testWeather.getCondition()).thenReturn("Mist");
        assertEquals("Mist", testWeather.getCondition());
        log.info("=====End Test 2");
    }

    @Test
    void testRegion() {
        log.info("=====Start Test 3");
        Mockito.when(testWeather.getRegion()).thenReturn("Bayern");
        assertEquals("Bayern", testWeather.getRegion());
        log.info("=====End Test 3");
    }

    @Test
    void testTemp() {
        log.info("=====Start Test 4");
        Mockito.when(testWeather.getTemp()).thenReturn("4");
        assertEquals("4", testWeather.getTemp());
        log.info("=====End Test 4");
    }

    @Test
    void testNoValue() {
        log.info("=====Start Test 5");
        assertEquals(null, testWeather.getCity());
        log.info("=====End Test 5");
    }

    @AfterEach
    void tearDown() {
        log.info("=====AfterEach");
        testWeather = null;
    }
}
