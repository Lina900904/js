package pool;

import java.io.File;

import enums.Term;

public class test {

	public static void main(String[] args) {
		 File files = new File(Term.UPLOAD_PATH.toString());
		 String path = Term.UPLOAD_PATH.toString();
		 String sep = File.separator;
		 String ext = path.substring(path.lastIndexOf(".") + 1);
		 String fileName = path.substring(path.lastIndexOf(sep) + 1, path.lastIndexOf("."));
		System.out.println(path);
		System.out.println(sep);
		System.out.println(ext);
		System.out.println(fileName);

	}

}
