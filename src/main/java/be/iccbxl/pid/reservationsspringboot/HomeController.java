package be.iccbxl.pid.reservationsspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(required=false) final Boolean accessDenied, Model model) {
		if (accessDenied == Boolean.TRUE) {
			model.addAttribute("errorMessage", "Accès refusé : action réservée à l'administrateur !");
		}

		return "home";
	}
}
