/*     */ package util.error;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.io.File;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Paths;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ import snake2d.util.file.FileManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ErrorMessage
/*     */ {
/*     */   public static void main(String[] args) {
/*  31 */     if (args.length == 0) {
/*  32 */       args = new String[] {
/*  33 */           "test thing", 
/*  34 */           "bugs@gugs.com", 
/*  35 */           "2", 
/*  36 */           "oh no!", 
/*  37 */           "C:\\Users\\Jake\\AppData\\Roaming\\songsofsyx\\logs\\error03-22-2021-15-15-02-157.txt", 
/*  38 */           "C:", 
/*  39 */           "Runtime..."
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*  44 */     String pgmname = args[0];
/*  45 */     String bugmail = args[1];
/*  46 */     int type = Integer.parseInt(args[2]);
/*  47 */     String message = args[3];
/*  48 */     String dump = args[4];
/*  49 */     String path = (args.length > 5) ? args[5] : null;
/*  50 */     String key = args[6];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ErrorMessage(String pgmname, String bugMail, int type, String message, String dump, String path, String key) {
/*  61 */     JFrame frame = new JFrame(pgmname + " Error Message");
/*     */     
/*  63 */     frame.setDefaultCloseOperation(3);
/*  64 */     frame.setResizable(false);
/*  65 */     frame.setMinimumSize(new Dimension(700, 100));
/*  66 */     frame.setMaximumSize(new Dimension(700, 700));
/*     */     
/*  68 */     JPanel container = new JPanel();
/*  69 */     container.setLayout(new BoxLayout(container, 1));
/*  70 */     container.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  71 */     if (type == 0) {
/*  72 */       setHeader(container, new Color(230, 200, 128), "Failed loading assets!");
/*  73 */       setFile(container, path);
/*  74 */       setMessage(container, message);
/*  75 */     } else if (type == 1) {
/*  76 */       setHeader(container, new Color(230, 200, 128), "Game Notification");
/*  77 */       setMessage(container, message);
/*     */     }
/*  79 */     else if (type == 2) {
/*  80 */       setHeader(container, new Color(230, 200, 128), "Output");
/*  81 */       if ((new File(path)).exists())
/*  82 */         setFile(container, path); 
/*  83 */       setMessage(container, message);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  88 */       setHeader(container, new Color(240, 20, 20), "Unexpected Problems!");
/*  89 */       setMessage(container, message);
/*  90 */       setDump(container, dump, bugMail, key);
/*     */     } 
/*     */     
/*  93 */     frame.add(container);
/*     */     
/*  95 */     frame.pack();
/*  96 */     frame.setLocationRelativeTo((Component)null);
/*     */     
/*  98 */     frame.setAutoRequestFocus(true);
/*  99 */     frame.toFront();
/* 100 */     frame.setVisible(true);
/*     */   }
/*     */   
/*     */   private final void setHeader(JPanel container, Color col, String m) {
/* 104 */     JLabel header = new JLabel(m);
/* 105 */     header.setFont(header.getFont().deriveFont(24.0F));
/* 106 */     JPanel c = new JPanel();
/* 107 */     c.setBackground(col);
/* 108 */     c.setAlignmentX(0.5F);
/* 109 */     c.setAlignmentY(0.0F);
/* 110 */     c.add(header);
/* 111 */     container.add(c);
/*     */   } private final void setFile(JPanel container, String filepath) {
/*     */     final String p;
/*     */     JLabel label;
/* 115 */     JPanel file = new JPanel();
/*     */ 
/*     */     
/* 118 */     if (filepath == null) {
/* 119 */       filepath = "null";
/*     */     }
/* 121 */     if (filepath != null && (new File(filepath)).exists()) {
/* 122 */       label = new JLabel("file corrupt:");
/* 123 */       p = filepath;
/*     */     }
/* 125 */     else if (filepath.endsWith(File.separator)) {
/* 126 */       String pa = filepath.substring(0, filepath.length() - 1);
/* 127 */       int last = pa.lastIndexOf(File.separator);
/* 128 */       String fol = pa.substring(last, pa.length());
/* 129 */       label = new JLabel("directory missing: " + fol);
/* 130 */       p = pa.substring(0, last);
/*     */     } else {
/* 132 */       String pa = filepath;
/* 133 */       int last = pa.lastIndexOf(File.separator) + 1;
/* 134 */       String fol = pa.substring(last, pa.length());
/* 135 */       label = new JLabel("file missing: " + fol);
/* 136 */       p = pa.substring(0, last);
/*     */     } 
/*     */ 
/*     */     
/* 140 */     label.setFont(label.getFont().deriveFont(16.0F));
/* 141 */     file.add(label);
/*     */     
/* 143 */     JLabel path = new JLabel(p);
/* 144 */     path.setFont(label.getFont().deriveFont(16.0F));
/* 145 */     path.setForeground(Color.blue);
/*     */     
/* 147 */     path.setCursor(Cursor.getPredefinedCursor(12));
/*     */     
/* 149 */     path.addMouseListener(new MouseListener()
/*     */         {
/*     */           public void mouseReleased(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mousePressed(MouseEvent e) {
/*     */             try {
/* 160 */               FileManager.openDesctop(p);
/* 161 */             } catch (Exception exception) {}
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseExited(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseEntered(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseClicked(MouseEvent e) {}
/*     */         });
/* 187 */     file.add(path);
/*     */ 
/*     */ 
/*     */     
/* 191 */     label.setAlignmentX(0.0F);
/* 192 */     container.add(file);
/*     */   }
/*     */   
/*     */   private void setMessage(JPanel container, String message) {
/* 196 */     JTextArea text = new JTextArea(5, 25);
/* 197 */     text.setWrapStyleWord(true);
/* 198 */     text.setLineWrap(true);
/* 199 */     text.setFont(text.getFont().deriveFont(18.0F));
/* 200 */     text.setAlignmentX(0.0F);
/* 201 */     text.setBorder(new EmptyBorder(25, 25, 5, 25));
/* 202 */     text.append(message);
/*     */     
/* 204 */     JScrollPane scroll = new JScrollPane(text);
/* 205 */     container.add(scroll);
/*     */   }
/*     */   
/*     */   private void setDump(JPanel container, final String dumpfile, final String mail, final String key) {
/* 209 */     if (dumpfile == null || dumpfile.equals("none")) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 215 */     JPanel panel = new JPanel();
/* 216 */     panel.setLayout(new BoxLayout(panel, 1));
/* 217 */     JLabel label = new JLabel("Please report this terrible incident!");
/* 218 */     label.setFont(label.getFont().deriveFont(20.0F));
/* 219 */     label.setAlignmentX(0.5F);
/* 220 */     panel.add(label);
/*     */     
/* 222 */     label = new JLabel("(By doing so you will share your computers specs with the developer, used for debugging)");
/* 223 */     label.setFont(label.getFont().deriveFont(12.0F));
/* 224 */     label.setAlignmentX(0.5F);
/* 225 */     panel.add(label);
/*     */     
/* 227 */     JTextField f = new JTextField("please send file to: " + mail);
/* 228 */     f.setEditable(false);
/* 229 */     f.setAlignmentX(0.5F);
/* 230 */     panel.add(f);
/*     */ 
/*     */     
/* 233 */     container.add(panel);
/*     */ 
/*     */ 
/*     */     
/* 237 */     panel = new JPanel();
/*     */     
/* 239 */     label = new JLabel("Dump file: ");
/* 240 */     label.setFont(label.getFont().deriveFont(16.0F));
/* 241 */     label.setAlignmentX(0.0F);
/* 242 */     panel.add(label);
/*     */     
/* 244 */     label = new JLabel(dumpfile);
/* 245 */     label.setFont(label.getFont().deriveFont(12.0F));
/* 246 */     label.setForeground(Color.blue);
/* 247 */     label.setCursor(Cursor.getPredefinedCursor(12));
/* 248 */     label.addMouseListener(new MouseListener()
/*     */         {
/*     */           public void mouseReleased(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mousePressed(MouseEvent e) {
/* 258 */             FileManager.openDesctop(dumpfile);
/* 259 */             System.exit(0);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseExited(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseEntered(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseClicked(MouseEvent e) {}
/*     */         });
/* 280 */     panel.add(label);
/* 281 */     container.add(panel);
/*     */     
/* 283 */     panel = new JPanel();
/*     */     
/* 285 */     label = new JLabel("Message: ");
/* 286 */     label.setFont(label.getFont().deriveFont(16.0F));
/* 287 */     label.setAlignmentX(0.0F);
/* 288 */     panel.add(label);
/* 289 */     container.add(panel);
/*     */ 
/*     */     
/* 292 */     final JTextArea text = new JTextArea(5, 25);
/* 293 */     text.setWrapStyleWord(true);
/* 294 */     text.setLineWrap(false);
/* 295 */     text.setFont(text.getFont().deriveFont(18.0F));
/* 296 */     text.setAlignmentX(0.0F);
/* 297 */     text.setBorder(new EmptyBorder(5, 5, 5, 5));
/* 298 */     text.append("It just happened, man!");
/* 299 */     final JTextArea mess = text;
/* 300 */     JScrollPane scroll = new JScrollPane(text);
/* 301 */     container.add(scroll);
/*     */     
/* 303 */     JPanel c = new JPanel();
/*     */     
/* 305 */     final JButton ok = new JButton("REPORT");
/* 306 */     ok.addActionListener(new ActionListener() {
/*     */           boolean sent = false;
/*     */           
/*     */           public void actionPerformed(ActionEvent e) {
/* 310 */             if (this.sent)
/*     */               return; 
/* 312 */             this.sent = true;
/*     */             try {
/* 314 */               if ((new ErrorSender()).send(key, text.getText(), new String(Files.readAllBytes(Paths.get(dumpfile, new String[0]))))) {
/* 315 */                 System.exit(0);
/*     */               } else {
/* 317 */                 String m = "";
/*     */                 try {
/* 319 */                   m = mess.getText() + "\n" + mess.getText();
/*     */                 }
/* 321 */                 catch (Exception e1) {
/* 322 */                   e1.printStackTrace();
/* 323 */                   if (!FileManager.sendEmail(mail, m, "Bug")) {
/* 324 */                     ok.setText("ERROR..");
/*     */                   } else {
/* 326 */                     System.exit(0);
/*     */                   }
/*     */                 
/*     */                 }
/*     */               
/*     */               } 
/* 332 */             } catch (Exception e2) {
/* 333 */               e2.printStackTrace();
/* 334 */               String m = "";
/*     */               try {
/* 336 */                 m = mess.getText() + "\n" + mess.getText();
/*     */               }
/* 338 */               catch (Exception e1) {
/* 339 */                 e1.printStackTrace();
/* 340 */                 if (!FileManager.sendEmail(mail, m, "Bug")) {
/* 341 */                   ok.setText("ERROR..");
/*     */                 } else {
/* 343 */                   System.exit(0);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 356 */     ok.setFont(ok.getFont().deriveFont(24.0F));
/* 357 */     ok.setAlignmentX(0.5F);
/* 358 */     ok.setBackground(new Color(200, 200, 200));
/* 359 */     c.add(ok);
/*     */     
/* 361 */     c.setBorder(new EmptyBorder(15, 0, 5, 0));
/* 362 */     container.add(c);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\error\ErrorMessage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */