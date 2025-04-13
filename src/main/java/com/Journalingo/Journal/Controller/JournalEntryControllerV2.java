package com.Journalingo.Journal.Controller;

import com.Journalingo.Journal.entity.JournalEntryEntity;
import com.Journalingo.Journal.service.JournalEntryService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

	@Autowired
	private JournalEntryService journalEntryService;

	@GetMapping
	public ResponseEntity<?> getAll(){
		List<JournalEntryEntity> all = journalEntryService.getAll();
		if(all!=null && !all.isEmpty()){
			return new ResponseEntity<>(all, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<JournalEntryEntity> createEntry(@RequestBody JournalEntryEntity myEntry) {
		try {
			myEntry.setDate(LocalDateTime.now());
			journalEntryService.save(myEntry);
			return  new ResponseEntity<>(myEntry, HttpStatus.CREATED);
		}
		catch (Exception e){
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("id/{myId}")
	public ResponseEntity<JournalEntryEntity> getJournalEntryById(@PathVariable ObjectId myId){
		Optional<JournalEntryEntity> journalEntry = journalEntryService.finaById(myId);
		if(journalEntry.isPresent()){
			return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("id/{myId}")
	public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId){
		journalEntryService.deleteById(myId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("id/{myId}")
	public ResponseEntity<?> updateEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntryEntity newEntry){
		JournalEntryEntity oldId = journalEntryService.finaById(myId).orElse(null);
		if(oldId!=null){
			oldId.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldId.getTitle());
			oldId.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldId.getContent());
			journalEntryService.save(oldId);
			return new ResponseEntity<>(oldId, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
