package proxy;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class pagination implements proxy {
	int pageNumber, pageSize, blockSize, rowCount, 
	pageCount, clockCount, beginRow, endRow, beginPage, endPage,
		prevBlock, nextBlock;
boolean existPrev, existNext;

@Override
public Map<?, ?> carrayOut(Map<?, ?> param) {
	Map<String, Object> map = new HashMap<>();
	map.put("beginRow", String.valueOf(beginRow));
	map.put("endRow", String.valueOf(endRow));

	return null;
}


}
