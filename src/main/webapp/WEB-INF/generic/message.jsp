<% 
		if (request.getAttribute("message") != null) {
			String message = request.getAttribute("message").toString();
			if (message != null) {
				out.println(message);
				out.println("<br>");
				out.println("<br>");
			}
		}
%>