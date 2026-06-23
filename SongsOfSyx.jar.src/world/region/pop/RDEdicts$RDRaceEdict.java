/*     */ package world.region.pop;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.Faction;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RBooster;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RDRaceEdict
/*     */ {
/*     */   public final LIST<INT_O.INT_OE<Region>> toggled;
/*     */   public final LIST<INT_O.INT_OE<Faction>> realm;
/*     */   public final INFO info;
/*     */   public final SPRITE icon;
/*     */   public final BoostSpecs boosts;
/*     */   
/*     */   private RDRaceEdict(String key, RD.RDInit init, INFO info, SPRITE icon, LIST<RDRace> races, double loyalty, double growth) {
/* 147 */     this.info = info;
/*     */     
/* 149 */     ArrayList<INT_O.INT_OE<Region>> toggleds = new ArrayList(races.size());
/* 150 */     ArrayList<INT_O.INT_OE<Faction>> realms = new ArrayList(races.size());
/*     */ 
/*     */     
/* 153 */     this.boosts = new BoostSpecs(info.name, icon, true);
/*     */     
/* 155 */     for (RDRace r : races) {
/*     */       
/* 157 */       final DataO.DataBit toggled = new DataO.DataBit(init.count, key + "_RACE_TOGGLED" + key);
/* 158 */       final DataO.DataByte realm = new DataO.DataByte(init.rCount, key + "_RACE_REALM" + key);
/*     */       
/* 160 */       this.boosts.push((Booster)new RBooster(new BSourceInfo(info.name, icon), 1.0D, 1.0D - loyalty, true)
/*     */           {
/*     */             public double get(Region t)
/*     */             {
/* 164 */               return toggled.get(t);
/*     */             }
/* 167 */           }r.loyalty.target);
/*     */       
/* 169 */       this.boosts.push((Booster)new BoosterImp(new BSourceInfo(String.valueOf(RDEdicts.¤¤Distant) + ": " + String.valueOf(RDEdicts.¤¤Distant), icon), 1.0D, 1.0D - loyalty, true)
/*     */           {
/*     */             public double vGet(Region t)
/*     */             {
/* 173 */               if (t.faction() != null && realm.get(t.faction()) > 0)
/* 174 */                 return CLAMP.d(realm.getD(t.faction()), 0.0D, 1.0D); 
/* 175 */               return 0.0D;
/*     */             }
/*     */ 
/*     */             
/*     */             public double vGet(Faction f) {
/* 180 */               return CLAMP.d(realm.getD(f), 0.0D, 1.0D);
/*     */             }
/* 184 */           }r.loyalty.target);
/*     */       
/* 186 */       this.boosts.push((Booster)new RBooster(new BSourceInfo(info.name, icon), 1.0D, 1.0D - growth, true)
/*     */           {
/*     */             public double get(Region t)
/*     */             {
/* 190 */               return toggled.get(t);
/*     */             }
/* 193 */           }r.pop.dtarget);
/*     */       
/* 195 */       toggleds.add(dataBit);
/* 196 */       realms.add(dataByte);
/*     */     } 
/*     */     
/* 199 */     this.toggled = (LIST<INT_O.INT_OE<Region>>)toggleds;
/* 200 */     this.realm = (LIST<INT_O.INT_OE<Faction>>)realms;
/*     */     
/* 202 */     this.icon = icon;
/*     */   }
/*     */   
/*     */   public INT_O.INT_OE<Region> toggled(RDRace r) {
/* 206 */     return (INT_O.INT_OE<Region>)this.toggled.get(r.index());
/*     */   }
/*     */   
/*     */   public INT_O.INT_OE<Faction> realm(RDRace r) {
/* 210 */     return (INT_O.INT_OE<Faction>)this.realm.get(r.index());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDEdicts$RDRaceEdict.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */