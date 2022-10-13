package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teams;

/**
 * Servlet implementation class TeamNavigationServlet
 */
@WebServlet("/teamNavigationServlet")
public class TeamNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String in = request.getParameter("doThisToTeam");
		TeamHelper th  = new TeamHelper();
		
		String path = "/viewAllTeamsServlet";
		
		if(in.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Teams teamToDelete = th.searchForTeamById(tempId);
				th.deleteTeam(teamToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Did not select a team");
			}
		} else if (in.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Teams teamToEdit = th.searchForTeamById(tempId);
				request.setAttribute("teamToEdit", teamToEdit);
				path = "/edit-team.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Did not select a team");
			}
		} else if (in.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
