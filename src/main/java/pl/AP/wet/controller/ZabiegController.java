package pl.AP.wet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.AP.wet.entity.Zabieg;
import pl.AP.wet.service.ZabiegService;




@Controller
public class ZabiegController {
	
	private ZabiegService zabiegService;

	public ZabiegController(ZabiegService zabiegService) {
		super();
		this.zabiegService = zabiegService;
	}
	
	// POkazanie wszystkich  zabiegów
	@GetMapping("/zabieg")
	public String listZabieg(Model model) {
		model.addAttribute("zabieg", zabiegService.getAllZabieg());
		return "zabieg";
	}
	
	
	
	@GetMapping("/zabieg/new")
	public String createZabiegForm(Model model) {
		Zabieg zabieg = new Zabieg();
		model.addAttribute("zabieg", zabieg);
		return "create_zabieg";
		
	}
	//Dodanie nowego zabiegu 
	@PostMapping("/zabieg")
	public String saveZabieg(@ModelAttribute("zabieg") Zabieg zabieg) {
		zabiegService.addZabieg(zabieg);
		return "redirect:/zabieg";
	}
	//Edycja wpisu
	@GetMapping("/zabieg/edit/{id}")
	public String editZabiegForm(@PathVariable Long id, Model model) {
		model.addAttribute("zabieg", zabiegService.getZabiegById(id));
		return "edit_zabieg";
	}
	//Aktualizacja wpisu
	@PostMapping("/zabieg/{id}")
	public String updateZabieg(@PathVariable Long id,
			@ModelAttribute("zabieg") Zabieg zabieg,
			Model model) {
		Zabieg existingZabieg = zabiegService.getZabiegById(id);
		existingZabieg.setId(id);
		existingZabieg.setNazwaZabiegu(zabieg.getNazwaZabiegu());
		existingZabieg.setOpis(zabieg.getOpis());
	
		zabiegService.updateZabieg(existingZabieg);
		return "redirect:/zabieg";		
	}
	
	//Usunięcie wpisu
	@GetMapping("/zabieg/{id}")
	public String deleteZabieg(@PathVariable Long id) {
		zabiegService.deleteZabiegById(id);
		return "redirect:/zabieg";
	}
	
}
