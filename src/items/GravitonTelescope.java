package items;

import enums.*;
import spaceObjects.*;

public class GravitonTelescope {

    private Direction direction;
    public Antenna antenna;
    public Screen screen;
    public Locator locator;
    private Direction location; //где находится телескоп

    public GravitonTelescope(Direction location, Direction direction){
        this.location = location;
        this.direction = direction;

        this.antenna = new Antenna();
        this.screen = new Screen();
        this.locator = new Locator();

        System.out.println("гравитонный телескоп создан");
    }

    public void setDirection(Direction newDirection){
        this.direction = newDirection;
    }

    public int[][] getInformationAboutObject(SpaceObject.Graviton graviton){
        return new int[][]{this.screen.createCroockedLine(graviton), this.locator.turnOn(graviton)};
    }


    public class Antenna {

        public void turn(Direction newDirection){
            GravitonTelescope.this.direction = newDirection;
        }

        protected int[] scan(SpaceObject.Graviton graviton){
            //вот сюда можно добавить ошибку: скорость/масса отрицательные
            return graviton.getInf();
        }

    }

    private class Screen {
        //определяет массу объекта
        public int[] createCroockedLine(SpaceObject.Graviton graviton){
            int weighOfObject = GravitonTelescope.this.antenna.scan(graviton)[1];
            int degreeOfCurvature = (weighOfObject*200);
            int XPlaceOnScreen = weighOfObject/55;
            int YPlaceOnScreen = weighOfObject/155;
            return new int[]{degreeOfCurvature, XPlaceOnScreen, YPlaceOnScreen};
            //а чтобы расшифровать эти данные, нужно быть давилонским астрономом :)
        }
    }

    private class Locator {
        //определяет расстояние до объекта и скорость
        public int[] turnOn(SpaceObject.Graviton graviton){
            int speedOfObject = GravitonTelescope.this.antenna.scan(graviton)[0];
            int distanceToObject = speedOfObject+(GravitonTelescope.this.location.hashCode());
            return new int[]{distanceToObject, speedOfObject};
        }
    }

}
