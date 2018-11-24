package de.fh.albsig._86115;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author bjoern
 *
 */
public class DataRetriever {
    /**
     *
     */
    private static final Logger LOG = LogManager.getLogger(DataRetriever.class);

    /**
     * @param city the city we want the weather data
     * @return the XML Stream with the weather data
     * @throws Exception because of URLConnection
     */
    public final InputStream retrieve(final String city) throws Exception {
        LOG.info("Retrieving Weather Data");
        String url = "http://api.apixu.com/v1/current.xml?"
                + "key=eb3ca015e1754086a4e12844182211&q=" + city;
        URLConnection conn = null;
        try {
            conn = new URL(url).openConnection();
        } catch (MalformedURLException e) {
            LOG.error("Bad URL. \n" + e.getMessage(), e);
        } catch (IOException e) {
            LOG.error("IO Exception while trying to retrieve weatherdata"
                    + e.getMessage(), e);
        }
        return conn.getInputStream();

    }
}
