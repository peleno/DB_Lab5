package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.model.WorldPart;
import ua.lviv.iot.service.CountryService;
import ua.lviv.iot.service.WorldPartService;

import java.util.List;
import java.util.Scanner;

public class CountryView {
  public static void selectAll() {
    System.out.println("Table: country");
    System.out.printf("%-5s %-20s %s%n", "id", "name", "world_part_id");
    CountryService service = new CountryService();
    List<Country> countries = service.findAll();
    for (Country country : countries) {
      System.out.println(country);
    }
  }

  public static void selectById() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of country: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    CountryService service = new CountryService();
    Country country = service.findById(id);
    System.out.printf("%-5s %-20s %s%n", "id", "name", "world_part_id");
    System.out.println(country);
  }

  public static void create() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter name for new country: ");
    String name = scanner.nextLine();
    System.out.print("Please, enter world_part_id for new country: ");
    Integer worldPartId = scanner.nextInt();
    scanner.nextLine();

    CountryService countryService = new CountryService();
    WorldPartService worldPartService = new WorldPartService();
    WorldPart worldPart = worldPartService.findById(worldPartId);
    Country country = new Country(0, name, worldPart);
    int count = countryService.create(country);
    System.out.printf("There are created %d rows%n", count);
  }

  public static void update() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of country you want to change: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Please, enter new name for this country: ");
    String name = scanner.nextLine();
    System.out.print("Please, enter world_part_id for this country: ");
    Integer worldPartId = scanner.nextInt();
    scanner.nextLine();

    WorldPartService worldPartService = new WorldPartService();
    WorldPart worldPart = worldPartService.findById(worldPartId);

    CountryService countryService = new CountryService();
    Country country = new Country(id, name, worldPart);
    int count = countryService.update(country);
    System.out.printf("There are updated %d rows%n", count);
  }

  public static void delete() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of country you want to delete: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    CountryService service = new CountryService();
    int count = service.delete(id);
    System.out.printf("There are deleted %d rows%n", count);
  }
}
