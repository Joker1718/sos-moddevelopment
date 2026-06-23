/*    */ package view.ui.message;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import util.gui.misc.GTextR;
/*    */ import util.gui.table.GScrollRows;
/*    */ 
/*    */ public class MessageText
/*    */   extends Message {
/*    */   private static final long serialVersionUID = 1L;
/* 15 */   private String[] paragraphs = new String[0];
/*    */   
/*    */   public MessageText(CharSequence title) {
/* 18 */     super(title);
/*    */   }
/*    */   
/*    */   public MessageText(CharSequence title, CharSequence body) {
/* 22 */     this(title);
/* 23 */     paragraph(body);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageText(Json json) {
/* 29 */     this(json.text("TITLE"));
/* 30 */     if (json.has("PARAGRAPHS")) {
/* 31 */       byte b; int i; String[] arrayOfString; for (i = (arrayOfString = json.texts("PARAGRAPHS")).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 32 */         paragraph(s); b++; } 
/* 33 */     } else if (json.has("MESSAGE")) {
/* 34 */       paragraph(json.text("MESSAGE"));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageText paragraph(CharSequence text) {
/* 40 */     String[] ps = new String[this.paragraphs.length + 2];
/* 41 */     for (int i = 0; i < this.paragraphs.length; i++) {
/* 42 */       ps[i] = this.paragraphs[i];
/*    */     }
/* 44 */     ps[ps.length - 2] = " ";
/* 45 */     ps[ps.length - 1] = String.valueOf(text);
/* 46 */     this.paragraphs = ps;
/* 47 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected RENDEROBJ makeSection() {
/* 53 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/* 54 */     Font f = (UI.FONT()).M;
/*    */     
/* 56 */     int mw = 0; byte b; int i;
/*    */     String[] arrayOfString;
/* 58 */     for (i = (arrayOfString = this.paragraphs).length, b = 0; b < i; ) { String body = arrayOfString[b];
/* 59 */       int ei = 0;
/* 60 */       while (ei < body.length()) {
/* 61 */         int n = f.getEndIndex(body, ei, 600);
/* 62 */         GTextR t = new GTextR(f, body.subSequence(ei, n));
/* 63 */         mw = Math.max(mw, t.body().width());
/* 64 */         rows.add(t);
/*    */         
/* 66 */         n = f.getStartIndex(body, n);
/* 67 */         ei = f.getStartIndex(body, n);
/*    */       } 
/*    */       b++; }
/*    */     
/* 71 */     if (rows.size() * f.height() < 600) {
/* 72 */       GuiSection s = new GuiSection();
/* 73 */       for (RENDEROBJ r : rows)
/* 74 */         s.addDown(0, r); 
/* 75 */       return (RENDEROBJ)s;
/*    */     } 
/*    */     
/* 78 */     rows.add(new RENDEROBJ.RenderDummy(mw + 16, 1));
/* 79 */     return (RENDEROBJ)(new GScrollRows((Iterable)rows, 600)).view();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\message\MessageText.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */