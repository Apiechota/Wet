package pl.AP.wet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.AP.wet.entity.Harmonogram;
import pl.AP.wet.service.HarmonogramService;
import pl.AP.wet.service.ZabiegService;
import pl.AP.wet.service.ZwierzakService;



@Controller
public class HarmonogramController {
	
	private HarmonogramService harmonogramService;
	private ZabiegService zabiegService;
	private ZwierzakService zwierzakService;
	public HarmonogramController(HarmonogramService harmonogramService, ZabiegService zabiegService,ZwierzakService zwierzakService) {
		super();
		this.harmonogramService = harmonogramService;
		this.zabiegService = zabiegService;
		this.zwierzakService = zwierzakService;
	}
	

	
	
	// POkazanie wszystkich terminów w harmonogramie
	@GetMapping("/harmonograms")
	public String listHarmonograms(Model model) {
		model.addAttribute("harmonograms", harmonogramService.getHarmonogram());
		
		return "harmonograms";
	}
	
	
	
	@GetMapping("/harmonograms/new")
	public String createHarmonogramForm(Model model) {
		Harmonogram harmonogram = new Harmonogram();
		model.addAttribute("harmonograms", harmonogram);
		model.addAttribute("zabiegi", zabiegService.getAllZabieg());
		model.addAttribute("zwierzaki", zwierzakService.getAllZwierzak());
		return "create_harmonogram";
		
	}
	//Dodanie nowego terminu do harmonogramu 
	@PostMapping("/harmonograms")
	public String saveHarmonogram(@ModelAttribute("harmonograms") Harmonogram harmonogram) {
		harmonogramService.addTermin(harmonogram);
		return "redirect:/harmonograms";
	}
	//Edycja wpisu
	@GetMapping("/harmonograms/edit/{id}")
	public String editHarmonogramForm(@PathVariable Long id, Model model) {
		model.addAttribute("harmonograms", harmonogramService.getTerminById(id));
		model.addAttribute("zabiegi", zabiegService.getAllZabieg());
		model.addAttribute("zwierzaki", zwierzakService.getAllZwierzak());
		return "edit_harmonogram";
	}
	//Aktualizacja wpisu
	@PostMapping("/harmonograms/{id}")
	public String updateHarmonogram(@PathVariable Long id,
			@ModelAttribute("harmonograms") Harmonogram harmonogram,
			Model model) {
		Harmonogram existingHarmonogram = harmonogramService.getTerminById(id);
		existingHarmonogram.setId(id);
		existingHarmonogram.setZabieg(harmonogram.getZabieg());
		existingHarmonogram.setZwierzak(harmonogram.getZwierzak());
		existingHarmonogram.setData(harmonogram.getData());
		harmonogramService.updateTermin(existingHarmonogram);
		return "redirect:/harmonograms";		
	}
	
	//Usunięcie wpisu
	@GetMapping("/harmonograms/{id}")
	public String deleteHarmonogram(@PathVariable Long id) {
		harmonogramService.deleteTerminById(id);
		return "redirect:/harmonograms";
	}
	@GetMapping("/harmonograms/count")
	public String countHarmonogram(Model model) {
		model.addAttribute("harmonograms", harmonogramService.countTermin());
		return "harmonogram_count";
	}
}
