public class app {
    public static void main(String[] args){
        if(args.length<2){
            usage();
            return;
        }
        String path= args[0];
        int k=Integer.parseInt(args[1]);

        SatDecoder sat= new SatDecoder(path,k);
        String result=sat.decode();
        System.out.println(result);
    }

    public static void usage(){
        System.err.println("Usage : java -jar printSchur filepath NumberOfBox");
    }
}
