

public class TestQuadTree {
    public static void main(String[] args) {
        ReprUnique Re = new ReprUnique();
        AQTCons Q0 = new AQTCons(Re.getRef(new Noir()), Re.getRef(new Blanc()), Re.getRef(new Blanc()), Re.getRef(new Noir()));
        AQTCons Q1 = new AQTCons(Re.getRef(new Noir()), Re.getRef(Q0), Re.getRef(new Noir()), Re.getRef(new Blanc()));
        System.out.println(Q1.toString());
    }
}
