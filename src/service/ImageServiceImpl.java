package service;

import domain.ImageBean;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}
	


	@Override
	public void insertImg(ImageBean img) {
		ImageServiceImpl.getInstance().insertImg(img);
		
	}
	

}
