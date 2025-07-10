package Ejercicio1_Prueba_IIB_2.Clases;

public class Producto {
    // Atributos de la clase
    private String codigo;
    private String nombreProducto;
    private String detalle;
    private double precio;
    private int stock;

    // Metodo constructor
    public Producto(String codigo, String nombreProducto, String detalle, double precio, int stock) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.detalle = detalle;
        this.precio = precio;
        this.stock = stock;
    }

    // Metodos set y get para los atributos
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
