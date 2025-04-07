//package com.Journalingo.Journal.Controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Journalingo.Journal.entity.JournalEntryEntity;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//	private Map<Long, JournalEntryEntity> journalEntries=new HashMap<>();
//
//	@GetMapping
//	public List<JournalEntryEntity> getall(){
//		return new ArrayList<>(journalEntries.values());
//	}
//
//	@PostMapping
//	public boolean createEntry(@RequestBody JournalEntryEntity myEntry) {
//		journalEntries.put(myEntry.getId(), myEntry);
//		return true;
//	}
//	@GetMapping("id/{myId}")
//	public JournalEntryEntity getEntryById(@PathVariable Long myId){
//		return journalEntries.get(myId);
//	}
//	@DeleteMapping("id/{myId}")
//	public JournalEntryEntity deleteEntryById(@PathVariable Long myId){
//		return journalEntries.remove(myId);
//	}
//	@PutMapping("id/{myId}")
//	public boolean updateEntryById(@PathVariable Long myId, @RequestBody JournalEntryEntity myEntry){
//		journalEntries.replace(myId, myEntry);
//		return true;
//	}
//
//
//
//}
