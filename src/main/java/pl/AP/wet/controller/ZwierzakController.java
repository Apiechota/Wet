package pl.AP.wet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.AP.wet.entity.Zwierzak;
import pl.AP.wet.service.WlascicielService;
import pl.AP.wet.service.ZwierzakService;




@Controller
public class ZwierzakController {
	
	private ZwierzakService zwierzakService;
	private WlascicielService wlascicielService;
	public ZwierzakController(ZwierzakService zwierzakService,WlascicielService wlascicielService) {
		super();
		this.zwierzakService = zwierzakService;
		this.wlascicielService = wlascicielService;
	}
	
	// POkazanie wszystkich  zwierzaków
	@GetMapping("/zwierzak")
	public String listZwierzak(Model model) {
		model.addAttribute("zwierzak", zwierzakService.getAllZwierzak());
	
		return "zwierzak";
	}
	
	
	
	@GetMapping("/zwierzak/new")
	public String createZwierzakForm(Model model) {
		Zwierzak zwierzak = new Zwierzak();
		model.addAttribute("zwierzak", zwierzak);
		model.addAttribute("wlasciciele", wlascicielService.getAllWlasciciel());
		return "create_zwierzak";
		
	}
	//Dodanie nowego zwierzaku 
	@PostMapping("/zwierzak")
	public String saveZwierzak(@ModelAttribute("zwierzak") Zwierzak zwierzak) {
		zwierzakService.addZwierzak(zwierzak);
		return "redirect:/zwierzak";
	}
	//Edycja wpisu
	@GetMapping("/zwierzak/edit/{id}")
	public String editZwierzakForm(@PathVariable Long id, Model model) {
		model.addAttribute("zwierzak", zwierzakService.getZwierzakById(id));
		model.addAttribute("wlasciciele", wlascicielService.getAllWlasciciel());
		return "edit_zwierzak";
	}
	//Aktualizacja wpisu
	@PostMapping("/zwierzak/{id}")
	public String updateZwierzak(@PathVariable Long id,
			@ModelAttribute("zwierzak") Zwierzak zwierzak,
			Model model) {
		Zwierzak existingZwierzak = zwierzakService.getZwierzakById(id);
		existingZwierzak.setId(id);
		existingZwierzak.setImie(zwierzak.getImie());
		existingZwierzak.setWlasciciel(zwierzak.getWlasciciel());
		existingZwierzak.setGatunek(zwierzak.getGatunek());
		zwierzakService.updateZwierzak(existingZwierzak);
		return "redirect:/zwierzak";		
	}
	
	//Usunięcie wpisu
	@GetMapping("/zwierzak/{id}")
	public String deleteZwierzak(@PathVariable Long id) {
		zwierzakService.deleteZwierzakById(id);
		return "redirect:/zwierzak";
	}
	
}
