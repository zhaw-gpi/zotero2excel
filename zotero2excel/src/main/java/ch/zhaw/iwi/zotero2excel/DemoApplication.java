package ch.zhaw.iwi.zotero2excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.zhaw.iwi.zotero2excel.models.Charset;
import ch.zhaw.iwi.zotero2excel.repositories.CharsetRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CharsetRepository charsetRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner started...");
		/* WebsiteUser websiteUser = new WebsiteUser();
		websiteUser.setName("Test");
		websiteUser.setEmail("test@test.ch");
		websiteUser.setId(1);

		userRepository.save(websiteUser);
		userRepository.flush(); */

		for (Charset charset : charsetRepository.findAll()) {
			System.out.println(charset.getCharset());
		}
	}

}
