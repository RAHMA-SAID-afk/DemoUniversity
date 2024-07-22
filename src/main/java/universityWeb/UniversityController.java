package universityWeb;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UniversityController {
    private final UniversityService service;

    public UniversityController(UniversityService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String getHome(){
        return "home"; //View name
    }

    @GetMapping("/Register")
    public String getRegister(){
        return "Register";
    }

//    @GetMapping("/view")
//    public String getView(){
//        return "ViewAll";
//    }

    @PostMapping("/save")
    public String saveUniversity(@ModelAttribute University university){
        service.insertUniversity(university);
        return "redirect:/All";
    }

//    @GetMapping("/All")
//    public String getAll(Model model , @Param("keyword") long keyword ){
//        List<University> list = service.getAllUniversity();
//        model.addAttribute("universities" , list);
//       // model.addAttribute("keyword" , keyword);
//        return "viewAll";
//    }

   @GetMapping("/All")
    public String getAll(Model model, @Param("keyword") Long keyword){
        List<University> list = service.getAllUniversity(keyword);
        model.addAttribute("universities" , list);
        model.addAttribute("keyword" , keyword);
        return "viewAll";
    }


    @RequestMapping("/delete/{id}")
    public  String deleteUniversity(@PathVariable long id){
        service.deleteUniversity(id);
        return "redirect:/All";
    }

    ///Update or Edit
    @RequestMapping("/Edit/{id}")
    public String UpdateUniversity( @PathVariable long id , Model model){
        University university = service.getUniversityById(id);
        model.addAttribute("university", university);
        return "EditUniversity";

    }

}
