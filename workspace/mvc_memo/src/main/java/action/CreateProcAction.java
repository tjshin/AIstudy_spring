package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;
import model.MemoDTO;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		//모델 사용
		
		MemoDAO dao = new MemoDAO();
		MemoDTO dto = new MemoDTO();
		
		dto.setWname(request.getParameter("wname"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		boolean flag = dao.create(dto);
		
		request.setAttribute("flag", flag);
		
		return "/view/createProc.jsp";
	}

}
