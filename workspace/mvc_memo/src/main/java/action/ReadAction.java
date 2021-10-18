package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemoDAO;
import model.MemoDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		MemoDAO dao = new MemoDAO();
		int memono = Integer.parseInt(request.getParameter("memono"));
		
		dao.upViewcnt(memono);
		
		MemoDTO dto = dao.read(memono);
		
		request.setAttribute("dto", dto);
		
		return "/view/read.jsp";
	}

}
