import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static void printOut(String string) {System.out.println(string);}

    public static void main(String[] args) {
        scanner.useDelimiter("\n");
        printResult(getCount(), getProducts());
        scanner.close();
    }

    private static void printResult(int peopleCount, ArrayList<Calculator> calc) {
        printOut("Добавленные товары:");
        double sumAll = 0;
        for (Calculator calcItem : calc){
            System.out.printf("%s %.2f \n", calcItem.product,calcItem.price);
            sumAll += calcItem.price;
        }
        System.out.printf("Всего потратили: %.2f\n", sumAll);
        double sumPerPerson = sumAll / (double) peopleCount;
        System.out.printf("Каждый человек должен заплатить по %.2f руб%s \n", sumPerPerson, Formatter.formatRubles(sumPerPerson));
    }

    private static ArrayList<Calculator> getProducts() {
        ArrayList<Calculator> products = new  ArrayList<>();
        do {
            printOut("Давайте добавим новый товар.\nУкажите его название:");
            String product = getProduct();
            printOut("Отлично, теперь укажите его стоимость в формате *рубли*,*копейки*:");
            products.add(new Calculator(product, getPrice()));
            printOut("Товар успешно записан!\nЕсли хотите добавить еще товары нажмите Enter? Если нет, напишите \"завершить\".");
        } while (!"завершить".equalsIgnoreCase(scanner.next().trim()));
        return products;
    }

    private static double getPrice() {
        double price = 0;
        do {
            try {
                price = Double.parseDouble(scanner.next().replace(",", "."));
                if (0 >= price) printOut("Цена не может равняться нулю или быть отрицательной! Повторите ввод:");
            } catch (Exception e) {
                printOut("Вы ввели неверное значение! Повторите ввод:");
            }
        } while (0 >= price);
        return price;
    }
    private static int getCount() {
        int count;
        printOut("На сколько человек разделить счет:");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число!");
                scanner.nextLine();
            }
            count = scanner.nextInt();
            if (count < 1) {
                printOut("Это некорректное значение для подсчёта.");
            } else if (count == 1) {
                printOut("В этом случае нет смысла ничего считать и делить.");
            }
        } while (count <= 1 );
        return count;
    }

    private static String getProduct(){
        String product;
        do {
            product = scanner.next().trim();
            if (product.length() != 0)
                break;
            printOut("Пустое название быть не может!\nУкажите название товара:");
        } while (true);
        return product;
    }
}