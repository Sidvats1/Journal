package com.Journalingo.Journal.Controller;

import com.Journalingo.Journal.entity.JournalEntryEntity;
import com.Journalingo.Journal.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

	@Autowired
	private JournalEntryService journalEntryService;

	@GetMapping
	public List<JournalEntryEntity> getAll(){
		return journalEntryService.getAll();
	}

	@PostMapping
	public boolean createEntry(@RequestBody JournalEntryEntity myEntry) {
		myEntry.setDate(LocalDateTime.now());
		journalEntryService.save(myEntry);
		return true;
	}
	@GetMapping("id/{myId}")
	public JournalEntryEntity getJournalEntryById(@PathVariable ObjectId myId){
		return journalEntryService.finaById(myId).orElse(null);
	}
	@DeleteMapping("id/{myId}")
	public boolean deleteEntryById(@PathVariable ObjectId myId){
		journalEntryService.deleteById(myId);
		return true;
	}
	@PutMapping("id/{myId}")
	public JournalEntryEntity updateEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntryEntity newEntry){
		JournalEntryEntity oldId = journalEntryService.finaById(myId).orElse(null);
		if(oldId!=null){
			oldId.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldId.getTitle());
			oldId.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldId.getContent());
		}
		journalEntryService.save(oldId);
		return oldId;
	}
	
	
	
}
