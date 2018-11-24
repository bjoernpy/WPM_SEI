package de.fh.albsig._86115;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

/**
 * @author bjoern
 *
 */
public class XMLParser {
    /**
     *
     */
    private static Logger log = LogManager.getLogger(XMLParser.class);

    /**
     * @param inputStream the weather Data
     * @return a Weather Element
     * @throws Exception because of inputStream or something like that
     */
    public final Weather parse(final InputStream inputStream) throws Exception {
        Weather weather = new Weather();
        log.info("Creating XML Reader");
        SAXReader xmlReader = createXmlReader();
        Document doc = xmlReader.read(inputStream);
        log.info("Parsing XML Response");
        weather.setCity(doc.valueOf("/root/location/name"));
        weather.setRegion(doc.valueOf("/root/location/region"));
        weather.setCountry(doc.valueOf("/root/location/country"));
        weather.setTemp(doc.valueOf("/root/current/temp_c"));
        weather.setCondition(doc.valueOf("/root/current/condition/text"));
        weather.setWindSpeed(doc.valueOf("/root/current/wind_kph"));
        weather.setHumidity(doc.valueOf("/root/current/humidity"));
        weather.setLastUpdated(doc.valueOf("/root/current/last_updated"));

        return weather;
    }

    /**
     * @return the XMLReader
     */
    private SAXReader createXmlReader() {
        Map<String, String> uris = new HashMap<>();
        uris.put("y", "http://api.apixu.com/v1/current.xml");
        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs(uris);
        SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);
        return xmlReader;
    }
}
