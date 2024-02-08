package bot;

import static bot.Quotes.*;

public class ReportGenerator {
    private ReportGenerator() {}

    public static String generate(Quotes quotes) {
        StringBuilder builder = new StringBuilder("Курс валют на ")
        .append(quotes.timestamp().split("T")[0].replace("-", "."))
        .append(System.lineSeparator())
        .append(generateCurrencyStr(quotes.usdEurCny().USD()))
        .append(generateCurrencyStr(quotes.usdEurCny().EUR()))
        .append(generateCurrencyStr(quotes.usdEurCny().CNY()));
        return builder.toString();
    }

    private static String generateCurrencyStr(Currency currency) {
        return currency.name() + " (" + currency.charCode() + "/RUB): " + currency.value() +
                " " + calculateDayIncrease(currency) + System.lineSeparator();
    }

    private static String calculateDayIncrease(Currency currency) {
        double increase = (double) Math.round(((currency.value() * 100 / currency.previousValue()) - 100) * 100) / 100;
        if (increase >= 0) {
            return "+" + increase + "%";
        }
        return increase + "%";
    }
}
