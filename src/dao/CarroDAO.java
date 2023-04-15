/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Carro;
import servicos.PessoaServicos;

/**
 *
 * @author 201401665
 */
public class CarroDAO {
    
    public void cadastrarCarroDAO (Carro cVO){
        try {
            Connection con = Conexao.getConexao();
            String sql = "insert into carros values (null,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getPlaca());
            pst.setString(2, cVO.getMarca());
            pst.setString(3, cVO.getModelo());
            pst.setInt(4, cVO.getAnoFab());
            pst.setInt(5, cVO.getAnoMod());
            pst.setString(6, cVO.getCor());
            pst.setString(7, cVO.getTpCambio());
            pst.setString(8, cVO.getCombustivel());
            pst.setInt(9, cVO.getProprietario().getIdPessoa());
            pst.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao cadastrar Carro\n" + e.getMessage());
        }
            
    }
    
}
