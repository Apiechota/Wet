package pl.AP.wet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.AP.wet.entity.Wlasciciel;
import pl.AP.wet.service.WlascicielService;




@Controller
public class WlascicielController {
	
	private WlascicielService wlascicielService;

	public WlascicielController(WlascicielService wlascicielService) {
		super();
		this.wlascicielService = wlascicielService;
	}
	
	// POkazanie wszystkich  wlascicielów
	@GetMapping("/wlasciciel")
	public String listWlasciciel(Model model) {
		model.addAttribute("wlasciciel", wlascicielService.getAllWlasciciel());
		return "wlasciciel";
	}
	
	
	
	@GetMapping("/wlasciciel/new")
	public String createWlascicielForm(Model model) {
		Wlasciciel wlasciciel = new Wlasciciel();
		model.addAttribute("wlasciciel", wlasciciel);
		return "create_wlasciciel";
		
	}
	//Dodanie nowego wlasciciela 
	@PostMapping("/wlasciciel")
	public String saveWlasciciel(@ModelAttribute("wlasciciel") Wlasciciel wlasciciel) {
		wlascicielService.addWlasciciel(wlasciciel);
		return "redirect:/wlasciciel";
	}
	//Edycja wpisu
	@GetMapping("/wlasciciel/edit/{id}")
	public String editWlascicielForm(@PathVariable Long id, Model model) {
		model.addAttribute("wlasciciel", wlascicielService.getWlascicielById(id));
		return "edit_wlasciciel";
	}
	//Aktualizacja wpisu
	@PostMapping("/wlasciciel/{id}")
	public String updateWlasciciel(@PathVariable Long id,
			@ModelAttribute("wlasciciel") Wlasciciel wlasciciel,
			Model model) {
		Wlasciciel existingWlasciciel = wlascicielService.getWlascicielById(id);
		existingWlasciciel.setId(id);
		existingWlasciciel.setImie(wlasciciel.getImie());
		existingWlasciciel.setNazwisko(wlasciciel.getNazwisko());
		existingWlasciciel.setTelefon(wlasciciel.getTelefon());
		wlascicielService.updateWlasciciel(existingWlasciciel);
		return "redirect:/wlasciciel";		
	}
	
	//Usunięcie wpisu
	@GetMapping("/wlasciciel/{id}")
	public String deleteWlasciciel(@PathVariable Long id) {
		wlascicielService.deleteWlascicielById(id);
		return "redirect:/wlasciciel";
	}
	
}
