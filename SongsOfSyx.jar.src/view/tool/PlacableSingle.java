/*    */ package view.tool;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ 
/*    */ public abstract class PlacableSingle
/*    */   implements PLACABLE {
/*    */   private final CharSequence name;
/*    */   private final CharSequence desc;
/*    */   private final PLACABLE undo;
/*    */   PLACER_TYPE previous;
/*    */   
/*    */   public PlacableSingle(CharSequence name) {
/* 16 */     this(name, null, null);
/*    */   }
/*    */   
/*    */   public PlacableSingle(CharSequence name, CharSequence desc) {
/* 20 */     this(name, desc, null);
/*    */   }
/*    */   
/*    */   public PlacableSingle(CharSequence name, CharSequence desc, PLACABLE undo) {
/* 24 */     this.name = name;
/* 25 */     this.desc = desc;
/* 26 */     this.undo = undo;
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE getIcon() {
/* 31 */     return (SPRITE)(SPRITES.icons()).m.cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 36 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 41 */     return this.undo;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverDesc(GBox box) {
/* 46 */     if (this.name != null)
/* 47 */       box.title(this.name); 
/* 48 */     if (this.desc != null)
/* 49 */       box.text(this.desc); 
/*    */   }
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public abstract CharSequence isPlacable(int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract void placeFirst(int paramInt1, int paramInt2);
/*    */   
/*    */   public void placeExpanded(int tx, int ty) {}
/*    */   
/*    */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, boolean isPlacable) {
/* 63 */     (SPRITES.cons()).BIG.dashedThick.render(r, mask, x, y);
/*    */   }
/*    */   
/*    */   public void placeInfo(GBox b, int tiles) {}
/*    */   
/*    */   protected void init(int tx, int ty) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableSingle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */