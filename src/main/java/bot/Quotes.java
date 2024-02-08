package bot;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Quotes(
        @JsonProperty("Date")
        String date,
        @JsonProperty("PreviousDate")
        String previousDate,
        @JsonProperty("PreviousURL")
        String previousURL,
        @JsonProperty("Timestamp")
        String timestamp,
        @JsonProperty("Valute")
        UsdEurCny usdEurCny
) {
        record UsdEurCny(Currency USD, Currency EUR, Currency CNY) {}

        record Currency(
                @JsonProperty("CharCode")
                String charCode,
                @JsonProperty("Name")
                String name,
                @JsonProperty("Value")
                double value,
                @JsonProperty("Previous")
                double previousValue
        ) {}
}
