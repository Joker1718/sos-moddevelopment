/*     */ package settlement.stats.muls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
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
/*     */ public abstract class StatMultiplierAction
/*     */   extends StatsMultipliers.StatMultiplier
/*     */ {
/*     */   public final SPRITE icon;
/* 298 */   private final ArrayListGrower<INT.IntImp> auto = new ArrayListGrower();
/*     */ 
/*     */   
/*     */   private StatMultiplierAction(String key, StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all, final int autoDef, int autoMax, SPRITE icon, HCLASS... cl) {
/* 302 */     super(new StatsMultipliers.C(key, init), all, cl);
/* 303 */     this.icon = icon;
/*     */     
/* 305 */     for (HCLASS_RACE c : HCLASS_RACE.ALL()) {
/* 306 */       this.auto.add(new INT.IntImp(autoDef, 0, autoMax));
/*     */     }
/* 308 */     init.savers.put("MUL_AUTO_" + key, new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/* 312 */             HCLASS_RACE.MAP().saver().save((LIST)StatsMultipliers.StatMultiplierAction.this.auto, file);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 317 */             HCLASS_RACE.MAP().loader().load((LIST)StatsMultipliers.StatMultiplierAction.this.auto, file);
/*     */           }
/*     */ 
/*     */           
/*     */           public void clear() {
/* 322 */             for (INT.IntImp i : StatsMultipliers.StatMultiplierAction.this.auto) {
/* 323 */               i.set(autoDef);
/*     */             }
/*     */           }
/*     */         });
/* 327 */     init.upers.add(new StatsInit.StatUpdatable()
/*     */         {
/*     */           int ii;
/*     */ 
/*     */           
/*     */           public void update(double ds) {
/* 333 */             if (this.ii >= 60000)
/* 334 */               this.ii = 0; 
/* 335 */             ENTITY e = SETT.ENTITIES().getAllEnts()[this.ii];
/* 336 */             if (e != null && e instanceof Humanoid) {
/* 337 */               Humanoid h = (Humanoid)e;
/* 338 */               if (StatsMultipliers.StatMultiplierAction.this.autoAmount(h.indu().clas(), h.indu().race()) > 0 && StatsMultipliers.StatMultiplierAction.this.canBeMarked(h.indu())) {
/* 339 */                 StatsMultipliers.StatMultiplierAction.this.mark(h, true);
/*     */               }
/*     */             } 
/* 342 */             this.ii++;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private StatMultiplierAction(StatsMultipliers.C c, LISTE<StatsMultipliers.StatMultiplier> all, SPRITE icon, HCLASS... cl) {
/* 349 */     super(c, all, cl);
/* 350 */     this.icon = icon;
/*     */   }
/*     */   public abstract boolean canUnmark();
/*     */   public abstract int unmarkable(HCLASS paramHCLASS, Race paramRace);
/*     */   public abstract void unmark(HCLASS paramHCLASS, Race paramRace);
/*     */   
/*     */   public boolean markIs(Humanoid a) {
/* 357 */     return markIs(a.indu());
/*     */   }
/*     */   public abstract boolean markIs(Induvidual paramInduvidual);
/*     */   public boolean canBeMarked(Induvidual a) {
/* 361 */     if (!this.classes[a.clas().index()])
/* 362 */       return false; 
/* 363 */     if (markIs(a))
/* 364 */       return false; 
/* 365 */     return (maxAmount(a.clas(), a.race()) > 0);
/*     */   }
/*     */   
/*     */   public abstract void mark(HCLASS paramHCLASS, Race paramRace, int paramInt);
/*     */   
/*     */   public final boolean consumeIs(Humanoid a) {
/* 371 */     return consumeIs(a.indu());
/*     */   }
/*     */   public abstract void mark(Humanoid paramHumanoid, boolean paramBoolean);
/*     */   public abstract void consume(Humanoid paramHumanoid);
/*     */   public abstract boolean consumeIs(Induvidual paramInduvidual);
/*     */   public abstract int maxAmount(HCLASS paramHCLASS, Race paramRace);
/*     */   public void info(GBox box, int amount) {}
/*     */   
/*     */   public abstract int autoAmount(HCLASS paramHCLASS, Race paramRace);
/*     */   
/*     */   public INT.IntImp auto(HCLASS cl, Race race) {
/* 382 */     return (INT.IntImp)this.auto.get((HCLASS_RACE.clP(race, cl)).index);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\muls\StatsMultipliers$StatMultiplierAction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */