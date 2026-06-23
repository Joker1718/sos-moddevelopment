/*    */ package util.error;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.BoxLayout;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTextArea;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SwingMessage
/*    */ {
/*    */   public static void main(String[] args) {
/* 17 */     if (args.length == 0) {
/* 18 */       args = new String[] {
/*    */           
/* 20 */           "Dear Mac User", "You are playing Songs of Syx through Mac, this is good." + 
/* 21 */           System.lineSeparator() + "Unfortionately, the steam overlay breaks the visuals of the game." + 
/* 22 */           System.lineSeparator() + "The overlay can not be disabled by us developers, it has to be done manually by the user." + 
/* 23 */           System.lineSeparator() + "Steam > Right click Songs of Syx > Properties > General > Uncheck \"Enable the Steam Overlay while in-game\"" + 
/* 24 */           System.lineSeparator() + "if having trouble: www.reddit.com/r/songsofsyx/comments/umzi1t/deactivate_steam_overlay_to_run_game_on_mac" + 
/* 25 */           System.lineSeparator() + "Please also report this as a bug so that steam will fix this issue." + 
/* 26 */           System.lineSeparator() + "https://help.steampowered.com/en/" + 
/* 27 */           System.lineSeparator() + "The game also works fine to run like a normal app from the installation directory, being completely DRM free." + 
/* 28 */           System.lineSeparator() + "Appologies for the inconvieniance, the alternative is to delist the game for mac, which would be a travesty, since it should run fine nativly on it. The goal is to apply enough preassure on steam so that they fix it." + 
/* 29 */           System.lineSeparator()
/*    */         };
/*    */     }
/*    */ 
/*    */     
/* 34 */     String title = args[0];
/* 35 */     String mess = args[1];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private SwingMessage(String title, String message) {
/* 46 */     JFrame frame = new JFrame(title);
/*    */     
/* 48 */     frame.setDefaultCloseOperation(3);
/* 49 */     frame.setResizable(false);
/* 50 */     frame.setMinimumSize(new Dimension(700, 500));
/* 51 */     frame.setMaximumSize(new Dimension(700, 700));
/*    */     
/* 53 */     JPanel container = new JPanel();
/* 54 */     container.setLayout(new BoxLayout(container, 1));
/* 55 */     container.setBorder(new EmptyBorder(5, 5, 5, 5));
/* 56 */     setMessage(container, message);
/*    */     
/* 58 */     frame.add(container);
/*    */     
/* 60 */     frame.pack();
/* 61 */     frame.setLocationRelativeTo((Component)null);
/*    */     
/* 63 */     frame.setAutoRequestFocus(true);
/* 64 */     frame.toFront();
/* 65 */     frame.setVisible(true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void setMessage(JPanel container, String message) {
/* 71 */     JTextArea text = new JTextArea(5, 25);
/* 72 */     text.setWrapStyleWord(true);
/* 73 */     text.setLineWrap(true);
/* 74 */     text.setFont(text.getFont().deriveFont(18.0F));
/* 75 */     text.setAlignmentX(0.0F);
/* 76 */     text.setBorder(new EmptyBorder(25, 25, 5, 25));
/* 77 */     text.append(message);
/*    */     
/* 79 */     JScrollPane scroll = new JScrollPane(text);
/* 80 */     container.add(scroll);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\error\SwingMessage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */