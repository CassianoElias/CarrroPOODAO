/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

/**
 *
 * @author 201401665
 */
public class ServicosFactory {
    private static PessoaServicos pessoaS = new PessoaServicos();
    private static CarroServicos carroS =   new CarroServicos();
    
    public static PessoaServicos getPessoaServicos(){
        return pessoaS;
    }
    
    public static CarroServicos getCarroServicos(){
        return carroS;
    }
}
