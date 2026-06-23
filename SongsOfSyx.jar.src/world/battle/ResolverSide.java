/*     */ package world.battle;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ import world.army.ADDiv;
/*     */ import world.army.ADSupplies;
/*     */ import world.army.ADSupply;
/*     */ import world.army.WDIV;
/*     */ import world.battle.spec.WBattleSide;
/*     */ import world.battle.spec.WBattleUnit;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ final class ResolverSide
/*     */   implements WBattleSide
/*     */ {
/*  33 */   private final ArrayList<ResolverUnit> all = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  34 */   public final ArrayList<ResolverUnit> us = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  35 */   private final ArrayList<WBattleUnit> units = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   
/*     */   public Side side;
/*  38 */   private final Coo coo = new Coo();
/*     */   public boolean player;
/*     */   public double powerBalance;
/*     */   private int men;
/*     */   private int losses;
/*     */   private int lossesRetreat;
/*  44 */   private final int[] artilleryPieces = Alloc.ii(AD.supplies().arts().size());
/*  45 */   public final Coo retreatCoo = new Coo();
/*     */   
/*     */   ResolverSide() {
/*  48 */     while (this.all.hasRoom())
/*  49 */       this.all.add(new ResolverUnit()); 
/*     */   }
/*     */   
/*     */   public void init(Side side, double powerBalance) {
/*  53 */     this.side = side;
/*  54 */     this.powerBalance = powerBalance;
/*  55 */     this.men = 0;
/*  56 */     this.player = false;
/*  57 */     this.losses = 0;
/*  58 */     this.lossesRetreat = 0;
/*  59 */     this.us.clearSloppy();
/*  60 */     this.units.clearSloppy();
/*  61 */     for (int i = 0; i < side.us.size(); i++) {
/*  62 */       ResolverUnit u = (ResolverUnit)this.all.get(i);
/*  63 */       u.init((Side.SideUnit)side.us.get(i));
/*  64 */       this.player |= (((Side.SideUnit)side.us.get(i)).faction() == FACTIONS.player()) ? 1 : 0;
/*  65 */       this.men += ((Side.SideUnit)side.us.get(i)).men();
/*  66 */       this.us.add(u);
/*  67 */       this.units.add(u);
/*     */     } 
/*  69 */     this.coo.set(((Side.SideUnit)side.us.get(0)).x(), ((Side.SideUnit)side.us.get(0)).y());
/*  70 */     for (int ai = 0; ai < AD.supplies().arts().size(); ai++) {
/*  71 */       int am = 0;
/*  72 */       for (Side.SideUnit u : side.us) {
/*  73 */         if (u.a() != null) {
/*  74 */           am += ((ADSupplies.ADArtillery)AD.supplies().arts().get(ai)).current(u.a());
/*     */         }
/*     */       } 
/*  77 */       this.artilleryPieces[ai] = am;
/*     */     } 
/*     */     
/*  80 */     this.retreatCoo.set(-1.0D, -1.0D);
/*     */   }
/*     */   
/*     */   public void count(RCount c, double looseAmount, boolean ret) {
/*  84 */     for (ResolverUnit u : this.us) {
/*  85 */       u.count(c, looseAmount, ret);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ResolverSide clear() {
/*  91 */     this.losses = 0;
/*  92 */     this.lossesRetreat = 0;
/*     */     
/*  94 */     for (ResolverUnit u : this.us) {
/*  95 */       u.losses = 0;
/*  96 */       u.lossesRetreat = 0;
/*     */     } 
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public void extract(double looseAmount) {
/* 102 */     for (ResolverUnit u : this.us) {
/* 103 */       u.extract(looseAmount);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE coo() {
/* 109 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 114 */     return this.men;
/*     */   }
/*     */ 
/*     */   
/*     */   public int losses() {
/* 119 */     return this.losses;
/*     */   }
/*     */ 
/*     */   
/*     */   public int lossesRetreat() {
/* 124 */     return this.lossesRetreat;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<WBattleUnit> units() {
/* 129 */     return (LIST<WBattleUnit>)this.units;
/*     */   }
/*     */ 
/*     */   
/*     */   public int artillery(ADSupplies.ADArtillery a) {
/* 134 */     return this.artilleryPieces[a.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double powerBalance() {
/* 139 */     return this.powerBalance;
/*     */   }
/*     */ 
/*     */   
/*     */   final class ResolverUnit
/*     */     implements WBattleUnit
/*     */   {
/*     */     public Side.SideUnit unit;
/*     */     
/*     */     int losses;
/*     */     
/*     */     int lossesRetreat;
/*     */     double defences;
/*     */     
/*     */     private void init(Side.SideUnit u) {
/* 154 */       this.unit = u;
/* 155 */       this.defences = 0.0D;
/* 156 */       this.losses = 0;
/* 157 */       this.lossesRetreat = 0;
/*     */     }
/*     */     
/*     */     public void count(ResolverSide.RCount c, double looseAmount, boolean ret) {
/* 161 */       int losses = (int)Math.ceil(looseAmount * this.unit.men());
/* 162 */       count(c, losses, ret);
/*     */     }
/*     */     
/*     */     public void count(ResolverSide.RCount c, int loss, boolean ret) {
/* 166 */       double looseAm = loss / this.unit.men();
/* 167 */       int dead = 0;
/* 168 */       if (this.unit.a() != null) {
/* 169 */         WArmy a = this.unit.a();
/* 170 */         double d = 1.1D * looseAm;
/* 171 */         d = CLAMP.d(d, 0.0D, 1.0D);
/* 172 */         for (ADSupply s : (AD.supplies()).all) {
/* 173 */           int am = (int)(s.current().get(a) * d);
/* 174 */           c.res[s.res.index()] = c.res[s.res.index()] + am;
/*     */         } 
/*     */         
/* 177 */         for (int di = 0; di < a.divs().size(); di++) {
/* 178 */           ADDiv aDDiv = a.divs().get(di);
/* 179 */           int dd = (int)Math.ceil(d * aDDiv.men());
/* 180 */           c.dead[(aDDiv.race()).index] = c.dead[(aDDiv.race()).index] + dd;
/* 181 */           dead += dd;
/*     */         } 
/*     */       } else {
/* 184 */         Region reg = this.unit.r();
/* 185 */         double d = 1.1D * looseAm;
/* 186 */         for (int di = 0; di < RD.MILITARY().divisions(reg).size(); di++) {
/* 187 */           WDIV div = (WDIV)RD.MILITARY().divisions(reg).get(di);
/* 188 */           int dd = (int)Math.ceil(d * div.men());
/* 189 */           dead += dd;
/* 190 */           c.dead[div.race().index()] = c.dead[div.race().index()] + dd;
/*     */         } 
/*     */       } 
/* 193 */       if (ret) {
/* 194 */         ResolverSide.this.lossesRetreat += dead - this.lossesRetreat;
/* 195 */         this.lossesRetreat = dead;
/*     */       } else {
/* 197 */         ResolverSide.this.losses += dead - this.losses;
/* 198 */         this.losses = dead;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void extract(double looseAmount) {
/* 203 */       if (this.unit.a() != null) {
/* 204 */         extract(this.unit.a(), looseAmount);
/*     */       } else {
/* 206 */         extract(this.unit.r(), looseAmount);
/*     */       } 
/*     */     }
/*     */     public void extract(WArmy a, double looseAmount) {
/* 210 */       double d = 1.1D * looseAmount;
/* 211 */       for (ADSupply s : (AD.supplies()).all) {
/* 212 */         int am = (int)Math.ceil(s.current().get(a) * d);
/* 213 */         s.current().inc(a, -am);
/*     */       } 
/*     */       
/* 216 */       for (int di = 0; di < a.divs().size(); di++) {
/* 217 */         ADDiv aDDiv = a.divs().get(di);
/* 218 */         kill((WDIV)aDDiv, looseAmount);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void extract(Region reg, double looseAmount) {
/* 223 */       for (int di = 0; di < RD.MILITARY().divisions(reg).size(); di++) {
/* 224 */         WDIV div = (WDIV)RD.MILITARY().divisions(reg).get(di);
/* 225 */         kill(div, looseAmount);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void kill(WDIV div, double looseAmount) {
/* 230 */       int l = (int)Math.ceil(looseAmount * div.men());
/* 231 */       this.losses += l;
/*     */       
/* 233 */       int survivors = div.men() - l;
/*     */       
/* 235 */       double xp = 0.0D;
/*     */       
/* 237 */       if (survivors > 0) {
/* 238 */         xp = 0.1D * div.men() / survivors;
/* 239 */         xp += div.experience();
/* 240 */         xp = CLAMP.d(xp, 0.0D, 1.0D);
/*     */       } 
/*     */       
/* 243 */       div.resolve(survivors, xp);
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name() {
/* 248 */       return (this.unit.a() != null) ? (CharSequence)(this.unit.a()).name : (CharSequence)(this.unit.r()).info.name();
/*     */     }
/*     */ 
/*     */     
/*     */     public int men() {
/* 253 */       return ResolverSide.this.men;
/*     */     }
/*     */ 
/*     */     
/*     */     public int losses() {
/* 258 */       return this.losses;
/*     */     }
/*     */ 
/*     */     
/*     */     public int lossesRetreat() {
/* 263 */       return this.lossesRetreat;
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE icon() {
/* 268 */       return (this.unit.faction() != null) ? (this.unit.faction().banner()).MEDIUM : (SPRITE)(UI.icons()).m.rebellion;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hover(GUI_BOX box) {
/* 273 */       if (this.unit.a() != null) {
/* 274 */         (VIEW.world()).UI.armies.hover(box, this.unit.a());
/* 275 */       } else if (this.unit.r() != null) {
/* 276 */         (VIEW.world()).UI.regions.hoverGarrison(this.unit.r(), box);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double defences() {
/* 284 */       return this.defences;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RCount
/*     */   {
/* 293 */     public int[] res = Alloc.ii(RESOURCES.ALL().size());
/* 294 */     public int[] dead = Alloc.ii(RACES.all().size());
/*     */     
/*     */     public RCount clear() {
/* 297 */       Arrays.fill(this.res, 0);
/* 298 */       Arrays.fill(this.dead, 0);
/* 299 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\ResolverSide.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */