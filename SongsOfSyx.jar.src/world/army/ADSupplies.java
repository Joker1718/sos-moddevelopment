/*     */ package world.army;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoosterAbs;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResSupply;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.ui.message.MessageText;
/*     */ import world.entity.army.WArmy;
/*     */ import world.entity.army.WArmyState;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ADSupplies
/*     */ {
/*     */   public static final int artilleryMax = 40;
/*  41 */   private final ArrayList<ArrayListGrower<ADSupply>> map = new ArrayList(RESOURCES.ALL().size()); final ADInt.ADIntImp creditsNeeded; final ADInt.ADIntImp creditsTarget; public final LIST<ADSupply> all; public final LIST<ADSupply> healths; public final LIST<ADSupply> morales;
/*  42 */   private final ArrayListGrower<RESOURCE> resources = new ArrayListGrower(); public final LIST<ADSupply.ADSupplyRes> food; public final LIST<ADSupply> equip; private final Bitmap1D has; private final ArrayListGrower<ADArtillery> arts; private final INT_O.INT_OE<WArmy> artilleryTot;
/*     */   ADSupplies(ADInit init) {
/*  44 */     while (this.map.hasRoom()) {
/*  45 */       this.map.add(new ArrayListGrower());
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
/*  56 */     this.has = new Bitmap1D(RESOURCES.ALL().size(), false);
/*  57 */     this.arts = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     this.creditsNeeded = new ADInt.ADIntImp(init, "CREDITS_CURRENT", Dic.¤¤Currs, "");
/*  69 */     this.creditsTarget = new ADInt.ADIntImp(init, "CREDITS_TARGET", Dic.¤¤Currs, "");
/*  70 */     final ArrayListGrower<ADSupply> all = new ArrayListGrower();
/*     */     
/*  72 */     ArrayListGrower<ADSupply.ADSupplyRes> misc = new ArrayListGrower();
/*  73 */     for (ResSupply rs : (RESOURCES.SUP()).ALL) {
/*  74 */       ADSupply.ADSupplyRes s = new ADSupply.ADSupplyRes(all.size(), init, rs);
/*  75 */       all.add(s);
/*  76 */       misc.add(s);
/*     */     } 
/*  78 */     this.food = (LIST<ADSupply.ADSupplyRes>)misc;
/*     */     
/*  80 */     ArrayListGrower<ADSupply> equip = new ArrayListGrower();
/*  81 */     for (EquipBattle a : STATS.EQUIP().BATTLE_ALL()) {
/*  82 */       ADSupply s = new ADSupply.ADSupplyEquip(all.size(), init, a);
/*  83 */       all.add(s);
/*  84 */       equip.add(s);
/*     */     } 
/*  86 */     this.equip = (LIST<ADSupply>)equip;
/*     */     
/*  88 */     init.registers.add(new ADInit.Register()
/*     */         {
/*     */           public void register(ADDiv div, int d)
/*     */           {
/*  92 */             if (div.army() != null) {
/*  93 */               for (int si = 0; si < all.size(); si++) {
/*  94 */                 ((ADSupply)all.get(si)).setChanged(div.army());
/*     */               }
/*     */             }
/*  97 */             (AD.supplies()).creditsNeeded.inc(div.army(), d * div.costPerMan() * div.men());
/*  98 */             (AD.supplies()).creditsTarget.inc(div.army(), d * div.costPerMan() * div.menTarget());
/*     */           }
/*     */         });
/*     */     
/* 102 */     init.dataA.getClass(); this.artilleryTot = (INT_O.INT_OE<WArmy>)new DataO.DataInt(init.dataA, "ARTILLARY_TARGET_TOT");
/*     */     
/* 104 */     for (ROOM_ARTILLERY a : (SETT.ROOMS()).ARTILLERY) {
/* 105 */       this.arts.add(new ADArtillery(init, a, (LISTE<ADSupply>)all));
/*     */     }
/*     */     
/* 108 */     this.all = (LIST<ADSupply>)all;
/*     */     
/* 110 */     ArrayListGrower<ADSupply> mm = new ArrayListGrower();
/* 111 */     ArrayListGrower<ADSupply> he = new ArrayListGrower();
/* 112 */     for (ADSupply s : all) {
/* 113 */       if (s.baseMorale > 0.0D) {
/* 114 */         mm.add(s);
/*     */       }
/* 116 */       if (s.baseHealth > 0.0D)
/* 117 */         he.add(s); 
/*     */     } 
/* 119 */     this.healths = (LIST<ADSupply>)he;
/* 120 */     this.morales = (LIST<ADSupply>)mm;
/*     */ 
/*     */     
/* 123 */     AD.moraleFactors().add(new BoosterAbs<WArmy>(new BSourceInfo(Dic.¤¤Supplies, (SPRITE)(UI.icons()).s.storage), false)
/*     */         {
/*     */           public double to()
/*     */           {
/* 127 */             return 1.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           protected double pget(WArmy o) {
/* 132 */             return ADSupplies.this.morale(o);
/*     */           }
/*     */ 
/*     */           
/*     */           public double from() {
/* 137 */             return 0.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double getValue(double input) {
/* 142 */             return input;
/*     */           }
/*     */         });
/*     */     
/* 146 */     init.updaters.add(new ADInit.Updater()
/*     */         {
/*     */           public void update(Faction f, double timeSinceLast) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void update(WArmy a, double timeSinceLast) {
/* 157 */             if (a.faction() == FACTIONS.player()) {
/* 158 */               double he = ADSupplies.this.health(a);
/* 159 */               for (ADSupply s : all) {
/* 160 */                 double am = s.consumedPerDayCurrent(a) * timeSinceLast * TIME.secondsPerDayI();
/* 161 */                 int tot = (int)am;
/* 162 */                 if (am - tot > RND.rFloat())
/* 163 */                   tot++; 
/* 164 */                 s.current().inc(a, -tot);
/*     */               } 
/*     */               
/* 167 */               if (he >= 1.0D && AD.supplies().health(a) < 1.0D) {
/* 168 */                 Str.TMP.clear();
/* 169 */                 Str.TMP.add(ADSupplies.¤¤StarvingD).insert(0, (CharSequence)a.name);
/* 170 */                 (new MessageText(ADSupplies.¤¤Starving, (CharSequence)Str.TMP)).send();
/*     */               } 
/*     */             } else {
/* 173 */               for (ADSupply s : (AD.supplies()).all) {
/* 174 */                 double am = Math.ceil(s.targetAmount(a) / 16.0D);
/* 175 */                 double tar = s.minimumAmount(a);
/* 176 */                 am += s.current().get(a);
/* 177 */                 if (am > tar)
/* 178 */                   am = tar; 
/* 179 */                 s.current().set(a, (int)am);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 187 */     Bitmap1D res = new Bitmap1D(RESOURCES.ALL().size(), false);
/* 188 */     for (ADSupply a : this.all) {
/* 189 */       this.has.set(a.res.index(), true);
/* 190 */       ((ArrayListGrower)this.map.get(a.res.index())).add(a);
/* 191 */       if (!res.get(a.res.index())) {
/* 192 */         this.resources.add(a.res);
/* 193 */         res.set(a.res.index(), true);
/*     */       } 
/*     */     } 
/*     */   } private static CharSequence ¤¤Starving = "¤Supplies low!"; private static CharSequence ¤¤StarvingD = "¤Essential supplies have not been delivered to our army, affecting health. Low health will stop training of new recruits and cause deaths and desertion. Fill up our military depots and fortify the army immediately. Affected army: {0}."; static {
/*     */     D.ts(ADSupplies.class);
/*     */   }
/*     */   public LIST<ADArtillery> arts() {
/* 200 */     return (LIST<ADArtillery>)this.arts;
/*     */   }
/*     */   
/*     */   public LIST<RESOURCE> resses() {
/* 204 */     return (LIST<RESOURCE>)this.resources;
/*     */   }
/*     */   
/*     */   public LIST<ADSupply> get(RESOURCE res) {
/* 208 */     return (LIST<ADSupply>)this.map.get(res.index());
/*     */   }
/*     */   
/*     */   public ADSupply get(ResSupply res) {
/* 212 */     return (ADSupply)this.all.get(res.index());
/*     */   }
/*     */   
/*     */   public ADSupply get(EquipBattle a) {
/* 216 */     return (ADSupply)this.all.get((RESOURCES.SUP()).ALL.size() + a.indexMilitary());
/*     */   }
/*     */   
/*     */   public void fillAll(WArmy a) {
/* 220 */     for (ADSupply s : this.all) {
/* 221 */       s.current().set(a, s.targetAmount(a));
/*     */     }
/*     */   }
/*     */   
/*     */   public ADInt credits() {
/* 226 */     return this.creditsNeeded;
/*     */   }
/*     */   
/*     */   public double morale(WArmy a) {
/* 230 */     double m = 0.0D;
/* 231 */     for (ADSupply s : this.morales) {
/* 232 */       m += s.moraleAdd(a);
/*     */     }
/* 234 */     return m;
/*     */   }
/*     */   
/*     */   public double health(WArmy a) {
/* 238 */     double m = 1.0D;
/* 239 */     for (ADSupply s : this.healths) {
/* 240 */       m *= s.healthMul(a);
/*     */     }
/* 242 */     return m;
/*     */   }
/*     */   
/*     */   public void transfer(WDIV div, WArmy old, WArmy current) {
/* 246 */     if (old == null || current == null)
/*     */       return; 
/* 248 */     for (ADSupply s : this.all) {
/* 249 */       s.transfer(div, old, current);
/*     */     }
/*     */   }
/*     */   
/*     */   public final class ADArtillery
/*     */     implements INDEXED
/*     */   {
/*     */     public final ROOM_ARTILLERY art;
/*     */     public final INT_O.INT_OE<WArmy> target;
/* 258 */     private final ArrayListGrower<ADSupply> supplies = new ArrayListGrower();
/*     */     
/*     */     ADArtillery(ADInit init, ROOM_ARTILLERY art, LISTE<ADSupply> sups) {
/* 261 */       this.art = art;
/* 262 */       this.target = (INT_O.INT_OE<WArmy>)new DataO<WArmy>.DataByte(init.dataA, "ART_TARGET_" + art.key)
/*     */         {
/*     */           
/*     */           public void set(WArmy t, int s)
/*     */           {
/* 267 */             (ADSupplies.ADArtillery.access$0(ADSupplies.ADArtillery.this)).artilleryTot.inc(t, -get(t));
/* 268 */             super.set(t, CLAMP.i(s, 0, max(t)));
/* 269 */             (ADSupplies.ADArtillery.access$0(ADSupplies.ADArtillery.this)).artilleryTot.inc(t, get(t));
/* 270 */             for (ADSupply ss : ADSupplies.ADArtillery.this.supplies) {
/* 271 */               ss.setChanged(t);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(WArmy t) {
/* 277 */             return get(t) + 40 - (ADSupplies.ADArtillery.access$0(ADSupplies.ADArtillery.this)).artilleryTot.get(t);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 282 */       for (int i = 0; i < art.constructor().resources(); i++) {
/* 283 */         RESOURCE res = art.constructor().resource(i);
/* 284 */         ADSupply.ADSupplyArt sup = new ADSupply.ADSupplyArt(sups.size(), init, this, res, i);
/* 285 */         this.supplies.add(sup);
/* 286 */         sups.add(sup);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int current(WArmy a) {
/* 292 */       double d = 1.0D;
/* 293 */       for (ADSupply ss : this.supplies) {
/* 294 */         d = Math.min(d, ss.amountValue(a));
/*     */       }
/* 296 */       if (a.state() != WArmyState.fortified)
/* 297 */         d *= 0.5D; 
/* 298 */       return (int)(this.target.get(a) * d);
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 303 */       return this.art.typeIndex();
/*     */     }
/*     */     
/*     */     public LIST<ADSupply> sups() {
/* 307 */       return (LIST<ADSupply>)this.supplies;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSupplies.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */