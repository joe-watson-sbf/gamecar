package com.sofka.dao;

import com.opencsv.CSVReader;
import com.sofka.domain.carro.Carro;
import com.sofka.domain.podio.Podio;
import com.sofka.utils.Utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class DAO {
    
    private static final String filepath="ganadores.csv";

    private static void saveToCsv(String data){
        if(!updatePuntos(data)){
            try {
                String datos = datosArchivo() + data;
                FileWriter fileWriter = new FileWriter(filepath);
    
                fileWriter.write(datos);
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {}
        }
    }

    private static String datosArchivo(){
        String datos ="";
        try {
            FileReader reader = new FileReader(filepath);
            CSVReader csvReader = new CSVReader(reader);
            

            for (String[] strings : csvReader.readAll()) {
                datos += strings[0] +","+ strings[1] +","+ strings[2] + "\n";
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return datos;
    }

    private static boolean updatePuntos(String data){
        boolean encontrado = false;
        String newData = "";
        String dataUpdate = "";
        try {
            FileReader reader = new FileReader(filepath);
            CSVReader csvReader = new CSVReader(reader);
            String[] datos = data.split(",");
            for (String[] strings : csvReader.readAll()) {
                if(datos[0].trim().equals(strings[0].trim())){
                    String punto = sumarPuntos(datos[2].trim(), strings[2].trim());
                    dataUpdate = strings[0] +","+ strings[1] +","+ punto + "\n";
                    encontrado = true;
                }else{
                    newData += strings[0] +","+ strings[1] +","+ strings[2] + "\n";
                }
            }
            FileWriter fileWriter = new FileWriter(filepath);
            newData +=dataUpdate;
            fileWriter.write(newData);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {}
        return encontrado;
    }

    private static String sumarPuntos(String data1, String data2){
        //"{conductor : Joseph, puesto: 1, puntos : 9}"
        data1=data1.replace("puntos : ", "").replace("}", "");
        data2=data2.replace("puntos : ", "").replace("}", "");
        int suma = Integer.parseInt(data1) + Integer.parseInt(data2);
        return "puntos : " + suma + "}";
    }

    public static void saveDataGanadores(Podio podio, List<Carro> listCarros){
        Carro carro1 = listCarros
                    .stream()
                    .filter(e-> podio.getPrimerLugar().getId()==e.getJugador().getId())
                    .findFirst().get();
        Carro carro2 = listCarros
                    .stream()
                    .filter(e-> podio.getSegundoLugar().getId()==e.getJugador().getId())
                    .findFirst().get();
        Carro carro3 = listCarros
                    .stream()
                    .filter(e-> podio.getTercerLugar().getId()==e.getJugador().getId())
                    .findFirst().get();
        
        
        saveToCsv("{conductor : "+carro1.getNombre()+", puesto: "+podio.getPrimerLugar().getPuesto()+", puntos : "+podio.getPrimerLugar().getPuntos()+"}\n");
        saveToCsv("{conductor : "+carro2.getNombre()+", puesto: "+podio.getSegundoLugar().getPuesto()+", puntos : "+podio.getSegundoLugar().getPuntos()+"}\n");
        saveToCsv("{conductor : "+carro3.getNombre()+", puesto: "+podio.getTercerLugar().getPuesto()+", puntos : "+podio.getTercerLugar().getPuntos()+"}\n");
        
    }

}
