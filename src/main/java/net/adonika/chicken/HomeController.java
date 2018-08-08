package net.adonika.chicken;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//@RequestMapping("/{path:[^\\.]+}/")
	@RequestMapping(value= {"/{path:.*}/*.do", "/{path:.*}/{path2:.*}/*.do"})
    public String forward(HttpServletRequest request, @PathVariable String path) {
		System.out.println(request.getContextPath());
		System.out.println(String.format("path: %1$s", path));
        return "forward:/";
    }
}
