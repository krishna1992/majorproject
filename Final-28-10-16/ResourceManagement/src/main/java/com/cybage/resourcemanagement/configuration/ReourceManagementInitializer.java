package com.cybage.resourcemanagement.configuration;
 
import javax.servlet.Filter;
 
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 
public class ReourceManagementInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ResourceManagementConfiguration.class };
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
     
    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CORSFilter() };
        return singleton;
    }
  
}