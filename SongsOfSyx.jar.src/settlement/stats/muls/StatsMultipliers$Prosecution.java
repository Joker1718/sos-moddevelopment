/*     */ package settlement.stats.muls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayInt;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Prosecution
/*     */   extends StatsMultipliers.StatMultiplierAction
/*     */ {
/*     */   private final INT_O.INT_OE<Induvidual> in;
/* 391 */   protected final ArrayInt count = new ArrayInt(HCLASS_RACE.ALL().size());
/*     */   
/*     */   private Prosecution(StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all) {
/* 394 */     super("PROSECUTION", init, all, 60000, 60000, (SPRITE)(SPRITES.icons()).m.slave, new HCLASS[] { HCLASSES.CITIZEN(), HCLASSES.SLAVE() });
/* 395 */     init.savers.put("PROSECUTION_COUNT", new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 405 */             StatsMultipliers.Prosecution.this.count.clear();
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void clear() {
/* 411 */             StatsMultipliers.Prosecution.this.count.clear();
/*     */           }
/*     */         });
/* 414 */     init.count.getClass(); this.in = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "MUL_PROSECUTION");
/* 415 */     init.addable.add(new StatsInit.Addable()
/*     */         {
/*     */           public void removePrivate(Induvidual i)
/*     */           {
/* 419 */             if (i.player()) {
/* 420 */               StatsMultipliers.Prosecution.this.count.inc((INDEXED)i.popCL(), -StatsMultipliers.Prosecution.this.in.get(i));
/*     */             } else {
/* 422 */               StatsMultipliers.Prosecution.this.in.set(i, 0);
/*     */             } 
/*     */           }
/*     */           
/*     */           public void addPrivate(Induvidual i) {
/* 427 */             if (i.player()) {
/* 428 */               StatsMultipliers.Prosecution.this.count.inc((INDEXED)i.popCL(), StatsMultipliers.Prosecution.this.in.get(i));
/*     */             } else {
/* 430 */               StatsMultipliers.Prosecution.this.in.set(i, 0);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public double value(HCLASS cl, Race race, int daysBack) {
/* 438 */     return CLAMP.d(STATS.LAW().persecution(cl, race), 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markIs(Induvidual a) {
/* 449 */     return (this.in.get(a) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(Humanoid a, boolean set) {
/* 454 */     this.count.inc((INDEXED)a.indu().popCL(), -this.in.get(a.indu()));
/* 455 */     this.in.set(a.indu(), set ? 1 : 0);
/* 456 */     if (set)
/* 457 */       CRIMES.PERSECUTED().stat().commit(a.indu()); 
/* 458 */     this.count.inc((INDEXED)a.indu().popCL(), this.in.get(a.indu()));
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxAmount(HCLASS cl, Race race) {
/* 463 */     return (STATS.POP()).POP.data(cl).get(race) - this.count.get((INDEXED)cl.get(race));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark(HCLASS cl, Race race, int amount) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUnmark() {
/* 486 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int unmarkable(HCLASS cl, Race race) {
/* 491 */     return this.count.get((INDEXED)cl.get(race));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unmark(HCLASS cl, Race race) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void consume(Humanoid a) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double value(Induvidual h) {
/* 516 */     return ((this.in.get(h) == 1) ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean consumeIs(Induvidual a) {
/* 521 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void info(GBox box, int amount) {
/* 526 */     if ((SETT.ROOMS()).GUARD.employment().employed() == 0) {
/* 527 */       box.add((SPRITE)box.text().add(((SETT.ROOMS()).GUARD.employment()).verb).add(':').s().add('0'));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int autoAmount(HCLASS cl, Race race) {
/* 533 */     return (STATS.POP()).POP.data(cl).get(race) - auto(cl, race).get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\muls\StatsMultipliers$Prosecution.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */