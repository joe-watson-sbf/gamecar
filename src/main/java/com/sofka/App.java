package com.sofka;
import java.util.List;

import com.sofka.dao.DAO;
import com.sofka.domain.carro.Carro;
import com.sofka.domain.juego.Juego;
import com.sofka.domain.pista.Carril;
import com.sofka.domain.podio.Podio;
import com.sofka.utils.Utils;
import com.sofka.utils.View;

public class App {

  public static void main(String[] args) {
      iniciarJuego();
  }



  public static void iniciarJuego(){
    /***Configurar Juego */
    View vista = View.instance();
    Juego juego = vista.crearJuego();

    Utils.clearConsole();
    Utils.Sleep(1000);

    /***Inicia el Juego */
    List<Carro> listCarros = vista.getCarros();
    List<Carril> carriles = Carril.asignarCarro(listCarros);

    Utils.Sleep(1000);

    if(juego.iniciar()){
        while(juego.isEjecutando()){
            juego.avanzarCarroEncarril(carriles);
            Utils.Sleep(1000);
        }
    }
    try {
      Podio podio = juego.ListarResultadoFinal();
      DAO.saveDataGanadores(podio, listCarros);
    } catch (Exception e) {}
    
  }




}
