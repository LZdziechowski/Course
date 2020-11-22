package com.kodilla.exception.nullpointer;

public class MessageSender {

    public void sendMessageTo(User user, String message) throws MessageNotSentEException{
        if (user != null) {
            System.out.println("Sending message: " + message + " to " + user);
        } else {
            throw new MessageNotSentEException("Object User was null");
        }
    }
}
