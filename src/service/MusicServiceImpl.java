package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import model.Music;
import util.DatabaseUtils;

 
public class MusicServiceImpl implements MusicService{

	
	@Override
	public List<Music> getAllMusics() {

		EntityManager em = DatabaseUtils.getManager();

		 return em
			.createQuery("select m from Music m" , Music.class )
			.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Music> getAllMusicsPublicOnly() {
		List<Music> musics = new ArrayList<>(
				Arrays.asList( 
						new Music(1L, "Teste musica 1","/resources/musics/Sleep Away.mp3",false),
						new Music(1L, "Teste musica 1","/resources/musics/Sleep Away.mp3"),
						new Music(2L, "Teste musica 2","/resources/musics/Sleep Away.mp3"),
						new Music(3L, "Teste musica 3","/resources/musics/Sleep Away.mp3")
				)		
			);
		
		return (List<Music>) musics.stream().filter ( m -> m.getForPublic() );
	}

	@Override
	public void saveMusic(Music music) {
		
		EntityManager em = DatabaseUtils.getManager();	
		
		em.getTransaction().begin();
		em.persist( music );
		em.getTransaction().commit();
	}

	@Override
	public void updateMusic(Music music) 
	{
		
		EntityManager em = DatabaseUtils.getManager();
		
		em.getTransaction().begin();
		em.merge( music );
		em.getTransaction().commit();
	}

	@Override
	public void deleteMusic(Music music) 
	{
		
		EntityManager em = DatabaseUtils.getManager();
		
		em.getTransaction().begin();
		em.remove( music );
		em.getTransaction().commit();
	}

	@Override
	public List<Music> searchMusicByName(String search) {
		
		Optional<String> name = Optional.ofNullable( search );
		
		if( name.isPresent() ) {
			return getListOfMusicsByUsingLikeOperatorOf(name);
		}
		return new ArrayList<>();
	}


	@SuppressWarnings("unchecked")
	private List<Music> getListOfMusicsByUsingLikeOperatorOf(Optional<String> optionalName) {
		EntityManager em = DatabaseUtils.getManager();
		
		return em
			   .createQuery("select m from Music m where lower( m.name ) LIKE lower( :name  )")
			   .setParameter("name", "%"+ optionalName.get() +"%" )
			   .getResultList();
	}


	@Override
	public Music getOneMusicById(Long id) {
		
		EntityManager em = DatabaseUtils.getManager();
		return em.find( Music.class , id );
	}
}
