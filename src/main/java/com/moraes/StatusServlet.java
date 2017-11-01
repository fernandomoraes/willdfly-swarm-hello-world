package com.moraes;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "status")
public class StatusServlet extends HttpServlet {

    @Inject
    private StatusCheckerService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        service.checkNow(StatusCheck.Status.OK);

        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\": \"ok\"}");
    }


}
