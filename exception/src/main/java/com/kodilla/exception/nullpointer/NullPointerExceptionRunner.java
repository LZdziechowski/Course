package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {

        final User user = null;
        final MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello.");
        } catch (MessageNotSentEException e) {
            System.out.println("Message not send, but my program still running.");
        }

        System.out.println("Processing other logic.");
    }
}
