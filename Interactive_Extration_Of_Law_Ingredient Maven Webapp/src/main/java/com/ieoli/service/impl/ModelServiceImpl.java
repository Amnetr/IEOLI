package com.ieoli.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ieoli.dao.ModelEntityMapper;
import com.ieoli.entity.ModelEntity;
import com.ieoli.entity.ModelEntityExample;
import com.ieoli.service.ModelService;

public class ModelServiceImpl implements ModelService{

	@Resource
	ModelEntityMapper mapper;
	@Override
	public List<ModelEntity> getModels() {
		// TODO Auto-generated method stub
		 List<ModelEntity> lists;
		 ModelEntityExample me = new ModelEntityExample();
		 me.createCriteria();
		 lists = mapper.selectByExample(me);
		 return lists;
	}
	@Override
	public void insertModel(String description) {
		// TODO Auto-generated method stub
		ModelEntity meEntity = new ModelEntity();
		meEntity.setModeldescription(description);
		mapper.insert(meEntity);
		
	}

}
