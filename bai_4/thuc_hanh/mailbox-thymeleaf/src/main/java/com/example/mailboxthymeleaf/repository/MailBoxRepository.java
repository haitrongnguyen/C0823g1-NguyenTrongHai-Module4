package com.example.mailboxthymeleaf.repository;

import com.example.mailboxthymeleaf.model.MailBox;

import java.util.ArrayList;
import java.util.List;

public class MailBoxRepository implements IMailBoxRepository{
    private static final MailBox mailBox = new MailBox("Vietnamese",10,false,"Hai");
    private static final List<String> languageList;
    private static final List<Integer> pageSizeList;
    static {
        languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(20);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }
    @Override
    public MailBox getMailBox() {
        return mailBox;
    }

    @Override
    public List<String> getLanguage() {
        return languageList;
    }

    @Override
    public List<Integer> getPageSize() {
        return pageSizeList;
    }
}
