package com.topgear;

import java.awt.Checkbox;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/**
 * Servlet implementation class fileupload
 */
public class fileupload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
		
		ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
		
		List<FileItem> multifiles =sf.parseRequest(request);
		File file = new File("C:/Users/Shubham/workspace/Workspace_neon/ServletAssignment3/src/main/webapp/WEB-INF/Upload/");
        
		String[] fileList = file.list();
		
        
		
		System.out.println("value of 1"+fileList);
		
		System.out.println("value of 2"+multifiles);
		
		
		for (FileItem item:multifiles)
		{
			
			System.out.println("333");
			if (item.equals(null)){
	        	System.out.println("444444");	
	        	item.write(new File("C:/Users/Shubham/workspace/Workspace_neon/ServletAssignment3/src/main/webapp/WEB-INF/Upload/"+item.getName()));
	    		
				request.setAttribute("mesage", "file written");
	        	
	        }
	        
			
			
			for(String name:fileList){
			
	        if (name.equalsIgnoreCase(item.getName()) && request.getParameter("checkbox")!=null){
			
			item.write(new File("C:/Users/Shubham/workspace/Workspace_neon/ServletAssignment3/src/main/webapp/WEB-INF/Upload/"+item.getName()));
		
			request.setAttribute("mesage", "file is overwritten");
			
			System.out.println("file is overwritten");
			//getServletContext.getRequestDispatcher()
	        }
	        else if (name.equalsIgnoreCase(item.getName()) && request.getParameter("checkbox")==null) {
	        
	        	
	        	//item.write(new File("C:/Users/Shubham/workspace/Workspace_neon/ServletAssignment3/src/main/webapp/WEB-INF/Upload/"+item.getName()));
	    		
				request.setAttribute("mesage", "file already exists and overwrite not checked");
				System.out.println("file already exists and overwrite not checked");
	        		
	        }
	        
			}
			
			
	    
	        	
		}   
		}
		
		catch(Exception e){
			
			
			System.out.println(e);
		}
	}

}
