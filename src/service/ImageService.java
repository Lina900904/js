package service;

import java.util.HashMap;
import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void insertImg(Map<?, ?> param);
	public String retrieve(String word);
	

}
