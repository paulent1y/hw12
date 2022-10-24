package by.paulent1y;

public class Triangle {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) {
        if (sideA < sideB + sideC && sideB < sideC + sideA && sideC < sideB + sideA) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        else {
            String s = "Triangle with sides " +
                    sideA + "," +
                    sideB + "," +
                    sideC + " cannot exist";
            throw new RuntimeException(s);
        }
    }

    public double getArea(){
        double area, sp;
        sp = (sideA + sideB + sideC) / 2;
        System.out.println(sp);
        area = Math.sqrt(sp * (sp - sideA) * (sp - sideB) * (sp - sideC));
        return area;
    }
}
