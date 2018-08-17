package service;

import java.util.Map;

import dao.ImageDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}


	@Override
	public void insertImg(Map<?, ?> param) {
		ImageDAOImpl.getInstance().insertImg(param);
		
	}
	@Override
	public String retrieve(String word) {
		return ImageDAOImpl.getInstance().retrieve(word);
	}
	
}
