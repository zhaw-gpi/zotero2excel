package ch.zhaw.iwi.zotero2excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.zhaw.iwi.zotero2excel.models.Charsets;
import ch.zhaw.iwi.zotero2excel.repositories.CharsetsRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CharsetsRepository charsetsRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner started...");
		Charsets charsets = new Charsets();
		charsets.setCharset("Demo-Charset 2");
		charsets.setCharsetID(2);
		charsetsRepository.save(charsets);
		charsetsRepository.flush();

		for (Charsets charset : charsetsRepository.findAll()) {
			System.out.println(charset.getCharset());
		}
	}

}
