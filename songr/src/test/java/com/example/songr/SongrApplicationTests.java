package com.example.songr;

import com.example.songr.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test void testConstructorAlbum(){
		Album alboum = new Album("Prince and the Revolution","Purple Rain",5,1,"https://pbs.twimg.com/media/Eihki4LWoAAcvjk?format=png&name=small");
		assertNotNull(alboum);
	}

	private void assertNotNull(Album alboum) {
	}

}
