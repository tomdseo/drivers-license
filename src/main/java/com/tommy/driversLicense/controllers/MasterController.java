package com.tommy.driversLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tommy.driversLicense.models.DLModel;
import com.tommy.driversLicense.models.PersonModel;
import com.tommy.driversLicense.services.MasterService;

@Controller
public class MasterController {
	@Autowired
	private MasterService masterService;
	static String[] states = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
	static Integer nextNumber = 1;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/persons/new";
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Add Person Page 
	@RequestMapping("/persons/new")
	public String newPersonPage(@ModelAttribute("person") PersonModel person) {
		return "driversLicense/new-person.jsp";
	}
	
	//Add Person Form
	@RequestMapping(value="/persons/new/add", method=RequestMethod.POST)
	public String newPersonForm(@Valid @ModelAttribute("person") PersonModel person, BindingResult result) {
		if (result.hasErrors()) {
			return "driversLicense/new-person.jsp";
		}
		masterService.addPerson(person);
		return "redirect:/licenses/new";
	}
	
	//Add License Page
	@RequestMapping("/licenses/new")
	public String newLicensePage(@ModelAttribute("DL") DLModel DL, Model model) {
		List<PersonModel> persons = masterService.allPersons();
		model.addAttribute("persons", persons);
		model.addAttribute("states", states);
		return "driversLicense/new-license.jsp";
	}
	
	//Add License Form
	@RequestMapping(value="/licenses/new/add", method=RequestMethod.POST)
	public String newLicenseForm(@Valid @ModelAttribute("DL") DLModel DL, BindingResult result) {
		StringBuilder number = new StringBuilder();
		number.append(nextNumber);
		while(number.length() < 6) {
			number.insert(0,  "0");
		}
		nextNumber += 1;
		masterService.addLicense(number.toString(), DL);
		DLModel dl = masterService.addLicense(number.toString(), DL);
		Long id = dl.getPerson().getId();
		String idString = Long.toString(id);
		return "redirect:/persons/"+idString;
	}
	
	//Profile Page
	@RequestMapping(value="/persons/{id}", method=RequestMethod.GET)
	public String findItemById(@PathVariable("id") Long id, Model model) {
		PersonModel person = masterService.findPerson(id);
		model.addAttribute("person", person);
		return "driversLicense/profile-page.jsp";
	}
	

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//  //Find Specific Item by Id
//  @RequestMapping(value="/items/{id}", method=RequestMethod.GET)
//  public String findItemById(@PathVariable("id") Long id, Model model) {
//	  Optional<TestModel> song = testService.showItem(id);
//	  model.addAttribute("item", item.get());
//	  return "test/show-item.jsp";
//  }
//	
//  //Find Specific Item by ATTRIBUTE
//  @RequestMapping(value="/search", method=RequestMethod.POST)
//  public String findItemByATTRIBUTE(@RequestParam("ATTRIBUTE") String ATTRIBUTE, Model model) {
//	  if(testService.findItem(ATTRIBUTE) != null) {
//		  List<TestModel> songs = testService.findItem(ATTRIBUTE);
//		  model.addAttribute("items", items);
//		  return "test/search-by-ATTRIBUTE.jsp";
//	  }
//  	  return "test/search-not-found.jsp";
//  }
//
//    //Part 1 for Edit (render user to edit page)
//    @RequestMapping("/items/{id}/edit")
//    public String editItem(@PathVariable("id") Long id, Model model) {
//        TestModel item = testService.findItemById(id);
//        model.addAttribute("item", item);
//        return "/items/edit.jsp";
//    }
//    
//    //Part 2 for Edit (actually saves the change in the database)
//    @RequestMapping(value="/items/{id}", method=RequestMethod.PUT)
//    public String updateItem(@Valid @ModelAttribute("item") ItemModel item, BindingResult result) {
//        if (result.hasErrors()) {
//            return "/items/edit.jsp";
//        } else {
//            testService.updateItem(item);
//            return "redirect:/dashboard";
//        }
//    }
//	
//	//Top Ten Items Page (ranking items by ATTRIBUTE)
//	@RequestMapping("/search/topTen")
//	public String topTenPage(Model model) {
//		if(testService.findTopTen().size() > 0) {
//			List<PandadoraModel> topItems = testService.findTopTen();
//			model.addAttribute("items", items);
//			return "test/top-ten-items.jsp";
//		}
//		return "top-ten-not-found.jsp";
//	}
//*/
}

