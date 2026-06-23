/*    */ package init.type;
/*    */ 
/*    */ import game.boosting.BoostSpecs;
/*    */ import game.time.TIME;
/*    */ import init.sprite.UI.UI;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public final class CLIMATE
/*    */   extends INFO
/*    */   implements MAPPED {
/*    */   public final String key;
/*    */   private final int index;
/*    */   public final double seasonChange;
/*    */   public final double tempCold;
/*    */   public final double tempWarm;
/*    */   public final double fertility;
/*    */   public final COLOR color;
/*    */   public final COLOR colorGroundDry;
/*    */   public final COLOR colorGroundWet;
/*    */   public final SPRITE icon;
/*    */   public final BoostSpecs boosters;
/*    */   
/*    */   CLIMATE(LISTE<CLIMATE> all, String key, CharSequence name, CharSequence desc, Json json) throws IOException {
/* 31 */     super(name, desc);
/* 32 */     this.index = all.add(this);
/* 33 */     this.key = key;
/* 34 */     json = json.json(key);
/* 35 */     this.seasonChange = json.d("SEASONAL_CHANGE", 0.0D, 1.0D);
/* 36 */     double t = json.d("TEMP_COLD", -1.0D, 1.0D);
/* 37 */     this.icon = (SPRITE)UI.icons().get(json);
/* 38 */     t = (t < 0.0D) ? (1.0D + t) : (1.0D + t);
/* 39 */     this.tempCold = t / 2.0D;
/* 40 */     t = json.d("TEMP_WARM", -1.0D, 1.0D);
/* 41 */     t = (t < 0.0D) ? (1.0D + t) : (1.0D + t);
/* 42 */     this.tempWarm = t / 2.0D;
/* 43 */     this.color = (COLOR)new ColorImp(json);
/* 44 */     this.boosters = new BoostSpecs(String.valueOf((CLIMATES.INFO()).name) + ": " + String.valueOf((CLIMATES.INFO()).name), this.icon, false);
/* 45 */     this.boosters.read(json, null);
/* 46 */     this.fertility = json.d("FERTILITY");
/* 47 */     json = json.json("GROUND");
/* 48 */     this.colorGroundDry = (COLOR)new ColorImp(json, "DRY");
/* 49 */     this.colorGroundWet = (COLOR)new ColorImp(json, "WET");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int index() {
/* 56 */     return this.index;
/*    */   }
/*    */   
/*    */   public double getPartOfYear() {
/* 60 */     int pow = (int)(this.seasonChange * 2.0D);
/* 61 */     if (pow == 0)
/* 62 */       return 0.5D; 
/* 63 */     double d = (TIME.years().bitPartOf() + 0.125D) % 1.0D;
/* 64 */     if (d < 0.5D) {
/* 65 */       d *= 2.0D;
/* 66 */       d = Math.pow(d, pow);
/* 67 */       return d * 0.5D;
/*    */     } 
/* 69 */     d -= 0.5D;
/* 70 */     d *= 2.0D;
/* 71 */     d = 1.0D - d;
/* 72 */     d = Math.pow(d, pow);
/* 73 */     d = 1.0D - d;
/* 74 */     return 0.5D + d * 0.5D;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String key() {
/* 80 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CLIMATE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */