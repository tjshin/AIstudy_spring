package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandService {
	
	public StringBuffer getHello() {
		StringBuffer sb = new StringBuffer();
		sb.append("<li> 안녕하세요..MVC 입니다.<br>"); 
        sb.append("<li> Template Page<br>"); 
        sb.append("<li> URI Command Pattern<br>"); 
        sb.append("<li> Properties 파일을 이용한 처리입니다.<br>"); 
		
		return sb;
	}
	
	public String getDate() {
		Date dt = new Date();
		
		return dt.toLocaleString();
	}
	
	public StringBuffer getMyinfo() {
		StringBuffer sb = new StringBuffer();
		sb.append("<li> 이름 : 홍길동 <br>");
		sb.append("<li> 나이 : 29 <br>");
		sb.append("<li> 보유기술 : 없어요 <br>");
		sb.append("<li> 성격 : 느긋해요 <br>");
		
		return sb;
	}
	
	public List < Map > getTeam() {
		List < Map > list = new ArrayList < Map >();
		Map map = new HashMap();
		map.put("name", "홍길동");
		map.put("age", "29");
		map.put("skill", "java");
		map.put("psnlt", "친절하다");
		list.add(map);
		
		map = new HashMap();
		map.put("name", "고길동");
		map.put("age", "40");
		map.put("skill", "java");
		map.put("psnlt", "친절하다");
		list.add(map);
		
		map = new HashMap();
		map.put("name", "둘리");
		map.put("age", "150000000");
		map.put("skill", "초능력");
		map.put("psnlt", "버릇없다");
		list.add(map);
		
		map = new HashMap();
		map.put("name", "홍철수");
		map.put("age", "20");
		map.put("skill", "java, JSP");
		map.put("psnlt", "친절하다");
		list.add(map);
		
		map = new HashMap();
		map.put("name", "홍영희");
		map.put("age", "25");
		map.put("skill", "java, JSP");
		map.put("psnlt", "친절하다");
		list.add(map);
				
		return list;
	}

}
