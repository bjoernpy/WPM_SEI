package de.fh.albsig._86115;

import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author bjoern
 *
 */
public class Main {

    /**
     *
     */
    private static final Logger LOG = LogManager.getLogger(Main.class);
    /**
     *
     */
    private String city;

    /**
     * @param args the first arg is the city
     * @throws Exception has to be there
     */
    public static void main(final String[] args) {

        // Read city from command line
        // if no city is entered Albstadt is set as standard
        String city = "Albstadt";
        try {
            city = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            LOG.error("Kein Argument beim Aufruf der Main übergeben. "
                    + "Albstadt wird als Standard genommen. \n"
                    + e.getMessage(), e);
        } catch (Exception e) {
            LOG.error("Error beim Aufruf der Main. \n" + e.getMessage(), e);
            LOG.info(
                    "Fehler beim Aufruf der Main, für weitere Informationen siehe LOG");
            return;
        }
        // Start the program
        new Main(city).start();
    }

    /**
     * @param city the name of the city the weather want to be retrieved from
     */
    public Main(final String city) {
        this.city = city;
    }

    /**
     * @throws Exception has to be there
     */
    public final void start() {
        // Retrieve Data
        InputStream dataIn = null;
        try {
            dataIn = new DataRetriever().retrieve(city);
        } catch (Exception e) {
            LOG.error(
                    "Error while trying to retrieve data from the webservice. \n"
                            + e.getMessage(),
                    e);
        }
        // Parse Data
        Weather weather = null;
        try {
            weather = new XMLParser().parse(dataIn);
        } catch (Exception e) {
            LOG.error("Error while trying to parse the weather data xml. \n"
                    + e.getMessage() + e);
        }
        // Format (Print) Data
        LOG.info(new WeatherFormatter().format(weather));
    }
}
