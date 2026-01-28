/*
 This program renders a static landscape scene using the StdDraw library
 which demonstrates procedural logic, coordinate-based reasoning,
 nested loops, and modular decomposition of drawing tasks.
 
 Author: Olivia Rueschhoff
 */

public class PavilionScene{

   //method to draw trees
   public static void drawTrees(){
      //wood stump
      StdDraw.setPenColor(74, 34, 10);
      for (double i = 0; i < 1; i = i + .1){
         //back row
         StdDraw.filledRectangle(i + 0.05, 0.45, .01, 0.08);
         
         //front row
         StdDraw.filledRectangle(i, 0.4, 0.01, 0.08); 
      }
      
      //Tree top
      for (double i = 0; i < 1; i = i + .1){
         //back row
         StdDraw.setPenColor(14, 46, 22);
         double[] a = {i-0.05, i + 0.05, i + 0.15};
         double[] b = {0.48, 0.8, 0.48};
         StdDraw.filledPolygon(a, b);
         
         //front row
         StdDraw.setPenColor(22, 74, 35);
         double[] c = {i-0.08, i, i + 0.08};
         double[] d = {0.45, 0.75, 0.45};
         StdDraw.filledPolygon(c, d);
      }
   }
   
   public static void main(String[] args){
      //sky
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.filledSquare(0.50, 0.50, 0.50);

      //ground
      StdDraw.setPenColor(31, 115, 53);
      StdDraw.filledRectangle(0.5, 0.2, 0.5, 0.2);   
      
      //pond
      StdDraw.setPenColor(StdDraw.CYAN);
      StdDraw.filledRectangle(0.50, 0.15, 0.50, 0.15);   
      drawTrees();
      
      //building block
      StdDraw.setPenColor(115, 56, 54);
      StdDraw.filledRectangle(0.6, 0.4, 0.3, 0.1);
      
      //main windows
      for(double i = 0.35; i < 0.90; i = i + 0.1){
         StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         StdDraw.filledRectangle(i, 0.41, 0.02, 0.05);
         StdDraw.setPenColor(StdDraw.GRAY);
         StdDraw.rectangle(i, 0.41, 0.02, 0.05);
         StdDraw.line(i-0.02, 0.41, i+0.02, 0.41); 
         StdDraw.line(i, 0.36, i, 0.46);
      }
      
      //poles
      for(double i = 0.32; i < 0.95; i = i + 0.15){
         StdDraw.setPenColor(232, 231, 211);
         StdDraw.filledRectangle(i, 0.4, 0.01, 0.08);
         StdDraw.setPenColor(138, 70, 67);
         StdDraw.filledRectangle(i, 0.36, 0.025, 0.05);
      }
      
      //sidewalk
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.filledRectangle(0.50, 0.27, 0.50, 0.015);
      StdDraw.setPenColor(184, 183, 125);
      StdDraw.filledRectangle(0.50, 0.30, 0.50, 0.025);
      
      //dock
      StdDraw.filledRectangle(0.70, 0.30, 0.15, 0.035);
      StdDraw.setPenColor(150, 150, 111);
      StdDraw.rectangle(0.70, 0.30, 0.15, 0.035);
      for(double i = 0.56; i < 0.85; i = i + 0.07){ //dock legs
         StdDraw.filledRectangle(i, 0.25, 0.01, 0.015);
      }
      for(double i = 0.28; i < 0.34; i = i + 0.02){
         StdDraw.filledRectangle(0.625, i, 0.07, 0.005);
         StdDraw.filledRectangle(0.775, i, 0.07, 0.005);
      }
      
      //stairs
      StdDraw.setPenColor(184, 183, 125);
      StdDraw.filledRectangle(0.70, 0.33, 0.075, 0.035);
      StdDraw.setPenColor(StdDraw.GRAY);
      for(double i = 0.30; i < 0.36; i = i+0.01){
         StdDraw.line(0.64, i, 0.76, i);
      }
      
      //chimney
      StdDraw.setPenColor(115, 56, 54);
      StdDraw.filledRectangle(0.40, 0.65, 0.04, 0.17);
      
      //lower roof
      StdDraw.setPenColor(72, 71, 82);
      double[] a = {0.25, 0.40, 0.9, 0.96};
      double[] b = {0.48, 0.55, 0.55, 0.48};
      StdDraw.filledPolygon(a, b);
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.polygon(a, b);
      
      //triangle second floor
      StdDraw.setPenColor(72, 71, 82);
      double[] c = {0.350, 0.550, 0.750};
      double[] d = {0.500, 0.800, 0.500};
      StdDraw.filledPolygon(c, d);
      StdDraw.setPenColor(115, 56, 54);
      double[] x = {0.450, 0.550, 0.650};
      double[] y = {0.550, 0.725, 0.550}; 
      StdDraw.filledPolygon(x, y); 
      
      //triangle poles
      StdDraw.setPenColor(232, 231, 211);
      StdDraw.filledRectangle(0.47, 0.58, 0.007, 0.03); 
      StdDraw.filledRectangle(0.63, 0.58, 0.007, 0.03);
      StdDraw.filledRectangle(0.55, 0.55, 0.100, 0.01);
      StdDraw.filledCircle(0.47, 0.62, 0.015);
      StdDraw.filledCircle(0.63, 0.62, 0.015);
      
      //dome
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.filledCircle(0.8, 0.68, 0.08);
      StdDraw.setPenColor(115, 56, 54);
      StdDraw.filledSquare(0.8, 0.6, 0.075);
      
      //dome top
      StdDraw.setPenColor(228, 225, 207);
      StdDraw.filledRectangle(0.8, 0.67, 0.09, 0.02);
      double[] xVal = {0.78, 0.80, 0.82};
      double[] yVal = {0.75, 0.82, 0.75};
      StdDraw.filledPolygon(xVal, yVal);
      StdDraw.filledRectangle(0.8, 0.75, 0.03, 0.01);
      
      //circle window
      StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      StdDraw.filledCircle(0.55, 0.625, 0.03);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.circle(0.55, 0.625, 0.03);
      StdDraw.line(0.55, 0.595, 0.55, 0.655); 
      StdDraw.line(0.52, 0.625, 0.58, 0.625);
      
      //dome window
      for(double i = 0.75; i < 0.90; i = i + 0.05){
         StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         StdDraw.filledRectangle(i, 0.59, 0.02, 0.05);
         StdDraw.setPenColor(StdDraw.GRAY);
         StdDraw.rectangle(i, 0.59, 0.02, 0.05);
         StdDraw.line(i-0.02, 0.59, i+0.02, 0.59); 
         StdDraw.line(i, 0.54, i, 0.64);
      }
      
      //fountain
      StdDraw.setPenColor(70, 194, 235);
      StdDraw.setPenRadius(0.003);
      StdDraw.filledRectangle(0.20, 0.10, 0.015, 0.007);
      //middle section
      for(double i = 0.19; i < 0.22; i = i + 0.01){
         for(double j = 0.10; j < 0.25; j = j + 0.07){
            StdDraw.line(i, j, i, j+0.05);
         }
      }
      //side sections
      StdDraw.line(0.19, 0.10, 0.16, 0.13);
      StdDraw.line(0.21, 0.10, 0.24, 0.13);
      StdDraw.line(0.14, 0.15, 0.10, 0.18);
      StdDraw.line(0.26, 0.15, 0.30, 0.18);
      //top bowing water
      StdDraw.line(0.19, 0.30, 0.17, 0.33); //left
      StdDraw.line(0.20, 0.30, 0.20, 0.32); //middle
      StdDraw.line(0.21, 0.30, 0.23, 0.33); //right
      StdDraw.line(0.16, 0.34, 0.14, 0.34); //left straight
      StdDraw.line(0.24, 0.34, 0.26, 0.34); //right straight
      StdDraw.line(0.13, 0.33, 0.11, 0.31); //left down
      StdDraw.line(0.27, 0.33, 0.29, 0.31); //right down
   }


}

