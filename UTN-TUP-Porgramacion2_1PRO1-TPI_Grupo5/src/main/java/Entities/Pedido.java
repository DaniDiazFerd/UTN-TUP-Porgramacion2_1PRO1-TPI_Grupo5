package Entities;

import Enums.Estado;
import Enums.FormaPago;
import Interfaces.Calculable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Base implements Calculable {

    // Variables
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Usuario usuario;
    private List<DetallePedido> detalles;

    //Constructor


    public Pedido(Long id,
                  boolean eliminado,
                  LocalDateTime createdAt,
                  LocalDate fecha,
                  Estado estado,
                  Double total,
                  FormaPago formaPago,
                  Usuario usuario,
                  List<DetallePedido> detalles) {
        super(id, eliminado, createdAt);
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.formaPago = formaPago;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public void addDetallePedido(int cantidad, Double precio, Producto producto){

        double subtotal = cantidad * precio;

        DetallePedido detallePedido = new DetallePedido(0L,false, LocalDateTime.now(), cantidad , subtotal , producto);

        detalles.add(detallePedido);

        calcularTotal();

    }

    @Override
    public void calcularTotal() {
        total = 0.0;

        for(DetallePedido d : detalles){
            total += d.getSubtotal();
        }
    }

    public DetallePedido findeDetallePedidoByProducto(Producto producto){



    }

    public void deleteDetallePedidoByProducto(Producto producto){



    }

}
