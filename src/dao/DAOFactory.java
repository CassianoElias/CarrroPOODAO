/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author 201401665
 */
public class DAOFactory {
    private static PessoaDAO pDAO = new PessoaDAO();
    private static CarroDAO cDAO = new CarroDAO();
    
    public static PessoaDAO getPessoaDAO(){
        return pDAO;
    }

    public static CarroDAO getCarroDAO() {
       return cDAO;
    } 
}
