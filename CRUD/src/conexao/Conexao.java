package conexao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class Conexao //Classe usada para ligar o codigo Java ao Banco(MySQL)
{
   public static Connection getConexao() throws SQLException
   {
       Connection conexao=null;
       try{//Tratando Erros
            Class.forName("com.mysql.jdbc.Driver");//Passo por parametro quem estou usando como Driver
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/FabricaBicicletas?autoReconnect=true&useSSL=false","root","123ajsk456dl");//Obtendo a conexão
       }catch(ClassNotFoundException e){
           System.out.print("\n Erro ao conectar: "+e.toString());
       }
       return(conexao);
    }
}
//jdbc : Conector
//linguagem de bacno: mysql
//local do banco de dados: LocalHost
//porta: 3306
//nome do projeto: FabricaBicicletas
//usuario e senha do banco: root, 123ajsk456dl