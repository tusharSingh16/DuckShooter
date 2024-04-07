package utility;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import java.util.ArrayList;
import java.io.File;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;

// To Load or Save (Sprite sheets)
public class LoadSave {
    public static final String HUD = "spritesheet_hud";
    public static final String OBJECTS = "spritesheet_objects";
    public static final String STALL = "spritesheet_stall";

    public static BufferedImage[] LoadSprites(String filename) {
        ArrayList<ArrayList<String>> metaData = readXML(filename);
        BufferedImage img = getSpriteAtlas(filename);

        BufferedImage[] imgs = new BufferedImage[metaData.size()];
        for (int i=0;i<metaData.size();i++) {
            int x = Integer.parseInt(metaData.get(i).get(1));
            int y = Integer.parseInt(metaData.get(i).get(2));
            int width = Integer.parseInt(metaData.get(i).get(3));
            int height = Integer.parseInt(metaData.get(i).get(4));
            imgs[i] = img.getSubimage(x, y, width, height);
        }
        return imgs;
    }

    public static BufferedImage getSpriteAtlas(String filename) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(LoadSave.class.getResourceAsStream("/"+filename+".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }


    public static ArrayList<ArrayList<String>> readXML(String filename) {
        ArrayList<ArrayList<String>> spriteMetadata = new ArrayList<>();
        try {
            // Parse the XML file
            File file = new File("/Users/devanshu/IdeaProjects/DuckShooter/res/" + filename + ".xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            // Get all <SubTexture> nodes
            NodeList subTextureNodes = doc.getElementsByTagName("SubTexture");

            // Iterate through each <SubTexture> node
            for (int i = 0; i < subTextureNodes.getLength(); i++) {
                Node subTextureNode = subTextureNodes.item(i);
                if (subTextureNode.getNodeType() == Node.ELEMENT_NODE) {
                    // Created an ArrayList to store extracted values
                    ArrayList<String> internalNode = new ArrayList<>();

                    Element subTextureElement = (Element) subTextureNode;

                    String name = subTextureElement.getAttribute("name");
                    String x = subTextureElement.getAttribute("x");
                    String y = subTextureElement.getAttribute("y");
                    String width = subTextureElement.getAttribute("width");
                    String height = subTextureElement.getAttribute("height");

                    internalNode.add(name);
                    internalNode.add(x);
                    internalNode.add(y);
                    internalNode.add(width);
                    internalNode.add(height);

                    spriteMetadata.add(internalNode);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return spriteMetadata;
    }

    public static synchronized void playSound(final String filename) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(LoadSave.class.getResourceAsStream("/"+filename+".wav"));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    // Functions used to play sound initially

//    public static void playSound(String str) {
//        try {
//            playSoundHelper(str);
//        } catch (LineUnavailableException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void playSoundHelper(String str) throws LineUnavailableException, IOException {
//        AudioInputStream audioInputStream = null;
//        try {
//            audioInputStream = AudioSystem.getAudioInputStream(new File(str).getAbsoluteFile());
//        } catch (UnsupportedAudioFileException | IOException e) {
//            throw new RuntimeException(e);
//        }
//        Clip clip = null;
//        try {
//            clip = AudioSystem.getClip();
//        } catch (LineUnavailableException e) {
//            throw new RuntimeException(e);
//        }
//        clip.open(audioInputStream);
//        clip.start();
//    }
}

