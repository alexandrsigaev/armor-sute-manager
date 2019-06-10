package ru.sigaevaleksandr.armorsutemanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.service.CostumeService;

import java.util.*;

@RestController
@RequestMapping("/costume")
public class CostumeController {

    private final CostumeService costumeService;

    public CostumeController(final CostumeService costumeService) {
        this.costumeService = costumeService;
    }

    @GetMapping("/")
    public List<Costume> findAll() {
        return new ArrayList<>(this.costumeService.findAll());
    }

    @GetMapping("/find")
    public List<Costume> findByArtifact(@RequestParam(name = "param") String param) {
        return new ArrayList<>(this.costumeService.findByArtifact(param));
    }

    @GetMapping("/fullness/{id}")
    public Map<String, String> getArmorLoad(@PathVariable int id) {
        double load = this.costumeService.armorLoad(id);
        return Collections.singletonMap("percent", String.format("%.0f", (load * 100)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costume> findById(@PathVariable int id) {
        Optional<Costume> costume = this.costumeService.findById(id);
        return new ResponseEntity<>(
                costume.orElse(new Costume()),
                costume.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Costume> create(@RequestBody Costume costume) {
        return new ResponseEntity<>(
                this.costumeService.save(costume),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Costume costume) {
        this.costumeService.save(costume);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Costume costume = new Costume();
        costume.setId(id);
        this.costumeService.delete(costume);
        return ResponseEntity.ok().build();
    }
}
