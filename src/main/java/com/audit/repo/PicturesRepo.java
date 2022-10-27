package com.audit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audit.entities.Picture;

@Repository
public interface PicturesRepo extends JpaRepository<Picture, Long>{

}
