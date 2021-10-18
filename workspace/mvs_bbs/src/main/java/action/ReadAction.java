package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;
import model.BbsDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 모델 사용
		BbsDAO dao = new BbsDAO();
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		dao.upViewcnt(bbsno); //조회수 증가
		BbsDTO dto = dao.read(bbsno);
		
		request.setAttribute("dto", dto);
		
		return "/view/read.jsp";
	}

}
