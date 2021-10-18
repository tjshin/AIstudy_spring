package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class DateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 1. 모델 사용
		CommandService service = new CommandService();
		String str = service.getDate();
		// 2. 결과 저장
		request.setAttribute("date", str);
		// 3. 뷰페이지 리턴
		return "/view/date.jsp";
	}

}
