package com.ieoli.service;

import java.util.List;

import com.ieoli.entity.ResultEntity;

public interface ResultsService {

	public void insertResult(ResultEntity result);
	public List<ResultEntity> getResultByTextID(int textid);
	public void deleteResultByID(int id);
}