package dao;

import java.util.Map;

import domain.ImageBean;

public interface ImageDAO {
	public void insertImg(Map<?, ?> param);
	public String retrieve(String img);
	

}
