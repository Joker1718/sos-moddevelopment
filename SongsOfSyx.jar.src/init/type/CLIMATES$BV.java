/*     */ package init.type;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 188 */   private final double[] values = new double[CLIMATES.ALL().size()];
/*     */   private final boolean isMul;
/*     */   public final BoostSpec spec;
/*     */   private final BValue value;
/*     */   
/*     */   BV(BoostSpecs bos, Boostable target, boolean isMul) {
/* 194 */     super(new BSourceInfo((CLIMATES.INFO()).name, (SPRITE)(UI.icons()).s.heat), isMul);
/* 195 */     this.isMul = isMul;
/* 196 */     if (isMul)
/* 197 */       Arrays.fill(this.values, 1.0D); 
/* 198 */     set();
/* 199 */     this.spec = bos.push(this, target);
/* 200 */     this.value = new BValue()
/*     */       {
/*     */         public double vGet(Region reg)
/*     */         {
/* 204 */           if (reg == null)
/* 205 */             return 0.0D; 
/* 206 */           double res = 0.0D;
/* 207 */           for (int ci = 0; ci < CLIMATES.ALL().size(); ci++) {
/* 208 */             res += CLIMATES.BV.this.values[ci] * reg.info.climate((CLIMATE)CLIMATES.ALL().get(ci));
/*     */           }
/*     */           
/* 211 */           return res;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Faction f) {
/* 216 */           if (f == null)
/* 217 */             return 0.0D; 
/* 218 */           return super.vGet(f);
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Induvidual indu) {
/* 223 */           return vGet(indu.faction());
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Div div) {
/* 228 */           return vGet(div.faction());
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE popTime) {
/* 233 */           if (FACTIONS.player() == null)
/* 234 */             return 0.0D; 
/* 235 */           return vGet(FACTIONS.player());
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Player f) {
/* 240 */           if (f.capitolRegion() == null)
/* 241 */             return 0.0D; 
/* 242 */           return CLIMATES.BV.this.values[((CLIMATE)(WORLD.CLIMATE()).getter.get(f.capitolRegion().cx(), f.capitolRegion().cy())).index()];
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f) {
/* 247 */           return vGet(f.capitolRegion());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   void set(CLIMATE c, double value) {
/* 253 */     this.values[c.index()] = value;
/* 254 */     set();
/*     */   }
/*     */   
/*     */   private void set() {
/* 258 */     if (this.isMul) {
/* 259 */       this.from = 1.0D;
/* 260 */       this.to = 1.0D;
/*     */     } else {
/* 262 */       this.from = 0.0D;
/* 263 */       this.to = 0.0D;
/*     */     }  byte b; int i;
/*     */     double[] arrayOfDouble;
/* 266 */     for (i = (arrayOfDouble = this.values).length, b = 0; b < i; ) { double v = arrayOfDouble[b];
/*     */       
/* 268 */       this.from = Math.min(v, this.from);
/* 269 */       this.to = Math.max(v, this.to);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double from() {
/* 279 */     return this.from;
/*     */   }
/*     */ 
/*     */   
/*     */   public double to() {
/* 284 */     return this.to;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/* 289 */     return input;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(BOOSTABLE_O o) {
/* 294 */     return o.boostableValue(this.value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CLIMATES$BV.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */