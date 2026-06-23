/*     */ package init.race;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BV
/*     */   extends Booster
/*     */ {
/*     */   private double from;
/*     */   private double to;
/* 204 */   private final double[] dd = new double[RACES.all().size()];
/*     */   private final boolean isMul;
/*     */   public final BoostSpec spec;
/*     */   private final BValue value;
/*     */   
/*     */   BV(BoostSpecs bos, Boostable target, final boolean isMul) {
/* 210 */     super(new BSourceInfo(RACES.name(), (SPRITE)(UI.icons()).s.citizen), isMul);
/* 211 */     this.isMul = isMul;
/* 212 */     if (isMul)
/* 213 */       Arrays.fill(this.dd, 1.0D); 
/* 214 */     set();
/*     */     
/* 216 */     this.spec = bos.push(this, target);
/*     */     
/* 218 */     this.value = new BValue()
/*     */       {
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f)
/*     */         {
/* 224 */           if (f == null || f.capitolRegion() == null)
/* 225 */             return 0.0D; 
/* 226 */           return vGet(f.capitolRegion());
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Player f) {
/* 231 */           return isMul ? 1.0D : 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE popTime) {
/* 236 */           if (popTime.race == null) {
/* 237 */             double acc = 0.0D;
/* 238 */             double tot = 0.0D;
/* 239 */             for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 240 */               Race r = (Race)RACES.all().get(ri);
/* 241 */               double pop = (STATS.POP()).POP.data(popTime.cl).get(r);
/*     */               
/* 243 */               acc += RaceBoosts.BV.this.dd[r.index()] * pop;
/* 244 */               tot += pop;
/*     */             } 
/* 246 */             if (tot == 0.0D)
/* 247 */               return 0.0D; 
/* 248 */             return acc / tot;
/*     */           } 
/*     */           
/* 251 */           return RaceBoosts.BV.this.dd[popTime.race.index()];
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(Div div) {
/* 257 */           return RaceBoosts.BV.this.dd[div.info.race().index()];
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Induvidual indu) {
/* 262 */           return RaceBoosts.BV.this.dd[indu.race().index()];
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Region reg) {
/* 267 */           double acc = 0.0D;
/* 268 */           double tot = 0.0D;
/* 269 */           for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 270 */             RDRace r = (RDRace)(RD.RACES()).all.get(ri);
/* 271 */             double pop = r.pop.get(reg);
/* 272 */             acc += RaceBoosts.BV.this.dd[r.race.index()] * pop;
/* 273 */             tot += pop;
/*     */           } 
/* 275 */           if (tot == 0.0D)
/* 276 */             return 0.0D; 
/* 277 */           return acc / tot;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   void set(Race c, double value) {
/* 283 */     this.dd[c.index()] = value;
/* 284 */     set();
/*     */   }
/*     */   
/*     */   private void set() {
/* 288 */     if (this.isMul) {
/* 289 */       this.from = 1.0D;
/* 290 */       this.to = 1.0D;
/*     */     } else {
/* 292 */       this.from = 0.0D;
/* 293 */       this.to = 0.0D;
/*     */     }  byte b; int i;
/*     */     double[] arrayOfDouble;
/* 296 */     for (i = (arrayOfDouble = this.dd).length, b = 0; b < i; ) { double v = arrayOfDouble[b];
/* 297 */       this.from = Math.min(v, this.from);
/* 298 */       this.to = Math.max(v, this.to);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public double getValue(double input) {
/* 304 */     return input;
/*     */   }
/*     */ 
/*     */   
/*     */   public double from() {
/* 309 */     return this.from;
/*     */   }
/*     */ 
/*     */   
/*     */   public double to() {
/* 314 */     return this.to;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(BOOSTABLE_O o) {
/* 319 */     return o.boostableValue(this.value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceBoosts$BV.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */