import javax.swing.plaf.IconUIResource;
import java.util.Scanner;
class Country {
    String name;
    double square;
}

public class InfoAboutCountries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество стран");
        int count = sc.nextInt();
        sc.nextLine();
        Country[] countries = new Country[count];
        System.out.println("Введите информация о стране");
        for (int i=0; i<countries.length; i++){
            countries[i] = new Country();
            System.out.println("Введите название " + (i + 1) + "-й страны");
            countries[i].name = sc.nextLine();
            System.out.println("Введите площадь " + (i + 1) + "-й страны");
            countries[i].square = sc.nextDouble();
            sc.nextLine();
        }
        System.out.println("Информация о странах");
        System.out.println("Название \t Площадь");
        for (int i=0; i<countries.length; i++){
            System.out.printf("%s \t %f \n", countries[i].name, countries[i].square);
        }
        //Поиск страны с максимальной площадью
        int indexMax = 0;
        double squareMax = countries[indexMax].square;
        for (int i=0; i<countries.length; i++){
            if (countries[i].square>squareMax){
                indexMax = i;
                squareMax = countries[indexMax].square;
            }
        }
        System.out.println("Страна с максимальной площадью ");
        System.out.println("Название " + countries[indexMax].name + " с площадью " + squareMax);

        //Сортировка по площади
        for (int i=0; i<countries.length -1; i++){
            for (int j=0; j<countries.length - i - 1; j++){
                Country temp = countries[j]; //рабочая переменная
                countries[j] = countries[j+1];
                countries[j+1] = temp;
            }
        }
        System.out.println("Отсортированный список по площади");
        for (int i=0; i<countries.length; i++){
            System.out.printf("%s \t %s \n", countries[i].name, countries[i].square);
        }
        //Сортировка по названию
        for (int i=0; i<countries.length - 1; i++){
            for (int j=0; j<countries.length - i - 1; j++){
                if (countries[j].name.compareTo(countries[j+1].name) >0){
                    Country temp = countries[j]; //рабочая переменная
                    countries[j] = countries[j+1];
                    countries[j+1] = temp;
                }
            }
        }
        System.out.println("Отсортированный список по названию");
        for (int i=0; i<countries.length; i++){
            System.out.printf("%s \t %s \n", countries[i].name, countries[i].square);
        }
        //Нахождение средней площади
        double sumSquare = 0; //суммарная площадь
        for (int i=0; i<countries.length; i++){
            sumSquare += countries[i].square;
        }
        double avgSquare = (double) sumSquare / countries.length;
        System.out.println("Средняя площадь = " + avgSquare);
        //Вывод стран с площадью более средней
        System.out.println("Страны с площадью бальше средней");
        for (int i=0; i<countries.length; i++){
            if (countries[i].square > avgSquare){
                System.out.printf("%s \t %s \n", countries[i].name, countries[i].square);
            }
        }
        //Поиск по названию
        System.out.println("Введите название искомой страны");
        String nameSearch = sc.nextLine();
        int indexSearch = -1; //предварительный индекс искомой страны
        //-1 означает что искомая страна с искомой названием отсутствует

        for (int i=0; i<countries.length; i++){
            if (nameSearch.equalsIgnoreCase(countries[i].name)){
                indexSearch=i;
            }
        }
        //Проверка результата поиска
        //Если indexSearch поменяло занчение значит страна найдена
        if (indexSearch != -1){
            System.out.println("Такая страна есть в списке");
            System.out.printf("%s \t %s \n", countries[indexSearch].name, countries[indexSearch].square);
        } else {
            System.out.println("Такой страны нет в списке");
        }
    }
}
