package bg.thereadingroom;

import org.springframework.boot.SpringApplication;

public class TestThereadingroomApplication {

	public static void main(String[] args) {
		SpringApplication.from(ThereadingroomApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
