package bean;

public class Bicicleta //Espelho das Informações no banco de dados
{
    private int codigo;
    private String modelo;
    private String material;
    private int marchas;
    private String aro;
    private boolean suspensao;
    private String cor;

    public Bicicleta(int codigo, String nome, String material, int marchas, String aro, boolean suspensao, String cor) {
        this.codigo = codigo;
        this.modelo = nome;
        this.material = material;
        this.marchas = marchas;
        this.aro = aro;
        this.suspensao = suspensao;
        this.cor = cor;
    }
    
    public Bicicleta() {
        this.codigo = 000;
        this.modelo = "sem nome";
        this.material = "sem material";
        this.marchas = 000;
        this.aro = "sem aro";
        this.suspensao = true;
        this.cor = "sem cor";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getMarchas() {
        return marchas;
    }

    public void setMarchas(int marchas) {
        this.marchas = marchas;
    }

    public String getAro() {
        return aro;
    }

    public void setAro(String aro) {
        this.aro = aro;
    }

    public boolean isSuspensao() {
        return suspensao;
    }

    public void setSuspensao(boolean suspensao) {
        this.suspensao = suspensao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + "codigo=" + codigo + ", Modelo: " + modelo + ", material=" + material + ", marchas=" + marchas + ", aro=" + aro + ", suspensao=" + suspensao + ", cor=" + cor + '}';
    }
    
    
}
