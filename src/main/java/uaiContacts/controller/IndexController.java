package uaiContacts.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/protected/home")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() throws IOException {
    	
//    	throw new IOException("io exeption alindi");
    	
        return new ModelAndView("welcomePage");
    }
}
