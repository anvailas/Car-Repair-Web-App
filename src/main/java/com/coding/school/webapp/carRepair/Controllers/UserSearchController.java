package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UserSearchController {

    private static final String SEARCH_FORM = "searchForm";
    public static final String OWNER = "owner";
    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/searchOwner", method = RequestMethod.GET)
    public String getSearchView(Model model) {
        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "index";
    }

    @RequestMapping(value = "/searchOwner", method = RequestMethod.POST)
    public String doSearch(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        Owner owner = ownerService.findByEmailOrVat(searchForm.getEmail() , searchForm.getVat());

        if (owner == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Owner not found");
        }

        redirectAttributes.addFlashAttribute(OWNER, owner);
        return "redirect:/searchOwner";
    }
}