package com.maurizio.preventivi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("preventivoForm", new PreventivoForm());
        return "home";
    }

    @PostMapping("/calcola")
public String calcola(@ModelAttribute PreventivoForm preventivoForm, Model model) {

    Double prezzo = preventivoForm.getPrezzo();

    Double iva = prezzo * 0.22;
    Double totale = prezzo + iva;

    preventivoForm.setIva(iva);
    preventivoForm.setTotale(totale);

    model.addAttribute("preventivoForm", preventivoForm);
    model.addAttribute("messaggio", "Preventivo calcolato correttamente");

    return "home";
}

@PostMapping("/pdf")
public ResponseEntity<byte[]> generaPdf(@ModelAttribute PreventivoForm preventivoForm) {

    byte[] pdf = PdfService.generaPdf(preventivoForm);

    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=preventivo.pdf")
            .contentType(MediaType.APPLICATION_PDF)
            .body(pdf);
}
}