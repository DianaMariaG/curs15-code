package ro.fasttrackit.curs15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuoteService {
    private final List<Quote> quotes = new ArrayList<>();

    public QuoteService(Collection<Quote> quotes) {
        if (quotes != null) {
            this.quotes.addAll(quotes);
        }
    }

    public List<String> getAllQuotes() {
        List<String> result = new ArrayList<>();
        for (Quote quote : quotes) {
            result.add(quote.quote());
        }
        return result;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.author().equals(author)) {
                result.add(quote);
            }
        }
        return result;
    }
}
