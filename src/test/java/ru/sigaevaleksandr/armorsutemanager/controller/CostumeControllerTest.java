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
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.service.CostumeService;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CostumeController.class)
public class CostumeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CostumeService costumeService;

    @Test
    public void whenFindAll() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1);
        Costume costume = new Costume(1, "MARK1", 3, Lists.newArrayList(armor));
        given(this.costumeService.findAll())
                .willReturn(
                        new ArrayList<>(Lists.newArrayList(costume)
                        )
                );

        this.mockMvc.perform(
                get("/costume/").accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("[{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"createDate\""
                        + ":null,\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}],"
                        + "\"loadArmor\":0.3333333333333333}]")
        );

    }

    @Test
    public void whenFindByArtifact() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1);
        Costume costume = new Costume(1, "MARK1", 3, Lists.newArrayList(armor));
        given(this.costumeService.findByArtifact("test"))
                .willReturn(
                        new ArrayList<>(Lists.newArrayList(costume))
                );

        this.mockMvc.perform(
                get("/costume/find").param("param", "test")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("[{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"createDate\""
                        + ":null,\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}],"
                        + "\"loadArmor\":0.3333333333333333}]")
        );
    }

    @Test
    public void whenGetArmorLoad() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1);
        Costume costume = new Costume(1, "MARK1", 1, Lists.newArrayList(armor));

        given(this.costumeService.armorLoad(1))
                .willReturn(
                        1d
                );

        this.mockMvc.perform(
                get("/costume/fullness/1").accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("{\"percent\":\"100\"}")
        );
    }

    @Test
    public void whenFindById() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1);
        Costume costume = new Costume(1, "MARK1", 3, Lists.newArrayList(armor));
        given(this.costumeService.findById(1))
                .willReturn(
                        Optional.of(costume)
                );

        this.mockMvc.perform(
                get("/costume/1").accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"createDate\""
                        + ":null,\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}],"
                        + "\"loadArmor\":0.3333333333333333}")
        );
    }

    @Test
    public void whenCreate() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1);
        Costume costume = new Costume(1, "MARK1", 3, Lists.newArrayList(armor));
        given(this.costumeService.save(costume))
                .willReturn(costume);

        this.mockMvc.perform(
                post("/costume/").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"createDate\""
                                + ":null,\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}],"
                                + "\"loadArmor\":0.3333333333333333}")
        ).andExpect(
                status().isCreated()
        );
    }

    @Test
    public void whenUpdate() throws Exception {
        this.mockMvc.perform(
                put("/costume/").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"createDate\""
                                + ":null,\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\",\"idCostume\":1}],"
                                + "\"loadArmor\":0.3333333333333333}")
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    public void whenDelete() throws Exception {
        this.mockMvc.perform(
                delete("/costume/1").accept(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        );
    }
}