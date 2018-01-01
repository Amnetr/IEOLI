package com.ieoli.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.ieoli.entity.TextEntity;

public interface TextsService {

	public TextEntity getTextByID(int id);
	public void updateText(TextEntity text);
	public List<TextEntity> getHandledText();
	public void generateFile(int textid,int resultid,String path)throws FileNotFoundException, IOException;
}
