package br.upf.produtomarca.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
<<<<<<< Updated upstream
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
=======
>>>>>>> Stashed changes

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< Updated upstream
import com.jayway.jsonpath.JsonPath;
=======
>>>>>>> Stashed changes

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.MediaType;



import br.upf.produtomarca.dto.UserDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    public MockMvc mockMvc;

<<<<<<< Updated upstream
    // Você pode injetar outros serviços que são usados no UserController, como o UserService, aqui.
=======
>>>>>>> Stashed changes
    public Long userId;

    @BeforeEach
    public void setUp() {
<<<<<<< Updated upstream
        // Configurações de inicialização antes de cada teste, se necessário.
        // Aqui, você pode criar um usuário no banco de dados e armazenar o ID na variável userId.
=======
        // Configurações de inicialização antes de cada teste.
        // Aqui, criei um usuário no banco de dados e armazenar o ID na variável userId.
>>>>>>> Stashed changes
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Willian Padrao");
        userDTO.setEmail("willianpadrao@example.com");
        userDTO.setSenha("user1");

        try {
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aWxsaWFuYmlhenppZGVvbGl2ZWlyYUBnbWFpbC5jb20iLCJpc3MiOiJ1cGYiLCJpYXQiOjE2OTU1MjI0NDgsInBhc3N3b3JkIjoic2Rsa2pzZG9pam9ucHZmNjV2NGU2ZnY1ZTZ2ZXIiLCJleHAiOjE2OTgwNDI0NDh9.ZStKUderEBvMVwg4y6uWKvZRcdCKBF4-99AARVO145Q"; // Substitua pelo token real que você deseja usar.

            MvcResult result = mockMvc.perform(post("/produtomarca/user/inserir")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(userDTO))
                    .header("token", token))
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id").exists())
                    .andReturn();

            String responseJson = result.getResponse().getContentAsString();
            UserDTO responseUserDTO = new ObjectMapper().readValue(responseJson, UserDTO.class);
            userId = responseUserDTO.getId(); // Armazena o ID do usuário criado.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInserirUsuario() throws Exception {
<<<<<<< Updated upstream
        // Criando um objeto UserDTO para ser inserido no banco de dados.
=======
        // Criando um objeto UserDTO para ser inserido no BD.
>>>>>>> Stashed changes
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Willian Integracao");
        userDTO.setEmail("willianintegracao@example.com");
        userDTO.setSenha("mepassa123");

<<<<<<< Updated upstream
        // Converta o objeto UserDTO em JSON para enviar na solicitação POST.
        String userDTOJson = new ObjectMapper().writeValueAsString(userDTO);

        // Faça uma solicitação POST para o endpoint de inserção de usuário e obtenha a resposta.
=======
        // Convertendo o objeto UserDTO em JSON para enviar na solicitação POST.
        String userDTOJson = new ObjectMapper().writeValueAsString(userDTO);

        // Fazendo uma solicitação POST para o endpoint de inserção de usuário e trazendo a resposta.
>>>>>>> Stashed changes
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aWxsaWFuYmlhenppZGVvbGl2ZWlyYUBnbWFpbC5jb20iLCJpc3MiOiJ1cGYiLCJpYXQiOjE2OTU1MjI0NDgsInBhc3N3b3JkIjoic2Rsa2pzZG9pam9ucHZmNjV2NGU2ZnY1ZTZ2ZXIiLCJleHAiOjE2OTgwNDI0NDh9.ZStKUderEBvMVwg4y6uWKvZRcdCKBF4-99AARVO145Q"; // Substitua pelo token real que você deseja usar.
        MvcResult result = mockMvc.perform(post("/produtomarca/user/inserir")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDTOJson)
<<<<<<< Updated upstream
                .header("token", token)) // Adicione o cabeçalho token aqui
                .andExpect(status().isCreated()) // Verifique se a resposta tem status 201 (Created).
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()) // Verifique se a resposta contém um campo "id" no JSON retornado.
                .andReturn(); // Captura a resposta

        // Converta o JSON de resposta em um objeto UserDTO.
        String responseJson = result.getResponse().getContentAsString();
        UserDTO responseUserDTO = new ObjectMapper().readValue(responseJson, UserDTO.class);
        
        // Verifique se o objeto retornado está igual ao objeto criado.
