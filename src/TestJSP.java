import javax.persistence.EntityManager;

import model.Music;
import util.DatabaseUtils;

public class TestJSP {

	public static void main(String[] args) {
		
		EntityManager em = DatabaseUtils.getManager();
		
		em.persist( new Music(1L, "Teste musica 1","/resources/musics/Sleep Away.mp3",false) );
		
		em.close();
		
	}
}
