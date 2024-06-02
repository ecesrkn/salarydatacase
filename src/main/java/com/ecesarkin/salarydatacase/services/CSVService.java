package com.ecesarkin.salarydatacase.services;

import com.ecesarkin.salarydatacase.entity.Entry;
import com.ecesarkin.salarydatacase.repository.EntryRepository;
import com.opencsv.CSVReader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    private EntryRepository entryRepository;
    public List<Entry> entries = new ArrayList<>();

    @PostConstruct
    public void loadCsv () throws Exception{
            List<Entry> entryList = new ArrayList<>();
            try{
                CSVReader reader = new CSVReader(new FileReader("src/main/resources/datasets/survey.csv"));
                List<String[]> records = reader.readAll();
                List<Entry> entries = new ArrayList<>();

                for (String[] record : records) {
                    Entry entry = new Entry(
                            record[0],
                            record[1],
                            record[2],
                            record[3],
                            record[4],
                            record[5],
                            record[6],
                            record[7],
                            record[8],
                            record[9],
                            record[10],
                            record[11],
                            record[12],
                            record[13],
                            record[14],
                            record[15],
                            record[16],
                            record[17],
                            record[18],
                            record[19],
                            record[20],
                            record[21],
                            record[22],
                            record[23],
                            record[24],
                            record[25],
                            record[26]);
                    entries.add(entry);

                }
                entryRepository.saveAll(entries);
            } catch (Exception e) {
                System.out.println(e);
            }
    }

    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }
}


