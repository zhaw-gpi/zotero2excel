package ch.zhaw.iwi.zotero2excel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.iwi.zotero2excel.models.Charsets;

/**
 * CharsetRepository
 */
public interface CharsetsRepository extends JpaRepository<Charsets, Integer>{
    
}
