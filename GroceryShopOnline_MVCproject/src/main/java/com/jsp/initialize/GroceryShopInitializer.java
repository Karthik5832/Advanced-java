package com.jsp.initialize;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.jsp.GroceryConfig;

public class GroceryShopInitializer extends  AbstractAnnotationConfigDispatcherServletInitializer{

		@Override
		protected Class<?>[] getRootConfigClasses() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return new Class[] {GroceryConfig.class};
		}
		
		@Override
		protected String[] getServletMappings() {
			// TODO Auto-generated method stub
			return new String[] {"/"};
}
}
