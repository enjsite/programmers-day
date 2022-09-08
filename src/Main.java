import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {
            // обработка разных случаев
            int month;
            int day;
            int steps;
            int goal;
            if (userInput == 1) {
                month = setMonth(scanner);
                day = setDay(scanner);
                System.out.println("Введите количество шагов:");
                steps = setSteps(scanner);
                stepTracker.setStepsCount(month, day, steps);
            } else if (userInput == 2) {
                month = setMonth(scanner);
                stepTracker.getStatistics(month);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель:");
                goal = setSteps(scanner);
                stepTracker.setStepsGoal(goal);
            } else {
                System.out.println("Неизвестная команда");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static int setMonth(Scanner scanner) {
        System.out.println("Введите месяц (от 0 до 11):");
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Несуществующий месяц, попробуйте еще раз:");
            return setMonth(scanner);
        }
        return month;
    }

    private static int setDay(Scanner scanner) {
        System.out.println("Введите день (от 0 до 29):");
        int day = scanner.nextInt();
        if (day < 0 || day > 29) {
            System.out.println("Несуществующий день, попробуйте еще раз:");
            return setDay(scanner);
        }
        return day;
    }

    private static int setSteps(Scanner scanner) {
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Количество шагов не может быть отрицательным, попробуйте еще раз:");
            return setSteps(scanner);
        }
        return steps;
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}