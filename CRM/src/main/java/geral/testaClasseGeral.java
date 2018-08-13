/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geral;
import geral.Classe_Geral;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Flavio
 */

@ManagedBean

public class testaClasseGeral {
    
    private List<String> listatudo;
   
    
    public static void main(String[] args) throws SQLException {

        String Tabela = "imagens_site";
        Classe_Geral formularios = new Classe_Geral();
  
        //o primeiro ResultSet pega os campos, o Segundo a Quantidade de Camppos
        ResultSet rs, quantosCampos;
        rs = formularios.listar_tabela(Tabela);
        quantosCampos = formularios.quantosCampos(Tabela);

        String cpo = "";
        while (quantosCampos.next()) {
            cpo = quantosCampos.getString(1);
        }

         while (rs.next()) {
                for (int i = 1; i <= Integer.parseInt(cpo); i++) {
                System.out.println(rs.getString(i));
               }
         }
        
    }
}
