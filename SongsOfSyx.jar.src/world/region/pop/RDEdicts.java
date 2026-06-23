/*     */ package world.region.pop;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RBooster;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ public class RDEdicts
/*     */ {
/*  28 */   private static CharSequence ¤¤Distant = "¤Distant";
/*     */   
/*  30 */   private static CharSequence ¤¤Prosecute = "¤Persecution";
/*  31 */   private static CharSequence ¤¤ProsecuteD = "¤Persecuting a species severely diminishes growth and decreases happiness.";
/*     */   
/*  33 */   private static CharSequence ¤¤Exile = "¤Exile";
/*  34 */   private static CharSequence ¤¤ExileD = "¤Forbid this species from immigrating and sends off any citizens to neighbouring regions where they are still welcome.";
/*     */ 
/*     */   
/*  37 */   private static CharSequence ¤¤Massacre = "¤Massacre";
/*  38 */   private static CharSequence ¤¤MassacreD = "¤Commit genocide and instantly rid yourself of this species. Will cause an outrage of course, make sure you have enough military presence to handle an eventual uprising.";
/*     */   
/*  40 */   private static double dtime = 1.0D / (TIME.secondsPerDay() * 2 * 16);
/*     */   
/*     */   static {
/*  43 */     D.ts(RDEdicts.class);
/*     */   }
/*     */   
/*     */   public final LIST<RDRaceEdict> all;
/*     */   public final RDRaceEdict sanction;
/*     */   public final RDRaceEdict exile;
/*     */   public final RDRaceEdict massacre;
/*     */   
/*     */   RDEdicts(LIST<RDRace> races, RD.RDInit init) {
/*  52 */     this.sanction = new RDRaceEdict("SANCTION", init, new INFO(¤¤Prosecute, ¤¤ProsecuteD), (SPRITE)(UI.icons()).m.descrimination, races, 0.25D, 0.5D);
/*  53 */     this.exile = new RDRaceEdict("EXILE", init, new INFO(¤¤Exile, ¤¤ExileD), (SPRITE)(UI.icons()).m.exit, races, 1.0D, 0.6D);
/*  54 */     this.massacre = new RDRaceEdict("MASSACRE", init, new INFO(¤¤Massacre, ¤¤MassacreD), (SPRITE)(UI.icons()).m.skull, races, 1.0D, 1.0D);
/*  55 */     this.all = (LIST<RDRaceEdict>)new ArrayList((Object[])new RDRaceEdict[] { this.sanction, this.exile, this.massacre });
/*  56 */     for (RDRace r : races) {
/*  57 */       init.upers.add(new Up(r));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     for (RDRace r : races) {
/*  73 */       BSourceInfo ss = new BSourceInfo(String.valueOf((STATS.MULTIPLIERS()).PROSECUTION.name) + " (" + String.valueOf((STATS.MULTIPLIERS()).PROSECUTION.name) + ")", (SPRITE)(UI.icons()).m.descrimination);
/*  74 */       (new RBooster(ss, 1.0D, 0.25D, true)
/*     */         {
/*     */           public double get(Region t)
/*     */           {
/*  78 */             return (STATS.MULTIPLIERS()).PROSECUTION.value(HCLASSES.CITIZEN(), r.race, 0);
/*     */           }
/*  81 */         }).add(r.loyalty.target);
/*     */     } 
/*     */   }
/*     */   
/*     */   private class Up
/*     */     implements RD.RDUpdatable {
/*     */     private final RDRace race;
/*     */     
/*     */     Up(RDRace r) {
/*  90 */       this.race = r;
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(Region reg, double ds) {
/*  95 */       if (reg.faction() != null && reg.capitol()) {
/*  96 */         for (RDEdicts.RDRaceEdict e : RDEdicts.this.all) {
/*  97 */           int am = 0;
/*  98 */           for (int ri = 0; ri < reg.faction().realm().regions(); ri++) {
/*  99 */             Region r = reg.faction().realm().region(ri);
/* 100 */             am += e.toggled(this.race).get(r);
/*     */           } 
/*     */           
/* 103 */           if (am > 0) {
/* 104 */             e.realm(this.race).incFraction(reg.faction(), am * 0.5D * ds * TIME.secondsPerDayI() * e.realm(this.race).max(null)); continue;
/*     */           } 
/* 106 */           e.realm(this.race).incFraction(reg.faction(), -ds * RDEdicts.dtime * e.realm(this.race).max(null));
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void init(Region reg) {
/* 118 */       if (reg.faction() == FACTIONS.player()) {
/*     */         
/* 120 */         for (RDEdicts.RDRaceEdict e : RDEdicts.this.all) {
/* 121 */           e.toggled(this.race).set(reg, 0);
/* 122 */           e.realm(this.race).setD(reg.faction(), 0.0D);
/*     */         } 
/* 124 */       } else if (reg.faction() != null && reg.capitol()) {
/* 125 */         for (RDEdicts.RDRaceEdict e : RDEdicts.this.all) {
/* 126 */           e.realm(this.race).setD(reg.faction(), 0.0D);
/* 127 */           for (int ri = 0; ri < reg.faction().realm().regions(); ri++) {
/* 128 */             Region r = reg.faction().realm().region(ri);
/* 129 */             if (e.toggled(this.race).get(r) == 1) {
/* 130 */               e.realm(this.race).setD(reg.faction(), 1.0D);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class RDRaceEdict
/*     */   {
/*     */     public final LIST<INT_O.INT_OE<Region>> toggled;
/*     */     public final LIST<INT_O.INT_OE<Faction>> realm;
/*     */     public final INFO info;
/*     */     public final SPRITE icon;
/*     */     public final BoostSpecs boosts;
/*     */     
/*     */     private RDRaceEdict(String key, RD.RDInit init, INFO info, SPRITE icon, LIST<RDRace> races, double loyalty, double growth) {
/* 147 */       this.info = info;
/*     */       
/* 149 */       ArrayList<INT_O.INT_OE<Region>> toggleds = new ArrayList(races.size());
/* 150 */       ArrayList<INT_O.INT_OE<Faction>> realms = new ArrayList(races.size());
/*     */ 
/*     */       
/* 153 */       this.boosts = new BoostSpecs(info.name, icon, true);
/*     */       
/* 155 */       for (RDRace r : races) {
/*     */         
/* 157 */         final DataO.DataBit toggled = new DataO.DataBit(init.count, key + "_RACE_TOGGLED" + key);
/* 158 */         final DataO.DataByte realm = new DataO.DataByte(init.rCount, key + "_RACE_REALM" + key);
/*     */         
/* 160 */         this.boosts.push((Booster)new RBooster(new BSourceInfo(info.name, icon), 1.0D, 1.0D - loyalty, true)
/*     */             {
/*     */               public double get(Region t)
/*     */               {
/* 164 */                 return toggled.get(t);
/*     */               }
/* 167 */             }r.loyalty.target);
/*     */         
/* 169 */         this.boosts.push((Booster)new BoosterImp(new BSourceInfo(String.valueOf(RDEdicts.¤¤Distant) + ": " + String.valueOf(RDEdicts.¤¤Distant), icon), 1.0D, 1.0D - loyalty, true)
/*     */             {
/*     */               public double vGet(Region t)
/*     */               {
/* 173 */                 if (t.faction() != null && realm.get(t.faction()) > 0)
/* 174 */                   return CLAMP.d(realm.getD(t.faction()), 0.0D, 1.0D); 
/* 175 */                 return 0.0D;
/*     */               }
/*     */ 
/*     */               
/*     */               public double vGet(Faction f) {
/* 180 */                 return CLAMP.d(realm.getD(f), 0.0D, 1.0D);
/*     */               }
/* 184 */             }r.loyalty.target);
/*     */         
/* 186 */         this.boosts.push((Booster)new RBooster(new BSourceInfo(info.name, icon), 1.0D, 1.0D - growth, true)
/*     */             {
/*     */               public double get(Region t)
/*     */               {
/* 190 */                 return toggled.get(t);
/*     */               }
/* 193 */             }r.pop.dtarget);
/*     */         
/* 195 */         toggleds.add(dataBit);
/* 196 */         realms.add(dataByte);
/*     */       } 
/*     */       
/* 199 */       this.toggled = (LIST<INT_O.INT_OE<Region>>)toggleds;
/* 200 */       this.realm = (LIST<INT_O.INT_OE<Faction>>)realms;
/*     */       
/* 202 */       this.icon = icon;
/*     */     }
/*     */     
/*     */     public INT_O.INT_OE<Region> toggled(RDRace r) {
/* 206 */       return (INT_O.INT_OE<Region>)this.toggled.get(r.index());
/*     */     }
/*     */     
/*     */     public INT_O.INT_OE<Faction> realm(RDRace r) {
/* 210 */       return (INT_O.INT_OE<Faction>)this.realm.get(r.index());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDEdicts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */