package com.dream.team.library.repository;

import com.dream.team.library.entity.lib.Book;
import com.dream.team.library.entity.lib.Language;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends EntityRepository<Language> {
    List<Language> findAllByName(String name);
}
