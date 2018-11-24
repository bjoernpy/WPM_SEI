package de.fh.albsig._86115;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * @author bjoern
 *
 */
public class WeatherFormatter {
    /**
     *
     */
    private static final Logger LOG = LogManager
            .getLogger(WeatherFormatter.class);

    /**
     * @param weather input
     * @return the formated output
     */
    public final String format(final Weather weather) {
        LOG.info("Formatting Weather Data");
        Reader reader = new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("output.vm"));
        VelocityContext context = new VelocityContext();
        context.put("weather", weather);
        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "", reader);
        return writer.toString();
    }
}
