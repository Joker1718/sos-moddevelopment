/*     */ package view.ui.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UIDivStats
/*     */ {
/*  40 */   private static CharSequence ¤¤Config = "Configuration";
/*     */   
/*     */   static {
/*  43 */     D.ts(UIDivStats.class);
/*     */   }
/*     */   
/*  46 */   private static int width = 300;
/*     */   
/*     */   private static final int height = 20;
/*     */   private Div sdiv;
/*     */   
/*  51 */   private final DIV_SPEC spec = new DIV_SPEC()
/*     */     {
/*     */       public Race race()
/*     */       {
/*  55 */         return UIDivStats.this.sdiv.race();
/*     */       }
/*     */ 
/*     */       
/*     */       public double training(StatsBattle.StatTraining tr) {
/*  60 */         return tr.stat.div().getD(UIDivStats.this.sdiv);
/*     */       }
/*     */ 
/*     */       
/*     */       public int men() {
/*  65 */         return UIDivStats.this.sdiv.menNrOf();
/*     */       }
/*     */ 
/*     */       
/*     */       public double equip(EquipBattle e) {
/*  70 */         return e.stat().div().getD(UIDivStats.this.sdiv);
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name() {
/*  75 */         return (CharSequence)UIDivStats.this.sdiv.info.name();
/*     */       }
/*     */ 
/*     */       
/*     */       public Faction faction() {
/*  80 */         return UIDivStats.this.sdiv.faction();
/*     */       }
/*     */ 
/*     */       
/*     */       public double experience() {
/*  85 */         return (STATS.BATTLE()).COMBAT_EXPERIENCE.div().getD(UIDivStats.this.sdiv);
/*     */       }
/*     */ 
/*     */       
/*     */       public int bannerI() {
/*  90 */         return UIDivStats.this.sdiv.info.bannerI();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private DIV_SPEC div;
/*  96 */   private final GuiSection ss = new GuiSection();
/*     */ 
/*     */   
/*     */   public UIDivStats() {
/* 100 */     pair((BOOSTABLES.BATTLE()).OFFENCE, (BOOSTABLES.BATTLE()).DEXTERITY, (BOOSTABLES.BATTLE()).CHARGE, GMeter.C_YELLOW);
/* 101 */     pair((BOOSTABLES.BATTLE()).DEFENCE, (BOOSTABLES.BATTLE()).PARRY, (BOOSTABLES.BATTLE()).FORMATION, GMeter.C_GREEN);
/*     */     
/* 103 */     this.ss.body().incrH(4.0D);
/*     */     
/* 105 */     pair((BOOSTABLES.BATTLE()).BLUNT_ATTACK, (BOOSTABLES.BATTLE()).BLUNT_DEFENCE_DIR, (BOOSTABLES.BATTLE()).BLUNT_DEFENCE);
/*     */     
/* 107 */     for (BOOSTABLES.BDamage bb : (BOOSTABLES.BATTLE()).DAMAGES) {
/* 108 */       pair(bb.attack, bb.defenceDir, bb.defence);
/*     */     }
/*     */     
/* 111 */     icon((SPRITE)(BOOSTABLES.BATTLE()).MORALE.icon);
/* 112 */     this.ss.addRightC(4, (RENDEROBJ)new GaugeBo((BOOSTABLES.BATTLE()).MORALE, GMeter.C_BLUE, width, 20));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     icon((SPRITE)(UI.icons()).s.bow);
/*     */     
/* 121 */     HOVERABLE.HoverableAbs aa = new HOVERABLE.HoverableAbs(width, 20)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 125 */           double def = 0.0D;
/* 126 */           double curr = 0.0D;
/* 127 */           double max = 0.0D;
/* 128 */           EquipRange rr = UIDivStats.best(UIDivStats.this.div);
/* 129 */           if (rr != null) {
/* 130 */             def = rr.projectile.range(0, rr.ref(0.0D, 0.0D));
/* 131 */             curr = rr.projectile.range(0, rr.ref(UIDivStats.this.div.equip((EquipBattle)rr), GAME.battle().boost(UIDivStats.this.div, rr.boostable)));
/* 132 */             for (EquipRange e : STATS.EQUIP().RANGED()) {
/* 133 */               max = Math.max(max, e.projectile.range(0, rr.ref(1.0D, rr.boostable.max(Div.class))));
/*     */             }
/* 135 */             def /= 64.0D;
/* 136 */             curr /= 64.0D;
/* 137 */             max /= 64.0D;
/*     */           } 
/* 139 */           GMeter.renderDelta(r, def / max, curr / max, this.body.x1(), body().x2(), this.body.y1(), this.body.cY(), GMeter.C_YELLOW);
/* 140 */           if (rr != null) {
/* 141 */             def = (GAME.battle()).power.range(rr, 0.0D);
/* 142 */             curr = (GAME.battle()).power.range(rr, rr.ref(UIDivStats.this.div.equip((EquipBattle)rr), GAME.battle().boost(UIDivStats.this.div, rr.boostable)));
/*     */           } 
/* 144 */           max = (GAME.battle()).power.bestRangedPower() + 1.0D;
/* 145 */           GMeter.renderDelta(r, def / max, curr / max, this.body.x1(), body().x2(), this.body.cY(), this.body.y2(), GMeter.C_ORANGE);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 150 */           GBox box = (GBox)text;
/* 151 */           box.title(Dic.¤¤Ammunition);
/* 152 */           EquipRange b = UIDivStats.best(UIDivStats.this.div);
/*     */           
/* 154 */           if (b != null)
/*     */           {
/* 156 */             b.projectile.hover((GUI_BOX)box, null, b.ref(UIDivStats.this.div.equip((EquipBattle)b), GAME.battle().boost(UIDivStats.this.div, b.boostable)), 0);
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 161 */     this.ss.addRightC(4, (RENDEROBJ)aa);
/*     */ 
/*     */ 
/*     */     
/* 165 */     GuiSection oo = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/* 169 */     oo.addDown(4, (RENDEROBJ)simple((BOOSTABLES.PHYSICS()).SPEED));
/* 170 */     oo.addDown(4, (RENDEROBJ)simple((BOOSTABLES.PHYSICS()).MASS));
/* 171 */     oo.addDown(4, (RENDEROBJ)simple((BOOSTABLES.PHYSICS()).STAMINA));
/* 172 */     oo.addDown(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 176 */             GFORMAT.f0(text, (GAME.battle()).power.get(UIDivStats.this.div));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 181 */             (GAME.battle()).power.hover((GUI_BOX)b, UIDivStats.this.div);
/*     */           }
/* 184 */         }).hh((SPRITE)(UI.icons()).s.fist));
/*     */ 
/*     */     
/* 187 */     this.ss.addRelBody(16, DIR.E, (RENDEROBJ)oo);
/* 188 */     this.ss.body().incrW(64.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiSection get(DIV_SPEC div) {
/* 200 */     this.sdiv = null;
/* 201 */     this.div = div;
/* 202 */     return this.ss;
/*     */   }
/*     */   
/*     */   public GuiSection get(Div div) {
/* 206 */     this.sdiv = div;
/* 207 */     this.div = this.spec;
/* 208 */     return this.ss;
/*     */   }
/*     */   
/*     */   private static EquipRange best(DIV_SPEC div) {
/* 212 */     double max = 0.0D;
/* 213 */     EquipRange b = null;
/* 214 */     for (EquipRange rr : STATS.EQUIP().RANGED()) {
/* 215 */       if (div.equip((EquipBattle)rr) > 0.0D) {
/* 216 */         double m = (GAME.battle()).power.range(rr, rr.ref(div.equip((EquipBattle)rr), GAME.battle().boost(div, rr.boostable)));
/* 217 */         if (m > max) {
/* 218 */           max = m;
/* 219 */           b = rr;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   private void pair(Boostable a, Boostable b, Boostable c, GMeter.GMeterCol col) {
/* 229 */     icon((SPRITE)a.icon);
/* 230 */     this.ss.addRight(4, (RENDEROBJ)new GaugeBo(a, col, width / 3, 20));
/* 231 */     this.ss.addRight(0, (RENDEROBJ)new GaugeBo(b, col, width / 3, 20));
/* 232 */     this.ss.addRight(0, (RENDEROBJ)new GaugeBo(c, col, width / 3, 20));
/*     */   }
/*     */ 
/*     */   
/*     */   private void pair(Boostable a, Boostable b, Boostable c) {
/* 237 */     icon((SPRITE)a.icon);
/* 238 */     this.ss.addRight(4, (RENDEROBJ)new GaugeBo(a, GMeter.C_YELLOW, width / 3, 20));
/* 239 */     this.ss.addRight(0, (RENDEROBJ)new GaugeBo(b, GMeter.C_GREEN, width / 3, 20));
/* 240 */     this.ss.addRight(0, (RENDEROBJ)new GaugeBo(c, GMeter.C_GREEN, width / 3, 20));
/*     */   }
/*     */   
/*     */   private void icon(SPRITE icon) {
/* 244 */     this.ss.add(icon, 0, this.ss.body().y2());
/*     */   }
/*     */   
/*     */   private HOVERABLE simple(final Boostable bo) {
/* 248 */     return (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 252 */           double v = GAME.battle().boost(UIDivStats.this.div, bo);
/* 253 */           if (UIDivStats.this.sdiv != null)
/* 254 */             v = bo.get((BOOSTABLE_O)UIDivStats.this.sdiv); 
/* 255 */           GFORMAT.fRel(text, v, UIDivStats.this.div.race().bvalue(bo));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 260 */           UIDivStats.this.hoverI(UIDivStats.this.div, bo, (GUI_BOX)b);
/*     */         }
/* 263 */       }).hh((SPRITE)bo.icon);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverI(DIV_SPEC st, Boostable bo, GUI_BOX text) {
/* 270 */     GBox b = (GBox)text;
/* 271 */     b.title(bo.name);
/* 272 */     b.text(bo.desc);
/* 273 */     b.sep();
/*     */     
/* 275 */     if (this.sdiv != null) {
/* 276 */       bo.hoverDetailed(text, (BOOSTABLE_O)this.sdiv, bo.name, true);
/*     */     } else {
/*     */       
/* 279 */       double base = bo.baseValue;
/* 280 */       double tot = GAME.battle().boost(st, bo);
/* 281 */       double withoutRace = tot;
/*     */       
/* 283 */       for (BoostSpec s : (st.race()).boosts.all()) {
/* 284 */         if (s.boostable == bo && 
/* 285 */           s.booster.isMul) {
/* 286 */           withoutRace /= s.booster.to();
/*     */         }
/*     */       } 
/* 289 */       for (BoostSpec s : (st.race()).boosts.all()) {
/* 290 */         if (s.boostable == bo && 
/* 291 */           !s.booster.isMul) {
/* 292 */           withoutRace -= s.booster.to();
/*     */         }
/*     */       } 
/*     */       
/* 296 */       double withOutFaction = withoutRace;
/* 297 */       for (Booster ss : bo.fGlobal) {
/* 298 */         if (ss.isMul) {
/* 299 */           withOutFaction /= ss.get(st.faction());
/*     */         }
/*     */       } 
/* 302 */       for (Booster ss : bo.fGlobal) {
/* 303 */         if (!ss.isMul) {
/* 304 */           withOutFaction -= ss.get(st.faction());
/*     */         }
/*     */       } 
/* 307 */       double race = tot - withoutRace;
/* 308 */       double fac = withoutRace - withOutFaction;
/* 309 */       double con = tot - race - fac - base;
/* 310 */       b.textLL(Dic.¤¤Base);
/* 311 */       b.tab(7);
/* 312 */       b.add((SPRITE)GFORMAT.f(b.text(), base));
/* 313 */       b.NL(2);
/*     */       
/* 315 */       b.textLL(RACES.name());
/* 316 */       b.tab(7);
/* 317 */       b.add((SPRITE)GFORMAT.f0(b.text(), race));
/* 318 */       b.NL(2);
/* 319 */       b.textLL(Dic.¤¤Faction);
/* 320 */       b.tab(7);
/* 321 */       b.add((SPRITE)GFORMAT.f0(b.text(), fac));
/* 322 */       b.NL(2);
/* 323 */       b.textLL(¤¤Config);
/* 324 */       b.tab(7);
/* 325 */       b.add((SPRITE)GFORMAT.f0(b.text(), con));
/* 326 */       b.NL(8);
/* 327 */       b.textLL(Dic.¤¤Total);
/* 328 */       b.tab(7);
/* 329 */       b.add((SPRITE)GFORMAT.f0(b.text(), tot));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private class GaugeBo
/*     */     extends Gauge
/*     */   {
/*     */     private final Boostable bo;
/*     */ 
/*     */     
/*     */     GaugeBo(Boostable bo, GMeter.GMeterCol col, int width, int height) {
/* 341 */       super(col, width, height);
/* 342 */       this.bo = bo;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 348 */       double max = this.bo.max(Div.class);
/* 349 */       double rr = UIDivStats.this.div.race().bvalue(this.bo);
/* 350 */       double d = GAME.battle().boost(UIDivStats.this.div, this.bo);
/* 351 */       if (UIDivStats.this.sdiv != null) {
/* 352 */         d = this.bo.get((BOOSTABLE_O)UIDivStats.this.sdiv);
/*     */       }
/* 354 */       render(r, rr, d, max);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 361 */       UIDivStats.this.hoverI(UIDivStats.this.div, this.bo, text);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class Gauge
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     public final GMeter.GMeterCol col;
/*     */ 
/*     */ 
/*     */     
/* 375 */     private final GText tt = new GText((UI.FONT()).S, 4);
/*     */     
/*     */     Gauge(GMeter.GMeterCol col, int width, int height) {
/* 378 */       super(width, height);
/* 379 */       this.col = col;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, double def, double current, double max) {
/* 384 */       int X1 = this.body.x1();
/* 385 */       int X2 = this.body.x2();
/* 386 */       int Y1 = this.body.y1();
/* 387 */       int Y2 = this.body.y2();
/* 388 */       GMeter.renderDelta(r, def / max, current / max, X1, X2, Y1, Y2, this.col);
/*     */       
/* 390 */       this.tt.clear();
/* 391 */       GFORMAT.f(this.tt, current, 1);
/* 392 */       this.tt.adjustWidth();
/* 393 */       OPACITY.O35.bind();
/*     */       
/* 395 */       X2 -= 4;
/* 396 */       X1 = X2 - this.tt.width() - 8;
/* 397 */       Y1 += (Y2 - Y1 - this.tt.height()) / 2;
/* 398 */       Y2 = Y1 + this.tt.height();
/*     */       
/* 400 */       COLOR.BLACK.render(r, X1, X2, Y1, Y2);
/* 401 */       OPACITY.unbind();
/* 402 */       this.tt.render(r, X1 + 4, Y1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivStats.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */