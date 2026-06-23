/*    */ package snake2d;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.io.File;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class PreLoaderSwing {
/*    */   private JFrame frame;
/*    */   
/*    */   public static void main(String[] args) {
/* 15 */     if (args.length == 0) {
/* 16 */       args = new String[] {
/* 17 */           "Songs of poop", 
/* 18 */           "C:\\Users\\mail__000\\Documents\\syx13\\Syx\\res\\base\\texture\\PreLoader.png"
/*    */         };
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private PreLoaderSwing(String name, String path, String iconPath) {
/*    */     try {
/* 29 */       this.frame = new JFrame(name);
/* 30 */     } catch (Exception e) {
/* 31 */       e.printStackTrace(System.out);
/*    */     } 
/*    */ 
/*    */     
/* 35 */     this.frame.setLocationRelativeTo((Component)null);
/* 36 */     this.frame.setUndecorated(true);
/* 37 */     this.frame.setAlwaysOnTop(true);
/* 38 */     JPanel panel = new JPanel();
/* 39 */     panel.setBackground(Color.BLACK);
/*    */     
/* 41 */     String preloader = path;
/*    */     
/* 43 */     if (!(new File(preloader)).exists())
/* 44 */       throw new RuntimeException("unable to find file: " + preloader); 
/* 45 */     ImageIcon icon = new ImageIcon(preloader);
/* 46 */     JLabel label = new JLabel();
/* 47 */     label.setIcon(icon);
/* 48 */     panel.add(label);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 56 */     this.frame.getContentPane().add(panel);
/* 57 */     this.frame.pack();
/*    */     
/* 59 */     this.frame.setLocation((this.frame.getLocation()).x - this.frame.getWidth() / 2, (this.frame.getLocation()).y - this.frame.getHeight() / 2);
/* 60 */     this.frame.setIconImage((new ImageIcon(iconPath)).getImage());
/* 61 */     this.frame.setFocusable(false);
/* 62 */     this.frame.setFocusableWindowState(false);
/* 63 */     this.frame.setVisible(true);
/* 64 */     this.frame.toFront();
/*    */     
/* 66 */     for (int i = 0; i < 5000; i++) {
/*    */ 
/*    */       
/*    */       try {
/*    */ 
/*    */         
/* 72 */         if (System.in.available() > 0 && System.in.read() != -1)
/*    */           break; 
/* 74 */         Thread.sleep(1L);
/* 75 */       } catch (InterruptedException|java.io.IOException e) {
/* 76 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/* 79 */     dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   private void dispose() {
/* 84 */     this.frame.setVisible(false);
/*    */     
/* 86 */     this.frame.dispose();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\PreLoaderSwing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */