/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.CarroDAO;
import dao.DAOFactory;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 201401665
 */
public class CarroServicos {
    public void cadastroCarro (Carro cVO){
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.cadastrarCarroDAO(cVO);
        
    }
    
    public ArrayList<Carro> getCarro(){
        CarroDAO cDAO =  DAOFactory.getCarroDAO();
        return cDAO.getCarros();
        
    }
    
    public Carro getCarroByDoc (String placa){
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.getCarroByDoc(placa);
    }
    
    public void atualizarCarro (Carro cVO){
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.atualizarCarro(cVO);
    }
    
    public void deletarCarro (String placa){
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.deletarCarro(placa);
    }
}
