package modelo.dao;

import java.sql.*;
import connection.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaPrincipal;

public class UsuarioDAO {

    Connection conexao = ConnectionFactory.getConncetion();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    boolean check = false;

    //método para logar no sistema, retorna true ou false
    public boolean logar(String login, String senha) {
        String sql = "SELECT * FROM tbusuarios WHERE login=? AND senha=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            while (rs.next()) {
                check = true;
                TelaPrincipal main = new TelaPrincipal();
                main.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check; //se o login e senha não forem compatíveis, retorna false
    }

}
