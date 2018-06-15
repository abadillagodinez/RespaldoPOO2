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
        
//        FuncionalidadesServer func = new FuncionalidadesServer();   //Simulacion del reader del XML parser
//        Platillo p1 = new Platillo("pollo",1000,200,0,"Pollo rico","PRN");
//        Platillo p2 = new Platillo("Bistec",1500,400,0,"Bistec grande","PRN");
//        Platillo p3 = new Platillo("ensalada",1800,75,0,"Ensalada Saludable","PRN");
//        Platillo p4 = new Platillo("Crema de Hongos",2300,300,0,"Sopa deliciosa","PRN");
//        Platillo p5 = new Platillo("Casado Completo",3000,1000,0,"Almuerzo de lujo","PRN");
//        listaPlatillos[0]= p1;
//        listaPlatillos[1]= p2;
//        listaPlatillos[2]= p3;
//        listaPlatillos[3]= p4;
//        listaPlatillos[4]= p5;
//        
//        
//        //Orden de cliente*****************
//        
//        Platillo platillo1 = new Platillo("pollo",1000,200);    //nombre precio y calorias
//        OrdenCliente orden1 = new OrdenCliente(platillo1,4);//platillo y cantidad
//        
//        Platillo platillo2 = new Platillo("Crema de Hongos",1000,200);
//        OrdenCliente orden2 = new OrdenCliente(platillo2,1);//platillo y cantidad
//        
//        Platillo platillo3 = new Platillo("Casado Completo",3000,200);
//        OrdenCliente orden3 = new OrdenCliente(platillo3,1);//platillo y cantidad
//        
//        OrdenCliente[] ordenes = new OrdenCliente[100];
//        ordenes[0] = orden1;    //crea un array de ordenes
//        ordenes[1] = orden2;
//        ordenes[2] = orden3;
//      
//        
//        
//        
//        Pedido pedidoTotal= new Pedido("Marco","Moravia","direccion",1300,100,"EXPRESS",ordenes);   //crea un pedido general
//        
//        //se manda pedido por el socket
//        
//        func.procesarPedido(pedidoTotal);
//        
//        //System.out.println("precio final:"+func.getPrecioTotal());
//        //System.out.println("Calorias:"+func.getCaloriasTotal());
//        
//        System.out.println(func.topZero());
//        System.out.print(func.topTen());
//        
//        
//        
    }
    
    
}
