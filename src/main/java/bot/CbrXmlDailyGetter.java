package bot;

import java.io.IOException;

public class CbrXmlDailyGetter implements Getter {
    private final String jsonUrl = "https://www.cbr-xml-daily.ru/daily_json.js";
    private final JSONGetter getter;

    public CbrXmlDailyGetter() {
        getter = new JSONGetter(jsonUrl);
    }

    @Override
    public Quotes get() throws IOException {
        return getter.get();
    }
}
