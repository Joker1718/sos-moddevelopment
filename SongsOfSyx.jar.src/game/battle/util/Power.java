/*     */ package game.battle.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.nio.file.Path;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Power
/*     */ {
/*  29 */   public static CharSequence ¤¤desc = "The overall power of a battle unit. Divided into different attack and defence types. The total power is an indication of how well the unit will perform in a fight, but in practice each type determines the outcome.";
/*  30 */   private static CharSequence ¤¤attack = "attack";
/*  31 */   private static CharSequence ¤¤defence = "defence";
/*  32 */   private static CharSequence ¤¤morale = "morale";
/*  33 */   private static CharSequence ¤¤mass = "mass";
/*  34 */   private static CharSequence ¤¤speed = "speed";
/*  35 */   private static CharSequence ¤¤charge = "charge";
/*     */   
/*  37 */   private static CharSequence ¤¤ranged = "ranged";
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  42 */     D.ts(Power.class);
/*     */   }
/*     */   
/*  45 */   public final double HIGH_POWER = 5.0D;
/*     */   
/*  47 */   private double minPower = -1.0D;
/*  48 */   private double maxPI = -1.0D;
/*  49 */   private double bestRanged = 1.0D;
/*     */ 
/*     */ 
/*     */   
/*     */   private Div sDiv;
/*     */ 
/*     */ 
/*     */   
/*     */   private final DIV_SPEC dstats;
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(DIV_SPEC div) {
/*  62 */     init();
/*     */     
/*  64 */     double d = pget(div);
/*  65 */     d -= this.minPower;
/*  66 */     d *= this.maxPI;
/*  67 */     return div.men() * (1.0D + d);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, DIV_SPEC spec) {
/*  71 */     GBox b = (GBox)box;
/*     */     
/*  73 */     b.title(Dic.¤¤Power);
/*  74 */     b.text(¤¤desc);
/*     */     
/*  76 */     double att = attack(spec);
/*  77 */     double def = defence(spec);
/*     */ 
/*     */     
/*  80 */     b.NL(8);
/*  81 */     b.textLL(¤¤attack);
/*  82 */     b.tab(6);
/*  83 */     GText t = b.text();
/*  84 */     t.add('+');
/*  85 */     b.add((SPRITE)GFORMAT.f(t, att));
/*  86 */     b.NL();
/*     */     
/*  88 */     b.textLL(¤¤defence);
/*  89 */     b.tab(6);
/*  90 */     t = b.text();
/*  91 */     t.add('+');
/*  92 */     b.add((SPRITE)GFORMAT.f(t, def));
/*  93 */     b.NL();
/*     */     
/*  95 */     b.textLL(¤¤morale);
/*  96 */     b.tab(6);
/*  97 */     t = b.text();
/*  98 */     t.add('*');
/*  99 */     b.add((SPRITE)GFORMAT.f(t, bo(spec, (BOOSTABLES.BATTLE()).MORALE)));
/* 100 */     b.NL();
/*     */     
/* 102 */     b.textLL(¤¤charge);
/* 103 */     b.tab(6);
/* 104 */     t = b.text();
/* 105 */     t.add('+');
/* 106 */     b.add((SPRITE)GFORMAT.f(t, att * bo(spec, (BOOSTABLES.BATTLE()).CHARGE) / 2.0D));
/* 107 */     b.NL();
/*     */     
/* 109 */     b.textLL(¤¤mass);
/* 110 */     b.tab(6);
/* 111 */     t = b.text();
/* 112 */     t.add('*');
/* 113 */     b.add((SPRITE)GFORMAT.f(t, 1.0D + 0.1D * bo(spec, (BOOSTABLES.PHYSICS()).MASS)));
/* 114 */     b.NL();
/*     */     
/* 116 */     b.textLL(¤¤speed);
/* 117 */     b.tab(6);
/* 118 */     t = b.text();
/* 119 */     t.add('*');
/* 120 */     b.add((SPRITE)GFORMAT.f(t, 1.0D + 0.1D * bo(spec, (BOOSTABLES.PHYSICS()).SPEED)));
/* 121 */     b.NL();
/*     */     
/* 123 */     b.textLL(¤¤ranged);
/* 124 */     b.tab(6);
/* 125 */     t = b.text();
/* 126 */     t.add('+');
/* 127 */     b.add((SPRITE)GFORMAT.f(t, range(spec)));
/* 128 */     b.NL();
/*     */     
/* 130 */     b.textLL(Dic.¤¤Soldiers);
/* 131 */     b.tab(6);
/* 132 */     t = b.text();
/* 133 */     t.add('*');
/* 134 */     b.add((SPRITE)GFORMAT.i(t, spec.men()));
/* 135 */     b.NL();
/*     */     
/* 137 */     b.tab(6);
/* 138 */     t = b.text();
/* 139 */     b.add((SPRITE)GFORMAT.f0(t, get(spec)));
/* 140 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 144 */     b.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private double pget(DIV_SPEC div) {
/* 150 */     double attack = attack(div);
/* 151 */     double defence = defence(div) + defenceDir(div) * 0.5D;
/*     */     
/* 153 */     double tot = attack + defence;
/* 154 */     tot *= bo(div, (BOOSTABLES.BATTLE()).MORALE);
/*     */     
/* 156 */     tot += attack * GAME.battle().boost(div, (BOOSTABLES.BATTLE()).CHARGE) / 2.0D;
/*     */     
/* 158 */     tot *= 1.0D + 0.1D * (bo(div, (BOOSTABLES.PHYSICS()).MASS) - 1.0D);
/* 159 */     tot *= 1.0D + 0.25D * (bo(div, (BOOSTABLES.PHYSICS()).SPEED) - 1.0D);
/*     */     
/* 161 */     tot += range(div);
/*     */     
/* 163 */     return tot;
/*     */   }
/*     */ 
/*     */   
/*     */   private double attack(DIV_SPEC div) {
/* 168 */     double base = bo(div, (BOOSTABLES.BATTLE()).OFFENCE) + bo(div, (BOOSTABLES.BATTLE()).DEXTERITY) * 0.5D;
/* 169 */     double blunt = bo(div, (BOOSTABLES.BATTLE()).BLUNT_ATTACK);
/* 170 */     double res = blunt;
/* 171 */     for (int di = 0; di < (BOOSTABLES.BATTLE()).DAMAGES.size(); di++) {
/* 172 */       res += blunt * bo(div, ((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(di)).attack) / (BOOSTABLES.BATTLE()).DAMAGES.size();
/*     */     }
/* 174 */     res += base;
/*     */     
/* 176 */     return res;
/*     */   }
/*     */   
/*     */   private double defence(DIV_SPEC div) {
/* 180 */     double base = bo(div, (BOOSTABLES.BATTLE()).DEFENCE) + bo(div, (BOOSTABLES.BATTLE()).FORMATION) * 0.5D + bo(div, (BOOSTABLES.BATTLE()).PARRY) * 0.5D;
/* 181 */     double blunt = bo(div, (BOOSTABLES.BATTLE()).BLUNT_DEFENCE);
/* 182 */     double res = 1.0D;
/* 183 */     for (int di = 0; di < (BOOSTABLES.BATTLE()).DAMAGES.size(); di++) {
/* 184 */       res += bo(div, ((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(di)).defence) / (BOOSTABLES.BATTLE()).DAMAGES.size();
/*     */     }
/* 186 */     res *= blunt;
/* 187 */     return res + base;
/*     */   }
/*     */   
/*     */   private double defenceDir(DIV_SPEC div) {
/* 191 */     double base = bo(div, (BOOSTABLES.BATTLE()).DEFENCE) + bo(div, (BOOSTABLES.BATTLE()).FORMATION) * 0.5D;
/* 192 */     double blunt = bo(div, (BOOSTABLES.BATTLE()).BLUNT_DEFENCE_DIR);
/* 193 */     double res = 1.0D;
/* 194 */     for (int di = 0; di < (BOOSTABLES.BATTLE()).DAMAGES.size(); di++) {
/* 195 */       res += bo(div, ((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(di)).defenceDir) / (BOOSTABLES.BATTLE()).DAMAGES.size();
/*     */     }
/* 197 */     res *= blunt;
/* 198 */     return res + base;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private double range(DIV_SPEC div) {
/* 204 */     EquipRange rr = best(div);
/* 205 */     if (rr == null) {
/* 206 */       return 0.0D;
/*     */     }
/* 208 */     double ref = rr.ref(div.equip((EquipBattle)rr), GAME.battle().boost(div, rr.boostable));
/*     */     
/* 210 */     return range(rr, ref);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double range(EquipRange rr, double ref) {
/* 218 */     double hits = rr.projectile.range(0, ref) / rr.projectile.reloadSeconds(ref) * 64.0D * (1.0D + (BOOSTABLES.PHYSICS()).SPEED.baseValue * 4.0D);
/*     */ 
/*     */     
/* 221 */     double base = hits;
/* 222 */     double blunt = rr.projectile.bluntDamage(ref) / (1.0D + (BOOSTABLES.BATTLE()).BLUNT_ATTACK.baseValue);
/* 223 */     double res = blunt;
/*     */     
/* 225 */     for (int di = 0; di < (BOOSTABLES.BATTLE()).DAMAGES.size(); di++) {
/* 226 */       res += blunt * rr.projectile.damage(di, ref) / (1.0D + ((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(di)).attack.baseValue) * (BOOSTABLES.BATTLE()).DAMAGES.size();
/*     */     }
/* 228 */     res *= base;
/* 229 */     res *= 1.0D + rr.projectile.areaAttack(ref);
/* 230 */     res *= 0.2D + 0.8D * rr.projectile.accuracy(ref);
/* 231 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double bo(DIV_SPEC div, Boostable b) {
/* 238 */     return GAME.battle().boost(div, b) / (1.0D + b.baseValue);
/*     */   }
/*     */   
/*     */   private EquipRange best(DIV_SPEC div) {
/* 242 */     double max = 0.0D;
/* 243 */     EquipRange b = null;
/* 244 */     for (int ei = 0; ei < STATS.EQUIP().RANGED().size(); ei++) {
/* 245 */       EquipRange rr = (EquipRange)STATS.EQUIP().RANGED().get(ei);
/* 246 */       if (div.equip((EquipBattle)rr) > 0.0D) {
/* 247 */         double ref = rr.ref(div.equip((EquipBattle)rr), GAME.battle().boost(div, rr.boostable));
/* 248 */         double m = range(rr, ref);
/* 249 */         if (m > max) {
/* 250 */           max = m;
/* 251 */           b = rr;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 256 */     return b;
/*     */   }
/*     */   
/*     */   public double bestRangedPower() {
/* 260 */     return this.bestRanged;
/*     */   }
/*     */   
/*     */   private void init() {
/* 264 */     if (this.maxPI >= 0.0D) {
/*     */       return;
/*     */     }
/*     */     
/* 268 */     DIV_SPEC.DIV_SPECImp spec = new DIV_SPEC.DIV_SPECImp();
/*     */     
/* 270 */     double minAverage = 0.0D;
/* 271 */     for (int ri = 0; ri < RACES.playable().size(); ri++) {
/*     */       
/* 273 */       Race r = (Race)RACES.playable().get(ri);
/* 274 */       spec.clear(r);
/* 275 */       spec.menSet(1);
/* 276 */       minAverage += pget(spec);
/*     */     } 
/*     */ 
/*     */     
/* 280 */     minAverage /= RACES.playable().size();
/* 281 */     this.minPower = minAverage;
/*     */     
/* 283 */     double highAverage = 0.0D;
/* 284 */     for (int i = 0; i < RACES.playable().size(); i++) {
/*     */       
/* 286 */       Race r = (Race)RACES.playable().get(i);
/* 287 */       spec.clear(r);
/* 288 */       spec.menSet(1);
/* 289 */       spec.experienceSet(0.5D);
/*     */       
/* 291 */       double am = 0.0D;
/* 292 */       double pp = 0.0D;
/* 293 */       for (int si = 0; si < (GAME.battle()).types.ALL().size(); si++) {
/* 294 */         DivType t = (DivType)(GAME.battle()).types.ALL().get(si);
/* 295 */         if (t.valid(r)) {
/* 296 */           am += t.occurence;
/* 297 */           spec.copySettings(t);
/* 298 */           pp += pget(spec) * t.occurence;
/*     */         } 
/*     */       } 
/*     */       
/* 302 */       double m = minAverage;
/* 303 */       if (am > 0.0D) {
/* 304 */         m = Math.max(m, pp / am);
/*     */       }
/*     */       
/* 307 */       highAverage += m;
/*     */     } 
/* 309 */     highAverage /= RACES.playable().size();
/* 310 */     double delta = highAverage - minAverage;
/* 311 */     this.maxPI = 5.0D / delta;
/*     */ 
/*     */ 
/*     */     
/* 315 */     this.bestRanged = 0.0D;
/* 316 */     for (EquipRange r : STATS.EQUIP().RANGED()) {
/* 317 */       this.bestRanged = Math.max(this.bestRanged, range(r, r.ref(1.0D, GAME.battle().boostMax(r.boostable))));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Power() {
/* 325 */     this.dstats = new DIV_SPEC()
/*     */       {
/*     */         public double training(StatsBattle.StatTraining tr)
/*     */         {
/* 329 */           return tr.stat.div().getD(Power.this.sDiv);
/*     */         }
/*     */ 
/*     */         
/*     */         public double equip(EquipBattle e) {
/* 334 */           return e.stat().div().getD(Power.this.sDiv);
/*     */         }
/*     */ 
/*     */         
/*     */         public Race race() {
/* 339 */           return Power.this.sDiv.info.race();
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 344 */           return Power.this.sDiv.menNrOf();
/*     */         }
/*     */ 
/*     */         
/*     */         public Faction faction() {
/* 349 */           return Power.this.sDiv.army().faction();
/*     */         }
/*     */ 
/*     */         
/*     */         public double experience() {
/* 354 */           return (STATS.BATTLE()).COMBAT_EXPERIENCE.div().getD(Power.this.sDiv);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence name() {
/* 360 */           return null;
/*     */         } public void exe(Path t) {
/*     */           Power.this.maxPI = -1.0D;
/*     */         }
/*     */       };
/*     */     GAME.saver().onAfterLoad(new ACTION.ACTION_O<Path>() { public int bannerI() {
/* 366 */             return 0;
/*     */           } }
/*     */       );
/*     */   }
/*     */   public double get(Div div) {
/* 371 */     this.sDiv = div;
/* 372 */     return get(this.dstats);
/*     */   }
/*     */   
/*     */   public double get(WArmy a) {
/* 376 */     int am = 0;
/* 377 */     for (int di = 0; di < a.divs().size(); di++) {
/* 378 */       am = (int)(am + get((DIV_SPEC)a.divs().get(di)));
/*     */     }
/* 380 */     return am;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\Power.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */