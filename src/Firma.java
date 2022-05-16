import java.util.Scanner;
class Sotrudnik {
    String fam, im, otch, doljnost;
    int oklad;
}

public class Firma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество сотрудников");
        int count = sc.nextInt();
        sc.nextLine();
        Sotrudnik[] sotr = new Sotrudnik[count];
        System.out.println("Введите информацияю о каждом сотруднике");
        for (int i=0; i<count; i++){
            sotr[i] = new Sotrudnik();
            System.out.println("Введите фамилию " + (i + 1) + " сотрудика");
            sotr[i].fam = sc.nextLine();
            System.out.println("Введите имя " + (i + 1) + " сотрудика");
            sotr[i].im = sc.nextLine();
            System.out.println("Введите отчество " + (i + 1) + " сотрудика");
            sotr[i].otch = sc.nextLine();
            System.out.println("Введите должность " + (i + 1) + " сотрудика");
            sotr[i].doljnost = sc.nextLine();
            System.out.println("Введите оклад " + (i + 1) + " сотрудика");
            sotr[i].oklad = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Фамилия\t Имя\t Отчество\t должность\t Оклад");
        for (int i=0; i< sotr.length; i++){
            System.out.println(sotr[i].fam + "\t" + sotr[i].im + "\t" + sotr[i].otch + "\t" + sotr[i].doljnost + "\t" + sotr[i].oklad);
        }
    }
}
