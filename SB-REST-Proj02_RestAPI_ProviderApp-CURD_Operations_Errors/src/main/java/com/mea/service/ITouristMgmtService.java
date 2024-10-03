package com.mea.service;

import java.util.List;

import com.mea.entity.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer tid);
	public String updateTourist(Tourist tourist);
	public String updateBudgetById(Integer tid,Double hikePercentage);
	public String deleteTouristById(Integer tid);
	
}
