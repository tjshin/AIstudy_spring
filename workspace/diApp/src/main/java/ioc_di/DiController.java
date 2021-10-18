package ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiController {

	@Autowired
	@Qualifier("samsungTV")
	private TV tv;
	
	@Autowired
	@Qualifier("lgTV")
	private TV tv2;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();
		
		return "Annotation DI 사용하기";
	}

}
