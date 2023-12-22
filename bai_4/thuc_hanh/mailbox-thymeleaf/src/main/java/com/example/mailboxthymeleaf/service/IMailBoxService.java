package com.example.mailboxthymeleaf.service;

import com.example.mailboxthymeleaf.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    MailBox getMailBox();

    List<String> getLanguage();

    List<Integer> getPageSize();
}
