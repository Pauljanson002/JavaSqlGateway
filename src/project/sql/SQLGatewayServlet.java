package project.sql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class SQLGatewayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sqlStatement = req.getParameter("sqlStatement");
        String sqlResult = "";
        String dbUrl = "jdbc:mysql://localhost:3306/my";
        String username = "user";
        String password = "password";
        try {
            Connection connection = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Database connection successful");
            Statement statement = connection.createStatement();
            sqlStatement = sqlStatement.trim();
            if(sqlStatement.length() >=6){
                // If the querry is a select
                String sqlType = sqlStatement.substring(0,6);
                if(sqlType.equalsIgnoreCase("select")){
                    ResultSet resultSet = statement.executeQuery(sqlStatement);
                    sqlResult = SQLUtil.getHtmlTable(resultSet);
                    resultSet.close();
                }

                //If the queryy is an update call
                else {
                    int i = statement.executeUpdate(sqlStatement);
                    if(i==0){
                        sqlResult = "<p> The statement executed sucessfully </p>";
                    } else{
                        sqlResult = "<p> The statement executed successfully.<br>" +
                                i+" rows affected </p>";
                    }
                }
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = req.getSession();
        session.setAttribute("sqlResult",sqlResult);
        session.setAttribute("sqlStatement",sqlStatement);
        String url = "/index.jsp";
        getServletContext().getRequestDispatcher(url).forward(req,resp);

    }
}
