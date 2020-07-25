package service;

import java.util.List;

import model.Music;

public interface MusicService {

	public List<Music> getAllMusics();
	
	public void saveMusic  ( Music music );
	public void updateMusic( Music music );
	public void deleteMusic( Music music );
	
	public List<Music> searchMusicByName( String name );
	
	List<Music> getAllMusicsPublicOnly();

	public Music getOneMusicById(Long id);
}
