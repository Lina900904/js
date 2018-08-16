package command;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import dao.ImageDAOImpl;
import domain.ImageBean;
import domain.MemberBean;
import enums.Term;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class FileCommand extends Command{


	public FileCommand(HttpServletRequest request){
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		execute();
	}

	
	@Override
	public void execute() {
		HashMap<String, Object>map = new HashMap<>();
		ImageBean img = new ImageBean();
		MemberBean member = 
				(MemberBean) request.getSession().getAttribute("member");
		System.out.println("session id"+member.getId());
		System.out.println("----1-----");
		if (!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("업로드 파일 없음");
			return;
		}
		System.out.println("----2. 업로드 파일이 존재-----");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024 * 1024 * 40);// 40MB
		upload.setSizeMax(1024 * 1024 * 50); // 50MB
		List<FileItem> items = null;
		

		try {
			System.out.println("----3.try 내부 진입-----");
			File file = null;
			items =upload.parseRequest((new ServletRequestContext(request)));
			System.out.println("----4 아이템 생성-----");
			Iterator<FileItem>iter = items.iterator();
			while (iter.hasNext()) {
				
				System.out.println("----5. while 진입-----");
				FileItem item = (FileItem)iter.next();
				if(!item.isFormField()) {
					
					System.out.println("----6.if 진입-----");
					String fileName = item.getName();
					file = new File(Term.UPLOAD_PATH+fileName);
					System.out.println("file 출력 : "+file);
					item.write(file);
					System.out.println("----7. 업로드 성공 ---");
					System.out.println("업로드용 네임~~"+fileName);
					img.setImgname(fileName.split("\\.")[0]);
					img.setExtension(fileName.substring(fileName.lastIndexOf("\\") + 1));
					img.setId(member.getId());
					ImageServiceImpl.getInstance().insertImg(img);
					System.out.println(img.getImgname());
					System.out.println(img.getExtension());
					System.out.println(img.getId());
					
					
					
					/* File file = new File(Term.UPLOAD_PATH.toString());
					 String path = Term.UPLOAD_PATH.toString();
					 String sep = File.separator;
					 String ext = path.substring(path.lastIndexOf(".") + 1);
					 String fileName = path.substring(path.lastIndexOf(sep) + 1, path.lastIndexOf("."));
					System.out.println(path);
					System.out.println(sep);
					System.out.println(ext);
					System.out.println(path);*/	
					
					
					
				}else {
					System.out.println("----8. 업로드 실패----");
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 
			
		 super.execute();
		
		
	}
}
