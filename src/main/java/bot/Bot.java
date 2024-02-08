package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        try {
            message.setText(ReportGenerator.generate(new CbrXmlDailyGetter().get()));
            this.execute(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "sk_currency_bot";
    }

    @Override
    public String getBotToken() {
        return System.getenv("APP_TELGRAM_TOKEN");
    }
}
