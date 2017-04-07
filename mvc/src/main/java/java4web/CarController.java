package java4web;

import java4web.entity.CarProjection;
import java4web.services.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CarController {

    @Autowired
    CarService service;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("cars", service.findAll());
        service.findAll().forEach(e-> System.out.println(e.toString()));
        model.addAttribute("carProjection", new CarProjection());
        return "index";
    }


    @PostMapping("/")
    public String newCar(CarProjection carProjection){
        System.out.println(carProjection.toString());
        service.save(carProjection.getCar());
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id){
        service.delete(id);
        return "redirect:/";
    }

}
