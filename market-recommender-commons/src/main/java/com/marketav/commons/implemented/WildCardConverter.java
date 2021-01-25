package com.marketav.commons.implemented;

public class WildCardConverter {
    private final String append;

    public WildCardConverter(String append) {
        this.append = append;
    }

    public String convertToWildCard(String data) {
        return append + data + append;
    }
}
