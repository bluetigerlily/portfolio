package com.revature.services;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Breed;
import com.revature.beans.Cat;
import com.revature.beans.Person;
import com.revature.beans.SpecialNeed;
import com.revature.beans.Status;
import com.revature.data.BreedDAO;
import com.revature.data.CatDAO;
import com.revature.data.DAOFactory;
import com.revature.data.PersonDAO;
import com.revature.data.SpecialNeedsDAO;
import com.revature.data.StatusDAO;
import com.revature.exceptions.CatAlreadyAdoptedException;

@Service
public class CatServiceImpl implements CatService {
	// Data Access Object
	private CatDAO catDao;
	private PersonDAO personDao;
	private BreedDAO breedDao;
	private StatusDAO statusDao;
	private SpecialNeedsDAO specialNeedsDao;
	
	private static Logger log = Logger.getLogger(CatServiceImpl.class);
	
	@Autowired
	public CatServiceImpl(CatDAO c, PersonDAO p, BreedDAO b, StatusDAO s, SpecialNeedsDAO sn) {
		catDao = c;
		personDao = p;
		breedDao = b;
		statusDao = s;
		specialNeedsDao = sn;
	}

	@Override
	public Integer addCat(Cat c) {
		return catDao.add(c).getId();
	}

	@Override
	public Cat getCatById(Integer id) {
		return catDao.getById(id);
	}

	@Override
	public Set<Cat> getAllCats() {
		return catDao.getAll();
	}

	@Override
	public Set<Cat> getAvailableCats() {
		return catDao.getAvailableCats();
	}

	@Override
	public void updateCat(Cat c) {
		if (getCatById(c.getId()) != null)
			catDao.delete(c);
		else
			log.debug("Cat didn't exist in the database.");
	}

	@Override
	public void removeCat(Cat c) {
		if (getCatById(c.getId()) != null)
			catDao.delete(c);
		else
			log.debug("Cat didn't exist in the database.");
	}

	@Deprecated
	public void oldAdoptCat(Person p, Cat c) throws CatAlreadyAdoptedException {
		if ("Adopted".equals(c.getStatus().getName()))
			throw new CatAlreadyAdoptedException();
		
		Status s = new Status();
		s.setId(2);
		s.setName("Adopted");
		c.setStatus(s);
		catDao.update(c);
		
		Set<Cat> cats = p.getCats();
		cats.add(c);
		p.setCats(cats);
		personDao.update(p);
	}
	
	@Override
	public void adoptCat(Person p, Cat c) throws CatAlreadyAdoptedException {
		catDao.adoptCat(p, c);
	}

	@Override
	public Set<Breed> getAllBreeds() {
		return breedDao.getAll();
	}

	@Override
	public Breed getBreedById(Integer id) {
		return breedDao.getById(id);
	}

	@Override
	public void addBreed(Breed b) {
		breedDao.add(b);
	}

	@Override
	public Set<Status> getAllStatuses() {
		return statusDao.getAll();
	}

	@Override
	public Status getStatusById(Integer id) {
		return statusDao.getById(id);
	}
	
	@Override
	public SpecialNeed addSpecialNeed(SpecialNeed sn) {
		return specialNeedsDao.add(sn);
	}
	
	@Override
	public Set<SpecialNeed> getAllSpecialNeeds() {
		return specialNeedsDao.getAll();
	}

}
