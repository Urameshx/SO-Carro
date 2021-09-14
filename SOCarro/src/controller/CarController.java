package controller;

import java.util.concurrent.Semaphore;

public class CarController extends Thread {
  private int id_car;
  private Semaphore semaphore;
  public static String sentido;

  public CarController(int id_car, Semaphore semaphore) {
    this.id_car = id_car;
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    try {
      semaphore.acquire();
      cruzar();
    } catch (Exception error) {
        error.printStackTrace();
    } finally {
      semaphore.release();
    }
  }

  private void cruzar() {
    switch (id_car) {
      case 1: 
        sentido = "baixo";
        break;
      case 2 :
        sentido = "direita";
        break;
      case 3:
        sentido = "esquerda";
        break;
      case 4: 
        sentido = "cima";
        break;
    }

    System.out.println("O carro nº" + id_car + " segue sentido para " + sentido);
  }
}