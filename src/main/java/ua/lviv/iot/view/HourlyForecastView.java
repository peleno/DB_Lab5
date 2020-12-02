package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.DailyForecast;
import ua.lviv.iot.model.HourlyForecast;
import ua.lviv.iot.model.Weather;
import ua.lviv.iot.service.DailyForecastService;
import ua.lviv.iot.service.HourlyForecastService;
import ua.lviv.iot.service.WeatherService;

import java.util.List;
import java.util.Scanner;

public class HourlyForecastView {
  public static void selectAll() {
    System.out.println("Table: hourly_forecast");
    System.out.printf("%-5s %-5s %-20s %s%n", "id", "hour", "daily_forecast_id", "weather_id");
    HourlyForecastService service = new HourlyForecastService();
    List<HourlyForecast> hourlyForecasts = service.findAll();
    for (HourlyForecast hourlyForecast : hourlyForecasts) {
      System.out.println(hourlyForecast);
    }
  }

  public static void selectById() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of hourly_forecast: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    HourlyForecastService service = new HourlyForecastService();
    HourlyForecast hourlyForecast = service.findById(id);
    System.out.printf("%-5s %-5s %-20s %s%n", "id", "hour", "daily_forecast_id", "weather_id");
    System.out.println(hourlyForecast);
  }

  public static void create() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter hour for new hourly_forecast: ");
    Integer hour = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter daily_forecast_id for new hourly_forecast: ");
    Integer dailyForecastId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter weather_id for new hourly_forecast: ");
    Integer weatherId = scanner.nextInt();
    scanner.nextLine();

    DailyForecastService dailyForecastService = new DailyForecastService();
    DailyForecast dailyForecast = dailyForecastService.findById(dailyForecastId);

    WeatherService weatherService = new WeatherService();
    Weather weather = weatherService.findById(weatherId);

    HourlyForecast hourlyForecast = new HourlyForecast(0, hour, dailyForecast, weather);
    HourlyForecastService service = new HourlyForecastService();
    int count = service.create(hourlyForecast);
    System.out.printf("There are created %d rows%n", count);
  }

  public static void update() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of hourly_forecast you want to change: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Please, enter new hour for this hourly_forecast: ");
    Integer hour = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter new daily_forecast_id for this hourly_forecast: ");
    Integer dailyForecastId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter new weather_id for this hourly_forecast: ");
    Integer weatherId = scanner.nextInt();
    scanner.nextLine();

    DailyForecastService dailyForecastService = new DailyForecastService();
    DailyForecast dailyForecast = dailyForecastService.findById(dailyForecastId);

    WeatherService weatherService = new WeatherService();
    Weather weather = weatherService.findById(weatherId);

    HourlyForecast hourlyForecast = new HourlyForecast(id, hour, dailyForecast, weather);
    HourlyForecastService service = new HourlyForecastService();
    int count = service.update(hourlyForecast);
    System.out.printf("There are updated %d rows%n", count);
  }

  public static void delete() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of hourly_forecast you want to delete: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    HourlyForecastService service = new HourlyForecastService();
    int count = service.delete(id);
    System.out.printf("There are deleted %d rows%n", count);
  }

}
