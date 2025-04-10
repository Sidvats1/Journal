package com.Journalingo.Journal.service;

import com.Journalingo.Journal.entity.JournalEntryEntity;
import com.Journalingo.Journal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    //since this is interface spring will generate a implementation and inject in this in runtime

    public void save(JournalEntryEntity journalEntryEntity){
        journalEntryRepository.save(journalEntryEntity);
    }
    public List<JournalEntryEntity> getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntryEntity> finaById(ObjectId id){
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }

}