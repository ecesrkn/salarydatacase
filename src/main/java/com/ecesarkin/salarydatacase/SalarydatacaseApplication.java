package com.ecesarkin.salarydatacase;

import com.ecesarkin.salarydatacase.entity.Entry;
import com.ecesarkin.salarydatacase.repository.EntryRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SalarydatacaseApplication {


	public static void main(String[] args) {
		SpringApplication.run(SalarydatacaseApplication.class, args);

	}


}
