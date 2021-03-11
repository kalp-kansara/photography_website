/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clients.testCLIENT;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import org.primefaces.model.file.UploadedFile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.servlet.http.Part;

/**
 *
 * @author KALP
 */
@Named(value = "testBEAN")
@ApplicationScoped
public class testBEAN {

    /**
     * Creates a new instance of testBEAN
     */
    public testBEAN() {
    }

    testCLIENT t = new testCLIENT();

    int CategoryId, UserId;
    String PhotoDescription, PhotoPathOriginal, PhotoPathWithWM;
    Boolean IsApprove;

    Part file;

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getPhotoDescription() {
        return PhotoDescription;
    }

    public void setPhotoDescription(String PhotoDescription) {
        this.PhotoDescription = PhotoDescription;
    }

    public Boolean getIsApprove() {
        return IsApprove;
    }

    public void setIsApprove(Boolean IsApprove) {
        this.IsApprove = IsApprove;
    }

    public String getPhotoPathOriginal() {
        return PhotoPathOriginal;
    }

    public void setPhotoPathOriginal(String PhotoPathOriginal) {
        this.PhotoPathOriginal = PhotoPathOriginal;
    }

    public String getPhotoPathWithWM() {
        return PhotoPathWithWM;
    }

    public void setPhotoPathWithWM(String PhotoPathWithWM) {
        this.PhotoPathWithWM = PhotoPathWithWM;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    /**
     *
     * @throws IOException
     */
//    @PostConstruct
//    public void init()
//    {
//        try {
//            System.out.println("IN init");
//            addUserUploadPhoto();
//        } catch (IOException ex) {
//            Logger.getLogger(testBEAN.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public String addUserUploadPhoto() {
        System.out.println("in add method");

        try (InputStream i = file.getInputStream()) {
            System.out.println("in add");
            String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\AllUserPhotos";
            PhotoPathOriginal = file.getSubmittedFileName();
            Files.copy(i, new File(path, PhotoPathOriginal).toPath());
            File ppathorigin = new File(path + "\\" + PhotoPathOriginal);
            BufferedImage img = ImageIO.read(ppathorigin);
            img.getHeight();
            img.getWidth();

            String pathwithwm = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\AllUserPhotosWithWM";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int fori = 0; fori < 11; fori++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();
            PhotoPathWithWM = temp + file.getSubmittedFileName();
//            Files.copy(i,new File(pathwithwm,PhotoPathWithWM).toPath());
            File ppathWithWM = new File(pathwithwm + "\\" + PhotoPathWithWM);

            BufferedImage image;
            image = ImageIO.read(ppathorigin);

            // determine image type and handle correct transparency
            int imageType = "png".equalsIgnoreCase("jpg") ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
            double dif = image.getHeight() - image.getWidth();
            BufferedImage watermarked;
            if (image.getWidth() - image.getHeight() <= 1040) {
                watermarked = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            } else {
                final double rads = Math.toRadians(90);
                final double sin = Math.abs(Math.sin(rads));
                final double cos = Math.abs(Math.cos(rads));
                final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
                final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
                watermarked = new BufferedImage(h, w, image.getType());
                final AffineTransform at = new AffineTransform();
                at.translate(w, h);
                at.rotate(rads, w, h);
                
                at.translate(-image.getWidth() , -image.getHeight() );
//                final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//                rotateOp.filter(image, watermarked);
                  
                
                
//                watermarked = new BufferedImage( w,h, BufferedImage.TYPE_INT_RGB);
            }

            // Create graphics object and add original 
            // image to it 
            Graphics graphics = watermarked.getGraphics();
            graphics.drawImage(image, 0, 0, null);

            // Set font for the watermark text 
            graphics.setFont(new Font("Arial", Font.BOLD, 150));
            graphics.setColor(new Color(0, 0, 0, 200));

            // Setting watermark text 
            String watermark = "Depths Of World";

            // Add the watermark text at (width/5, height/3) 
            // location 
            graphics.drawString(watermark, image.getWidth() / 2,
                    image.getHeight() / 2);

            // releases any system resources that it is using 
            graphics.dispose();

            t.adduseruploadphoto(UserId, CategoryId, PhotoDescription, IsApprove, PhotoPathOriginal, PhotoPathWithWM);
            ImageIO.write(watermarked, "jpg", ppathWithWM);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        String text = "Depths of world";
//        File input = new File("E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Category\\abstract.jpg");
//        File output = new File("E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Category\\abstractwithWM.jpg");
//        
//        addTextWatermark(text, "jpg", input, output);
        return "test.xhtml?faces-redirect=true";
    }

    private static void addTextWatermark(String text, String type, File source, File destination) throws IOException {
        BufferedImage image;
        image = ImageIO.read(source);

        // determine image type and handle correct transparency
        int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
        BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

        // initializes necessary graphic properties
        Graphics2D w = (Graphics2D) watermarked.getGraphics();
        w.drawImage(image, 0, 0, null);
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
        w.setComposite(alphaChannel);
        w.setColor(Color.white);
        w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        FontMetrics fontMetrics = w.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(text, w);

        // calculate center of the image
        int centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = image.getHeight() / 2;

        // add text overlay to the image
        w.drawString(text, centerX, centerY);
        ImageIO.write(watermarked, type, destination);
        w.dispose();
    }

}
