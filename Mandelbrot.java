
import java.awt.Color; 

import java.awt.image.BufferedImage; 

import java.io.File; 

import java.io.IOException; 

import javax.imageio.ImageIO; 

 

public class Mandelbrot_set_mine { 

private static int max = 1000; 

public static void main(String args[]) throws IOException { 

int width = 1920; 

int height = 1080; 

BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 

        int black = 0; 

        int[] colors = new int[max]; 

        for (int i = 0; i<max; i++) { 

        //int base = i+4915330; 

            colors[i] = i*i*i;//base*1022; 

        } 

for (int i = 0; i < height; i++) { 

for (int j = 0; j < width; j++) { 

double re = (j - width / 2) * 4.0 / width; 

double im = (i - height / 2) * 4.0 / width; 

double x = 0, y = 0; 

int mand = chk(x,y,re,im); 

if (mand < max) img.setRGB(j, i, colors[mand]); 

                else img.setRGB(j, i, black); 

} 

System.out.println(Integer.toString(i)); 

} 

ImageIO.write(img, "png", new File("Out.png")); 

} 

public static int chk(double x, double y, double re, double im) { 

for (int i = 0; i<max; i++) { 

if(x*x+y*y < 4) { 

double x_new = x*x-y*y+re; 

                y = 2*x*y+im; 

                x = x_new; 

}else { 

return i; 

} 

} 

return max; 

} } 