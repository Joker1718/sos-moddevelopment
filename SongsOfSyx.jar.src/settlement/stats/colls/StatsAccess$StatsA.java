/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.environment.SettEnvShape;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatBooster;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatsA
/*     */   extends StatCollection
/*     */ {
/*     */   private final STAT WATER;
/* 169 */   private final ArrayListGrower<StatsAccess.Env> envs = new ArrayListGrower();
/*     */   
/*     */   private StatsA(StatsInit init) {
/* 172 */     super(init, "ACCESS", StatsAccess.¤¤nameA, StatsAccess.¤¤descA);
/* 173 */     for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) {
/*     */       
/* 175 */       StatInfo info = new StatInfo(e.info.name, e.info.names, e.info.desc);
/* 176 */       info.setOpinion(e.op);
/* 177 */       info.icon = e.icon;
/* 178 */       String dkey = this.key + "_" + this.key;
/* 179 */       init.count.getClass(); final STATData d = new STATData(e.key, init, (DataO.DataAbs)new DataO.DataNibble(init.count, dkey), info);
/* 180 */       init.onArrivalStats.add(d);
/* 181 */       d.standing = new StatStanding((STAT)d, 0.0D, e.standing);
/*     */       
/* 183 */       ACTION ac = new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 187 */             for (BoostSpec sp : e.bonuses.all()) {
/*     */               
/* 189 */               StatBooster vv = StatBooster.make((STAT)d);
/* 190 */               BoosterValue boosterValue = new BoosterValue((BValue)vv, sp.booster.info, sp.booster.to(), sp.booster.isMul);
/* 191 */               d.boosters.push((Booster)boosterValue, sp.boostable);
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/* 196 */       BOOSTING.connecter(ac);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 201 */     for (SettEnvShape.Type t : (SETT.ENV()).map.SHAPE.all) {
/* 202 */       this.envs.add(new StatsAccess.Env(init, t));
/*     */     }
/*     */     
/* 205 */     this.WATER = (STAT)new STATFake(this.key + "_WATER", init, null)
/*     */       {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack)
/*     */         {
/* 209 */           double d = (SETT.ENV()).map.WATER_SALT.stat().data(s).getD(r) + (SETT.ENV()).map.WATER_SWEET.stat().data(s).getD(r);
/* 210 */           d = CLAMP.d(d, 0.0D, 1.0D);
/* 211 */           return d;
/*     */         }
/*     */ 
/*     */         
/*     */         public double induGet(Induvidual t) {
/* 216 */           double a = (SETT.ENV()).map.WATER_SALT.stat().indu().getD(t) + (SETT.ENV()).map.WATER_SWEET.stat().indu().getD(t);
/* 217 */           return CLAMP.d(a, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */     
/* 221 */     (this.WATER.info()).icon = (SPRITE)(UI.icons()).m.water;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAccess$StatsA.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */