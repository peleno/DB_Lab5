package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.MonthlyForecast;
import ua.lviv.iot.model.MonthlyForecastPK;
import ua.lviv.iot.service.MonthlyForecastService;

import java.util.List;
import java.util.Scanner;

public class MonthlyForecastView {
  public static void selectAll() {
    System.out.println("Table: monthly_forecast");
    System.out.printf("%-5s %s%n", "year", "month");
    MonthlyForecastService service = new MonthlyForecastService();
    List<MonthlyForecast> monthlyForecasts = service.findAll();
    for (MonthlyForecast monthlyForecast : monthlyForecasts) {
      System.out.println(monthlyForecast);
    }
  }

  public static void create() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter year for new monthly_forecast: ");
    Integer year = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter month for new monthly_forecast: ");
    String month = scanner.nextLine();

    MonthlyForecastService service = new MonthlyForecastService();
    MonthlyForecast monthlyForecast = new MonthlyForecast(year, month);
    int count = service.create(monthlyForecast);
    System.out.printf("There are created %d rows%n", count);
  }

  public static void delete() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter year of monthly_forecast you want to delete: ");
    Integer year = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter month of monthly_forecast you want to delete: ");
    String month = scanner.nextLine();

    MonthlyForecastService service = new MonthlyForecastService();
    MonthlyForecastPK monthlyForecastPK = new MonthlyForecastPK(year, month);
    int count = service.delete(monthlyForecastPK);
    System.out.printf("There are deleted %d rows%n", count);
  }
}
