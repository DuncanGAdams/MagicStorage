package com.magicstorage;

import java.util.Arrays;
import java.util.List;

import org.poly2tri.Poly2Tri;
import org.poly2tri.geometry.polygon.Polygon;
import org.poly2tri.geometry.polygon.PolygonPoint;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;

public class TriTest {
  public static void main(String[] args) {
    // Prepare input data
    Polygon polygon = new Polygon(Arrays.asList(new PolygonPoint(0, 0, 0),
      new PolygonPoint(10, 0, 1),new PolygonPoint(10, 10, 2),new PolygonPoint(0, 10, 3)));
    // Launch tessellation  
    Poly2Tri.triangulate(polygon);
    // Gather triangles
    List<DelaunayTriangle> triangles = polygon.getTriangles();
    //System.out.println(triangles);
    
  }
}
