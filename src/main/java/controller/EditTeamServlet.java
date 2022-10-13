package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teams;

/**
 * Servlet implementation class EditTeamServlet
 */
@WebServlet("/EditTeamServlet")
public class EditTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamHelper th = new TeamHelper();
		
		String name = request.getParameter("name");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Teams teamToUpdate = th.searchForTeamById(tempId);
		teamToUpdate.setTeamName(name);
		
		th.updateTeam(teamToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}
