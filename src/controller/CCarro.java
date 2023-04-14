/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import inf3n212.carro.INF3N212Carro;
import static inf3n212.carro.INF3N212Carro.cadPessoa;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 201401665
 */
public class CCarro {
    ArrayList<Carro> carros = new ArrayList();
    
    public void addCarro(Carro c){
        this.carros.add(c);
    }
    public void removeCarro(Carro c){
        this.carros.remove(c);
        
    }
    
    public ArrayList<Carro> getCarros(){
        return this.carros;
    }
    
    public Carro getCarroPlaca (String placa){
        Carro c = null;
                
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)){
                c = carro;
                break;
            }
        }
        return c;        
    }
    
    public void mockCarros(){
      Carro c1 = new Carro();
      c1.setPlaca("GTI3989");
      c1.setAnoFab(2006);
      c1.setAnoMod(2007);
      c1.setMarca("Fiat");
      c1.setModelo("Palio");
      c1.setTpCambio("manual");
      c1.setCombustivel("flex");
      c1.setCor("prata");
      c1.setProprietario(cadPessoa.getPessoaCPF("27769049083"));
      addCarro (c1);
      Carro c2 = new Carro();
      c2.setPlaca("GTX1050");
      c2.setAnoFab(2023);
      c2.setAnoMod(2023);
      c2.setMarca("Fiat");
      c2.setModelo("Uno");
      c2.setTpCambio("Automatico");
      c2.setCombustivel("Plutonio");
      c2.setCor("Azul");
      c2.setProprietario(cadPessoa.getPessoaCPF("84505671062"));
      addCarro (c2);
     
      }
                   
} //fim da Classe CCarro
