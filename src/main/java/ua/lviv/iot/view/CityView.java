package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Region;
import ua.lviv.iot.service.CityService;
import ua.lviv.iot.service.RegionService;

import java.util.List;
import java.util.Scanner;

public class CityView {
  public static void selectAll() {
    System.out.println("Table: city");
    System.out.printf("%-5s %-20s %s%n", "id", "name", "region_id");
    CityService service = new CityService();
    List<City> cities = service.findAll();
    for (City city : cities) {
      System.out.println(city);
    }
  }

  public static void selectById() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of city: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    CityService service = new CityService();
    City city = service.findById(id);
    System.out.printf("%-5s %-20s %s%n", "id", "name", "region_id");
    System.out.println(city);
  }

  public static void create() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter name for new city: ");
    String name = scanner.nextLine();
    System.out.print("Please, enter region_id for new city: ");
    Integer regionId = scanner.nextInt();
    scanner.nextLine();

    CityService cityService = new CityService();
    RegionService regionService = new RegionService();
    Region region = regionService.findById(regionId);
    City city = new City(null, name, region);
    int count = cityService.create(city);
    System.out.printf("There are created %d rows%n", count);
  }

  public static void update() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of city you want to change: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Please, enter new name for this city: ");
    String name = scanner.nextLine();

    System.out.print("Please, enter region_id for this city: ");
    Integer regionId = scanner.nextInt();
    scanner.nextLine();

    CityService cityService = new CityService();
    RegionService regionService = new RegionService();
    Region region = regionService.findById(regionId);
    City city = new City(id, name, region);
    int count = cityService.update(city);
    System.out.printf("There are updated %d rows%n", count);
  }

  public static void delete() {
    Scanner scanner = Controller.getScanner();
    System.out.print("Please, enter id of city you want to delete: ");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    CityService service = new CityService();
    int count = service.delete(id);
    System.out.printf("There are deleted %d rows%n", count);
  }
}
