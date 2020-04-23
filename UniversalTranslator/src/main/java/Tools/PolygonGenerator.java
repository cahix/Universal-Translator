package Tools;

import java.awt.*;

public class PolygonGenerator {
    public static Polygon generate(String points){
        String[] pointsAsStrings = points.split(",");
        int[] xPoly = new int[pointsAsStrings.length];
        int[] yPoly = new int[pointsAsStrings.length];
        for(int i = 0 ; i < pointsAsStrings.length ; i++){
            String xValue = pointsAsStrings[i].substring(0 , pointsAsStrings[i].indexOf(" "));
            String yValue = pointsAsStrings[i].substring(pointsAsStrings[i].indexOf(" ") + 1);
            xPoly[i] = Integer.valueOf(xValue);
            yPoly[i] = Integer.valueOf(yValue);
        }
        return new Polygon(xPoly , yPoly , xPoly.length);
        //return normPolygon(xPoly , yPoly , originalFrameWidth , originalFrameHeight);
    }

    /*private static Polygon normPolygon(int[] xPoly , int[] yPoly , int w , int h){
        for(int i = 0 ; i < xPoly.length ; i++){
            xPoly[i] = Math.round(((float) xPoly[i] / (float)w) * (float)MainPage.WIDTH);
            yPoly[i] = Math.round(((float) yPoly[i] / (float)h) * (float)MainPage.WIDTH);
            System.out.println(xPoly[i]);
        }
        return new Polygon(xPoly , yPoly , xPoly.length);
    }*/

}
