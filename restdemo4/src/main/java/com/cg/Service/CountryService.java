package com.cg.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.daos.CountryDAO;
import com.cg.entities.Country;
import com.cg.exception.ApplicationException;

@Service
public class CountryService {

	@Autowired
	private CountryDAO dao;

	public List<Country> byContinent(String continent) {
		List<Country> list = dao.findByContinent(continent);
		if (list == null || list.isEmpty()) {
			throw new ApplicationException("No countries found in continent " + continent);
		}
		return list;
	}

	public Country byCode(String code) {
		Country country = dao.findByCode(code);
		if (country == null) {
			throw new ApplicationException("Country with code " + code + " is not found");
		}
		return country;
	}

	public void create(Country country) {
		Country temp = dao.findByCode(country.getCode());
		if (temp == null) {
			dao.save(country);
		} else {
			throw new ApplicationException("Country already Exists");
		}
	}

	public void update(Country country) {
		Country temp = dao.findByCode(country.getCode());
		if (temp != null) {
			dao.update(country);
		} else
			throw new ApplicationException("Country does not exists!");
	}
}