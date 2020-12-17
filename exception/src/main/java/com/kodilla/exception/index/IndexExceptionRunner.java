package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {

    public static void main(String[] args) {

        final VideoCollector videoCollector = new VideoCollector();
        final List<String> collection = videoCollector.getCollections();

        if (collection.size() > 2) {
            final String movie = collection.get(0);
            System.out.println(movie);

            final String anotherMovie = collection.get(1);
            System.out.println(anotherMovie);
        }
    }
}
