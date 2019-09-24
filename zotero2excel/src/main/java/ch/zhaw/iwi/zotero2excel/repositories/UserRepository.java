package ch.zhaw.iwi.zotero2excel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.zhaw.iwi.zotero2excel.models.WebsiteUser;


@Repository
public interface UserRepository extends JpaRepository<WebsiteUser, Long> {

}