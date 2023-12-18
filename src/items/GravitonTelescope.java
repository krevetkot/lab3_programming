package items;

import enums.*;
import spaceObjects.*;

public class GravitonTelescope {

    private Direction direction;
    private Antenna antenna;
    private Screen screen;
    private Locator locator;
    private Direction location; //где находится телескоп

    public GravitonTelescope(Direction location, Direction direction){
        this.location = location;
        this.direction = direction;
        System.out.println("гравитонный телескоп создан");

        this.antenna = new GravitonTelescope.Antenna();
        this.screen = new GravitonTelescope.Screen();
        this.locator = new GravitonTelescope.Locator();
    }

    public void setDirection(Direction newDirection){
        this.direction = newDirection;
    }

    public int[][] getInformationAboutObject(SpaceObject.Graviton[] graviton){
        return new int[][]{this.screen.createCroockedLine(graviton), this.locator.turnOn(graviton)};
    }

//    public void assemble(GravitonTelescope.Antenna antenna, GravitonTelescope.Screen screen, GravitonTelescope.Locator locator){
//        this.antenna = antenna;
//        this.screen = screen;
//        this.locator = locator;
//    }


    public class Antenna {

        public void turn(Direction newDirection){
            GravitonTelescope.this.direction = newDirection;
        }

        protected int[] scan(SpaceObject.Graviton[] graviton){
            //вот сюда можно добавить ошибку: скорость/масса отрицательные
            return graviton[0].getInf();
        }

    }

    public class Screen {
        //определяет массу объекта
        public int[] createCroockedLine(SpaceObject.Graviton[] graviton){
            int weighOfObject = GravitonTelescope.this.antenna.scan(graviton)[1];
            int degreeOfCurvature = (weighOfObject*200);
            int XPlaceOnScreen = weighOfObject/55;
            int YPlaceOnScreen = weighOfObject/155;
            return new int[]{degreeOfCurvature, XPlaceOnScreen, YPlaceOnScreen};
            //а чтобы расшифровать эти данные, нужно быть давилонским астрономом :)
        }
    }

    public class Locator {
        //определяет расстояние до объекта и скорость
        public int[] turnOn(SpaceObject.Graviton[] graviton){
            int speedOfObject = GravitonTelescope.this.antenna.scan(graviton)[0];
            int distanceToObject = speedOfObject+(GravitonTelescope.this.location.hashCode());
            return new int[]{distanceToObject, speedOfObject};
        }
    }

    public static class Instruction{
        private int telescopeModel;
        private Language language;

        public Instruction(int telescopeModel, Language language){
            this.telescopeModel = telescopeModel;
            this.language = language;
        }
    }

}
