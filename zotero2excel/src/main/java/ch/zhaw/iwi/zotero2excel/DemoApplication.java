package ch.zhaw.iwi.zotero2excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.zhaw.iwi.zotero2excel.excel.ExcelWriter;
import ch.zhaw.iwi.zotero2excel.models.Charsets;
import ch.zhaw.iwi.zotero2excel.repositories.CharsetsRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ExcelWriter excelWriter;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner started...");

		excelWriter.writeCharsets();

		System.out.println("Excel-Workbook exported.");
	}

}
