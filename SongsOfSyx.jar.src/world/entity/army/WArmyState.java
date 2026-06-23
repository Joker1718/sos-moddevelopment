/*     */ package world.entity.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.caravan.Shipment;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public abstract class WArmyState implements INDEXED {
/*  37 */   private static LIST<WArmyState> all = (LIST<WArmyState>)new ArrayList(0);
/*     */   
/*  39 */   private static CharSequence ¤¤siege = "Are you sure you wish to besiege {0} and declare war on the faction of {0}?";
/*     */   
/*     */   static {
/*  42 */     D.ts(WArmyState.class);
/*     */   }
/*     */   
/*     */   public static LIST<WArmyState> all() {
/*  46 */     return all;
/*     */   }
/*     */   
/*  49 */   public static final WArmyState fortified = new WArmyState()
/*     */     {
/*     */       WArmyState update(WArmy a, double ds)
/*     */       {
/*  53 */         WArmyState.checkTile(a);
/*  54 */         if (a.faction() == null && a.region().faction() == FACTIONS.player()) {
/*  55 */           return raiding;
/*     */         }
/*  57 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText info(WArmy a, GText box) {
/*  62 */         box.normalify();
/*  63 */         box.set(Dic.¤¤Fortified);
/*  64 */         return box;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name(WArmy a) {
/*  69 */         return Dic.¤¤Fortified;
/*     */       }
/*     */     };
/*     */   
/*  73 */   public static final WArmyState fortifying = new WArmyState()
/*     */     {
/*     */       WArmyState update(WArmy a, double ds)
/*     */       {
/*  77 */         WArmyState.checkTile(a);
/*  78 */         if (a.faction() == null && a.region().faction() == FACTIONS.player()) {
/*  79 */           return raiding;
/*     */         }
/*  81 */         a.stateFloat = (float)(a.stateFloat + ds);
/*  82 */         if (a.stateFloat > (TIME.secondsPerDay() / 2))
/*  83 */           return fortified; 
/*  84 */         return this;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public GText info(WArmy a, GText box) {
/*  90 */         box.normalify();
/*  91 */         box.set(Dic.¤¤Fortifying);
/*  92 */         return box;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name(WArmy a) {
/*  97 */         return Dic.¤¤Fortifying;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private static void checkTile(WArmy a) {
/* 103 */     if (!(WORLD.PATH()).map.is.is(a.ctx(), a.cty())) {
/* 104 */       for (int i = 0; i < GUTIL.circle().length(); i++) {
/* 105 */         COORDINATE c = GUTIL.circle().get(i);
/* 106 */         int x = a.body().cX() + c.x();
/* 107 */         int y = a.body().cY() + c.y();
/* 108 */         int tx = x >> 6;
/* 109 */         int ty = y >> 6;
/* 110 */         if ((WORLD.PATH()).map.is.is(tx, ty)) {
/* 111 */           a.teleport(tx, ty);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/* 118 */   public static final WArmyState raiding = new WArmyState()
/*     */     {
/*     */       
/*     */       WArmyState update(WArmy a, double ds)
/*     */       {
/* 123 */         Region reg = a.region();
/* 124 */         if (reg == null) {
/* 125 */           a.stateFloat = 0.0F;
/* 126 */           return WArmyState.fortifying;
/*     */         } 
/*     */         
/* 129 */         a.stateFloat = (float)(a.stateFloat + ds);
/*     */         
/* 131 */         if (a.stateFloat < 120.0F) {
/* 132 */           return this;
/*     */         }
/* 134 */         a.stateFloat -= 120.0F;
/*     */         
/* 136 */         double rd = RD.RACES().popSize(reg);
/* 137 */         double ad = AD.men(null).get(a) / (Config.battle()).MEN_PER_ARMY;
/* 138 */         double dd = ad / rd;
/*     */         
/* 140 */         double d = 180.0D * dd / (TIME.secondsPerDay() * 4);
/*     */         
/* 142 */         double inc = (RD.DEVASTATION()).current.max(reg) * d;
/* 143 */         int iinc = (int)inc;
/* 144 */         if (inc - iinc > RND.rFloat()) {
/* 145 */           iinc++;
/*     */         }
/* 147 */         int now = (RD.DEVASTATION()).current.get(reg);
/* 148 */         if (now + iinc >= (RD.DEVASTATION()).current.max(reg)) {
/* 149 */           iinc = (RD.DEVASTATION()).current.max(reg) - now;
/*     */         }
/*     */         
/* 152 */         if (iinc > 0) {
/*     */ 
/*     */           
/* 155 */           Shipment s = null;
/* 156 */           Faction to = a.faction();
/*     */           
/* 158 */           if (to != null) {
/* 159 */             for (RESOURCE res : RESOURCES.ALL()) {
/*     */               
/* 161 */               int am = (int)Math.ceil(RD.OUTPUT().get((TRADABLE)TR.get(res)).loot(reg) * d * 10.0D);
/*     */               
/* 163 */               if (am > 0 && to != null) {
/* 164 */                 if (s == null) {
/* 165 */                   s = (WORLD.ENTITIES()).caravans.create(a.ctx(), a.cty(), to.capitolRegion(), TRADE_TYPE.spoils);
/*     */                 }
/* 167 */                 if (s != null) {
/* 168 */                   s.loadAndReserve((TRADABLE)TR.get(res), am);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 174 */             for (RDRace ra : (RD.RACES()).all) {
/* 175 */               int pop = (int)Math.ceil(ra.pop.get(reg) * d * 0.5D);
/* 176 */               if (pop > 0) {
/*     */                 
/* 178 */                 ra.pop.inc(reg, -pop);
/* 179 */                 if (s == null) {
/* 180 */                   s = (WORLD.ENTITIES()).caravans.create(a.ctx(), a.cty(), to.capitolRegion(), TRADE_TYPE.spoils);
/*     */                 }
/* 182 */                 if (s != null) {
/* 183 */                   s.loadAndReserve((TRADABLE)TR.get(ra.race), (int)Math.ceil(pop / 2.0D));
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 192 */           if (a.faction() == FACTIONS.player() && reg.faction() instanceof FactionNPC) {
/* 193 */             FactionNPC ff = (FactionNPC)reg.faction();
/* 194 */             ROPINION.STANCE().raid(ff, 1.0D);
/*     */           } 
/*     */           
/* 197 */           (RD.DEVASTATION()).current.inc(reg, iinc);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 202 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText info(WArmy a, GText box) {
/* 207 */         box.warnify();
/* 208 */         box.set(Dic.¤¤Raiding);
/* 209 */         return box;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name(WArmy a) {
/* 214 */         return Dic.¤¤Raiding;
/*     */       }
/*     */     };
/*     */   
/* 218 */   public static final WArmyState moving = new WArmyState()
/*     */     {
/*     */       WArmyState update(WArmy a, double ds)
/*     */       {
/* 222 */         if (!a.path().move(a, WArmy.speed * ds)) {
/* 223 */           a.stateFloat = 0.0F;
/*     */           
/* 225 */           return fortifying;
/*     */         } 
/*     */         
/* 228 */         return this;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public GText info(WArmy a, GText box) {
/* 235 */         Region reg = (Region)(WORLD.REGIONS()).map.get(a.path().destX(), a.path().destY());
/* 236 */         if (reg == null) {
/* 237 */           box.normalify();
/* 238 */           box.add(name(a));
/*     */         } else {
/* 240 */           GText text = box;
/* 241 */           text.color(GCOLOR.MAP().get(reg.faction()));
/* 242 */           text.add(Dic.¤¤MarchingTo).insert(0, (CharSequence)reg.info.name());
/*     */         } 
/* 244 */         return box;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name(WArmy a) {
/* 249 */         return Dic.¤¤Moving;
/*     */       }
/*     */     };
/*     */   
/* 253 */   public static final WArmyState intercepting = new WArmyState()
/*     */     {
/*     */       WArmyState update(WArmy a, double ds)
/*     */       {
/* 257 */         WArmy other = intercepting(a);
/*     */ 
/*     */ 
/*     */         
/* 261 */         if (other == null || !a.path().isValid()) {
/* 262 */           a.stateFloat = 0.0F;
/*     */ 
/*     */           
/* 265 */           return fortifying;
/*     */         } 
/*     */         
/* 268 */         if (a.path().destX() == other.ctx() && a.path().destY() == other.cty()) {
/* 269 */           if (a.path().remaining() > 0) {
/* 270 */             a.path().move(a, WArmy.speed * ds);
/* 271 */             return this;
/*     */           } 
/*     */           
/* 274 */           if (other.state() == fortifying || other.state() == fortified) {
/* 275 */             a.stateFloat = 0.0F;
/* 276 */             return fortifying;
/*     */           } 
/*     */ 
/*     */           
/* 280 */           return this;
/*     */         } 
/*     */         
/* 283 */         double dist = COORDINATE.tileDistance(a.path().destX(), a.path().destY(), other.ctx(), other.cty());
/*     */ 
/*     */         
/* 286 */         if (dist * 10.0D > a.path().remaining() && 
/* 287 */           !a.path().find(a.ctx(), a.cty(), other.ctx(), other.cty())) {
/* 288 */           a.stateFloat = 0.0F;
/* 289 */           return fortifying;
/*     */         } 
/*     */ 
/*     */         
/* 293 */         return this;
/*     */       }
/*     */       
/*     */       private WArmy intercepting(WArmy a) {
/* 297 */         if (a.stateShort != -1) {
/* 298 */           WArmy aa = (WORLD.ENTITIES()).armies.get(a.stateShort);
/* 299 */           if (aa == null || !aa.added()) {
/* 300 */             a.stateShort = -1;
/* 301 */             return null;
/*     */           } 
/* 303 */           return aa;
/*     */         } 
/* 305 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText info(WArmy a, GText box) {
/* 310 */         WArmy aa = intercepting(a);
/* 311 */         if (aa == null) {
/* 312 */           box.normalify();
/* 313 */           box.add(name(a));
/*     */         } else {
/* 315 */           GText text = box;
/* 316 */           text.color(GCOLOR.MAP().get(aa.faction()));
/* 317 */           text.add(Dic.¤¤Intercepting).insert(0, (CharSequence)aa.name);
/*     */         } 
/* 319 */         return box;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public CharSequence name(WArmy a) {
/* 325 */         return Dic.¤¤Moving;
/*     */       }
/*     */     };
/*     */   
/* 329 */   public static final WArmyState besieging = new WArmyState() {
/*     */       Region aReg;
/*     */       WArmy aa;
/*     */       
/* 333 */       private ACTION besiege = new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 337 */             if (WArmyState.null.this.aReg.faction() != null && WArmyState.null.this.aReg.faction() instanceof FactionNPC) {
/* 338 */               ROPINION.STANCE().setNewStance((FactionNPC)WArmyState.null.this.aReg.faction(), (DipStance)DIP.WAR(), (WArmyState.null.this.aa.faction() == FACTIONS.player()));
/* 339 */               WArmyState.null.this.aa.besiege(WArmyState.null.this.aReg);
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       WArmyState update(WArmy a, double ds) {
/* 348 */         Region reg = WORLD.REGIONS().getByIndex(a.stateShort);
/*     */ 
/*     */         
/* 351 */         if (a.faction() == reg.faction() || !a.path().isValid()) {
/* 352 */           if (!a.besieging(reg)) {
/* 353 */             a.path().clear();
/* 354 */             a.stateFloat = 0.0F;
/* 355 */             return fortifying;
/*     */           } 
/* 357 */           return this;
/*     */         } 
/*     */         
/* 360 */         if (a.path().move(a, WArmy.speed * ds)) {
/* 361 */           return this;
/*     */         }
/* 363 */         a.path().clear();
/* 364 */         if (a.faction() == FACTIONS.player() && reg.faction() != a.faction() && !DIP.WAR().is(reg.faction(), a.faction()) && reg.faction() != null) {
/* 365 */           this.aReg = reg;
/* 366 */           this.aa = a;
/* 367 */           (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP.clear().add(WArmyState.¤¤siege).insert(0, (CharSequence)reg.info.name()).insert(0, (CharSequence)(reg.faction()).name), this.besiege, ACTION.NOP, true);
/* 368 */           return this;
/*     */         } 
/* 370 */         WORLD.BATTLES().besige(a, reg);
/*     */ 
/*     */ 
/*     */         
/* 374 */         return this;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public GText info(WArmy a, GText box) {
/* 380 */         Region reg = WORLD.REGIONS().getByIndex(a.stateShort);
/* 381 */         if (reg == null) {
/* 382 */           box.normalify();
/* 383 */           box.add(name(a));
/*     */         } else {
/* 385 */           GText text = box;
/* 386 */           text.color(GCOLOR.MAP().get(reg.faction()));
/* 387 */           text.add(Dic.¤¤BesiegingSomething).insert(0, (CharSequence)reg.info.name());
/*     */         } 
/* 389 */         return box;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name(WArmy a) {
/* 394 */         return Dic.¤¤Besieging;
/*     */       }
/*     */     };
/*     */   
/* 398 */   public static final WArmyState movingRaid = new WArmyState()
/*     */     {
/*     */       
/*     */       WArmyState update(WArmy a, double ds)
/*     */       {
/* 403 */         if (!a.path().move(a, WArmy.speed * ds)) {
/*     */           
/* 405 */           a.stateFloat = 0.0F;
/* 406 */           if (a.canRaid())
/* 407 */             return raiding; 
/* 408 */           return fortifying;
/*     */         } 
/*     */         
/* 411 */         return this;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public GText info(WArmy a, GText box) {
/* 418 */         Region reg = (Region)(WORLD.REGIONS()).map.get(a.path().destX(), a.path().destY());
/* 419 */         if (reg == null) {
/* 420 */           box.normalify();
/* 421 */           box.add(name(a));
/*     */         } else {
/* 423 */           GText text = box;
/* 424 */           text.color(GCOLOR.MAP().get(reg.faction()));
/* 425 */           text.add(Dic.¤¤MarchingTo).insert(0, (CharSequence)reg.info.name());
/*     */         } 
/* 427 */         return box;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name(WArmy a) {
/* 432 */         return Dic.¤¤Moving;
/*     */       }
/*     */     };
/*     */   
/*     */   private final int index;
/*     */   
/*     */   public static boolean canBesiege(WArmy a, Region reg) {
/* 439 */     return (reg != null && a.faction() != reg.faction());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private WArmyState() {
/* 445 */     all = all.join((Object[])new WArmyState[] { this });
/* 446 */     this.index = all.size() - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/* 456 */     return this.index;
/*     */   }
/*     */   
/*     */   abstract WArmyState update(WArmy paramWArmy, double paramDouble);
/*     */   
/*     */   public abstract GText info(WArmy paramWArmy, GText paramGText);
/*     */   
/*     */   public abstract CharSequence name(WArmy paramWArmy);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyState.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */