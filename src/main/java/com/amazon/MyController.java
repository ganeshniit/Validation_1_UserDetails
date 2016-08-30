package com.amazon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amazon.cart1.dao.CategoryDAO;
import com.amazon.cart1.model.Category;
@Controller
public class MyController {
	@Autowired
	
	CategoryDAO categoryDAO;
	//if you want to navigate to other page without carrying the data
	
	@RequestMapping("/")
	@Autowired
	public ModelAndView home()
	{
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("message","hello");
		List<Category> categoryList=categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		System.out.println("size:"+categoryList.size());
		return mv;
		//GET all the categories along with products
	}
	
	//if you want to navigate to other page with carrying the data
	//SPA:Single Page Application
/*	@RequestMapping("/Register")
	public ModelAndView register()
	{
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("message","thankyou");
		
		return mv;
	}
*/	
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv= new ModelAndView("Login");
		mv.addObject("message","Welcome");
		
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView signUp()
	{
		ModelAndView mv= new ModelAndView("SignUp");
		mv.addObject("message","thankyou");
		
		return mv;
	}
}
