package Modelo;

public class PedidoDetalle {

    private int idPedidoDetalle;
    private double cantidad;
    private double total;
    private int PedidoCabecera_idPedidoCabecera;
    private int Productos_idProductos;
    private int Unidades_idUnidades;

    public int getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(int idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPedidoCabecera_idPedidoCabecera() {
        return PedidoCabecera_idPedidoCabecera;
    }

    public void setPedidoCabecera_idPedidoCabecera(int PedidoCabecera_idPedidoCabecera) {
        this.PedidoCabecera_idPedidoCabecera = PedidoCabecera_idPedidoCabecera;
    }

    public int getProductos_idProductos() {
        return Productos_idProductos;
    }

    public void setProductos_idProductos(int Productos_idProductos) {
        this.Productos_idProductos = Productos_idProductos;
    }

    public int getUnidades_idUnidades() {
        return Unidades_idUnidades;
    }

    public void setUnidades_idUnidades(int Unidades_idUnidades) {
        this.Unidades_idUnidades = Unidades_idUnidades;
    }

}
