/*     */ package view.ui.raider;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.raiding.Raider;
/*     */ import game.raiding.RaiderPortrait;
/*     */ import init.constant.Config;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class Current
/*     */   extends GuiSection {
/*  38 */   private static CharSequence ¤¤atLargeD = "This bandit is currently at large, and is contemplating their next raid on us.";
/*  39 */   private static CharSequence ¤¤killed = "This bandit is but a memory and was brought to justice {0}.";
/*  40 */   private static CharSequence ¤¤hidingD = "This bandit does not have the strength to attack us currently and will leave us alone for now.";
/*  41 */   private static CharSequence ¤¤distantD = "We are too insignificant and poor for this bandit to bother us.";
/*  42 */   private static CharSequence ¤¤raidingD = "This bandit is currently raiding you.";
/*     */ 
/*     */   
/*  45 */   private static CharSequence ¤¤Ransom = "Ransom";
/*  46 */   private static CharSequence ¤¤Raids = "Raids";
/*     */   
/*     */   static {
/*  49 */     D.ts(Current.class);
/*     */   }
/*     */   
/*  52 */   int ri = 0;
/*     */ 
/*     */   
/*     */   Current(int height) {
/*  56 */     addDown(0, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  60 */             text.setFont((UI.FONT()).H2);
/*  61 */             (GCOLOR.T()).H1.bind();
/*  62 */             text.add((Current.this.rr()).name);
/*     */           }
/*  64 */         }).r(DIR.NW));
/*     */     
/*  66 */     addDown(8, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  70 */             text.setMaxWidth(700);
/*  71 */             text.setMultipleLines(true);
/*  72 */             if ((GAME.raiders()).current.current() == Current.this.rr()) {
/*  73 */               text.color((GCOLOR.T()).IBAD).add(Current.¤¤raidingD);
/*  74 */             } else if ((Current.this.rr()).defeated) {
/*  75 */               Str.TMP.clear();
/*  76 */               DicTime.setDate(Str.TMP.clear(), (int)(Current.this.rr()).secondDefeated);
/*  77 */               text.add(Current.¤¤killed);
/*  78 */               text.insert(0, (CharSequence)Str.TMP);
/*  79 */               text.color((GCOLOR.T()).IGREAT);
/*  80 */             } else if (!Current.this.rr().hasInterrest()) {
/*  81 */               text.color((GCOLOR.T()).WARNING).add(Current.¤¤distantD);
/*  82 */             } else if (Current.this.rr().isScared()) {
/*  83 */               text.color((GCOLOR.T()).WARNING).add(Current.¤¤hidingD);
/*     */             } else {
/*  85 */               text.color((GCOLOR.T()).IBAD).add(Current.¤¤atLargeD);
/*     */             } 
/*     */           }
/*  88 */         }).r(DIR.NW));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     GuiSection s = new GuiSection();
/*  94 */     int dd = 150;
/*  95 */     int gi = 0;
/*     */     
/*  97 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 101 */             if (UIRaiding.statsVisible(Current.this.rr())) {
/* 102 */               GFORMAT.i(text, (Current.this.rr()).army.men);
/*     */             } else {
/* 104 */               text.add('?');
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 109 */         }).hv(Dic.¤¤Soldiers), gi++, dd, 100, dd, DIR.N);
/*     */     
/* 111 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 115 */             if (UIRaiding.statsVisible(Current.this.rr())) {
/* 116 */               GFORMAT.i(text, (Current.this.rr()).army.power);
/*     */             } else {
/* 118 */               text.add('?');
/*     */             }
/*     */           
/*     */           }
/* 122 */         }).hv(Dic.¤¤Power), gi++, dd, 100, dd, DIR.N);
/*     */     
/* 124 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 128 */             if (UIRaiding.statsVisible(Current.this.rr())) {
/* 129 */               GFORMAT.i(text, (int)(Current.this.rr()).worth);
/*     */             } else {
/* 131 */               text.add('?');
/*     */             } 
/*     */           }
/* 134 */         }).hv(¤¤Ransom), gi++, dd, 100, dd, DIR.N);
/*     */     
/* 136 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 140 */             GFORMAT.i(text, (Current.this.rr()).raids);
/*     */           }
/* 143 */         }).hv(¤¤Raids), gi++, dd, 100, dd, DIR.N);
/*     */     
/* 145 */     add((RENDEROBJ)s, 80, body().y2() + 40);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     GuiSection ss = new GuiSection();
/*     */     
/* 152 */     final RaiderPortrait p = new RaiderPortrait(4)
/*     */       {
/*     */         protected Induvidual raider() {
/* 155 */           dead((Current.this.rr()).defeated);
/* 156 */           return (Current.this.rr()).indu;
/*     */         }
/*     */       };
/*     */     
/* 160 */     SPRITE.Imp imp = new SPRITE.Imp(p.width(), p.height())
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 165 */           if (UIRaiding.portVisible(Current.this.rr()) || (S.get()).developer) {
/* 166 */             p.render(r, X1, Y1);
/*     */           } else {
/* 168 */             (UI.icons()).m.questionmark.renderC(r, X1, X2, Y1, Y2);
/*     */           } 
/*     */           
/* 171 */           GCOLOR.UI().border().renderFrame(r, X1, X2, Y1, Y2, 2, 2);
/*     */         }
/*     */       };
/*     */     
/* 175 */     ss.add((SPRITE)imp, 0, 0);
/*     */     
/* 177 */     final int am = 10;
/*     */     
/* 179 */     ArrayList<GuiSection> rows = new ArrayList((int)Math.ceil((Config.battle()).DIVISIONS_PER_ARMY / am));
/*     */     int i;
/* 181 */     for (i = 0; i < rows.max(); i++) {
/* 182 */       rows.add(new GuiSection());
/*     */     }
/*     */ 
/*     */     
/* 186 */     for (i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/*     */       
/* 188 */       GuiSection guiSection = (GuiSection)rows.get(i / am);
/* 189 */       guiSection.addRightC(2, (RENDEROBJ)new Button(i));
/*     */     } 
/*     */     
/* 192 */     ss.addRelBody(8, DIR.E, (RENDEROBJ)(new GScrollRows((Iterable)rows, imp.height())
/*     */         {
/*     */           protected boolean passesFilter(int i, RENDEROBJ o) {
/* 195 */             return (i <= Math.ceil(((Current.this.rr()).army.sdivs.size() / am)));
/*     */           }
/* 198 */         }).view());
/*     */     
/* 200 */     add((RENDEROBJ)ss, 0, body().y2() + 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 209 */   private static int dim = 50;
/*     */   
/*     */   private class Button
/*     */     extends HOVERABLE.HoverableAbs {
/*     */     private final int ii;
/*     */     
/*     */     Button(int ii) {
/* 216 */       this.ii = ii;
/* 217 */       this.body.setDim(Current.dim);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 222 */       if (this.ii >= (Current.this.rr()).army.sdivs.size()) {
/*     */         return;
/*     */       }
/*     */       
/* 226 */       DIV_SPEC d = (DIV_SPEC)(Current.this.rr()).army.sdivs.get(this.ii);
/*     */       
/* 228 */       if (d == null) {
/*     */         return;
/*     */       }
/* 231 */       GButt.ButtPanel.renderBG(r, true, isHovered, false, (RECTANGLE)this.body);
/*     */       
/* 233 */       if ((Current.this.rr()).raids > 0 || UIRaiding.debug) {
/* 234 */         (d.race().appearance()).icon.renderC(r, body().cX(), body().cY() - 6);
/*     */         
/* 236 */         (VIEW.UI()).div.renderPower(this.body.x2() - 16, this.body.y1() + 4, r, (GAME.battle()).power.get(d));
/*     */ 
/*     */         
/* 239 */         int w = (int)((this.body.width() - 8) * CLAMP.d((d.men() + (Config.battle()).MEN_PER_DIVISION / 5) / (Config.battle()).MEN_PER_DIVISION, 0.0D, 1.0D));
/*     */         
/* 241 */         GMeter.GMeterCol col = GMeter.C_REDBLUE;
/*     */ 
/*     */         
/* 244 */         GMeter.render(r, col, 1.0D, this.body.x1() + 4, this.body.x1() + 4 + w, this.body.y2() - 14, this.body.y2() - 6);
/* 245 */         OPACITY.unbind();
/*     */       } else {
/* 247 */         (UI.icons()).s.question.renderC(r, body().cX(), this.body.cY());
/*     */       } 
/*     */ 
/*     */       
/* 251 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 257 */       if (this.ii >= (Current.this.rr()).army.sdivs.size())
/*     */         return; 
/* 259 */       GBox b = (GBox)text;
/* 260 */       if ((Current.this.rr()).raids > 0 || UIRaiding.debug) {
/* 261 */         DIV_SPEC d = (DIV_SPEC)(Current.this.rr()).army.sdivs.get(this.ii);
/* 262 */         (VIEW.UI()).div.normal.hover(d, (GUI_BOX)b);
/*     */       } else {
/*     */         
/* 265 */         b.add((SPRITE)b.text().add('?'));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Raider rr() {
/* 272 */     return (Raider)GAME.raiders().ALL().get(this.ri);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\Current.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */