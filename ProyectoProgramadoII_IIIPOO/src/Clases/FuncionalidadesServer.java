/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;




public class FuncionalidadesServer {
    
    
    
    public static Platillo[] listaPlatillos;    //base de platillos totales
    public static double precioTotal;
    public static int caloriasTotales;
    
    public FuncionalidadesServer(){
        listaPlatillos = new Platillo[100];
    }
    
    public double getPrecioTotal(){
        return precioTotal;
    }
    public double getCaloriasTotal(){
        return caloriasTotales;
    }
    
    
    public void procesarPedido(Pedido pedido){      //recibo un pedido
        OrdenCliente[] orden = pedido.getPlatillos();
        
        int cont = 0;
        
        while(orden[cont] != null){
            Platillo platillo = orden[cont].getPlatillo();
            int cantidad = orden[cont].getCantidad();
            int calorias = platillo.getCalorias();
            double precioTotalPlato = platillo.getPrecio()*cantidad;
            int calTotal = platillo.getCalorias()*cantidad;
            precioTotal+=precioTotalPlato;
            caloriasTotales+=calTotal;
            int pos = buscarPlatillo(platillo);
            listaPlatillos[pos].cantPedidos+=cantidad;
            cont++;
         
        
        }
        System.out.println("pedido procesado");
        
        
    }
    public int buscarPlatillo(Platillo pl){
        int cont =0;
        int resul = 0;
        int size = listaPlatillos.length;
        while(cont<size){
            Platillo plVector = listaPlatillos[cont];
            if (pl.nombre.equals(plVector.nombre)){
                   resul = cont; 
                   break;
            }
            else{
                cont++;
            }
        }
        return resul;
        
    }
    
    public String topTen(){
        int contador = 0;
        int contTop = 0;
        int cantMasAlta=0;
        int place = 1;
        Platillo[] aux = listaPlatillos;
        String resul = "";
        
        while(listaPlatillos[contador]!=null){
            Platillo platillo = listaPlatillos[contador];
            if(platillo.cantPedidos>cantMasAlta){
                cantMasAlta = platillo.cantPedidos;
                contador++;
            }
            else{
                contador++;
            }
        }
        contador = 0;
        resul+="Top 10:\n";
        while(contTop<10 && contTop<arrSize(aux)){
            while(contador<arrSize(aux)){
                Platillo pl = aux[contador];
                if(pl.cantPedidos == cantMasAlta){
                    resul+=String.valueOf(place)+". "+pl.getNombre()+"("+pl.getCodClave()+")"+":"+pl.getDescripcion()+"\n";
                    contTop+=1;
                    contador++;
                    place++;
                    
                }
                else{
                    contador++;
                }
            }
            contador = 0;
            cantMasAlta--;
            
            
        }
        return resul;
    }
    public int arrSize(Platillo[]p){
        int cont=0;
        while(p[cont]!=null){
            cont++;
        }
        return cont;
    }
    
    public String topZero(){
        int cont = 0;
        String resul = "";
        int posicion =1;
        resul+="Top 0:\n";
        while(listaPlatillos[cont]!= null){
            Platillo p = listaPlatillos[cont];
            if(p.cantPedidos == 0){
                
                resul+=String.valueOf(posicion)+". "+ p.getNombre()+"("+p.getCodClave()+")"+"\n";
                posicion++;
                cont++;
            }
            else{
                cont++;
            }
        }
        return resul;
        
    }

    
    
    public static void main(String args[]){
 
        
        
    }
    
    
}
