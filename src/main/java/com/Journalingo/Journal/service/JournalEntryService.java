package com.Journalingo.Journal.service;

import com.Journalingo.Journal.entity.JournalEntryEntity;
import com.Journalingo.Journal.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    //since this is interface spring will generate a implementation and inject in this in runtime

    public void save(JournalEntryEntity journalEntryEntity){
        journalEntryRepository.save(journalEntryEntity);
    }
}