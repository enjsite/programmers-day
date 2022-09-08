public class StepTracker {

    int stepsGoal = 10000;
    MonthData[] monthToData;
    Converter converter = new Converter();

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setStepsGoal(int goal) {
        if (goal >= 0) {
            this.stepsGoal = goal;
        } else {
            System.out.println("Ваша цель не может быть отрицательной.");
        }
    }

    public void setStepsCount(int month, int day, int steps) {
        monthToData[month].setStepsPerDay(day, steps);
    }

    public void getStatistics(int month) {
        getMonthStepsPerDaysStat(month);
        getCountSteps(month);
        getMaxStepsCount(month);
        getAverageStepsCount(month);
        getDistance(month);
        getCalories(month);
        getTheBestSeries(month);
    }

    public void getTheBestSeries(int month) {
        int theBestSeries = 0;
        int curSeries = 0;
        for (int i = 0; i < monthToData[month].days; i++) {
            if (monthToData[month].stepsPerDay[i] > this.stepsGoal) {
                curSeries++;
            } else {
                if (curSeries > theBestSeries) {
                    theBestSeries = curSeries;
                    curSeries = 0;
                }
            }
        }
        System.out.println("Лучшая серия: " + theBestSeries);
    }

    public void getDistance(int month) {
        double distance = converter.getDistance(getCountStepsPerMonth(month));
        System.out.println("Пройденная дистанция (в км): " + String.format("%.2f", distance) + ".");
    }

    public void getCalories(int month) {
        double calories = converter.getCalories(getCountStepsPerMonth(month));
        System.out.println("Количество сожжённых килокалорий: " + String.format("%.2f", calories) + ".");
    }

    public void getAverageStepsCount(int month) {
        int averageStepsCount = getCountStepsPerMonth(month) / monthToData[month].days;
        System.out.println("Среднее количество шагов: " + averageStepsCount + ".");
    }

    public void getMaxStepsCount(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month].days; i++) {
            if (monthToData[month].stepsPerDay[i] > maxSteps) {
                maxSteps = monthToData[month].stepsPerDay[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps + ".");
    }

    public void getMonthStepsPerDaysStat(int month) {
        System.out.println("Статистика по шагам в " + month + " месяце.");
        for (int i = 0; i < monthToData[month].days; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month].stepsPerDay[i] + ", ");
        }
        System.out.println("");
    }

    public void getCountSteps(int month) {
        System.out.println("Общее количество шагов за месяц: " + getCountStepsPerMonth(month) + ".");
    }

    public int getCountStepsPerMonth(int month) {
        var countSteps = 0;
        for (int i = 0; i < monthToData[month].days; i++) {
            countSteps = countSteps + monthToData[month].stepsPerDay[i];
        }
        return countSteps;
    }



    class MonthData {
        // Заполните класс самостоятельно
        public int days = 30;
        public int[] stepsPerDay;

        public MonthData() {
            stepsPerDay = new int[days];
        }

        public void setStepsPerDay(int day, int steps) {
            stepsPerDay[day] = stepsPerDay[day] + steps;
        }

    }
}