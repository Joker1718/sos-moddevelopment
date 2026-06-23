/*    */ package util.gui.common;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
/*    */ 
/*    */ public abstract class UIPickerRes extends GuiSection {
/*    */   public UIPickerRes() {
/* 17 */     this(RESOURCES.ALL(), false);
/*    */   }
/*    */   
/*    */   public UIPickerRes(boolean includenull) {
/* 21 */     this(RESOURCES.ALL(), includenull);
/*    */   }
/*    */   
/*    */   public UIPickerRes(LIST<RESOURCE> list, boolean includenull) {
/* 25 */     int i = 0;
/* 26 */     if (includenull) {
/* 27 */       add((RENDEROBJ)new Resbutt(null, i++));
/*    */     }
/* 29 */     for (RESOURCE r : list) {
/* 30 */       Resbutt rb = new Resbutt(r, i);
/* 31 */       rb.body.moveX1Y1((rb.body.width() * i % 8), (rb.body.height() * i / 8));
/* 32 */       add((RENDEROBJ)rb);
/* 33 */       i++;
/*    */     } 
/*    */   }
/*    */   
/*    */   protected abstract RESOURCE getResource();
/*    */   
/*    */   protected void hoverResource(RESOURCE r, GBox b) {
/* 40 */     b.title(r.name);
/* 41 */     b.text(r.desc);
/* 42 */     b.NL();
/*    */   }
/*    */   
/*    */   protected abstract void select(RESOURCE paramRESOURCE, int paramInt);
/*    */   
/*    */   private class Resbutt extends GButt.ButtPanel {
/*    */     private final RESOURCE res;
/*    */     
/*    */     Resbutt(RESOURCE res, int i) {
/* 51 */       super((res == null) ? (SPRITE)(SPRITES.icons()).m.cancel : (SPRITE)res.icon());
/* 52 */       this.res = res;
/* 53 */       this.i = 0;
/* 54 */       pad(4, 4);
/*    */     }
/*    */     private int i;
/*    */     
/*    */     public void hoverInfoGet(GUI_BOX text) {
/* 59 */       if (this.res == null) {
/* 60 */         text.text(Dic.¤¤cancel);
/*    */       } else {
/* 62 */         UIPickerRes.this.hoverResource(this.res, (GBox)text);
/*    */       } 
/*    */     }
/*    */     
/*    */     protected void clickA() {
/* 67 */       UIPickerRes.this.select(this.res, this.i);
/*    */     }
/*    */ 
/*    */     
/*    */     protected void renAction() {
/* 72 */       selectedSet((UIPickerRes.this.getResource() == this.res));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */