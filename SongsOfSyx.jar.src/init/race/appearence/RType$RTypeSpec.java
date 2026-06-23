/*    */ package init.race.appearence;
/*    */ 
/*    */ import snake2d.util.file.Json;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RTypeSpec
/*    */ {
/*    */   public final double occurrence;
/*    */   public final RColors.ColorCollection skin;
/*    */   public final RColors.ColorCollection leg;
/*    */   
/*    */   RTypeSpec(RColors colors, Json json) {
/* 96 */     this.occurrence = json.has("OCCURRENCE") ? json.d("OCCURRENCE") : 0.5D;
/* 97 */     this.skin = (RColors.ColorCollection)colors.collection.read("COLOR_SKIN", json);
/* 98 */     this.leg = (RColors.ColorCollection)colors.collection.read("COLOR_LEG", json);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RType$RTypeSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */