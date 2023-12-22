package com.example.mailboxthymeleaf.service;

import com.example.mailboxthymeleaf.model.MailBox;
import com.example.mailboxthymeleaf.repository.IMailBoxRepository;
import com.example.mailboxthymeleaf.repository.MailBoxRepository;

import java.util.List;

public class MailBoxService implements IMailBoxService{
    private final IMailBoxRepository mailBoxRepository = new MailBoxRepository();
    @Override
    public MailBox getMailBox() {
        return mailBoxRepository.getMailBox();
    }

    @Override
    public List<String> getLanguage() {
        return mailBoxRepository.getLanguage();
    }

    @Override
    public List<Integer> getPageSize() {
        return mailBoxRepository.getPageSize();
    }
}
