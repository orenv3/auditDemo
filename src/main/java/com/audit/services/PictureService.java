package com.audit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.entities.Picture;
import com.audit.repo.PicturesRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PictureService implements PictureInterface{
	
	@Autowired
	PicturesRepo picturesRepo;
	
	@Override
	public Picture savePicture(Picture picture) {
		log.debug("creating picture details: " + picture);
		return picturesRepo.save(picture);
	}
	
	public Picture getPictureById(long id) {
		log.debug("Getting picture id: " + id);
		Optional<Picture> picOptional = picturesRepo.findById(id);
		if(picOptional.isEmpty())
			{
			return new Picture();
			}
		
		return picOptional.get();
		 
	}

	
}
