package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewAllMeat")
public class viewAllMeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public viewAllMeat() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao dao = new ItemDao();
		request.setAttribute("allItems", dao.showAllMeat());
		
		if(dao.showAllMeat().isEmpty()) {
			request.setAttribute("allItems", " ");
			
		} 
		getServletContext().getRequestDispatcher("/meat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}