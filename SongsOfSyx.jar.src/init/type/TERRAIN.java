/*    */ package init.type;
/*    */ 
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public abstract class TERRAIN
/*    */   extends INFO implements MAPPED {
/*    */   public final String key;
/*    */   private final int index;
/*    */   public final boolean world;
/*    */   
/*    */   TERRAIN(ArrayList<TERRAIN> all, String key, Json json, CharSequence name, CharSequence desc, boolean world) {
/* 16 */     super(name, desc);
/* 17 */     this.key = key;
/* 18 */     json.json(key);
/* 19 */     this.index = all.add(this);
/* 20 */     this.world = world;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 25 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract SPRITE icon();
/*    */   
/*    */   public abstract double value(int paramInt1, int paramInt2);
/*    */   
/*    */   public String key() {
/* 34 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TERRAIN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */