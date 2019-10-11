package rashmi.example.fileupload;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import rashmi.example.fileupload.storage.StorageProperties;
import rashmi.example.fileupload.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FileuploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileuploadApplication.class, args);
	}
	
	 @Bean
	    CommandLineRunner init(StorageService storageService) {
	        return (args) -> {
//	            storageService.deleteAll();
	            storageService.init();
	        };
	    }

}
