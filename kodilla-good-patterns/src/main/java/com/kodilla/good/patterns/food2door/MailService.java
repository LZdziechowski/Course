package com.kodilla.good.patterns.food2door;

public class MailService implements InformationService {
    @Override
    public boolean inform(Supplier supplier) {
        System.out.println("Mail send.");
        return true;
    }
}
