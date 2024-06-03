package com.neeraj.service;

import java.sql.Date;
import java.util.List;

import com.neeraj.entity.Entry;

public interface EntryService {
	public Entry saveEntry(Entry entry);
	public Entry updateEntry(Entry entry);
	public void deleteEntry(Entry entry);
	public Entry findEntry(Integer uid);
	public List<Entry> findAllEntries();
	public List<Entry> findByUid(int uid);
	public Entry findEntryByDate(int uid, Date date );
}
