package com.magicstorage;

import java.io.FileWriter;
import java.util.List;

import org.poly2tri.Poly2Tri;
import org.poly2tri.triangulation.TriangulationPoint;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;
import org.poly2tri.triangulation.sets.PointSet;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class TriHandler {
    private static double[][] m_dataArray;
    private static List<TriangulationPoint> m_TPoints;
    private static PointSet m_pointSet;

    private static int getPointIndex(TriangulationPoint point) {
        for (int i = 0; i < m_dataArray.length; i++) {
            if (m_dataArray[i][1] == point.getX() && m_dataArray[i][2] == point.getY()) return (int) m_dataArray[i][0];
        }
        System.out.println("Triangle list doesn't match up with point list D:");
        return -1;
    }

    public static int getTriangleIndex(List<DelaunayTriangle> triList, DelaunayTriangle tri, TriangulationPoint point) {
        return triList.indexOf(tri.neighborAcross(point));
    }

    public static void storeTriangles(String pathName, String pointFileName) {
        m_dataArray = PointHandler.getPointJsonData(pointFileName);
        m_TPoints = PointHandler.getTPoints(m_dataArray);
        JsonArray trianglesJson = new JsonArray();
        JsonObject iterableObject;
        JsonObject fileObject = new JsonObject();
        DelaunayTriangle iterabeTriangle;
        TriangulationPoint iterablePoint;
        int[] pointIndexList;
        int[] neighborIndexList;

        m_pointSet = new PointSet(m_TPoints);
        Poly2Tri.triangulate(m_pointSet);
        List<DelaunayTriangle> triangles = m_pointSet.getTriangles();

        for (int i = 0; i < triangles.size(); i++) {
            iterableObject = new JsonObject();
            pointIndexList = new int[3];
            neighborIndexList = new int[3];
            iterabeTriangle = triangles.get(i);
            for (int j = 0; j < iterabeTriangle.points.length; j++) {
                iterablePoint = iterabeTriangle.points[j];
                pointIndexList[j] = getPointIndex(iterablePoint);
                neighborIndexList[j] = getTriangleIndex(triangles, iterabeTriangle, iterablePoint);
            }
            iterableObject.put("points", pointIndexList);
            iterableObject.put("neighbors", neighborIndexList);
            trianglesJson.add(i, iterableObject);
        }
        
        fileObject.put("triangles", trianglesJson);
        try {
            FileWriter writer = new FileWriter(pathName);
            Jsoner.serialize(fileObject, writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("File writing error");
        }
    }

    public static void storeTriangles(String pathName, String pointFileName, String flipedName) {
        storeTriangles(pathName, pointFileName);
        m_dataArray = PointHandler.flipArgs(m_dataArray);
        m_TPoints = PointHandler.getTPoints(m_dataArray);
        storeTriangles(flipedName, pointFileName);

    }
}
