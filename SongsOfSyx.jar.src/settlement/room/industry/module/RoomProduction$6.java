/*     */ package settlement.room.industry.module;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.room.spirit.temple.TempleInstance;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.Equip;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 214 */     for (Equip e : STATS.EQUIP().allE()) {
/*     */       
/* 216 */       ((RoomProduction.Res)RoomProduction.this.consumers.get(e.resource.index())).all.add(new RoomProduction.Source(e.resource)
/*     */           {
/*     */             public double am()
/*     */             {
/* 220 */               return e.stat().data().get(null) * e.wearPerYear / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */             }
/*     */ 
/*     */             
/*     */             public SPRITE icon() {
/* 225 */               return (SPRITE)(UI.icons()).s.citizen;
/*     */             }
/*     */ 
/*     */             
/*     */             public CharSequence name() {
/* 230 */               return Dic.¤¤Equipped;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 237 */     for (ADSupply sup : (AD.supplies()).all) {
/* 238 */       ((RoomProduction.Res)RoomProduction.this.consumers.get(sup.res.index())).all.add(new RoomProduction.Source(sup.res)
/*     */           {
/*     */             
/*     */             public double am()
/*     */             {
/* 243 */               if (!(SETT.ROOMS()).SUPPLY.has(sup.res)) {
/* 244 */                 return 0.0D;
/*     */               }
/* 246 */               return sup.consumedPerDayCurrent((Faction)FACTIONS.player());
/*     */             }
/*     */ 
/*     */             
/*     */             public SPRITE icon() {
/* 251 */               return (SPRITE)(UI.icons()).s.sword;
/*     */             }
/*     */ 
/*     */             
/*     */             public CharSequence name() {
/* 256 */               return Dic.¤¤Supplies;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 263 */     for (RES_AMOUNT e : RACES.res().homeResMax(null)) {
/*     */       
/* 265 */       final ArrayListGrower<HCLASS_RACE> con = new ArrayListGrower();
/* 266 */       final ArrayListGrower<Integer> conRI = new ArrayListGrower();
/*     */       
/* 268 */       for (HCLASS cl : HCLASSES.ALL()) {
/* 269 */         for (Race ra : RACES.all()) {
/* 270 */           int ri = 0;
/* 271 */           for (RES_AMOUNT rr : ra.home().clas(cl).resources()) {
/*     */ 
/*     */             
/* 274 */             if (rr.resource() == e.resource()) {
/* 275 */               con.add(HCLASS_RACE.clP(ra, cl));
/* 276 */               conRI.add(Integer.valueOf(ri));
/*     */             } 
/* 278 */             ri++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 283 */       ((RoomProduction.Res)RoomProduction.this.consumers.get(e.resource().index())).all.add(new RoomProduction.Source(e.resource())
/*     */           {
/*     */             public double am()
/*     */             {
/* 287 */               double am = 0.0D;
/* 288 */               for (int i = 0; i < con.size(); i++) {
/* 289 */                 am += STATS.HOME().current(((HCLASS_RACE)con.getC(i)).cl, ((HCLASS_RACE)con.get(i)).race, ((Integer)conRI.get(i)).intValue()) * STATS.HOME().rate(((HCLASS_RACE)con.getC(i)).cl, ((HCLASS_RACE)con.get(i)).race);
/*     */               }
/*     */               
/* 292 */               return am / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */             }
/*     */ 
/*     */             
/*     */             public SPRITE icon() {
/* 297 */               return (SPRITE)(UI.icons()).s.house;
/*     */             }
/*     */ 
/*     */             
/*     */             public CharSequence name() {
/* 302 */               return ((STATS.HOME()).materials.info()).name;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 308 */     for (ROOM_TEMPLE t : (SETT.ROOMS()).TEMPLES.ALL) {
/* 309 */       if (t.resource != null) {
/* 310 */         ((RoomProduction.Res)RoomProduction.this.consumers.get(t.resource.index())).all.add(new RoomProduction.Source(t.resource)
/*     */             {
/*     */               public double am()
/*     */               {
/* 314 */                 double a = 0.0D;
/* 315 */                 for (int i = 0; i < t.instancesSize(); i++) {
/* 316 */                   a += ((TempleInstance)t.getInstance(i)).sacrifices();
/*     */                 }
/* 318 */                 return a;
/*     */               }
/*     */ 
/*     */               
/*     */               public SPRITE icon() {
/* 323 */                 return (SPRITE)t.icon;
/*     */               }
/*     */ 
/*     */               
/*     */               public CharSequence name() {
/* 328 */                 return t.info.names;
/*     */               }
/*     */             });
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 337 */     for (RoomProduction.Res r : RoomProduction.this.producers)
/* 338 */       r.init(); 
/* 339 */     for (RoomProduction.Res r : RoomProduction.this.consumers)
/* 340 */       r.init(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\RoomProduction$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */