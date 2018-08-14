package dao;

import domain.ImageBean;
import templates.QueryTemplate;
import templates.RetrieveQuery;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	private QueryTemplate q ;


	@Override
	public void insertImg(ImageBean img) {
		q = new RetrieveQuery();
		q.play();
		
		
	}

}
