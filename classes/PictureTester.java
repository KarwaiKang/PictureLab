/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {
    /**
     * Method to test zeroBlue
     */
    public static void testZeroBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    public static void testMirrorVerticalRightToLeft() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }

    public static void testMirrorHorizontal() {
        Picture coolBeans = new Picture("coolBeans.jpg").scale(0.5, 0.5);
        coolBeans.mirrorHorizontal();
        coolBeans.explore();
    }

    public static void testMirrorHorizontalBotToTop() {
        Picture coolBeans = new Picture("coolBeans.jpg").scale(0.5, 0.5);
        coolBeans.mirrorHorizontalBotToTop();
        coolBeans.explore();
    }

    public static void testMirrorDiagonal() {
        Picture coolBeans = new Picture("coolBeans.jpg").scale(0.5, 0.5);
        coolBeans.mirrorDiagonal();
        coolBeans.explore();
    }

    /**
     * Method to test mirrorTemple
     */
    public static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    /**
     * Method to test the collage method
     */
    public static void testCollage() {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture swan = new Picture("swan.jpg");
        swan.explore();
        swan.edgeDetection(10);
        swan.explore();
    }

    public static void testEdgeDetection2() {
        Picture coolBeans = new Picture("coolbeans.jpg");
        Picture coolerBeans = new Picture("coolbeans.jpg");
        coolBeans.explore();
        coolBeans.edgeDetection(10);
        coolBeans.explore();
        coolerBeans.edgeDetection2(0.25);
        coolerBeans.explore();
    }

    public static void testGrayscale() {
        Picture coolBeans = new Picture("coolBeans.jpg").scale(0.5, 0.5);
        coolBeans.grayscale();
        coolBeans.explore();
    }

    public static void testKeepOnlyBlue() {
        Picture coolBeans = new Picture("coolBeans.jpg").scale(0.5, 0.5);
        coolBeans.keepOnlyBlue();
        coolBeans.explore();
    }

    public static void testNegate() {
        Picture coolBeans = new Picture("coolBeans.jpg").scale(0.5, 0.5);
        coolBeans.negate();
        coolBeans.explore();
    }

    public static void testFixUnderwater() {
        Picture coolBeans = new Picture("water.jpg").scale(0.5, 0.5);
        coolBeans.explore();
        coolBeans.fixUnderwater();
        coolBeans.explore();
    }

    public static void testMirrorArms() {
        Picture snowman = new Picture("snowman.jpg");
        snowman.mirrorArms(161, 100, 300, 225);
        snowman.explore();
    }

    public static void testMirrorGull() {
        Picture seagull = new Picture("seagull.jpg");
        seagull.mirrorGull();
        seagull.explore();
    }

    public static void testCopy() {
        Picture canvas = new Picture("640x480.jpg");
        Picture coolBeans = new Picture("coolBeans.jpg");
        canvas.copy(coolBeans, 294, 511, 685, 873, 150, 220);
        canvas.explore();
    }

    public static void testMyCollage() {
        Picture canvas = new Picture("640x480.jpg");
        canvas.myCollage();
        canvas.explore();
    }

    /**
     * Main method for testing.  Every class can have a main
     * method in Java
     */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
//     testZeroBlue();
//    testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
//    testFixUnderwater();
//    testMirrorVertical();
//    testMirrorVerticalRightToLeft();
//  testMirrorHorizontal();
//  testMirrorHorizontalBotToTop();
//  testMirrorDiagonal();
//  testMirrorTemple();
//  testMirrorArms();
//  testMirrorGull();
//    testMirrorDiagonal();
//    testCollage();
//  testMyCollage();
//  testCopy();
    testEdgeDetection();
    testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}