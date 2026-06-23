/*    */ package view.tool;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.Icon;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ 
/*    */ public abstract class PlacableFixedImp extends PlacableFixed {
/*    */   private final CharSequence name;
/*    */   private final CharSequence desc;
/*    */   private final SPRITE icon;
/*    */   private final PLACABLE undo;
/*    */   private final int rots;
/*    */   private final int sizes;
/*    */   
/*    */   public PlacableFixedImp(CharSequence name, int rots, int sizes) {
/* 17 */     this(name, rots, sizes, null, null, null);
/*    */   }
/*    */   
/*    */   public PlacableFixedImp(CharSequence name, int rots, int sizes, CharSequence desc, SPRITE icon) {
/* 21 */     this(name, rots, sizes, desc, icon, null);
/*    */   }
/*    */   public PlacableFixedImp(CharSequence name, int rots, int sizes, CharSequence desc, SPRITE icon, PLACABLE undo) {
/*    */     Icon icon1;
/* 25 */     this.name = name;
/* 26 */     this.desc = desc;
/* 27 */     if (icon == null)
/* 28 */       icon1 = (SPRITES.icons()).m.cancel; 
/* 29 */     this.icon = (SPRITE)icon1;
/* 30 */     this.undo = undo;
/* 31 */     this.rots = rots;
/* 32 */     this.sizes = sizes;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence placableWhole(int tx1, int ty1) {
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE getIcon() {
/* 43 */     return this.icon;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 48 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 53 */     return this.undo;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverDesc(GBox box) {
/* 58 */     if (name() != null)
/* 59 */       box.title(name()); 
/* 60 */     if (this.desc != null) {
/* 61 */       box.text(this.desc);
/*    */     }
/*    */   }
/*    */   
/*    */   public final int rotations() {
/* 66 */     return this.rots;
/*    */   }
/*    */   
/*    */   public final int sizes() {
/* 70 */     return this.sizes;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableFixedImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */