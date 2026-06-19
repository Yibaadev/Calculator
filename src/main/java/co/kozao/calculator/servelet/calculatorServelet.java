package co.kozao.calculator.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.kozao.calculator.service.calculatorService;

/**
 * Servlet implementation class calculatorServelet
 */
@WebServlet("/calculatorServelet")
public class calculatorServelet extends HttpServlet {
	// Manque la déclaration de l'attribut
	private calculatorService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {

		service = new calculatorService();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String nbre2 = request.getParameter("nbr2");
	    String resultat = "";

	    try {
	        double nbr1 = Double.parseDouble(request.getParameter("nbr1"));

	        switch (request.getParameter("operation")) {
	            case "addition":
	                resultat = String.valueOf(calculatorService.addition(nbr1, Double.parseDouble(nbre2)));
	                break;
	            case "substraction":
	                resultat = String.valueOf(calculatorService.substraction(nbr1, Double.parseDouble(nbre2)));
	                break;
	            case "Multiplication":
	                resultat = String.valueOf(calculatorService.multiplication(nbr1, Double.parseDouble(nbre2)));
	                break;
	            case "division":
	                resultat = calculatorService.division(nbr1, Double.parseDouble(nbre2));
	                break;
	            case "puissance":
	                resultat = String.valueOf(calculatorService.power(nbr1, Double.parseDouble(nbre2)));
	                break;
	            case "racine":
	                resultat = calculatorService.squaReoot(nbr1);
	                break;
	            case "factoriel":
	                resultat = String.valueOf(calculatorService.factorial((int) nbr1));
	                break;
	            default:
	                resultat = "Opération inconnue";
	        }
	    } catch (NumberFormatException e) {
	        resultat = "Erreur : Veuillez entrer un nombre valide";
	    } catch (IllegalArgumentException e) {
	        resultat = e.getMessage();
	    }

	    request.setAttribute("resultat", resultat);
	    request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}