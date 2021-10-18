package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class TeamAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 1. 모델 사용
		CommandService service = new CommandService();
		List < Map > list = service.getTeam();
		// 2. 결과 저장
		request.setAttribute("team", list);
		// 3. 뷰페이지 리턴
		return "/view/team.jsp";
	}

}
