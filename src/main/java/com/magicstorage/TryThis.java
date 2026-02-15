package com.magicstorage;

// import com.github.cliftonlabs.json_simple.JsonObject;
// import com.github.cliftonlabs.json_simple.Jsoner;

public class TryThis {
    public static void main(String[] args) {
        // JsonObject temp = new JsonObject();
        // temp.put("Name", "Jack");
        // temp.put("Felon?", true);
        // temp.put("Age", 45);
        // String writable = temp.toJson();
        
        // double[][] twodtest = PointHandler.getPointJsonData();
        // for (double[] twodtest1 : twodtest) {
        //     System.out.print("[");
        //     for (int j = 0; j < twodtest1.length; j++) {
        //         System.out.print(twodtest1[j] + ", ");
        //     }
        //     System.out.print("]\n");
        // }
        // System.out.println();
        // twodtest = PointHandler.flipArgs(twodtest);
        // for (double[] twodtest1 : twodtest) {
        //     System.out.print("[");
        //     for (int j = 0; j < twodtest1.length; j++) {
        //         System.out.print(twodtest1[j] + ", ");
        //     }
        //     System.out.print("]\n");
        // }

        //TriHandler.storeTriangles("triangles.java");

        // try (FileWriter file = new FileWriter("points.json")) {
        //     file.write(writable);
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }

        TriangleInterpolator m_triangleInterpolator = new TriangleInterpolator(
            4, 
            "10kTestTriangles.json", 
            "10kTestPoints.json"
        );
        m_triangleInterpolator.draw("C:\\Users\\DGAda\\OneDrive\\Documents\\Robotics Stufff\\2026\\shooterSpeedLeftTestImage.png",
        1000,
        1000, 0, 8.27, 8.27, 0, 0, 0, 80);
        m_triangleInterpolator.draw("C:\\Users\\DGAda\\OneDrive\\Documents\\Robotics Stufff\\2026\\shooterSpeedRightTestImage.png",
        1000,
        1000, 0, 8.27, 8.27, 0, 1, 0, 80);
        m_triangleInterpolator.draw("C:\\Users\\DGAda\\OneDrive\\Documents\\Robotics Stufff\\2026\\pivotAngleTestImage.png",
        1000, 1000,
        0, 8.27, 8.27, 0, 2, 0.3, 0.5);
        m_triangleInterpolator.draw("C:\\Users\\DGAda\\OneDrive\\Documents\\Robotics Stufff\\2026\\headingTestImage.png",
        1000, 1000, 0,
        8.27, 8.27, 0, 3, (-Math.PI)/2, (Math.PI)/2);

        // TriHandler.storeTriangles("10kTestTriangles.json", "10kTestPoints.json");
    }
}
