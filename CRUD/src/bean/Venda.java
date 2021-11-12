package bean;
import java.time.LocalDate;

public class Venda 
{
    private int codigoVenda;
    private int codigoBVenda;
    private String valor;
    private LocalDate data;
    private int desconto;

    public Venda(int codigoVenda,int codigoBVenda, String valor, LocalDate data, int desconto) {
        this.codigoVenda = codigoVenda;
        this.codigoBVenda = codigoBVenda;
        this.valor = valor;
        this.data = data;
        this.desconto = desconto;
    }
    
    public Venda() {
        this.codigoVenda = 000;
        this.codigoBVenda = 000;
        this.valor = "Sem valor";
        this.data = data;
        this.desconto = 000;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoBVenda() {
        return codigoBVenda;
    }

    public void setCodigoBVenda(int codigoBVenda) {
        this.codigoBVenda = codigoBVenda;
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigoVenda=" + codigoVenda +"Codigo da bicicleta: "+codigoBVenda+" valor= "+ valor + ", data=" + data + ", desconto=" + desconto + '}';
    }
    
    
}
