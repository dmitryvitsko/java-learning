import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    double getExpensesSum() {
        double totalSum = 0;
        for (ArrayList<Double> expList : expensesByCategories.values()) {
            for (double exp : expList) {
                totalSum += exp;
            }
        }
        return totalSum;
    }

    void removeCategory(String category) {
        if (expensesByCategories.containsKey(category)) {
            expensesByCategories.remove(category);
        } else {
            System.out.println("Такой категории нет!");
        }
    }

    String getMaxCategoryName() {
        double maxCategorySum = 0;
        String maxCategoryName = "";

        for (String category : expensesByCategories.keySet()) {
            double sumExpensesCategory = 0;
            for (Double expense : expensesByCategories.get(category)) {
                sumExpensesCategory += expense;
                if (sumExpensesCategory > maxCategorySum) {
                    maxCategorySum = sumExpensesCategory;
                    maxCategoryName = category;
                }
            }
        }
        return maxCategoryName;
    }


}