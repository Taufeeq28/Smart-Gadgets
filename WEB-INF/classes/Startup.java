import java.io.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Startup")


public class Startup extends HttpServlet
{

	public void init() throws ServletException
    {
		SaxParserDataStore.addHashmap();
		MySqlDataStoreUtilities.Insertproducts();
        MySqlDataStoreUtilities.Updateproductquantity();
    }

    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	//MySqlDataStoreUtilities.Insertproducts(response);
    //}
}
