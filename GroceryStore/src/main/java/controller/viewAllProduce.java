package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewAllProduce")
public class viewAllProduce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public viewAllProduce() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao dao = new ItemDao();
		request.setAttribute("allItems", dao.showAllProduce());
		
		if(dao.showAllProduce().isEmpty()) {
			request.setAttribute("allItems", " ");
			
		} 
		getServletContext().getRequestDispatcher("/produce.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}