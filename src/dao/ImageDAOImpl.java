package dao;

import java.util.HashMap;

import domain.ImageBean;
import enums.Domain;
import templates.AddQuery;
import templates.ModifyQuery;
import templates.QueryTemplate;
import templates.RetrieveQuery;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	private QueryTemplate q ;


	@Override
	public void insertImg(ImageBean img) {
		
		q = new AddQuery();
	//	map.put("table",Domain.IMG);
		q.play(img);
		
		
	}
	@Override
	public String modifyImg(String img) {
		q = new ModifyQuery();
		q.play();
		return img;
		
	}

}
