/*    */ package init.religion;
/*    */ 
/*    */ import game.boosting.BOOSTING;
/*    */ import game.boosting.BValue;
/*    */ import game.boosting.BoostSpecs;
/*    */ import game.boosting.Boostable;
/*    */ import game.boosting.BoostableCat;
/*    */ import init.paths.PATHS;
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.Icon;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ 
/*    */ public final class Religion
/*    */   implements MAPPED
/*    */ {
/*    */   private final int index;
/*    */   public final String key;
/*    */   public final COLOR color;
/*    */   public final INFO info;
/*    */   public final CharSequence diety;
/*    */   private double[] liking;
/*    */   public final Icon icon;
/*    */   public final double inclination;
/*    */   public final Boostable conversionCity;
/*    */   public final BoostSpecs boosts;
/*    */   
/*    */   Religion(String key, int index) throws IOException {
/* 35 */     this.key = key;
/* 36 */     this.index = index;
/* 37 */     Json d = json();
/* 38 */     Json t = new Json(PATHS.TEXT().getFolder("religion").gets(key));
/* 39 */     this.info = new INFO(t);
/*    */     
/* 41 */     this.diety = t.text("DEITY");
/*    */     
/* 43 */     this.color = (COLOR)new ColorImp(d);
/* 44 */     this.icon = SPRITES.icons().get(d);
/* 45 */     this.inclination = d.d("DEFAULT_SPREAD");
/*    */     
/* 47 */     this.conversionCity = BOOSTING.push(key + "_CITY", 1.0D, this.info.name, this.info.desc, (SPRITE)this.icon, (BoostableCat.ALL()).RELIGION);
/* 48 */     this.boosts = new BoostSpecs(this.info.name, (SPRITE)this.icon, false);
/* 49 */     this.boosts.read(d, BValue.VALUE1);
/*    */   }
/*    */   
/*    */   private Json json() {
/* 53 */     return new Json(PATHS.INIT().getFolder("religion").gets(this.key));
/*    */   }
/*    */   
/*    */   public double opposition(Religion other) {
/* 57 */     return this.liking[other.index()];
/*    */   }
/*    */   
/*    */   void init() {
/* 61 */     this.liking = new double[RELIGIONS.ALL().size()];
/* 62 */     RELIGIONS.MAP().readFill("OPPOSITION", this.liking, json(), 0.0D, 100.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 67 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     return "[" + this.index + "]" + this.key;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 77 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\religion\Religion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */