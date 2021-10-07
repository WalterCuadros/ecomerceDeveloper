package com.ecommerce.dao;

public class FinalBD {
	public static final String URL="jdbc:mysql://localhost:3306/";
    public static final String DATABASE="gangazo";
    public static final String USER="root";
    public static final String PASSWORD="";
    
    public static final String T_CLIENTE="cliente";
    public static final String TC_ID="id";
    public static final String TC_NOMBRE="nombre";
    public static final String TC_CEDULA="cedula";
    public static final String TC_TARJETA="tarjeta";
    public static final String TC_EMAIL="email";
    
    public static final String T_PRODUCTO="producto";
    public static final String TP_ID="id";
    public static final String TP_CODIGO_BARRAS="codigo_barras";
    public static final String TP_NOMBRE="nombre";
    public static final String TP_TIPO_PRODUCTO="tipo_producto_id";
    public static final String TP_MARCA="marca";
    public static final String TP_FECHA_VENCIMIENTO="fecha_vencimiento";
    public static final String TP_PRECIO="precio";
    public static final String TP_DESCUENTO="descuento";
    public static final String TP_TIPO_PRODUCTO_NOMBRE="tipo_producto";
    
    public static final String T_CARRITO="carrito";
    public static final String TCAR_ID="id";
    public static final String TCAR_CLIENTE_ID="cliente_id";
    public static final String TCAR_IS_ACTIVE="is_active";
    
    
    public static final String T_COMPRA="compra";
    public static final String TCOM_ID="id";
    public static final String TCOM_VALOR_OBSEQUIO="valor_obsequio";
    public static final String TCOM_VALOR_TOTAL="valor_total";
    public static final String TCOM_FECHA="fecha";
    public static final String TCOM_CARRITO_ID="carrito_id";
    
    
    public static final String T_PRODUCTO_CARRITO ="productocarrito";
    public static final String TPC_ID = "id";
    public static final String TPC_CANTIDAD_PRODUCTO = "cantidad_producto";
    public static final String TPC_PRODUCTO_ID = "producto_id";
    public static final String TPC_IN_CARRITO = "in_carrito";
    public static final String TPC_CARRITO_ID = "carrito_id";
    
    public static final String T_TIPO_PRODUCTO = "tipo_producto";
    public static final String TTP_ID = "id";
    public static final String TTP_NOMBRE = "nombre";
}
