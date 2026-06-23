/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.BUILDING_PREFS;
/*     */ import init.type.HCLASS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.water.pool.ROOM_POOL;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public class StatsEnv
/*     */   extends StatCollection
/*     */ {
/*     */   public final STAT BUILDING_PREF;
/*     */   public final STAT ROAD_PREF;
/*     */   public final STAT POOL_PREF;
/*     */   public final STAT CLIMATE;
/*     */   public final STAT PATHOGENS;
/*     */   public final STAT OTHERS;
/*     */   public final STAT CANNIBALISM;
/*     */   public final STAT CANNIBALISM_PREF;
/*     */   public final STAT UNBURRIED;
/*     */   public final STAT ACCESS_ROAD;
/*  45 */   private static CharSequence ¤¤name = "Environment";
/*  46 */   private static CharSequence ¤¤desc = "External factors";
/*  47 */   private static CharSequence ¤¤exposure = "Exposure";
/*  48 */   private static CharSequence ¤¤pref = "Pref.";
/*     */   static {
/*  50 */     D.ts(StatsEnv.class);
/*     */   }
/*     */   private final StatsInit.StatUpdatableI updater;
/*     */   public StatsEnv(StatsInit init) {
/*  54 */     super(init, "ENVIRONMENT", ¤¤name, ¤¤desc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 219 */     this.updater = new StatsInit.StatUpdatableI()
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         public void update16(Humanoid h, int updateI, boolean day, int ui)
/*     */         {
/* 226 */           Induvidual i = h.indu();
/*     */ 
/*     */           
/* 229 */           double res = h.race().pref().structure(BUILDING_PREFS.get(h.tc().x(), h.tc().y()));
/* 230 */           for (DIR dIR : DIR.ORTHO) {
/* 231 */             res += h.race().pref().structure(BUILDING_PREFS.get(h.tc().x() + dIR.x(), h.tc().y() + dIR.y()));
/*     */           }
/* 233 */           res /= 5.0D;
/*     */           
/* 235 */           int d = (int)Math.ceil(15.0D * res);
/* 236 */           int n = StatsEnv.this.BUILDING_PREF.indu().get(h.indu());
/*     */           
/* 238 */           if (d > n * 2) {
/* 239 */             StatsEnv.this.BUILDING_PREF.indu().inc(i, 2);
/* 240 */           } else if (d > n) {
/* 241 */             StatsEnv.this.BUILDING_PREF.indu().inc(i, 1);
/* 242 */           } else if (d < n && (updateI & 0x7) == 0) {
/* 243 */             StatsEnv.this.BUILDING_PREF.indu().inc(i, -1);
/*     */           } 
/*     */ 
/*     */           
/* 247 */           Room r = (Room)(SETT.ROOMS()).map.get(h.physics.tileC());
/*     */           
/* 249 */           if (r == null) {
/* 250 */             int current = StatsEnv.this.ROAD_PREF.indu().get(i);
/* 251 */             int tar = 0;
/*     */             
/* 253 */             double deg = 1.0D - (SETT.FLOOR()).degrade.get(h.tc().x(), h.tc().y());
/*     */             
/* 255 */             Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(h.physics.tileC());
/* 256 */             if (f != null && f.isRoad) {
/* 257 */               StatsEnv.this.PATHOGENS.indu().inc(i, -1);
/* 258 */               tar = (int)Math.ceil(deg * 255.0D * f.pref(h.race()));
/* 259 */               StatsEnv.this.ACCESS_ROAD.indu().set(i, (deg > 0.5D) ? 1 : 0);
/*     */             } else {
/* 261 */               StatsEnv.this.ACCESS_ROAD.indu().set(i, 0);
/*     */             } 
/*     */             
/* 264 */             if (tar > current) {
/* 265 */               current += 128;
/* 266 */               current = CLAMP.i(current, 0, tar);
/* 267 */             } else if (tar < current) {
/* 268 */               current -= 48;
/* 269 */               current = CLAMP.i(current, tar, 255);
/*     */             } 
/* 271 */             StatsEnv.this.ROAD_PREF.indu().set(i, current);
/*     */           } else {
/*     */             
/* 274 */             if (r.blueprint() instanceof ROOM_POOL) {
/* 275 */               ROOM_POOL p = (ROOM_POOL)r.blueprint();
/* 276 */               double d1 = h.race().pref().pool(p);
/* 277 */               StatsEnv.this.POOL_PREF.indu().setD(i, d1);
/*     */             } 
/*     */             
/* 280 */             if ((SETT.ROOMS()).fData.item.get(h.tc()) == null && (SETT.FLOOR()).getter.get(h.physics.tileC()) == null)
/* 281 */               StatsEnv.this.PATHOGENS.indu().setD(i, (SETT.GROUND()).MOISTURE_BASE.get(h.tc())); 
/*     */           } 
/*     */         }
/*     */       };
/*     */     init.count.getClass();
/*     */     this.ACCESS_ROAD = (STAT)new STATData("ROAD_ACCESS", init, (DataO.DataAbs)new DataO.DataBit(init.count, "ENV_ROADA"));
/*     */     (this.ACCESS_ROAD.info()).icon = (SPRITE)(UI.icons()).m.wheel;
/*     */     init.count.getClass();
/*     */     this.ROAD_PREF = (STAT)new STATData("ROAD_PREF", init, (DataO.DataAbs)new DataO.DataByte(init.count, "ROAD_PREF"));
/*     */     (this.ROAD_PREF.info()).icon = (SPRITE)(UI.icons()).m.wheel.twin((SPRITE)(UI.icons()).m.expand);
/*     */     init.count.getClass();
/*     */     this.BUILDING_PREF = (STAT)new STATData("BUILDING_PREF", init, (DataO.DataAbs)new DataO.DataNibble(init.count, "BUILDING_PREF"));
/*     */     (this.BUILDING_PREF.info()).icon = (SPRITE)(UI.icons()).m.building;
/*     */     init.count.getClass();
/*     */     this.POOL_PREF = (STAT)new STATData("POOL_PREF", init, (DataO.DataAbs)new DataO.DataNibble(init.count, "POOL_PREF"));
/*     */     (this.POOL_PREF.info()).icon = (SPRITE)(UI.icons()).m.water;
/*     */     init.onArrivalStats.add(this.ACCESS_ROAD);
/*     */     init.onArrivalStats.add(this.ROAD_PREF);
/*     */     init.onArrivalStats.add(this.BUILDING_PREF);
/*     */     init.onArrivalStats.add(this.POOL_PREF);
/*     */     this.CLIMATE = (STAT)new STATFake("CLIMATE", init) {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack) {
/*     */           if (r == null) {
/*     */             double m = 0.0D;
/*     */             for (Race rr : RACES.all())
/*     */               m += rr.population().climate(SETT.ENV().climate()) * (STATS.POP()).POP.data(s).get(rr, daysBack); 
/*     */             double p = (STATS.POP()).POP.data(s).get(null, daysBack);
/*     */             if (p == 0.0D)
/*     */               return ((m > 0.0D) ? true : false); 
/*     */             return m / p;
/*     */           } 
/*     */           return r.population().climate(SETT.ENV().climate());
/*     */         }
/*     */       };
/*     */     this.CLIMATE.standing = new StatStanding(this.CLIMATE, 1.0D);
/*     */     this.CLIMATE.info().setMatters(true, false);
/*     */     (this.CLIMATE.info()).icon = (SPRITE)(UI.icons()).s.heat;
/*     */     init.count.getClass();
/*     */     this.PATHOGENS = (STAT)new STATData("PATHOGENS", init, (DataO.DataAbs)new DataO.DataNibble(init.count, "PATHOGENS")) {
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race type) {
/*     */           GBox b = (GBox)text;
/*     */           b.textLL(StatsEnv.¤¤exposure);
/*     */           b.tab(6);
/*     */           b.add((SPRITE)GFORMAT.percInv(b.text(), data(cl).getD(type)));
/*     */           b.NL();
/*     */           super.hover(text, cl, type);
/*     */         }
/*     */       };
/*     */     (this.PATHOGENS.info()).icon = (SPRITE)(UI.icons()).m.disease;
/*     */     this.OTHERS = (STAT)new STATFake("OTHERS", init) {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack) {
/*     */           if (r == null) {
/*     */             double p = 0.0D;
/*     */             for (int ri = 0; ri < RACES.all().size(); ri++)
/*     */               p += getDD(s, (Race)RACES.all().get(ri), daysBack) * (STATS.POP()).POP.data(s).get(RACES.all().get(ri), daysBack); 
/*     */             if (p == 0.0D)
/*     */               return 0.0D; 
/*     */             return p / (STATS.POP()).POP.data(s).get(null, daysBack);
/*     */           } 
/*     */           double pop = (STATS.POP()).POP.data(s).get(r, daysBack);
/*     */           if (pop == 0.0D)
/*     */             return 1.0D; 
/*     */           pop = 0.0D;
/*     */           double tot = 0.0D;
/*     */           for (Race rr : RACES.all()) {
/*     */             double p = (STATS.POP()).POP.data(s).get(rr, daysBack);
/*     */             pop += p;
/*     */             tot += p * r.pref().race(rr);
/*     */           } 
/*     */           if (pop == 0.0D)
/*     */             return 1.0D; 
/*     */           tot /= pop;
/*     */           return CLAMP.d(tot, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */     this.OTHERS.standing = new StatStanding(this.OTHERS, 1.0D);
/*     */     this.OTHERS.info().setMatters(true, false);
/*     */     (this.OTHERS.info()).icon = (SPRITE)(UI.icons()).m.descrimination;
/*     */     this.CANNIBALISM = (STAT)new STATFakeData("CANNIBALISM", init) {
/*     */         protected double getDD(HCLASS cl, Race race) {
/*     */           double d = 0.0D;
/*     */           for (Race r : RACES.all())
/*     */             d += (SETT.ROOMS()).CANNIBAL.cannibalism(r); 
/*     */           return CLAMP.d(d, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */     this.CANNIBALISM.info().setMatters(true, false);
/*     */     (this.CANNIBALISM.info()).icon = (SPRITE)(UI.icons()).s.death;
/*     */     this.CANNIBALISM_PREF = (STAT)new STATFakeData("CANNIBALISM_PREF", init) {
/*     */         protected double getDD(HCLASS cl, Race race) {
/*     */           double d = 0.0D;
/*     */           double tot = 0.0D;
/*     */           for (Race r : RACES.all()) {
/*     */             tot += 1.0D - race.pref().race(r);
/*     */             d += (1.0D - race.pref().race(r)) * (SETT.ROOMS()).CANNIBAL.cannibalism(r);
/*     */           } 
/*     */           return CLAMP.d(d / tot, 0.0D, 1.0D);
/*     */         }
/*     */         
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race type) {
/*     */           if (type != null) {
/*     */             GBox b = (GBox)text;
/*     */             b.textLL(RACES.name());
/*     */             b.tab(5);
/*     */             b.textLL(StatsEnv.¤¤pref);
/*     */             b.tab(10);
/*     */             b.textLL((StatsEnv.this.CANNIBALISM.info()).name);
/*     */             b.NL();
/*     */             for (Race r : RACES.all()) {
/*     */               b.add((SPRITE)(r.appearance()).icon);
/*     */               b.text(r.info.names);
/*     */               b.tab(5);
/*     */               b.add((SPRITE)GFORMAT.perc(b.text(), 1.0D - type.pref().race(r)));
/*     */               b.tab(10);
/*     */               b.add((SPRITE)GFORMAT.perc(b.text(), (SETT.ROOMS()).CANNIBAL.cannibalism(r)));
/*     */               b.NL();
/*     */             } 
/*     */           } 
/*     */           super.hover(text, cl, type);
/*     */         }
/*     */       };
/*     */     this.CANNIBALISM_PREF.info().setMatters(true, false);
/*     */     (this.CANNIBALISM_PREF.info()).icon = (SPRITE)(UI.icons()).s.death;
/*     */     this.UNBURRIED = (STAT)new STATFake("UNBURRIED", init) {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack) {
/*     */           double pop = 1.0D + (STATS.POP()).POP.data(null).get(null, daysBack);
/*     */           return (40 * (SETT.THINGS()).corpses.addedHistory.get(daysBack)) / pop;
/*     */         }
/*     */       };
/*     */     this.UNBURRIED.info().setInt();
/*     */     this.UNBURRIED.info().setMatters(true, false);
/*     */     (this.UNBURRIED.info()).icon = (SPRITE)(UI.icons()).m.disease;
/*     */     init.updatable.add(this.updater);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEnv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */