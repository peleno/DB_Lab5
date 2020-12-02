package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Precipitation;
import ua.lviv.iot.service.PrecipitationService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class PrecipitationView {
  public static void selectAll() {
    System.out.println("Table: precipitation");
    System.out.printf("%-5s %-8s %-8s %s%n", "id", "rain", "snow", "ice");
    PrecipitationService service = new PrecipitationService();
    List<Precipitation> precipitations = service.findAll();
    for (Precipitation precipitation : precipitations) {
      System.out.println(precipitation);
    }
  }

  public static void selectById() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of precipitation: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    PrecipitationService service = new PrecipitationService();
    Precipitation precipitation = service.findById(id);
    System.out.printf("%-5s %-8s %-8s %s%n", "id", "rain", "snow", "ice");
    System.out.println(precipitation);
  }

  public static void create() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter rain level in mm for new precipitation: ");
    BigDecimal rain = scanner.nextBigDecimal();
    scanner.nextLine();
    System.out.print("Please, enter snow level in mm for new precipitation: ");
    BigDecimal snow = scanner.nextBigDecimal();
    scanner.nextLine();
    System.out.print("Please, enter ice level in mm for new precipitation: ");
    BigDecimal ice = scanner.nextBigDecimal();
    scanner.nextLine();
    Precipitation precipitation = new Precipitation(0, rain, snow, ice);
    PrecipitationService service = new PrecipitationService();
    int count = service.create(precipitation);
    System.out.printf("There are created %d rows%n", count);
  }

  public static void update() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of precipitation you want to change: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter new rain level in mm for this precipitation: ");
    BigDecimal rain = scanner.nextBigDecimal();
    scanner.nextLine();
    System.out.print("Please, enter new snow level in mm for this precipitation: ");
    BigDecimal snow = scanner.nextBigDecimal();
    scanner.nextLine();
    System.out.print("Please, enter new ice level in mm for this precipitation: ");
    BigDecimal ice = scanner.nextBigDecimal();
    scanner.nextLine();
    Precipitation precipitation = new Precipitation(id, rain, snow, ice);
    PrecipitationService service = new PrecipitationService();
    int count = service.update(precipitation);
    System.out.printf("There are updated %d rows%n", count);
  }

  public static void delete() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of precipitation you want to delete: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    PrecipitationService service = new PrecipitationService();
    int count = service.delete(id);
    System.out.printf("There are deleted %d rows%n", count);
  }
}
