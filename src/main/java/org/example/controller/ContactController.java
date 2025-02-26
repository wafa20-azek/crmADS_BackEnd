package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Contact;
import org.example.service.IContactService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@AllArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    IContactService contactService;
    @GetMapping("/getall")
    public Iterable<Contact> getContact() {
        return contactService.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Contact getByIdContact(@PathVariable("id") Long id) {
        return contactService.findById(id).get();

    }

    @PostMapping("/addContact")
    public Contact addContact(@RequestBody Contact u) {
        return contactService.save(u);
    }

    @PutMapping("/updateContact")
    public Contact updateContact(@RequestBody Contact u) {
        return contactService.save(u);

    }


    @DeleteMapping("/deleteContact/{id}")
    public void deleteContact(@PathVariable("id") Long id) {
        contactService.deleteById(id);
    }

}
