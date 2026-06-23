/*     */ package view.ui.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPES;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ 
/*     */ public final class UIDivCardSett implements DIMENSION {
/*  44 */   private static CharSequence ¤¤needs = "¤Needs to Train";
/*  45 */   private static CharSequence ¤¤fully = "¤Fully Trained";
/*  46 */   private static CharSequence ¤¤currently = "¤Currently Training";
/*     */   
/*  48 */   private static CharSequence ¤¤army = "¤Division is currently attached to the world army '{0}'. It must be recalled in order to be edited;";
/*  49 */   private static CharSequence ¤¤armyTime = "¤Division is returning home to our capital. The soldiers will arrive in {0} days.";
/*     */   static {
/*  51 */     D.ts(UIDivCardSett.class);
/*     */   }
/*     */   
/*  54 */   private final Rec body = new Rec();
/*     */   private final int WIDTH;
/*     */   private final int HEIGHT;
/*     */   private final UIDiv m;
/*  58 */   private final TrainingSpec spec = new TrainingSpec();
/*     */   
/*  60 */   private GuiSection sec = new GuiSection();
/*  61 */   private final UIDivStats stat = new UIDivStats();
/*     */   private Div current;
/*     */   
/*     */   UIDivCardSett(UIDiv m) {
/*  65 */     this.m = m;
/*  66 */     m.getClass(); this.WIDTH = 58;
/*  67 */     m.getClass(); this.HEIGHT = 78 + 20;
/*     */ 
/*     */     
/*  70 */     GuiSection s = new GuiSection();
/*     */     
/*  72 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/*  73 */       SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  77 */             if (UIDivCardSett.this.current.info.equipI(e) == 0) {
/*  78 */               OPACITY.O50.bind();
/*     */             }
/*  80 */             e.resource.icon().render(r, X1, X2, Y1, Y2);
/*  81 */             OPACITY.unbind();
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*  86 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  90 */             if (UIDivCardSett.this.current.info.equipI(e) == 0) {
/*  91 */               text.color(COLOR.WHITE50).add('-');
/*     */             } else {
/*  93 */               GFORMAT.f(text, (10 * UIDivCardSett.this.current.info.equipI(e)) / 10.0D);
/*     */             } 
/*     */           }
/*  96 */         }).hh((SPRITE)imp);
/*  97 */       s.addGrid((RENDEROBJ)hOVERABLE, e.indexMilitary(), 4, 48, 0);
/*     */     } 
/*     */ 
/*     */     
/* 101 */     (GCOLOR.T()).H1.bind();
/* 102 */     s.add((SPRITE)(UI.icons()).s.death, 0, s.body().y2() + 2);
/*     */     
/* 104 */     s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 108 */             GFORMAT.percGood(text, 100.0D * UIDivCardSett.this.current.info.experience() / 100.0D);
/*     */           }
/* 110 */         }).hh(Dic.¤¤Experience, 220));
/*     */     
/* 112 */     for (StatsBattle.StatTraining tt : (STATS.BATTLE()).TRAINING_ALL) {
/* 113 */       s.add(tt.room.icon.small, 0, s.body().y2() + 2);
/* 114 */       s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             
/*     */             public void update(GText text)
/*     */             {
/* 119 */               int target = (int)(100.0D * UIDivCardSett.this.current.info.training(tt));
/* 120 */               int cu = (int)Math.round(100.0D * tt.stat.div().getD(UIDivCardSett.this.current));
/*     */               
/* 122 */               text.add(cu).add('/').add(target).add('%');
/* 123 */               if (target > 0) {
/* 124 */                 text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).IGOOD, cu / target));
/*     */               } else {
/* 126 */                 text.color((GCOLOR.T()).INACTIVE);
/*     */               }  }
/* 128 */           }).hh((tt.stat.info()).name, 200));
/*     */     } 
/*     */ 
/*     */     
/* 132 */     s.add((SPRITE)(UI.icons()).s.sword, 0, s.body().y2() + 8);
/* 133 */     s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 137 */             GFORMAT.iofk(text, UIDivCardSett.this.current.menNrOf(), UIDivCardSett.this.current.info.men());
/*     */           }
/* 140 */         }).hh(Dic.¤¤Deployable, 200));
/*     */     
/* 142 */     s.add((SPRITE)(UI.icons()).s.fist, 0, s.body().y2() + 2);
/* 143 */     s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 147 */             GFORMAT.iofk(text, (STATS.BATTLE()).RECRUIT.inDiv(UIDivCardSett.this.current), (UIDivCardSett.this.current.info.men() - UIDivCardSett.this.current.menNrOf()));
/*     */           }
/* 150 */         }).hh(Dic.¤¤Recruits, 200));
/*     */ 
/*     */     
/* 153 */     this.sec.add((RENDEROBJ)s);
/*     */     
/* 155 */     this.sec.addRelBody(8, DIR.W, (RENDEROBJ)new RENDEROBJ.RenderImp(this.WIDTH * 2, this.HEIGHT * 2)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 159 */             UIDivCardSett.this.render(r, this.body.x1(), this.body.y1(), 2, UIDivCardSett.this.current, true, false, false);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/* 168 */     return this.WIDTH;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 173 */     return this.HEIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1, int scale, Div d, boolean isActive, boolean isSelected, boolean isHovered) {
/* 179 */     this.body.set(x1, (x1 + width() * scale), y1, (y1 + height() * scale));
/* 180 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */     
/* 182 */     this.m.renderBasics(r, x1, y1, scale, (DIV_SPEC)d.info);
/* 183 */     this.body.set(x1, (x1 + width() * scale), y1, (y1 + height() * scale));
/* 184 */     int cx = this.body.cX();
/*     */     
/* 186 */     double men = d.info.men();
/* 187 */     double n = d.menNrOf();
/*     */     
/* 189 */     if (men == 0.0D) {
/* 190 */       GMeter.renderDelta(r, 0.0D, 0.0D, (RECTANGLE)this.body);
/*     */     } else {
/* 192 */       GMeter.renderDelta(r, n / men, (n + (STATS.BATTLE()).RECRUIT.inDiv(d)) / men, this.body.x1() + 4 * scale, this.body.x2() - 4 * scale, this.body.y2() - 26 * scale, this.body.y2() - 12 * scale);
/*     */     } 
/* 194 */     double trTarget = 0.0D;
/* 195 */     double tr = 0.0D;
/*     */     
/* 197 */     for (StatsBattle.StatTraining tt : (STATS.BATTLE()).TRAINING_ALL) {
/* 198 */       trTarget += d.info.training(tt);
/* 199 */       tr += tt.stat.div().getD(d);
/*     */     } 
/* 201 */     GMeter.render(r, GMeter.C_GRAY, tr / trTarget, this.body.x1() + 4 * scale, this.body.x2() - 4 * scale, this.body.y2() - 12 * scale, this.body.y2() - 4 * scale);
/*     */ 
/*     */     
/* 204 */     (UI.FONT()).S.renderC(r, cx, this.body.y2() - 18 * scale, (CharSequence)Str.TMP.clear().add(d.info.men()), scale);
/*     */     
/* 206 */     if (AD.cityDivs().attachedArmy(d) != null) {
/* 207 */       OPACITY.O50.bind();
/* 208 */       COLOR.BLACK.render(r, (RECTANGLE)this.body, -4);
/* 209 */       OPACITY.unbind();
/* 210 */       (UI.icons()).m.arrow_left.renderCScaled(r, this.body.cX(), this.body.cY(), scale);
/* 211 */     } else if (AD.cityDivs().daysToReturn(d) > 0.0D) {
/* 212 */       OPACITY.O50.bind();
/* 213 */       COLOR.BLACK.render(r, (RECTANGLE)this.body, -4);
/* 214 */       OPACITY.O75TO100.bind();
/* 215 */       (UI.icons()).m.time.renderCScaled(r, this.body.cX(), this.body.cY(), scale);
/* 216 */       OPACITY.unbind();
/*     */     } 
/*     */     
/* 219 */     GCOLOR.UI().border().renderFrame(r, (RECTANGLE)this.body, 0, 1);
/*     */     
/* 221 */     if ((SETT.ROOMS()).GUARD.activeDuty.is(d)) {
/* 222 */       (GCOLOR.UI()).GOOD.hovered.bind();
/* 223 */       (UI.icons()).s.shield.render(r, this.body.x2() - 20, this.body.y1() + 4);
/* 224 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, Div div) {
/* 234 */     GBox b = (GBox)box;
/*     */     
/* 236 */     b.title((CharSequence)div.info.name());
/*     */     
/* 238 */     this.current = div;
/* 239 */     b.add((RENDEROBJ)this.sec);
/*     */     
/* 241 */     b.sep();
/*     */     
/* 243 */     b.add((RENDEROBJ)this.stat.get((DIV_SPEC)div.info));
/* 244 */     b.sep();
/*     */     
/* 246 */     if (AD.cityDivs().attachedArmy(div) != null) {
/* 247 */       GText t = b.text().warnify();
/* 248 */       t.add(¤¤army);
/* 249 */       t.insert(0, (CharSequence)(AD.cityDivs().attachedArmy(div)).name);
/* 250 */       b.add((SPRITE)t);
/* 251 */       b.NL(8);
/* 252 */     } else if (AD.cityDivs().daysToReturn(div) >= 0.0D) {
/* 253 */       GText t = b.text().warnify();
/* 254 */       t.add(¤¤armyTime);
/* 255 */       t.insert(0, (int)Math.ceil(AD.cityDivs().daysToReturn(div)));
/* 256 */       b.add((SPRITE)t);
/* 257 */       b.NL(8);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 262 */     b.sep();
/*     */ 
/*     */     
/* 265 */     b.textLL(¤¤needs);
/* 266 */     b.tab(6);
/* 267 */     b.add((SPRITE)GFORMAT.i(b.text(), needsTraining(div)));
/* 268 */     b.NL();
/*     */     
/* 270 */     b.textLL(¤¤currently);
/* 271 */     b.tab(6);
/* 272 */     b.add((SPRITE)GFORMAT.i(b.text(), training(div)));
/* 273 */     b.NL();
/*     */     
/* 275 */     b.textLL(¤¤fully);
/* 276 */     b.tab(6);
/* 277 */     b.add((SPRITE)GFORMAT.i(b.text(), (div.info.men() - needsTraining(div))));
/* 278 */     b.NL();
/*     */     
/* 280 */     b.textLL(((SETT.ROOMS()).GUARD.activeDuty.info()).name);
/* 281 */     b.tab(6);
/* 282 */     b.add((SPRITE)GFORMAT.i(b.text(), STATS.POP().pop(HTYPES.GUARD(), div)));
/* 283 */     b.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final class TrainingSpec
/*     */   {
/* 292 */     private int upI = -1;
/*     */     
/* 294 */     private final int[] needsTraining = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/* 295 */     private final int[] training = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*     */     
/* 297 */     private final EntityIterator.Humans iter = new EntityIterator.Humans()
/*     */       {
/*     */         protected boolean processAndShouldBreakH(Humanoid h, int ie)
/*     */         {
/* 301 */           if ((h.indu().clas()).player)
/* 302 */             count(h); 
/* 303 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         private void count(Humanoid h) {
/* 308 */           Div div = (Div)(STATS.BATTLE()).DIV.get(h);
/* 309 */           if (div != null) {
/* 310 */             if (h.indu().hType() == HTYPES.RECRUIT()) {
/* 311 */               UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] + 1;
/* 312 */               UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */             } else {
/* 314 */               for (ROOM_M_TRAINER<?> tra : (Iterable<ROOM_M_TRAINER<?>>)ROOM_M_TRAINER.ALL()) {
/* 315 */                 if (tra.training().shouldTrain(h.indu(), div.info.training(tra.training()), false)) {
/* 316 */                   UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */                   
/*     */                   return;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } else {
/* 323 */             div = (Div)(STATS.BATTLE()).RECRUIT.get(h);
/* 324 */             if (div != null && 
/* 325 */               h.indu().hType() == HTYPES.RECRUIT()) {
/* 326 */               UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] + 1;
/* 327 */               UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void init() {
/* 344 */       if (GAME.updateI() == this.upI) {
/*     */         return;
/*     */       }
/* 347 */       for (int di = 0; di < GAME.ARMIES().player().divisions().size(); di++) {
/* 348 */         Div d = (Div)GAME.ARMIES().player().divisions().get(di);
/*     */         
/* 350 */         this.needsTraining[di] = d.info.men() - (STATS.BATTLE()).DIV.stat().div().get(d) + (STATS.BATTLE()).RECRUIT.inDiv(d);
/* 351 */         if (AD.cityDivs().attachedArmy(d) != null) {
/* 352 */           this.needsTraining[di] = this.needsTraining[di] - AD.cityDivs().get(d).men();
/*     */         }
/*     */       } 
/*     */       
/* 356 */       Arrays.fill(this.training, 0);
/* 357 */       this.iter.iterate();
/* 358 */       this.upI = GAME.updateI();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int training(Div div) {
/* 366 */     this.spec.init();
/* 367 */     return this.spec.training[div.indexArmy()];
/*     */   }
/*     */   
/*     */   public int needsTraining(Div div) {
/* 371 */     this.spec.init();
/* 372 */     return this.spec.needsTraining[div.indexArmy()];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardSett.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */