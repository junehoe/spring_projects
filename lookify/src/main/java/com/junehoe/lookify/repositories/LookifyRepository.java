package com.junehoe.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.junehoe.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
	List<Song> findTop10ByOrderByRatingDesc();
	List<Song> findByArtistContainingAndRatingGreaterThanEqual(String artist, int rating);
}