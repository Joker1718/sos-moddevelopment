/*    */ package init.type;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import init.race.RACES;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public abstract class BUILDING_PREF
/*    */   implements MAPPED {
/*    */   public CharSequence name;
/*    */   private final int index;
/*    */   public final String key;
/* 16 */   public final double[] defaultPref = new double[RACES.all().size()];
/*    */   
/*    */   BUILDING_PREF(String key, LISTE<BUILDING_PREF> all) {
/* 19 */     this.name = (new INFO(new Json(PATHS.TEXT_SETTLEMENT().getFolder("structure").gets(key)))).name;
/* 20 */     this.index = all.add(this);
/* 21 */     this.key = key;
/* 22 */     RACES.map().readFill("PREFERENCE", this.defaultPref, new Json(PATHS.INIT_SETTLEMENT().getFolder("structure").gets(key)), 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 27 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract SPRITE icon();
/*    */ 
/*    */   
/*    */   public String key() {
/* 35 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\BUILDING_PREF.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */