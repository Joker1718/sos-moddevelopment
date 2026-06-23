/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.religion.Religion;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
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
/*     */ public class RDReligion
/*     */ {
/*     */   public final Boostable boost;
/*     */   public final BoostSpecs boosts;
/*     */   public final Religion religion;
/*     */   public final INT_O.INT_OE<Region> current;
/*     */   
/*     */   private RDReligion(RD.RDInit init, final Religion reg) {
/* 156 */     this.boosts = new BoostSpecs(reg.info.name, (SPRITE)reg.icon, true);
/* 157 */     this.religion = reg;
/* 158 */     this.current = (INT_O.INT_OE<Region>)new DataO.DataByte(init.count, "REL" + reg.key);
/* 159 */     this.boost = BOOSTING.push("CONVERSION_" + reg.key, reg.inclination, reg.info.name, reg.info.desc, (SPRITE)reg.icon, (BoostableCat.ALL()).WORLD_CIVICS);
/* 160 */     BOOSTING.connecter(new ACTION()
/*     */         {
/*     */ 
/*     */           
/*     */           public void exe()
/*     */           {
/* 166 */             for (BoostSpec s : reg.boosts.all()) {
/*     */ 
/*     */ 
/*     */               
/* 170 */               if ((s.boostable.cat.typeMask & 0x2) != 0) {
/* 171 */                 BoosterValue b = new BoosterValue((BValue)new RDReligions.RDReligion.value(s.boostable), s.booster.info, s.booster.to(), s.booster.isMul);
/* 172 */                 RDReligions.RDReligion.this.boosts.push((Booster)b, s.boostable);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double target(Region reg) {
/* 182 */     double tot = 0.0D;
/* 183 */     for (RDReligion r : RDReligions.this.all) {
/* 184 */       tot += r.boost.get((BOOSTABLE_O)reg);
/*     */     }
/* 186 */     return this.boost.get((BOOSTABLE_O)reg) / tot;
/*     */   }
/*     */   
/*     */   public class value
/*     */     extends BValue.BValueFaction {
/*     */     value(Boostable bo) {
/* 192 */       super(bo);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 197 */       return RDReligions.RDReligion.this.current.getD(reg);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 202 */       double d = 0.0D;
/* 203 */       for (int i = 0; i < f.realm().regions(); i++) {
/* 204 */         Region reg = f.realm().region(i);
/* 205 */         d += RDReligions.RDReligion.this.current.getD(reg) * (RD.RACES()).population.get(reg);
/*     */       } 
/* 207 */       d /= (RD.RACES()).population.faction().get(f);
/* 208 */       return d;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 213 */       return 0.0D;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDReligions$RDReligion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */