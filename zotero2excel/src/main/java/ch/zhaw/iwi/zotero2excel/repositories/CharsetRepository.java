package ch.zhaw.iwi.zotero2excel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.iwi.zotero2excel.models.Charset;

/**
 * CharsetRepository
 */
public interface CharsetRepository extends JpaRepository<Charset, Long>{
    
}
