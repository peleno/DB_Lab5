package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.DailyForecast;
import ua.lviv.iot.model.MonthlyForecast;
import ua.lviv.iot.model.MonthlyForecastPK;
import ua.lviv.iot.service.DailyForecastService;
import ua.lviv.iot.service.MonthlyForecastService;

import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class DailyForecastView {
  public static void selectAll() {
    System.out.println("Table: daily_forecast");
    System.out.printf("%-5s %-5s %-10s %-10s %-10s %-10s %-25s %s%n", "id", "day", "sunrise", "sunset", "moonrise", "moonset", "monthly_forecast_year", "monthly_forecast_month");
    DailyForecastService service = new DailyForecastService();
    List<DailyForecast> dailyForecasts = service.findAll();
    for (DailyForecast dailyForecast : dailyForecasts) {
      System.out.println(dailyForecast);
    }
  }

  public static void selectById() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of daily_forecast: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    DailyForecastService service = new DailyForecastService();
    DailyForecast dailyForecast = service.findById(id);
    System.out.printf("%-5s %-5s %-10s %-10s %-10s %-10s %-25s %s%n", "id", "day", "sunrise", "sunset", "moonrise", "moonset", "monthly_forecast_year", "monthly_forecast_month");
    System.out.println(dailyForecast);
  }

  public static void create() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter day for new daily_forecast: ");
    Integer day = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter sunrise time for new daily_forecast: ");
    Time sunrise = Time.valueOf(scanner.nextLine());
    System.out.print("Please, enter sunset time for new daily_forecast: ");
    Time sunset = Time.valueOf(scanner.nextLine());
    System.out.print("Please, enter moonrise time for new daily_forecast: ");
    Time moonrise = Time.valueOf(scanner.nextLine());
    System.out.print("Please, enter moonset time for new daily_forecast: ");
    Time moonset = Time.valueOf(scanner.nextLine());
    System.out.print("Please, enter monthly_forecast_year for new daily_forecast: ");
    Integer monthlyForecastYear = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter monthly_forecast_month for new daily_forecast: ");
    String monthlyForecastMonth = scanner.nextLine();

    MonthlyForecastService monthlyForecastService = new MonthlyForecastService();
    MonthlyForecastPK monthlyForecastPK = new MonthlyForecastPK(monthlyForecastYear, monthlyForecastMonth);
    MonthlyForecast monthlyForecast = monthlyForecastService.findById(monthlyForecastPK);

    DailyForecast dailyForecast = new DailyForecast(0, day, sunrise, sunset, moonrise, moonset, monthlyForecast);
    DailyForecastService dailyForecastService = new DailyForecastService();
    int count = dailyForecastService.create(dailyForecast);
    System.out.printf("There are created %d rows%n", count);
  }

  public static void update() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of daily_forecast you want to change: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter new day for this daily_forecast: ");
    Integer day = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter new sunrise time for this daily_forecast: ");
    Time sunrise = Time.valueOf(scanner.nextLine());
    System.out.print("Please, enter new sunset time for this daily_forecast: ");
    Time sunset = Time.valueOf(scanner.nextLine());
    System.out.print("Please, enter new moonrise time for this daily_forecast: ");
    Time moonrise = Time.valueOf(scanner.nextLine());
    System.out.print("Please, enter new moonset time for this daily_forecast: ");
    Time moonset = Time.valueOf(scanner.nextLine());
    System.out.print("Please, enter new monthly_forecast_year for this daily_forecast: ");
    Integer monthlyForecastYear = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter new monthly_forecast_month for this daily_forecast: ");
    String monthlyForecastMonth = scanner.nextLine();

    MonthlyForecastService monthlyForecastService = new MonthlyForecastService();
    MonthlyForecastPK monthlyForecastPK = new MonthlyForecastPK(monthlyForecastYear, monthlyForecastMonth);
    MonthlyForecast monthlyForecast = monthlyForecastService.findById(monthlyForecastPK);

    DailyForecast dailyForecast = new DailyForecast(id, day, sunrise, sunset, moonrise, moonset, monthlyForecast);
    DailyForecastService service = new DailyForecastService();
    int count = service.update(dailyForecast);
    System.out.printf("There are updated %d rows%n", count);
  }

  public static void delete() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of daily_forecast you want to delete: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    DailyForecastService service = new DailyForecastService();
    int count = service.delete(id);
    System.out.printf("There are deleted %d rows%n", count);
  }
}
