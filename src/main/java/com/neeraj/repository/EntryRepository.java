package com.neeraj.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraj.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer> {
	
	public List<Entry> findByUid(int uid);
	public Entry findByUidAndDate(int uid, Date date);
	
}
