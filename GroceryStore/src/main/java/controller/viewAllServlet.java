package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewAllServlet")
public class viewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public viewAllServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao dao = new ItemDao();
		//request.setAttribute("allItems", dao.showAllItems());
		request.setAttribute("allItems", dao.showAllMeat());
		
		//if(dao.showAllItems().isEmpty()) {
		if(dao.showAllMeat().isEmpty()) {
			request.setAttribute("allItems", " ");
			
		} 
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}