package dao;

import java.util.HashMap;
import java.util.Map;

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
	public void insertImg(Map<?, ?> param) {
		
		System.out.println(param);
		HashMap<String, Object>map = (HashMap<String, Object>) param;
		q = new AddQuery();
		map.put("table",Domain.IMG);
		map.put("img", param);
		q.play(map);
	}
	@Override
	public String retrieve(String img) {
		q = new RetrieveQuery();
		HashMap<String, Object>map = new HashMap<>();
		map.put("table",Domain.IMG);
		map.put("word", img);
		q.play();
		return img;
	}
}
