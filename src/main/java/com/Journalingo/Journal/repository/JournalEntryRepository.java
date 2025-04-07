package com.Journalingo.Journal.repository;

import com.Journalingo.Journal.entity.JournalEntryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntryEntity, String>{
}
