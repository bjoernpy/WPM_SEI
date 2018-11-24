package de.fh.albsig._86115.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import de.fh.albsig._86115.Weather;
import de.fh.albsig._86115.XMLParser;

public class XMLParserTest {

    @Test
    void testParser() throws Exception {
        InputStream muData = getClass().getClassLoader()
                .getResourceAsStream("munich-weather.xml");
        Weather weather = new XMLParser().parse(muData);
        assertEquals("München", weather.getCity());
        assertEquals("Bayern", weather.getRegion());
        assertEquals("Deutschland", weather.getCountry());
        assertEquals("2", weather.getTemp());
        assertEquals("Mist", weather.getCondition());
        assertEquals("15.1", weather.getWindSpeed());
        assertEquals("100", weather.getHumidity());
    }
}
