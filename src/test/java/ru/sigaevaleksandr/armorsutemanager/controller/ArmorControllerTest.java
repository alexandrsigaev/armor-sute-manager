package ru.sigaevaleksandr.armorsutemanager.controller;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.service.ArmorService;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArmorController.class)
public class ArmorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ArmorService armorService;

    @Test
    public void whenFindAll() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1);
        given(this.armorService.findAll())
                .willReturn(
                        new ArrayList<>(Lists.newArrayList(armor)
                        )
                );

        this.mockMvc.perform(
                get("/armor/").accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}]")
        );
    }

    @Test
    public void whenFindById() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1);
        given(this.armorService.findById(1))
                .willReturn(
                        Optional.of(armor)
                );

        this.mockMvc.perform(
                get("/armor/1").accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}")
        );
    }

    @Test
    public void whenCreate() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1);
        given(this.armorService.save(armor))
                .willReturn(armor);

        this.mockMvc.perform(
                post("/armor/").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}")
        ).andExpect(
                status().isCreated()
        );
    }

    @Test
    public void whenUpdate() throws Exception {
        this.mockMvc.perform(
                put("/armor/").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}")
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    public void whenDelete() throws Exception {
        this.mockMvc.perform(
                delete("/armor/1").accept(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        );
    }
}