=======
                .header("token", token))
                .andExpect(status().isCreated()) // verificando se a resposta tem status 201 (Created).
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()) // verificando se a resposta contém um campo "id" no JSON retornado.
                .andReturn(); // Capturando a resposta

        // Convertendo o JSON de resposta em um objeto UserDTO.
        String responseJson = result.getResponse().getContentAsString();
        UserDTO responseUserDTO = new ObjectMapper().readValue(responseJson, UserDTO.class);
        
        // Verificando se o objeto retornado está igual ao objeto criado.
>>>>>>> Stashed changes
        assertEquals("Willian Integracao", responseUserDTO.getNome());
        assertEquals("willianintegracao@example.com", responseUserDTO.getEmail());
        assertEquals("mepassa123", responseUserDTO.getSenha());

        
}
    
    @Test
    public void testListarTodosUsuarios() throws Exception {
<<<<<<< Updated upstream
        // Faça uma solicitação GET para o endpoint de listagem de usuários e verifique a resposta.
=======
        // Fazendo uma solicitação GET para o endpoint de listagem de usuários e verificando a resposta.
>>>>>>> Stashed changes
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aWxsaWFuYmlhenppZGVvbGl2ZWlyYUBnbWFpbC5jb20iLCJpc3MiOiJ1cGYiLCJpYXQiOjE2OTU1MjI0NDgsInBhc3N3b3JkIjoic2Rsa2pzZG9pam9ucHZmNjV2NGU2ZnY1ZTZ2ZXIiLCJleHAiOjE2OTgwNDI0NDh9.ZStKUderEBvMVwg4y6uWKvZRcdCKBF4-99AARVO145Q"; // Substitua pelo token real que você deseja usar.
        MvcResult result = mockMvc.perform(get("/produtomarca/user/listarTodos")
                .header("token", token))
                .andExpect(status().isOk()) // Verifique se a resposta tem status 200 (OK).
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
<<<<<<< Updated upstream
                .andReturn(); // Captura a resposta

        // Converta o JSON de resposta em uma lista de UserDTO.
=======
                .andReturn(); // Capturando a resposta

        // Convertendo o JSON de resposta em uma lista de UserDTO.
>>>>>>> Stashed changes
        String responseJson = result.getResponse().getContentAsString();
        List<UserDTO> userList = new ObjectMapper().readValue(responseJson, new TypeReference<List<UserDTO>>() {});
        
        assertFalse(userList.isEmpty());

<<<<<<< Updated upstream
        // Ou verificar se a lista contém um usuário específico com base em algum critério.
        // Por exemplo, verificar se há um usuário com um nome específico.
        boolean hasUserWithName = userList.stream().anyMatch(user -> user.getNome().equals("Willian Integracao"));
        assertTrue(hasUserWithName);
    }

    @Test
    public void testRemoverUsuario() throws Exception {
        // Criando um objeto UserDTO para ser inserido no banco de dados.
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Usuário Para Remover");
        userDTO.setEmail("usuarioapagar@example.com");
        userDTO.setSenha("apaga123");

        // Converta o objeto UserDTO em JSON para enviar na solicitação POST.
        String userDTOJson = new ObjectMapper().writeValueAsString(userDTO);

        // Faça uma solicitação POST para o endpoint de inserção de usuário e obtenha a resposta.
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aWxsaWFuYmlhenppZGVvbGl2ZWlyYUBnbWFpbC5jb20iLCJpc3MiOiJ1cGYiLCJpYXQiOjE2OTU1MjI0NDgsInBhc3N3b3JkIjoic2Rsa2pzZG9pam9ucHZmNjV2NGU2ZnY1ZTZ2ZXIiLCJleHAiOjE2OTgwNDI0NDh9.ZStKUderEBvMVwg4y6uWKvZRcdCKBF4-99AARVO145Q"; // Substitua pelo token real que você deseja usar.
        MvcResult result = mockMvc.perform(post("/produtomarca/user/inserir")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDTOJson)
                .header("token", token))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andReturn();

        // Converta o JSON de resposta em um objeto UserDTO.
        String responseJson = result.getResponse().getContentAsString();
        UserDTO responseUserDTO = new ObjectMapper().readValue(responseJson, UserDTO.class);

        // Certifique-se de que o userId não é nulo.
        assertNotNull(responseUserDTO.getId());

        // Obtém o ID do usuário criado.
        Long userId = responseUserDTO.getId();

        // Agora que o usuário foi criado, faça uma solicitação DELETE para removê-lo.
        mockMvc.perform(delete("/produtomarca/user/delete/{id}", userId)
                .header("token", token))
                .andExpect(status().isNoContent()); // Verifique se a resposta tem status 204 (No Content).

        // Verifique se o usuário foi removido corretamente.
        mockMvc.perform(get("/produtomarca/user/buscarPorId/{id}", userId)
                .header("token", token))
                .andExpect(status().isNotFound()); // Verifique se a resposta tem status 404 (Not Found) após a remoção.
    }

    @Test
    public void testAtualizarUsuario() throws Exception {
        // Criando um objeto UserDTO para ser inserido no banco de dados.
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Willian Atualizar");
        userDTO.setEmail("willianatualizar@example.com");
        userDTO.setSenha("atualizar1");

        // Converta o objeto UserDTO em JSON para enviar na solicitação POST.
        String userDTOJson = new ObjectMapper().writeValueAsString(userDTO);

        // Faça uma solicitação POST para o endpoint de inserção de usuário e obtenha a resposta.
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aWxsaWFuYmlhenppZGVvbGl2ZWlyYUBnbWFpbC5jb20iLCJpc3MiOiJ1cGYiLCJpYXQiOjE2OTU1MjI0NDgsInBhc3N3b3JkIjoic2Rsa2pzZG9pam9ucHZmNjV2NGU2ZnY1ZTZ2ZXIiLCJleHAiOjE2OTgwNDI0NDh9.ZStKUderEBvMVwg4y6uWKvZRcdCKBF4-99AARVO145Q"; // Substitua pelo token real que você deseja usar.
        MvcResult result = mockMvc.perform(post("/produtomarca/user/inserir")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDTOJson)
                .header("token", token))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andReturn();

        // Converta o JSON de resposta em um objeto UserDTO.
        String responseJson = result.getResponse().getContentAsString();
        UserDTO responseUserDTO = new ObjectMapper().readValue(responseJson, UserDTO.class);

        // Certifique-se de que o userId não é nulo antes de prosseguir.
        assertNotNull(responseUserDTO.getId());

        // Atualize o usuário com novos dados.
        Long userId = responseUserDTO.getId();
        UserDTO updatedUserDTO = new UserDTO();
        updatedUserDTO.setId(userId);
        updatedUserDTO.setNome("Nome Atualizado");
        updatedUserDTO.setEmail("nomeatualizado@example.com");
        updatedUserDTO.setSenha("novasenha");

        // Converta o objeto UserDTO atualizado em JSON para enviar na solicitação PUT.
        String updatedUserDTOJson = new ObjectMapper().writeValueAsString(updatedUserDTO);

        // Faça uma solicitação PUT para o endpoint de atualização de usuário e verifique a resposta.
        mockMvc.perform(put("/produtomarca/user/atualizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedUserDTOJson)
                .header("token", token))
                .andExpect(status().isNoContent()); // Verifique se a resposta tem status 204 (No Content).

        // Faça uma solicitação GET para obter o usuário atualizado.
        MvcResult getResult = mockMvc.perform(get("/produtomarca/user/buscarPorId/{userId}", userId)
                .header("token", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Converta o JSON de resposta em um objeto UserDTO para verificar as atualizações.
        String updatedUserJson = getResult.getResponse().getContentAsString();
        UserDTO updatedUser = new ObjectMapper().readValue(updatedUserJson, UserDTO.class);

        // Verifique se os dados foram atualizados corretamente.
        assertEquals("Nome Atualizado", updatedUser.getNome());
        assertEquals("nomeatualizado@example.com", updatedUser.getEmail());
        assertEquals("novasenha", updatedUser.getSenha());
    }

=======
        // Verificando se a lista contém um usuário específico.
        boolean hasUserWithName = userList.stream().anyMatch(user -> user.getNome().equals("Willian Integracao"));
        assertTrue(hasUserWithName);
    }
    
    @Test
    public void testAtualizarUsuario() throws Exception {
        assertNotNull(userId);

        // Criando um objeto UserDTO com os dados atualizados.
        UserDTO userDTOAtualizado = new UserDTO();
        userDTOAtualizado.setId(userId);
        userDTOAtualizado.setNome("Novo Nome");
        userDTOAtualizado.setEmail("novonome@example.com");
        userDTOAtualizado.setSenha("novasenha");

        // Convertendo o objeto UserDTO em JSON para enviar na solicitação PUT.
        String userDTOJson = new ObjectMapper().writeValueAsString(userDTOAtualizado);

        // Fazendo uma solicitação PUT para o endpoint de atualização de usuário.
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aWxsaWFuYmlhenppZGVvbGl2ZWlyYUBnbWFpbC5jb20iLCJpc3MiOiJ1cGYiLCJpYXQiOjE2OTU1MjI0NDgsInBhc3N3b3JkIjoic2Rsa2pzZG9pam9ucHZmNjV2NGU2ZnY1ZTZ2ZXIiLCJleHAiOjE2OTgwNDI0NDh9.ZStKUderEBvMVwg4y6uWKvZRcdCKBF4-99AARVO145Q"; // Substitua pelo token real.

        // Modificando a solicitação PUT para enviar o ID no corpo da solicitação.
        mockMvc.perform(put("/produtomarca/user/atualizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDTOJson)
                .header("token", token))
                .andExpect(status().isNoContent()); // Verificando se a resposta tem status 204 (NoContent).
    }

    @Test
    public void testRemoverUsuario() throws Exception {
   
        assertNotNull(userId);

        // Realizando uma solicitação DELETE para remover o usuário pelo ID.
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aWxsaWFuYmlhenppZGVvbGl2ZWlyYUBnbWFpbC5jb20iLCJpc3MiOiJ1cGYiLCJpYXQiOjE2OTU1MjI0NDgsInBhc3N3b3JkIjoic2Rsa2pzZG9pam9ucHZmNjV2NGU2ZnY1ZTZ2ZXIiLCJleHAiOjE2OTgwNDI0NDh9.ZStKUderEBvMVwg4y6uWKvZRcdCKBF4-99AARVO145Q"; // Substitua pelo token real.
        mockMvc.perform(delete("/produtomarca/user/delete")
                .header("token", token)
                .header("id", userId.toString())) // Passa o ID do usuário a ser removido.
                .andExpect(status().isNoContent()); // Verifica se a resposta tem status 204 (No Content).

        // Tente buscar o usuário pelo ID após a remoção e verifique se a resposta é 404 (Not Found).
        mockMvc.perform(get("/produtomarca/user/buscarPorId/{id}", userId)
                .header("token", token))
                .andExpect(status().isNotFound());
    }
  
>>>>>>> Stashed changes

}
