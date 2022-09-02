package com.godoro.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godoro.utils.StreamUtilities;

@WebServlet("/post")
public class PostServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream in = request.getInputStream();
		String input = StreamUtilities.read(in);
		System.out.println("Girdi:");
		System.out.println(input);

		OutputStream out = response.getOutputStream();	
		StreamUtilities.write(out,"Oldu");
	}
}
