package com.audit.services;

import org.springframework.stereotype.Component;

import com.audit.entities.Picture;

@Component
public interface PictureInterface {

	Picture savePicture(Picture picture);
	Picture getPictureById(long id);
	
}
