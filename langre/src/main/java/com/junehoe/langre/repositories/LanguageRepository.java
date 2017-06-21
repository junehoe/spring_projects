package com.junehoe.langre.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.junehoe.langre.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

}
