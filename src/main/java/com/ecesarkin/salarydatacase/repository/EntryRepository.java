package com.ecesarkin.salarydatacase.repository;


import com.ecesarkin.salarydatacase.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}