/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 201401665
 */
public class CPessoa {
    
    ArrayList<Pessoa> pessoas = new ArrayList<>();
    int idPessoa = 1;
    
    /**
     * Autoincrement idPessoa
     * @return 
     */
    public int geraID(){
        return this.idPessoa++;
    }
            
    /**
     * Método addPessoa adiciona Pessoa no ArrayList pessoas
     * @param p 
     */
    public void addPessoa(Pessoa p){
        this.pessoas.add(p);
    } 
    /**
     * Metodo remove Pessoa do ArrayList pessoas
     * @param p 
     */
    public void removePessoa(Pessoa p){
        this.pessoas.remove(p);
    }
    
    public ArrayList<Pessoa> getPessoa(){
        return this.pessoas;
    }
   /**
    *  Metodo getPessoaCPF retorna uma Pessoa caso encontre correspondencia no CPF do ArrayList pessoas, caso contrario retorna null.
    * @param CPF
    * @return 
    */
   public Pessoa getPessoaCPF(String CPF){
       Pessoa p = null;
       for(Pessoa pes:pessoas){
           if (pes.getCpf().equals(CPF)) {
             p = pes;
             break;
               
           }
       }//fim do foreach
       return p;
   } 
   
   public void mockPessoas(){
       Pessoa p1 = new Pessoa();
       p1.setIdPessoa(geraID());
       p1.setCpf("27769049083");
       p1.setNome("Juvenal das Coves");
       p1.setTelefone("51986121874");
       p1.setEndereco("Rua Alamo");
       addPessoa(p1);
       Pessoa p2 = new Pessoa();
       p2.setIdPessoa(geraID());
       p2.setCpf("84505671062");
       p2.setNome("Madalena das Coves");
       p2.setTelefone("51986121875");
       p2.setEndereco("Rua sem saida");
       addPessoa(p2);
       
   }
           
}//fim classe controller
