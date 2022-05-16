import java.util.Scanner;
/*class Country {
    String name;
    double square;
}*/

public class InfoAboutCountriesWithMethods {
    static Scanner sc;
    /**
     *Ввод массива стран
     *
     * @param count - количесвто элементов в массиве
     * @return - заполненный массив стран
     */
    public static Country[] setCountry(int count) {
        Country[] countries = new Country[count];
        System.out.println("Введите иниформацию о странах");
        for (int i = 0; i < countries.length; i++) {
            countries[i] = new Country();
            System.out.println("Введите название " + (i + 1) + "-й страны");
            countries[i].name = sc.nextLine();
            System.out.println("Введите площадь " + (i + 1) + "-й страны");
            countries[i].square = sc.nextDouble();
            sc.nextLine();
        }
        return countries;
    }
    /**
     *Вывод информации о странах в табличном виде
     *
     * @param countries - массив стран
     */
    public static void showArray(Country[] countries){
        for (int i=0; i<countries.length; i++){
            System.out.printf("%s \t %f \n", countries[i].name, countries[i].square);
        }
    }
    /**
     *Вывод информации об одной стране
     *
     * @param country - объект класса Country
     */
    public static void showCountry(Country country){
        System.out.printf("%s \t %s \n", country.name, country.square);
    }
    /**
     *Определение индекса страны с максимальной площадью
     *
     * @param countries - массив стран
     * @return - индекс страны
     */
    public static int nomMax(Country[] countries) {
        int indexMax = 0;
        double squareMax = countries[indexMax].square;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].square > squareMax) {
                indexMax = i;
                squareMax = countries[indexMax].square;
            }
        }
        return indexMax;
    }
    /**
     *Сортировка стран по возрастанию площади
     *
     * @param countries - исходный массив
     * @return - отсортированный массив
     */
    public static Country[] sortSquare (Country[] countries) {
        for (int i = 0; i < countries.length - 1; i++) {
            for (int j = 0; j < countries.length - i - 1; j++) {
                if (countries[j].square>countries [j + 1].square) {
                    Country temp = countries[j]; //рабочая переменная
                    countries[j] = countries[j + 1];
                    countries[j + 1] = temp;
                }
            }
        }
        return countries;
    }
    /**
     *Сортировка стран по названию в алфавитном порядке
     *
     * @param countries - исходный массив
     * @return - отсортированный массив
     */
    public static Country[] sortName (Country[] countries) {
        for (int i = 0; i < countries.length - 1; i++) {
            for (int j = 0; j < countries.length - i - 1; j++) {
                if (countries[j].name.compareTo(countries[j + 1].name)>0) {
                    Country temp = countries[j]; //рабочая переменная
                    countries[j] = countries[j + 1];
                    countries[j + 1] = temp;
                }
            }
        }
        return countries;
    }
    /**
     *Определение средней площади
     *
     * @param countries - массив стран
     * @return - средняя площадь
     */
    public static double avgSquare (Country[] countries){
        double sumSquare = 0; //суммарная площадь
        for (int i=0; i<countries.length; i++){
            sumSquare += countries[i].square;
        }
        double avgSq = (double) sumSquare / countries.length;
        return avgSq;
    }
    /**
     *Определение стран с площадью больше средней
     *
     * @param countries - массив стран
     * @param avgSquare - среднее площадь
     * @return - массив стран с площадью больше средней
     */
    public static Country[] bigger(Country[] countries, double avgSquare){
        int k=0;
        for (int i=0; i<countries.length; i++){
            if (countries[i].square>avgSquare) k++;
        }
        if (k!=0){
            Country[] bigCountry = new Country[k];
            int n = -1;
            for (int i=0; i<countries.length; i++){
                if (countries[i].square>avgSquare) bigCountry[++n] = countries[i];
            }
            return bigCountry;
        }
        else return null;
    }
    /**
     *Поиск страны по названю
     * @param countries - массив стран
     * @param searchName - искомое имя
     * @return - объект класса Country
     */
    public static Country findForName(Country[] countries, String searchName){
        int indexSearch = -1; //предварительный индекс искомой страны
        //-1 означает что искомая страна с искомой названием отсутствует
        for (int i=0; i<countries.length; i++){
            if (searchName.equalsIgnoreCase(countries[i].name)){
                indexSearch=i;
            }
        }
        if (indexSearch != -1){
            return countries[indexSearch];
        }
        else{
            return null;
        }
    }
    public static void main (String[] args){
        sc = new Scanner(System.in);
        System.out.println("Введиье количество стран");
        int count = sc.nextInt();
        sc.nextLine(); //очистка буфера
        Country[] countries = setCountry(count);
        System.out.println("Информация о странах");
        System.out.println("Название \t Площадь \t");
        showArray(countries);
        System.out.println("Страна с максимальной площадью ");
        int indexMax = nomMax(countries);
        showCountry(countries[indexMax]);
        System.out.println("Отсортированный список по площади:");
        countries = sortSquare(countries);
        showArray(countries);
        System.out.println("Отсортированный список по названию:");
        countries = sortName(countries);
        showArray(countries);
        double avgSquare = avgSquare(countries);
        System.out.println("Средняя площадь = " + avgSquare);
        System.out.println("Стрна с площадью больше средней");
        Country[] bigCountries = bigger(countries,avgSquare);
        showArray(bigCountries);
        System.out.println("Введите название искомой страны");
        String nameSearch = sc.nextLine();
        Country countrySearch = findForName(countries, nameSearch);
        if(countrySearch!=null){
            System.out.println("Такая страна есть в списке");
            showCountry(countrySearch);
        }
        else{
            System.out.println("Такой страны нет в списке");
        }
    }
}
