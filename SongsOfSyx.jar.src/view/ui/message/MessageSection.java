/*    */ package view.ui.message;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import util.gui.misc.GText;
/*    */ 
/*    */ public abstract class MessageSection
/*    */   extends Message {
/*    */   private static final long serialVersionUID = 1L;
/*    */   protected static final int WIDTH = 900;
/*    */   private static final int PM = 10;
/*    */   private transient GuiSection section;
/*    */   
/*    */   public MessageSection(CharSequence title) {
/* 19 */     super(title);
/*    */   }
/*    */   
/*    */   protected MessageSection paragraph(CharSequence text) {
/* 23 */     GText t = (new GText((UI.FONT()).M, text)).clickify();
/* 24 */     t.setMaxWidth(880);
/* 25 */     t.adjustWidth();
/* 26 */     this.section.add((SPRITE)t, 0, this.section.getLastY2() + 10);
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   protected MessageSection paragraph(CharSequence text, Font font, COLOR color) {
/* 31 */     GText t = (new GText(font, text)).color(color);
/* 32 */     t.setMaxWidth(880);
/* 33 */     t.adjustWidth();
/* 34 */     this.section.add((SPRITE)t, 0, this.section.getLastY2() + 10);
/* 35 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   protected GuiSection makeSection() {
/* 40 */     this.section = new GuiSection();
/* 41 */     make(this.section);
/* 42 */     return this.section;
/*    */   }
/*    */   
/*    */   protected abstract void make(GuiSection paramGuiSection);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\message\MessageSection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */