package app.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import app.model.entity.Processos;
import app.model.service.ProcessosService;

@WebServlet("/cadastrar")
public class CadastroProcesso extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProcessosService processosService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			processosService = new ProcessosService();
			boolean resp = processosService.salvar(request);
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("resp = " + resp);
			out.println("</body>");
			out.println("</html>");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			processosService = new ProcessosService();
			List<Processos> resp = processosService.buscar(request);
			
			Gson gson = new Gson();
			String json = gson.toJson(resp);
			 
	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(json);
	        out.flush(); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}
}