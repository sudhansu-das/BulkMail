package org.msg;

import java.io.IOException;

import org.msg.util.ReadFileCsv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BulkMailApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BulkMailApplication.class, args);
		ReadFileCsv csv= new ReadFileCsv();
		csv.getAllMailList();
	}

}
