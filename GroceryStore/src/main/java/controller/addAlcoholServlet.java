package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

@WebServlet("/addAlcoholServlet")
public class addAlcoholServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addAlcoholServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao dao = new ItemDao();
		String item = request.getParameter("item");
		String deptID = request.getParameter("deptID");
		String department = request.getParameter("department");
		String price = request.getParameter("price");
		Item itemToUpdate = new Item();
		itemToUpdate.setItem(item);
		itemToUpdate.setDeptID(deptID);
		itemToUpdate.setDepartment(department);
		itemToUpdate.setPrice(price);
		dao.insertItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllAlcohol").forward(request, response);
	}
}