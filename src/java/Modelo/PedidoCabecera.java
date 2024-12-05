package Modelo;

public class PedidoCabecera {

    private int idPedidoCabecera;
    private int numeroPedido;
    private String fechaPedido;
    private int Persona_idPersona;

    public int getIdPedidoCabecera() {
        return idPedidoCabecera;
    }

    public void setIdPedidoCabecera(int idPedidoCabecera) {
        this.idPedidoCabecera = idPedidoCabecera;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getPersona_idPersona() {
        return Persona_idPersona;
    }

    public void setPersona_idPersona(int Persona_idPersona) {
        this.Persona_idPersona = Persona_idPersona;
    }

}
