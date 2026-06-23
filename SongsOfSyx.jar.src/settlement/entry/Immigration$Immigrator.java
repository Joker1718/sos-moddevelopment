/*     */ package settlement.entry;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Immigrator
/*     */   implements SAVABLE
/*     */ {
/* 244 */   private static double rate = 1.0D / TIME.secondsPerDay();
/*     */   
/*     */   private final Race race;
/* 247 */   private int autoAdmit = 0;
/* 248 */   private double timer = 0.0D;
/* 249 */   private double emmigrants = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final INT.INTE auto;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int wantedUltimately() {
/* 260 */     return Immigration.getImmigrants(this.race) - SETT.ENTRY().onTheirWay(this.race, HTYPES.SUBJECT());
/*     */   }
/*     */   
/*     */   private double speed(int wanted) {
/* 264 */     if (wanted <= 0) {
/* 265 */       return 0.0D;
/*     */     }
/* 267 */     if (WORLD.camps().available(this.race)) {
/* 268 */       return rate * WORLD.camps().replenishPerDay((Faction)FACTIONS.player(), this.race);
/*     */     }
/*     */ 
/*     */     
/* 272 */     return rate * (BOOSTABLES.CIVICS()).IMMIGRATION.get((BOOSTABLE_O)HCLASS_RACE.clP(this.race, HCLASSES.CITIZEN()));
/*     */   }
/*     */   
/*     */   public double secondsTillNext() {
/* 276 */     double rem = 1.0D - this.timer - (int)this.timer;
/* 277 */     double speed = speed(wantedUltimately());
/* 278 */     if (speed == 0.0D)
/* 279 */       return Double.NaN; 
/* 280 */     return rem / speed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 286 */     int wanted = wantedUltimately();
/*     */     
/* 288 */     if (wanted < 0) {
/* 289 */       this.emmigrants += -ds * wanted / 2.0D * TIME.secondsPerDay();
/* 290 */       this.timer = 0.0D;
/*     */       return;
/*     */     } 
/* 293 */     this.emmigrants = 0.0D;
/*     */     
/* 295 */     this.timer += speed(wanted) * ds;
/*     */     
/* 297 */     this.timer = CLAMP.d(this.timer, 0.0D, wanted);
/* 298 */     int a = this.auto.get();
/* 299 */     a -= POP.next(HCLASSES.CITIZEN(), this.race);
/* 300 */     int w = wanted();
/*     */ 
/*     */     
/* 303 */     if (a > 0 && w > 0) {
/* 304 */       int am = CLAMP.i(w, 0, a);
/* 305 */       SETT.ENTRY().add(this.race, HTYPES.SUBJECT(), am);
/* 306 */       this.timer -= am;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldEmmigrate() {
/* 312 */     if (this.emmigrants > 1.0D) {
/* 313 */       this.emmigrants--;
/* 314 */       return true;
/*     */     } 
/* 316 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 322 */     file.d(this.timer);
/* 323 */     file.i(this.autoAdmit);
/* 324 */     file.d(this.emmigrants);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 329 */     this.timer = file.d();
/* 330 */     this.autoAdmit = file.i();
/* 331 */     this.emmigrants = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 336 */     this.timer = 0.0D;
/* 337 */     this.autoAdmit = 0;
/*     */   }
/*     */   
/*     */   public int wanted() {
/* 341 */     return CLAMP.i((int)this.timer, 0, wantedUltimately());
/*     */   }
/*     */   Immigrator(Race race) {
/* 344 */     this.auto = new INT.INTE()
/*     */       {
/*     */         public int get()
/*     */         {
/* 348 */           return ((Immigration.Immigrator.this.race.population()).max == 0.0D) ? 40000 : Immigration.Immigrator.this.autoAdmit;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 353 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 358 */           return 40000;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 363 */           Immigration.Immigrator.this.autoAdmit = t;
/*     */         }
/*     */       };
/*     */     this.race = race;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\Immigration$Immigrator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */