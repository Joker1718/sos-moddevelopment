/*    */ package view.tool;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.gui.misc.GBox;
/*    */ import view.subview.GameWindow;
/*    */ 
/*    */ public abstract class PlacableSimple
/*    */   implements PLACABLE {
/*    */   private final CharSequence name;
/*    */   private final CharSequence desc;
/*    */   private final PLACABLE undo;
/*    */   
/*    */   public PlacableSimple(CharSequence name) {
/* 18 */     this(name, null, null);
/*    */   }
/*    */   
/*    */   public PlacableSimple(CharSequence name, CharSequence desc) {
/* 22 */     this(name, desc, null);
/*    */   }
/*    */   
/*    */   public PlacableSimple(CharSequence name, CharSequence desc, PLACABLE undo) {
/* 26 */     this.name = name;
/* 27 */     this.desc = desc;
/* 28 */     this.undo = undo;
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE getIcon() {
/* 33 */     return (SPRITE)(SPRITES.icons()).m.cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 38 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 43 */     return this.undo;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverDesc(GBox box) {
/* 48 */     box.title(this.name);
/* 49 */     box.text(this.desc);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract CharSequence isPlacable(int paramInt1, int paramInt2);
/*    */   
/*    */   public void renderPlaceHolder(SPRITE_RENDERER r, int cx, int cy, boolean isPlacable) {
/* 56 */     if (!isPlacable) {
/* 57 */       (GCOLOR.MAP()).OK.bind();
/*    */     } else {
/* 59 */       (GCOLOR.MAP()).BAD.bind();
/* 60 */     }  (SPRITES.cons()).BIG.dashedThick.get(0).renderC(r, cx, cy);
/* 61 */     COLOR.unbind();
/*    */   }
/*    */   
/*    */   public abstract void place(int paramInt1, int paramInt2);
/*    */   
/*    */   public void renderOverlay(int x, int y, SPRITE_RENDERER r, float ds, GameWindow window) {}
/*    */   
/*    */   public void placeInfo(GBox hoverBox, int cx, int cy) {}
/*    */   
/*    */   public void renderAction(int cx, int cy) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableSimple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */