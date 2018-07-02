package com.khoubyari.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khoubyari.example.dao.jpa.GroundRepository;
import com.khoubyari.example.domain.BookGround;

@Service
public class BookGroundService {

	
	private static final Logger log = LoggerFactory.getLogger(BookGroundService.class);
	
	    @Autowired
	    private GroundRepository groundRepository;
	     
	    public BookGroundService() {
			
		}
	  public BookGround createGround(BookGround ground) {
		return  groundRepository.save(ground);
	  }
	  public BookGround getGround(long id) {
		  return groundRepository.findOne(id);
	  }
	  public void updateGround(BookGround ground) {
		  groundRepository.save(ground);
	  }
	  public void deleteGround(long id) {
		  groundRepository.delete(id);
	  }
}
