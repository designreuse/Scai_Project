/**
 * 
 */
package net.com.scaiprojectv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Comment(s): 
 * 
 * @author Paulo Garcia
 * @Mar 18, 2014
 * @9:58:10 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Controller
public class Login{

	private static final String PAGE_LOGIN = "login";
	
	@RequestMapping(value = {"/login",""})
	public ModelAndView login(){
		ModelAndView view = new ModelAndView(PAGE_LOGIN);
		return view;
	}
	
}
