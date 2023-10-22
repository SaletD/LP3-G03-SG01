class Automovil {
    private String placa;
    private int numPuertas;
    private String marca;
    private String modelo;
    private Motor motor;
    public Automovil (String placa, int numPuertas, String marca, String modelo){
        this.placa =placa;
        this.numPuertas=numPuertas;
        this.marca=marca;
        this.modelo=modelo;
    }
    
    public String obtenerPlaca(){
        return placa;
    }
    public void establecerPlaca(String placa){
        this.placa=placa;
    }
    public int obtenerNumPuertas() {
        return numPuertas;
    }
    public void establecerNumPuertas( int numPuertas){
        this.numPuertas=numPuertas;
    }
    public String obtenerMarca(){
        return marca;
    }
    public void establecerMarca(String marca){
        this.marca=marca;
    }
    public String obtenerModelo(){
        return modelo;
    }
    public void establecerModelo(String modelo){
        this.modelo=modelo;
    }
    public void establecerMotor(Motor motor){
        this.motor=motor;
    }
    public String toString(){
        String motorInfo=(motor !=null)?motor.toString():"Sin motor";
        return "Inforamción del automovil: \n"+
                "Placa: "+ obtenerPlaca()+ "\n"+
                "Número de puertas: "+obtenerNumPuertas()+"\n"+
                "Marca: "+obtenerMarca()+"\n"+
                "Modelo: "+obtenerModelo()+"\n"+
                "Motor: "+motorInfo;
    }
}
class Motor{
    private int numMotor;
    private int revPorMin;
    public Motor(int numMotor, int revPorMin){
        this.numMotor=numMotor;
        this.revPorMin=revPorMin;
    }
    public int obtenerNumMotor(){
        return numMotor;
    }
    public void establecerNumMotor(int numMotor){
        this.numMotor=numMotor;
    }
    public int obtenerRevPorMin(){
        return revPorMin;
    }
    public void establecerRevPorMin(int revPorMin){
        this.revPorMin=revPorMin;
    }
    public String toString(){
        return "Número de motor: "+obtenerNumMotor()+ "\n"+
               "Revoluciones por minuto: "+obtenerRevPorMin();
    }
}
public class TestAgregacion{
    public static void main(String [] args){
        Motor motor =new Motor(5678,6000);
        Automovil automovil1=new Automovil ("XYZ789", 2, "FORD", "MUSTANG");
        automovil1.establecerMotor(motor);
        Automovil automovil2=new Automovil ("GHI789", 4, "HONDA", "CIVIC");
        System.out.println(automovil1.toString());
        System.out.println();
        System.out.println(automovil2.toString());
    }
}
