package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

@WebServlet("/editAlcoholListServlet")
public class editAlcoholListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public editAlcoholListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao dao = new ItemDao();
		String act = request.getParameter("doThisToItem");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllAlcohol").forward(request, response);
		} else if (act.equals("Delete Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("itemID"));
			Item itemToDelete = dao.searchForItemByItemID(tempId);
			dao.deleteItem(itemToDelete);
			getServletContext().getRequestDispatcher("/viewAllAlcohol").forward(request, response);
		} else if (act.equals("Edit Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("itemID"));
			Item itemToEdit = dao.searchForItemByItemID(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/editAlcohol.jsp").forward(request, response);
		} else if (act.equals("Add New Item")) {
			getServletContext().getRequestDispatcher("/addAlcoholItem.html").forward(request, response);
		} 
	}
}