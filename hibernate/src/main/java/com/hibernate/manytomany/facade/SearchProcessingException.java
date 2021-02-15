package com.hibernate.manytomany.facade;

public class SearchProcessingException extends Exception {

    public static String ERR_EMPTY_PARAM = "Please enter your text to search";
    public static String ERR_NOT_FOUND = "Search phrase is missing";
    public static String ERR_GIVEN_IS_NULL = "Given is null";

    public SearchProcessingException(String message) {
        super(message);
    }
}
