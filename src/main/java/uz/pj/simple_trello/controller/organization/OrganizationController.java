package uz.pj.simple_trello.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pj.simple_trello.controller.base.AbstractController;
import uz.pj.simple_trello.criteria.GenericCriteria;
import uz.pj.simple_trello.dto.organization.OrganizationCreateDto;
import uz.pj.simple_trello.dto.organization.OrganizationUpdateDto;
import uz.pj.simple_trello.services.organization.OrganizationService;

@Controller
@RequestMapping("/organization/")
public class OrganizationController extends AbstractController<OrganizationService> {


    @Autowired
    public OrganizationController(OrganizationService service) {
        super(service);
    }



    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "organization/create";
    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/organization/list";
    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping("detail/{id}/")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/detail";
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String listPage(Model model) {
//        model.addAttribute("organizations", service.getAll());
//        return "organization/list";
//    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/update";
    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable(name = "id") Long id, @ModelAttribute OrganizationUpdateDto dto) {
       dto.setId(id);
        service.update(dto);
        return "redirect:/organization/list";
    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/delete";
    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute Long id) {
        service.delete(id);
        return "redirect:/organization/list";
    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "organization/list";
    }
}
