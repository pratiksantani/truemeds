package com.truemeds.datacleaner.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.truemeds.datacleaner.entity.FinalOutput;

@Repository
public class FinalOutputDAOImpl implements FinalOutputDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(FinalOutputDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveFinalOutput(FinalOutput finalOutput) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(finalOutput);
		LOGGER.info("Object saved : " + finalOutput.toString());
	}
}
