/*    */ package init.type;
/*    */ 
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public final class HTYPE extends INFO implements MAPPED {
/*    */   private final int index;
/*    */   public final String key;
/*    */   boolean hostile;
/*    */   boolean works;
/*    */   public final COLOR color;
/*    */   
/* 16 */   HTYPE(LISTE<HTYPE> all, String key, HCLASS c, CharSequence name, CharSequence names, CharSequence desc, COLOR color, SPRITE icon) { super(name, names, desc, null);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 27 */     this.hostile = false;
/* 28 */     this.works = false;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 35 */     this.child = null;
/* 36 */     this.visible = true; this.color = color; this.CLASS = c;
/*    */     this.key = key;
/*    */     this.icon = icon;
/*    */     this.index = all.add(this);
/* 40 */     this.parent = this; } HTYPE parent; public final HCLASS CLASS; public final SPRITE icon; HTYPE child; boolean visible; public String toString() { return String.valueOf(this.name); }
/*    */ 
/*    */ 
/*    */   
/*    */   public int index() {
/* 45 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 50 */     return this.key;
/*    */   }
/*    */   
/*    */   public boolean visible() {
/* 54 */     return this.visible;
/*    */   }
/*    */   
/*    */   public HTYPE child() {
/* 58 */     return this.child;
/*    */   }
/*    */   
/*    */   public boolean isWorks() {
/* 62 */     return this.works;
/*    */   }
/*    */   
/*    */   public boolean isHostile() {
/* 66 */     return this.hostile;
/*    */   }
/*    */   
/*    */   public HCLASS parentClass() {
/* 70 */     return (parent()).CLASS;
/*    */   }
/*    */   
/*    */   public HTYPE parent() {
/* 74 */     return this.parent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HTYPE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */