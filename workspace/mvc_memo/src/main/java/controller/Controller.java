package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.NullAction;

public class Controller extends HttpServlet {
	
	private boolean usingTemplate = false; //template 사용 여부
	private String templatePage = null; //templatePage 경로
	private Map map = new HashMap(); //URI명령어 = Action
	
	public void init(ServletConfig config) throws ServletException {
		// web.xml에서 configFile 파라메터값 가져온다
		String configFile = config.getInitParameter("configFile");
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(configFile);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) try { fis.close(); } catch(IOException ex) {}
		}
		
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String handlerClassName = prop.getProperty(command).trim();
			
			try {
				Class handlerClass = Class.forName(handlerClassName);
				Object handlerInstance = handlerClass.newInstance();
				
				map.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}// while end
		// web.xml에서 templatePage 파라메터값 가져옴
		templatePage = config.getInitParameter("templatePage");
		
		if(templatePage != null && !templatePage.equals("")) {
			usingTemplate = true;
		}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 분석 - 명령어가 무엇인지 확인
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		
		Action action = (Action)map.get(command);
		
		if(action == null) {
			action = new NullAction();
		}
		
		String viewPage = null;
		
		try {
			viewPage = action.execute(request, response); //model 사용, 결과저장, view 리턴
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(usingTemplate) { // template 페이지 내용부분에서 사용
			request.setAttribute("CONTENT_PAGE", viewPage);
		}
		
		//jsp페이지로 포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher(usingTemplate ? templatePage : viewPage);
		dispatcher.forward(request, response);
	}

}
