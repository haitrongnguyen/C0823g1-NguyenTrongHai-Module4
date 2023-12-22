package com.example.mailboxthymeleaf.repository;

import com.example.mailboxthymeleaf.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {
    MailBox getMailBox();

    List<String> getLanguage();

    List<Integer> getPageSize();
}
