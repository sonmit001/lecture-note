package com.magic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.controller.action.Action;

@WebServlet("/EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EmployeesServlet() {
    super();

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String command = request.getParameter("command");
    
    ActionFactory af = ActionFactory.getInstance();
    Action action = af.getAction(command);
  
    if (action != null) {
      action.execute(request, response);
    }
  }
}
