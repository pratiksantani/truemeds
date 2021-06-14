package com.truemeds.datacleaner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truemeds.datacleaner.dao.FinalOutputDAO;
import com.truemeds.datacleaner.dao.InputDetailsDAO;
import com.truemeds.datacleaner.entity.FinalOutput;
import com.truemeds.datacleaner.util.DataCleanerUtil;

@Service
public class InputDetailsServiceImpl implements InputDetailsService {

	@Autowired
	private InputDetailsDAO inputDetailsDao;

	@Autowired
	private FinalOutputDAO finalOutputDao;

	private int finalOutputID = 1;

	/**
	 * Get the list of Strings to be cleaned from the database and pass it to Util
	 * method. Save the output returned from Util method.
	 */
	@Override
	public String cleanResult() {
		List<String> listInputDetails = getInputDetails();
		List<FinalOutput> listFinalOutput = DataCleanerUtil.cleanData(listInputDetails);
		for (FinalOutput finalOutput : listFinalOutput) {
			finalOutputDao.saveFinalOutput(finalOutput);
		}
		return "Data cleaned";
	}

	/**
	 * Get all the objects from the table input_details
	 * 
	 * @return List of InputDetails objects
	 */
	private List<String> getInputDetails() {
		List<String> list = new ArrayList<String>();
		Iterable<String> it = inputDetailsDao.getInputDetails();
		for (String str : it) {
			list.add(str);
		}
		return list;
	}

}
