package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wether")
public class wether extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public wether() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  PrintWriter p = response.getWriter();                                                              
		
		//String city = "London";
		String city = request.getParameter("city");
		String apiKey = "894b9069ab1a8c54edd618b4dcb0f5d2";
		String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city  + "&appid=" + apiKey + "&units=metric";
	
		 
			URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");

	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String inputLine;
	        StringBuilder response1 = new StringBuilder();
	        while ((inputLine = in.readLine()) != null) {
	            response1.append(inputLine);
	        }
	       
	        in.close();

	     
	        String jsonResponse = response1.toString();
	        double temperature = Double.parseDouble(jsonResponse.split("\"temp\":")[1].split(",")[0]);
	        long sunrise = Long.parseLong(jsonResponse.split("\"sunrise\":")[1].split(",")[0]);
	        long sunset = Long.parseLong(jsonResponse.split("\"sunset\":")[1].split("},")[0]);
//	        long sunset = Long.parseLong(jsonResponse.split("\"sunset\":")[1].split("},")[0]);
//	       System.out.println(sunrise);
	        
	        long timestamp = sunrise;
		    Instant instant = Instant.ofEpochSecond(timestamp);
		    LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		    int hour = dateTime.getHour();
	        int minute = dateTime.getMinute();
	        int second = dateTime.getSecond();
	        
	        long time = sunset; 
	        Instant instant1 = Instant.ofEpochSecond(time);
	        LocalDateTime date = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
	        int hh = date.getHour();
	        int mm = date.getMinute();
	        int sec = date.getSecond();
	        
	        ServletContext context = getServletContext();
		    context.setAttribute("temp1", temperature);  
		    context.setAttribute("temp2", hour);
		    context.setAttribute("temp3", minute);
		    context.setAttribute("temp4", second);
		    context.setAttribute("h", hh);
		    context.setAttribute("m", mm);
		    context.setAttribute("s", sec);
		    
		    System.out.println(temperature);
		    //p.print("<a href='servlet2'>link</a>");
		     RequestDispatcher rd = request.getRequestDispatcher("demo.jsp");
			  rd.forward(request, response);
           // System.out.println("Current temperature in " + city + " " + temperature+"°C "+ hour +":"+minute+":"+second);
	       

	        connection.disconnect();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
