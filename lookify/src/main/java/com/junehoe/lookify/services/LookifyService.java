package com.junehoe.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junehoe.lookify.models.Song;
import com.junehoe.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	private LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<Song> allSongs() {
		return (List<Song>) lookifyRepository.findAll();
	}
	
	public void addSong(Song song) {
		lookifyRepository.save(song);
	}
	
	public Song findSongById(Long id) {
		return lookifyRepository.findOne(id);
	}
	
	public void destroySong(Long id) {
		lookifyRepository.delete(id);
	}
	
	public List<Song> getTopTenSongs() {
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
	public List<Song> getSearchResults(String artist) {
		return lookifyRepository.findByArtistContainingAndRatingGreaterThanEqual(artist, 8);
	}
}
