package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Players;

/**
 * Servlet implementation class AddPlayerServlet
 */
@WebServlet("/addPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String stringNumber = request.getParameter("number");
		String stringStartDate = request.getParameter("startdate");
		
		LocalDate startDate = LocalDate.parse(stringStartDate);
		int number = Integer.parseInt(stringNumber);
		
		Players p = new Players(name, number, startDate);
		PlayerHelper ph = new PlayerHelper();
		ph.insertPlayer(p);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
