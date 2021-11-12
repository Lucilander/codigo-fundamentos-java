package dao;
import bean.Bicicleta;
import bean.Venda;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class BicicletaDao 
{
   private static Connection conexao;
   public static void getConexao()
   {
       try{
           BicicletaDao.conexao = Conexao.getConexao();
       }catch(SQLException e1){
           System.out.print("\n SQLException: "+e1);
       }
   }
   
   //Função para adicionar bicicleta
   public static void adicionar(Bicicleta bicicleta) throws SQLException, ClassNotFoundException//arremessando os erros/ Tratamento de erros
   {       
        BicicletaDao.getConexao();
        PreparedStatement ps_estado;
        String s_msgSql = "insert into bicicleta(codigo,modelo,material,marchas,aro,suspensao,cor) values(?,?,?,?,?,?,?)";
        ps_estado =  BicicletaDao.conexao.prepareStatement(s_msgSql);
        ps_estado.setInt(1, bicicleta.getCodigo());
        ps_estado.setString(2, bicicleta.getModelo());
        ps_estado.setString(3, bicicleta.getMaterial());
        ps_estado.setInt(4, bicicleta.getMarchas());
        ps_estado.setString(5, bicicleta.getAro());
        ps_estado.setBoolean(6, bicicleta.isSuspensao());
        ps_estado.setString(7, bicicleta.getCor());
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n Bicicleta adicionada com sucesso.");
   }
   //Função para adicionar uma Venda
   public static void adicionarVenda(Venda vendas) throws SQLException, ClassNotFoundException
   {       
        BicicletaDao.getConexao();
        PreparedStatement ps_estado;
        String s_msgSql = "insert into venda(codigoVenda,fk_codigo,valor,dia,desconto) values(?,?,?,?,?)";
        ps_estado =  BicicletaDao.conexao.prepareStatement(s_msgSql);
        ps_estado.setInt(1, vendas.getCodigoVenda());
        ps_estado.setInt(2, vendas.getCodigoBVenda());
        ps_estado.setString(3, vendas.getValor());
        //convertendo LocalDate em Date
        LocalDate ld_data = vendas.getData(); 
        Date d_data = Date.from(ld_data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date jsd_data;
        jsd_data = new java.sql.Date(d_data.getTime());
        //-----------------------------------------------------------------------------------
        ps_estado.setDate(4,jsd_data);
        ps_estado.setInt(5, vendas.getDesconto());
       
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n Bicicleta adicionada com sucesso.");
   }
   
   //Função para buscar todas as bicicletas inseridas
    public static ArrayList<Bicicleta> buscarTodasBicicletas() throws SQLException, ClassNotFoundException 
    {        
            BicicletaDao.getConexao();
            ArrayList<Bicicleta> al_listaBicicletas = new ArrayList();       
            ResultSet rs_executaOperacao;        
            PreparedStatement ps_estado;       
            String s_operacao = "select * from bicicleta";        
            ps_estado = BicicletaDao.conexao.prepareStatement(s_operacao);       
            rs_executaOperacao = ps_estado.executeQuery();       
            while(rs_executaOperacao.next())
            {            
                Bicicleta bicicleta = new Bicicleta();          
                bicicleta.setCodigo((rs_executaOperacao.getInt("codigo")));           
                bicicleta.setModelo(rs_executaOperacao.getString("modelo"));      
                bicicleta.setMaterial(rs_executaOperacao.getString("material"));            
                bicicleta.setMarchas(rs_executaOperacao.getInt("marchas"));  
                bicicleta.setAro(rs_executaOperacao.getString("aro"));
                bicicleta.setSuspensao(rs_executaOperacao.getBoolean("suspensao"));
                bicicleta.setCor(rs_executaOperacao.getString("cor"));
                al_listaBicicletas.add(bicicleta);           
            }        
            rs_executaOperacao.close();
            ps_estado.close();
            return(al_listaBicicletas);
    }
    //Função para buscar todas as vendas feitas
    public static ArrayList<Venda> buscarTodasVendas() throws SQLException, ClassNotFoundException 
    {        
            BicicletaDao.getConexao();
            ArrayList<Venda> al_listaVendas = new ArrayList();       
            ResultSet rs_executaOperacao;        
            PreparedStatement ps_estado;       
            String s_operacao = "select * from venda";        
            ps_estado = BicicletaDao.conexao.prepareStatement(s_operacao);       
            rs_executaOperacao = ps_estado.executeQuery();       
            while(rs_executaOperacao.next())
            {            
                Venda venda = new Venda();          
                venda.setCodigoVenda((rs_executaOperacao.getInt("codigoVenda")));           
                venda.setCodigoBVenda(rs_executaOperacao.getInt("fk_codigo"));      
                venda.setValor(rs_executaOperacao.getString("valor"));             
                //-----------------------------------------------------Convertendo de Date para LocalDate 
                Date data = rs_executaOperacao.getDate("dia");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String s_data = dateFormat.format(data);
                DateTimeFormatter dtf_data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate lc_data = LocalDate.parse(s_data, dtf_data);
                venda.setData(lc_data);
                //----------------------------------------------------
                venda.setDesconto(rs_executaOperacao.getInt("desconto"));
                al_listaVendas.add(venda);           
            }        
            rs_executaOperacao.close();
            ps_estado.close();
            return(al_listaVendas);
    }
   
    //Função para atualizar a tabela de bicicletas
    public static void atualizar(Bicicleta bicicleta) throws SQLException, ClassNotFoundException
   {
        BicicletaDao.getConexao();
        PreparedStatement ps_estado;
        String s_msgSql = "update bicicleta set modelo=?, material=?, marchas=?, aro=?, suspensao=?, cor=? where codigo=?";
        ps_estado =  BicicletaDao.conexao.prepareStatement(s_msgSql);
        
        ps_estado.setString(1,bicicleta.getModelo());
        ps_estado.setString(2,bicicleta.getMaterial());
        ps_estado.setInt(3,bicicleta.getMarchas());
        ps_estado.setString(4,bicicleta.getAro());
        ps_estado.setBoolean(5,bicicleta.isSuspensao());
        ps_estado.setString(6,bicicleta.getCor());
        ps_estado.setInt(7,bicicleta.getCodigo());
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n Bicicleta foi alterada");
   } 
   
    //Função para atualizar a tabela de vendas
    public static void atualizarVendas(Venda vendas) throws SQLException, ClassNotFoundException
   {
        BicicletaDao.getConexao();
        PreparedStatement ps_estado;
        String s_msgSql = "update venda set codigoVenda=?, valor=?, dia=?, desconto=? where fk_codigo=?";
        ps_estado =  BicicletaDao.conexao.prepareStatement(s_msgSql);
        
        ps_estado.setInt(1, vendas.getCodigoVenda());
        ps_estado.setString(2, vendas.getValor());
        //convertendo LocalDate em Date
        LocalDate ld_data = vendas.getData(); 
        Date d_data = Date.from(ld_data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date jsd_data;
        jsd_data = new java.sql.Date(d_data.getTime());
        //-----------------------------------------------------------------------------------
        ps_estado.setDate(3,jsd_data);
        ps_estado.setInt(4, vendas.getDesconto());
        ps_estado.setInt(5,vendas.getCodigoBVenda());
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n Dados da venda foram alterados");
   }
    
    //Função para Remover
    public static void remover(int codigo) throws SQLException, ClassNotFoundException
   {
        BicicletaDao.getConexao();
        PreparedStatement ps_estado;
        String s_msgSql = "delete from bicicleta where codigo = ?";
        ps_estado =  BicicletaDao.conexao.prepareStatement(s_msgSql);
        ps_estado.setInt(1, codigo);
        ps_estado.execute();
        ps_estado.close();
        System.out.println("A bicicleta foi removida.");
   }
   
}
