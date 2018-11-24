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

    private static final Logger LOG = LogManager.getLogger(WeatherTest.class);
    @Mock
    private Weather testWeather;

    @BeforeEach
    void init() {
        LOG.info("=====BeforeEach");
        testWeather = Mockito.mock(Weather.class);
    }

    @Test
    void testCountry() {
        LOG.info("=====Start Test 1");
        Mockito.when(testWeather.getCountry()).thenReturn("Germany");
        assertEquals("Germany", testWeather.getCountry());
        LOG.info("=====End Test 1");
    }

    @Test
    void testCondition() {
        LOG.info("=====Start Test 2");
        Mockito.when(testWeather.getCondition()).thenReturn("Mist");
        assertEquals("Mist", testWeather.getCondition());
        LOG.info("=====End Test 2");
    }

    @Test
    void testRegion() {
        LOG.info("=====Start Test 3");
        Mockito.when(testWeather.getRegion()).thenReturn("Bayern");
        assertEquals("Bayern", testWeather.getRegion());
        LOG.info("=====End Test 3");
    }

    @Test
    void testTemp() {
        LOG.info("=====Start Test 4");
        Mockito.when(testWeather.getTemp()).thenReturn("4");
        assertEquals("4", testWeather.getTemp());
        LOG.info("=====End Test 4");
    }

    @Test
    void testNoValue() {
        LOG.info("=====Start Test 5");
        assertEquals(null, testWeather.getCity());
        LOG.info("=====End Test 5");
    }

    @AfterEach
    void tearDown() {
        LOG.info("=====AfterEach");
        testWeather = null;
    }
}
