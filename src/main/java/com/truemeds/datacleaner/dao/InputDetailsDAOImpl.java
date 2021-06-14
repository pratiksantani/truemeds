package com.truemeds.datacleaner.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InputDetailsDAOImpl implements InputDetailsDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(InputDetailsDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Get the list of objects in the table input_details
	 */
	@Override
	public List<String> getInputDetails() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<String> query = currentSession.createQuery("select inputString from InputDetails", String.class);
		List<String> result = query.getResultList();
		if (result.size() > 0) {
			LOGGER.info("Total number of Strings to be processed : " + result.size());
		} else {
			LOGGER.info("No data found in \"input_details\" table");
		}
		return result;
	}

}
