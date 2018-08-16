package service;

import dao.ImageDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}
	


	@Override
	public void insertImg(ImageBean img) {
		ImageDAOImpl.getInstance().insertImg(img);
		
	}
	@Override
	public String modify(String word) {
		return ImageDAOImpl.getInstance().modifyImg(word);
	}
	

}
