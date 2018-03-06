package com.ieoli.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ieoli.dao.ResultEntityMapper;
import com.ieoli.dao.TextEntityMapper;
import com.ieoli.entity.TextEntity;
import com.ieoli.entity.TextEntityExample;
import com.ieoli.service.TextsService;
@Service("textsservice")
public class TextsServiceImpl implements TextsService {
	
	@Resource
	private TextEntityMapper textMapper;
	@Resource
	private ResultEntityMapper resultMapper;

	@Override
	public TextEntity getTextByID(int id) {
		// TODO Auto-generated method stub
		return textMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public void updateText(TextEntity text){
		
		textMapper.updateByPrimaryKeySelective(text);
	}

	@Override
	public List<TextEntity> getHandledText(int modelid) {
		// TODO Auto-generated method stub
		TextEntityExample textExample=new TextEntityExample();
		textExample.createCriteria().andCountEqualTo(3).andModelidEqualTo(modelid);
		List<TextEntity> texts=textMapper.selectByExample(textExample);
		return texts;
	}

	@Override
	public void generateFile(int textid,int resultid,String path) throws IOException {
		// TODO Auto-generated method stub
		String article=textMapper.selectByPrimaryKey(textid).getArticle();
		String label=resultMapper.selectByPrimaryKey(resultid).getLabel();
		String word[]=article.split("\\$");
		String labels[]=label.split("\\$");
		int sort[]=new int[labels.length];
		//Arrays.sort(labels);
		//去除单词编号
		for(int i=0;i<labels.length;i++){
			String withoutNum[]=labels[i].split("_");
			labels[i]=withoutNum[1];
			sort[i]=Integer.parseInt(withoutNum[0])-1;
		}
		//附上标签
		for(int i=0;i<sort.length;i++){
			word[sort[i]]=word[sort[i]]+"_"+labels[sort[i]];
		}
		
		File text=new File(path);
		FileOutputStream outputStream = new FileOutputStream(text);
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"utf-8"));
		for(int i=0;i<word.length;i++){
			bufferedWriter.write(word[i]+"\r\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	@Override
	public TextEntity getTextByModel(int id) {
		// TODO Auto-generated method stub
		TextEntityExample tee = new TextEntityExample();
		tee.createCriteria().andModelidEqualTo(id);
		List<TextEntity> te = textMapper.selectByExampleWithBLOBs(tee);
		int number;
		Random random =new Random(System.currentTimeMillis());
		if(te.size()>1)
		{
			number = random.nextInt(te.size());
		}else if(te.size()>=0)
		{
			number=0;
		}else {
			return null;
		}
		TextEntity pEntity = te.get(number);
		return te.get(number);
		
	}

	@Override
	public void insertFile(TextEntity text) {
		// TODO Auto-generated method stub
		textMapper.insert(text);
	}

}
