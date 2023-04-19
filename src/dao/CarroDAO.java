/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Carro;
import servicos.PessoaServicos;
import servicos.ServicosFactory;

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
    public ArrayList<Carro> getCarros(){
        ArrayList <Carro> carros = new ArrayList<>();
        
        try {
            Connection con = Conexao.getConexao();
            String sql = "select c.*, p.cpf as cpf from carros c join pessoas p on c.proprietario = p.idPessoa";
            // <<< JAVA | Script MYSQL >>>>
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Carro c = new Carro();
                c.setPlaca(rs.getString("placa"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setAnoFab(rs.getInt("anoFab"));
                c.setAnoMod(rs.getInt("anoMod"));
                c.setCor(rs.getString("cor"));
                c.setTpCambio(rs.getString("tpCambio"));
                c.setCombustivel(rs.getString("combustivel"));
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                c.setProprietario(pessoaS.getPessoaByDoc(rs.getString("cpf")));
                carros.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Carro.\n" + e.getMessage());
            
        }
        
        return carros;
    }// fim getCarro
    
    public Carro getCarroByDoc(String placa){
        Carro c = new Carro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select c.*, p.cpf as cpf from carros c join pessoas p on c.proprietario = p.idPessoa where placa = ? ";
            // <<< JAVA | Script MYSQL >>>>
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, placa);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                c.setPlaca(rs.getString("placa"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setAnoFab(rs.getInt("anoFab"));
                c.setAnoMod(rs.getInt("anoMod"));
                c.setCor(rs.getString("cor"));
                c.setTpCambio(rs.getString("tpCambio"));
                c.setCombustivel(rs.getString("combustivel"));
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                c.setProprietario(pessoaS.getPessoaByDoc(rs.getString("cpf")));
                
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar placa\n" + e.getMessage());
            
        }
        
        return c;
    }
    
    public void atualizarCarro(Carro cVO){
        try {
            Connection con = Conexao.getConexao();
            String sql = "update carros set cor = ?, tpCambio = ?, combustivel = ?, proprietario = ?, where placa = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getCor());
            pst.setString(2, cVO.getTpCambio());
            pst.setString(3, cVO.getCombustivel());
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
               pst.setInt(4, pessoaS.getPessoaByDoc(cVO.getProprietario().getCpf()).getIdPessoa());
                pst.setString(5, cVO.getPlaca());
                pst.executeUpdate();
               
        } catch (SQLException e) {
            System.out.println("Erro ao buscar placa.\n" + e.getMessage());
        }
    }
    
    public void deletarCarro(String placa){
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from carros where placa = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, placa);
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao deletar carro \n" + e.getMessage());
        }
    }
    
}// fim da clase
