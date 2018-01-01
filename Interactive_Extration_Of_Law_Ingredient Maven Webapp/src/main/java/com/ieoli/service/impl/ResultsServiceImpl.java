package com.ieoli.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ieoli.dao.ResultEntityMapper;
import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.ResultEntityExample;
import com.ieoli.service.ResultsService;
@Service("resultsservice")
public class ResultsServiceImpl implements ResultsService {

	@Resource
	private ResultEntityMapper resultMapper;
	
	@Override
	public void insertResult(ResultEntity result) {
		// TODO Auto-generated method stub
		resultMapper.insert(result);

	}

	@Override
	public List<ResultEntity> getResultByTextID(int textid) {
		// TODO Auto-generated method stub
		ResultEntityExample resultExample=new ResultEntityExample();
		resultExample.createCriteria().andTextidEqualTo(textid);
		List<ResultEntity> results=resultMapper.selectByExample(resultExample);
		
		return results;
	}

	@Override
	public void deleteResultByID(int id) {
		// TODO Auto-generated method stub
		resultMapper.deleteByPrimaryKey(id);
	}

}
