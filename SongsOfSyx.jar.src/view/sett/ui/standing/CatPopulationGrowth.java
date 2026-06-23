/*     */ package view.sett.ui.standing;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInputInt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ public abstract class CatPopulationGrowth extends GuiSection {
/*  30 */   private static CharSequence ¤¤immi = "¤Aspiring Immigrants";
/*  31 */   private static CharSequence ¤¤Athorize = "¤Authorize";
/*  32 */   private static CharSequence ¤¤Auto = "¤Auto";
/*  33 */   private static CharSequence ¤¤AutoDesc = "¤Automatically authorize new immigrants up until this amount.";
/*  34 */   private static CharSequence ¤¤Children = "Children";
/*  35 */   private static CharSequence ¤¤Limit = "¤Limit";
/*  36 */   private static CharSequence ¤¤LimitD = "¤Sets the max population desired from breeding. When breeding stops based on this limit, your population might be unhappy about it.";
/*     */   
/*  38 */   private static CharSequence ¤¤ForcedBreeding = "¤Forces your subjects to breed harder and faster."; private final HCLASS cl; private final GETTER<Race> race;
/*     */   
/*     */   static {
/*  41 */     D.ts(CatPopulationGrowth.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CatPopulationGrowth(HCLASS cl, GETTER<Race> race) {
/*  49 */     this.cl = cl;
/*  50 */     this.race = race;
/*     */     
/*  52 */     GuiSection b = breed();
/*  53 */     int w = b.body().width();
/*  54 */     if (cl == HCLASSES.CITIZEN()) {
/*  55 */       GuiSection a = immi();
/*  56 */       w = Math.max(w, a.body().width());
/*  57 */       a.body().setWidth(w);
/*  58 */       add((RENDEROBJ)a);
/*     */     } 
/*  60 */     b.body().setWidth(w);
/*  61 */     addDown(2, (RENDEROBJ)b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  69 */     visableSet((this.race.get() != null));
/*  70 */     if (this.race.get() != null)
/*  71 */       super.render(r, ds); 
/*     */   }
/*     */   
/*     */   private GuiSection immi() {
/*  75 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  79 */           GButt.ButtPanel.renderBG(r, (CatPopulationGrowth.this.cl == HCLASSES.CITIZEN()), false, hoveredIs(), (RECTANGLE)body());
/*  80 */           super.render(r, ds);
/*  81 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  87 */           super.hoverInfoGet(text);
/*  88 */           if (text.emptyIs()) {
/*  89 */             SETT.ENTRY().immi().hoverImmigrants(text, HCLASS_RACE.clP((Race)CatPopulationGrowth.this.race.get(), CatPopulationGrowth.this.cl));
/*     */           }
/*     */         }
/*     */       };
/*     */     
/*  94 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/*  99 */             if (CatPopulationGrowth.this.cl == HCLASSES.CITIZEN())
/* 100 */               GFORMAT.i(text, SETT.ENTRY().immi().wanted((Race)CatPopulationGrowth.this.race.get())); 
/* 101 */             if (CatPopulationGrowth.this.race.get() != null) {
/* 102 */               text.s().add('/').add(SETT.ENTRY().immi().auto((Race)CatPopulationGrowth.this.race.get()).get());
/*     */             } else {
/*     */               
/* 105 */               text.add(0L);
/*     */             } 
/*     */           }
/* 108 */         }).hh(¤¤immi));
/*     */     
/* 110 */     final INT.INTE m = new INT.INTE()
/*     */       {
/*     */         double[] d;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int min() {
/* 118 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 123 */           if (CatPopulationGrowth.this.cl == HCLASSES.CITIZEN())
/* 124 */             return SETT.ENTRY().immi().wanted((Race)CatPopulationGrowth.this.race.get()); 
/* 125 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 130 */           if (CatPopulationGrowth.this.race.get() != null)
/* 131 */             return (int)(max() * this.d[((Race)CatPopulationGrowth.this.race.get()).index]); 
/* 132 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 137 */           this.d[((Race)CatPopulationGrowth.this.race.get()).index] = t / max();
/*     */         }
/*     */       };
/* 140 */     s.addDown(4, (RENDEROBJ)new GInputInt(m, true, true));
/*     */     
/* 142 */     s.addRightC(8, (RENDEROBJ)new GButt.ButtPanel(¤¤Athorize)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 146 */             if (m.get() > 0) {
/* 147 */               SETT.ENTRY().immi().admit((Race)CatPopulationGrowth.this.race.get(), m.get());
/*     */             }
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 152 */             activeSet((m.get() > 0));
/* 153 */             super.renAction();
/*     */           }
/*     */         });
/*     */     
/* 157 */     s.add((RENDEROBJ)(new HOVERABLE.Sprite((SPRITE)new GText((UI.FONT()).S, ¤¤Auto))).hoverInfoSet(¤¤AutoDesc), 0, s.body().y2() + 10);
/*     */     
/* 159 */     INT.INTE a = new INT.INTE()
/*     */       {
/*     */ 
/*     */         
/*     */         public int min()
/*     */         {
/* 165 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 170 */           if (CatPopulationGrowth.this.cl == HCLASSES.CITIZEN() && CatPopulationGrowth.this.race.get() != null)
/* 171 */             return SETT.ENTRY().immi().auto((Race)CatPopulationGrowth.this.race.get()).max(); 
/* 172 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 177 */           if (CatPopulationGrowth.this.cl == HCLASSES.CITIZEN() && CatPopulationGrowth.this.race.get() != null)
/* 178 */             return SETT.ENTRY().immi().auto((Race)CatPopulationGrowth.this.race.get()).get(); 
/* 179 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 184 */           if (CatPopulationGrowth.this.cl == HCLASSES.CITIZEN())
/* 185 */             SETT.ENTRY().immi().auto((Race)CatPopulationGrowth.this.race.get()).set(t); 
/*     */         }
/*     */       };
/* 188 */     s.addRightCAbs(80, (RENDEROBJ)new GInputInt(a, true, true));
/*     */     
/* 190 */     s.addRelBody(16, DIR.W, (UI.icons()).s.arrow_right.scaled(2.0D));
/*     */     
/* 192 */     s.pad(16, 8);
/*     */     
/* 194 */     return s;
/*     */   }
/*     */   
/*     */   private GuiSection breed() {
/* 198 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 202 */           GButt.ButtPanel.renderBG(r, (STATS.POP()).reproduction.propagates(CatPopulationGrowth.this.cl, (Race)CatPopulationGrowth.this.race.get()), false, hoveredIs(), (RECTANGLE)body());
/* 203 */           super.render(r, ds);
/* 204 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 210 */           super.hoverInfoGet(text);
/* 211 */           GBox b = (GBox)text;
/* 212 */           if (text.emptyIs()) {
/* 213 */             (STATS.POP()).reproduction.hover((GUI_BOX)b, CatPopulationGrowth.this.cl, (Race)CatPopulationGrowth.this.race.get());
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 218 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 223 */             GFORMAT.i(text, (STATS.POP()).reproduction.kidsIncoming(CatPopulationGrowth.this.cl, (Race)CatPopulationGrowth.this.race.get()));
/*     */             
/* 225 */             text.s().add('+').add((STATS.POP()).reproduction.kidsPerYear(CatPopulationGrowth.this.cl, (Race)CatPopulationGrowth.this.race.get()), 2);
/*     */           }
/* 230 */         }).hh(¤¤Children));
/*     */     
/* 232 */     s.add((RENDEROBJ)(new HOVERABLE.Sprite((SPRITE)(new GText((UI.FONT()).S, ¤¤Limit)).lablify())).hoverInfoSet(¤¤LimitD), 0, s.body().y2() + 10);
/*     */     
/* 234 */     INT.INTE a = new INT.INTE()
/*     */       {
/*     */ 
/*     */         
/*     */         public int min()
/*     */         {
/* 240 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 245 */           return (STATS.POP()).reproduction.propagates(CatPopulationGrowth.this.cl, (Race)CatPopulationGrowth.this.race.get()) ? (STATS.POP()).reproduction.limit.max((MAPPED)HCLASS_RACE.clP((Race)CatPopulationGrowth.this.race.get(), CatPopulationGrowth.this.cl)) : 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 250 */           return (STATS.POP()).reproduction.propagates(CatPopulationGrowth.this.cl, (Race)CatPopulationGrowth.this.race.get()) ? (STATS.POP()).reproduction.limit.get((MAPPED)HCLASS_RACE.clP((Race)CatPopulationGrowth.this.race.get(), CatPopulationGrowth.this.cl)) : 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 255 */           (STATS.POP()).reproduction.limit.set((MAPPED)HCLASS_RACE.clP((Race)CatPopulationGrowth.this.race.get(), CatPopulationGrowth.this.cl), t);
/*     */         }
/*     */       };
/* 258 */     s.addRightCAbs(80, (RENDEROBJ)new GInputInt(a, true, true));
/*     */     
/* 260 */     s.addRightC(8, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.plus)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 264 */             (STATS.POP()).reproduction.forcedSetting.toggle((HCLASS_RACE.clP((Race)CatPopulationGrowth.this.race.get(), CatPopulationGrowth.this.cl)).index);
/* 265 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 270 */             selectedSet((STATS.POP()).reproduction.forcedSetting.get((HCLASS_RACE.clP((Race)CatPopulationGrowth.this.race.get(), CatPopulationGrowth.this.cl)).index));
/* 271 */             super.renAction();
/*     */           }
/* 274 */         }).hoverInfoSet(¤¤ForcedBreeding));
/*     */     
/* 276 */     s.addRelBody(16, DIR.W, (UI.icons()).s.reproduction.scaled(2.0D));
/*     */     
/* 278 */     s.pad(16);
/*     */     
/* 280 */     return s;
/*     */   }
/*     */   
/*     */   public abstract HCLASS_RACE pop();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatPopulationGrowth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */