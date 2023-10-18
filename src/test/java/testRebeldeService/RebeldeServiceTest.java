package testRebeldeService;

import jakarta.persistence.EntityNotFoundException;
import org.example.controller.RebeldeRequest;
import org.example.model.RebeldeModel;
import org.example.repository.RebeldeRepository;
import org.example.service.RebeldeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RebeldeServiceTest {

    @InjectMocks
    private RebeldeService rebeldeService;

    @Mock
    private RebeldeRepository rebeldeRepository;

//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void deveRetornarCriacaoRebeldesComSucesso() {
        //preparar
        RebeldeRequest rebeldeRequest = new RebeldeRequest();

        rebeldeRequest.setNome("rebelde");
        rebeldeRequest.setIdade(30);
        rebeldeRequest.setGenero("masculino");
        rebeldeRequest.setLocalizacao("base rebelde");

        Map<String, Double> inventario = new HashMap<>();
        inventario.put("Arma", 100.0);
        inventario.put("Comida", 15.0);
        rebeldeRequest.setInventario(inventario);

        when(rebeldeRepository.save(any(RebeldeModel.class))).thenReturn(new RebeldeModel());

        // testar
        RebeldeModel resultado = rebeldeService.adicionarRebeldes(rebeldeRequest);

        // validar
        assertNotNull(resultado);

        verify(rebeldeRepository, times(1)).save(any(RebeldeModel.class));

    }

    @Test
    public void deveRetornarErroAoTestarCriarRebeldesComNomeNulo() {
        //preparar
        RebeldeRequest rebeldeRequest = new RebeldeRequest();

        rebeldeRequest.setNome(null);
        rebeldeRequest.setIdade(30);
        rebeldeRequest.setGenero("masculino");
        rebeldeRequest.setLocalizacao("base rebelde");

        Map<String, Double> inventario = new HashMap<>();
        inventario.put("Arma", 100.0);
        inventario.put("Comida", 15.0);
        rebeldeRequest.setInventario(inventario);

        // testar
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rebeldeService.adicionarRebeldes(rebeldeRequest);
        });

        // validar
        assertEquals("Todos os campos obrigatórios devem ser fornecidos.", exception.getMessage());

        verify(rebeldeRepository, times(0)).save(any(RebeldeModel.class));

    }

    @Test
    public void deveRetornarErroAoTestarCriarRebeldesComIdadeZero() {
        //preparar
        RebeldeRequest rebeldeRequest = new RebeldeRequest();

        rebeldeRequest.setNome("rebelde");
        rebeldeRequest.setIdade(0);
        rebeldeRequest.setGenero("masculino");
        rebeldeRequest.setLocalizacao("base rebelde");

        Map<String, Double> inventario = new HashMap<>();
        inventario.put("Arma", 100.0);
        inventario.put("Comida", 15.0);
        rebeldeRequest.setInventario(inventario);

        // testar
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rebeldeService.adicionarRebeldes(rebeldeRequest);
        });

        // validar
        assertEquals("Todos os campos obrigatórios devem ser fornecidos.", exception.getMessage());

        verify(rebeldeRepository, times(0)).save(any(RebeldeModel.class));

    }

    @Test
    public void testAtualizarLocalizacaoRebeldesComSucesso() {
        Long id = 1L;

        RebeldeModel rebeldeModel = new RebeldeModel();
        rebeldeModel.setId(id);
        rebeldeModel.setLocalizacao("Nova Localização");

        when(rebeldeRepository.findById(id)).thenReturn(Optional.of(rebeldeModel));
        when(rebeldeRepository.save(any(RebeldeModel.class))).thenReturn(rebeldeModel);

        RebeldeModel resultado = rebeldeService.atualizarLocalizacaoRebeldes(id, rebeldeModel);

        assertNotNull(resultado);

        verify(rebeldeRepository, times(1)).findById(id);

        verify(rebeldeRepository, times(1)).save(any(RebeldeModel.class));

        assertEquals("Nova Localização", resultado.getLocalizacao());
    }

    @Test
    public void testAtualizarLocalizacaoRebeldesComIdNaoEncontrado() {
        Long id = 1L;

        when(rebeldeRepository.findById(id)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            rebeldeService.atualizarLocalizacaoRebeldes(id, new RebeldeModel());
        });

        assertEquals("Rebelde não encontrado por esse id: " + id, exception.getMessage());

        verify(rebeldeRepository, times(1)).findById(id);

        verify(rebeldeRepository, never()).save(any(RebeldeModel.class));
    }


}


