/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Servico;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Edilson Jr
 */
public class ServicoDao {

    public static void atualizarplanilha(String usuario, FileItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void adicionarPergunta(String usuario, String pergunta, String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void adicionarServico(Servico servico, String usuario) {
        try {
            Connection conexao= ConnectionFactory.getConnection();
            String sql = "INSERT INTO `servico`(`cod_servico`, `dt_criacao_servico`, `descricao`,  `Intervalo_ligacoes`, `Usuario_cod_usuario`) VALUES (?,?,?,?)";
            usuario = "1";

            PreparedStatement declaracao = conexao.prepareStatement(sql);

            declaracao.setString(1, String.valueOf(servico.getCriacao()));
            declaracao.setString(2, servico.getDescricao());
            declaracao.setString(3, String.valueOf(servico.getIntervalo()));
            declaracao.setString(4, usuario);

//            SELECT `cod_servico`, `dt_criacao_servico`, `descricao`, `Dt_encerramento`, `Intervalo_ligacoes`, `Usuario_cod_usuario` FROM `servico` WHERE 1
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
