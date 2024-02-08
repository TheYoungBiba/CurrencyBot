package bot;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;

public class JSONGetter implements Getter {
    private final URL url;

    public JSONGetter(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONGetter(URL url) {
        this.url = url;
    }

    @Override
    public Quotes get() throws IOException {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setDateFormat(DateFormat.getDateInstance())
                .readValue(url, Quotes.class);
    }
}
