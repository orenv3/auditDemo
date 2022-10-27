package com.audit.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.entities.Picture;
import com.audit.services.PictureInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/picture/")
public class PicturesController {

	@Autowired
	PictureInterface pictureInterface;
	
	@PostMapping("savePicture/{name}")
	public Picture savePicture(@PathVariable("id") Picture pictue){
		log.debug("savePicture API executed with pictue: " + pictue);
		return pictureInterface.savePicture(pictue);
	}
	
	@GetMapping("getPicture/{id}")
	public Picture getPicture(@PathVariable("id") long id){
		log.debug("getPicture API executed with id: " + id);
		return pictureInterface.getPictureById(id);
	}
	
}
