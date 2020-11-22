package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService{
    @Override
    public boolean inform(User user) {

        //mail send logic
        System.out.println("Mail sent.");
        //return true temporary
        return true;
    }
}
