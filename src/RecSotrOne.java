import java.util.Scanner;

class SotrudnikWithChild {
    String fam, im, otch, doljnost;
    int kolDet;
    Child[] child = null;
}

class Child {
    String nameR;
    int ageR;
}

public class RecSotrOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество сотрудников");
        int count = sc.nextInt();
        sc.nextLine();
        SotrudnikWithChild[] sotr = new SotrudnikWithChild[count];
        System.out.println("Введите информацияю о каждом сотруднике");
        for (int i = 0; i < count; i++) {
            sotr[i] = new SotrudnikWithChild();
            System.out.println("Введите фамилию " + (i + 1) + " сотрудика");
            sotr[i].fam = sc.nextLine();
            System.out.println("Введите имя " + (i + 1) + " сотрудика");
            sotr[i].im = sc.nextLine();
            System.out.println("Введите отчество " + (i + 1) + " сотрудика");
            sotr[i].otch = sc.nextLine();
            System.out.println("Введите должность " + (i + 1) + " сотрудика");
            sotr[i].doljnost = sc.nextLine();
            System.out.println("Введите количество детей " + (i + 1) + " сотрудика");
            sotr[i].kolDet = sc.nextInt();
            sc.nextLine();
            if (sotr[i].kolDet != 0) {
                sotr[i].child = new Child[sotr[i].kolDet];
                System.out.println("Дети =>");
                for (int j = 0; j < sotr[i].child.length; j++) {
                    sotr[i].child[j] = new Child();
                    System.out.println("Введите имя " + (j + 1) + " ребенка");
                    sotr[i].child[j].nameR = sc.nextLine();
                    System.out.println("Введите возраст " + (j + 1) + " ребенка");
                    sotr[i].child[j].ageR = sc.nextInt();
                    sc.nextLine();
                }
            }
        }

        System.out.println("\nСотрудники фирмы \n фам \t имя \t отч \t должность");
        for (SotrudnikWithChild s : sotr){
            System.out.println(s.fam + "\t" + s.im + "\t" + s.otch + "\t" + s.doljnost);
            if (s.kolDet != 0){
            System.out.println("\n Дети: ");
            for (Child r : s.child) System.out.println("\t\t\t" + r.nameR + "\t\t" + r.ageR);
            System.out.println("");
            }
        }
    }
}