package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.WeatherCondition;
import ua.lviv.iot.service.WeatherConditionService;

import java.util.List;
import java.util.Scanner;

public class WeatherConditionView {
  public static void selectAll() {
    System.out.println("Table: weather_condition");
    System.out.printf("%-5s %-15s %-5s %-7s %s%n", "id", "description", "day", "night", "icon");
    WeatherConditionService service = new WeatherConditionService();
    List<WeatherCondition> weatherConditions = service.findAll();
    for (WeatherCondition weatherCondition : weatherConditions) {
      System.out.println(weatherCondition);
    }
  }

  public static void selectById() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of weather_conditoin: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    WeatherConditionService service = new WeatherConditionService();
    WeatherCondition weatherCondition = service.findById(id);
    System.out.printf("%-5s %-15s %-5s %-7s %s%n", "id", "description", "day", "night", "icon");
    System.out.println(weatherCondition);
  }
}
