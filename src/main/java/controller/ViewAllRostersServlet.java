package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RosterDetails;

/**
 * Servlet implementation class ViewAllRostersServlet
 */
@WebServlet("/viewAllRostersServlet")
public class ViewAllRostersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllRostersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RosterDetailsHelper rh = new RosterDetailsHelper();
		List<RosterDetails> rosterList = rh.getRosters();
		request.setAttribute("allRosters", rosterList);
		
		if(rosterList.isEmpty()) {
			request.setAttribute("allRosters", "");
			
		}
		
		getServletContext().getRequestDispatcher("/roster-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
