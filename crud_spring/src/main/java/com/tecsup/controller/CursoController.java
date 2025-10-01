package com.tecsup.controller;

import com.tecsup.model.entities.Curso;
import com.tecsup.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("curso")
public class CursoController {
    @Autowired
    private CursoService servicio;
    //listado
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de cursos");
        model.addAttribute("cursos", servicio.findAllCourse());
        return "listarView";
    }

    // Mostrar formulario para crear curso
    @GetMapping("/form")
    public String crearCurso(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("titulo", "Formulario de Curso");
        return "formCursoView"; // plantilla para el formulario
    }

    //Guardar
    @PostMapping("/form")
    public String guardarCurso(@ModelAttribute("curso") Curso curso) {
        servicio.saveCourse(curso);
        return "redirect:/listar"; // redirige a listado después de guardar
    }

    //Eliminar
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable("id") int id) {
        servicio.deleteCourse(id);
        return "redirect:/listar";
    }

    //Buscar


    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public String buscar(@RequestParam("nombre") String nombre, Model model) {
        model.addAttribute("titulo", "Resultado de búsqueda");
        model.addAttribute("cursos", servicio.findByNombre(nombre));
        return "listarView"; // reutilizamos la vista de listado para mostrar resultados
    }

}
