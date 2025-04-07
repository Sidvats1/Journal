package com.Journalingo.Journal.Controller;

import com.Journalingo.Journal.entity.JournalEntryEntity;
import com.Journalingo.Journal.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

	@Autowired
	private JournalEntryService journalEntryService;

	@GetMapping
	public List<JournalEntryEntity> getall(){
		return null;
	}

	@PostMapping
	public boolean createEntry(@RequestBody JournalEntryEntity myEntry) {
		journalEntryService.save(myEntry);
		return true;
	}
	@GetMapping("id/{myId}")
	public JournalEntryEntity getEntryById(@PathVariable Long myId){
		return null;
	}
	@DeleteMapping("id/{myId}")
	public JournalEntryEntity deleteEntryById(@PathVariable Long myId){
		return null;
	}
	@PutMapping("id/{myId}")
	public boolean updateEntryById(@PathVariable Long myId, @RequestBody JournalEntryEntity myEntry){
		return true;
	}
	
	
	
}
