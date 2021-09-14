package view;

import java.util.concurrent.Semaphore;

import controller.CarController;

class Principal {
  public static void main(String[] args) {
      int sinal = 1;
      Semaphore semaphore = new Semaphore(sinal);

      for (int id_car = 1; id_car <= 4; id_car++) {
        Thread car = new CarController(id_car, semaphore);
        car.start();
      }
  }
}