/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDEdicts;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ final class PlayPop extends GuiSection {
/*  35 */   static CharSequence ¤¤eWarning = "¤Enabling an edict has a global effect in your whole kingdom. The affected race will have their loyalty decreased in all regions.";
/*  36 */   private double massacreAsked = -20.0D;
/*     */   static {
/*  38 */     D.ts(PlayPop.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public PlayPop(final GETTER.GETTER_IMP<Region> g, int width, int height) {
/*  43 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */ 
/*     */     
/*  46 */     GuiSection h = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/*  50 */     final GStat s = new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  54 */           GFORMAT.i(text, (RD.RACES()).population.get((Region)g.get()));
/*     */         }
/*     */       };
/*     */     
/*  58 */     SPRITE.Imp imp = new SPRITE.Imp(140, 24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  62 */           double n = (RD.RACES()).population.get((Region)g.get());
/*  63 */           double nn = (RD.RACES()).popTarget.getD(g.get());
/*  64 */           double mm = Math.max(n, nn);
/*  65 */           n /= mm;
/*  66 */           nn /= mm;
/*  67 */           GMeter.renderDelta(rr, n, nn, X1, X2, Y1, Y2);
/*  68 */           s.adjust();
/*  69 */           X1 += 8;
/*  70 */           Y1 += (Y2 - Y1 - s.height()) / 2;
/*  71 */           OPACITY.O50.bind();
/*  72 */           COLOR.BLACK.render(rr, X1 - 1, X1 + s.width() + 2, Y1 + 2, Y1 + s.height() - 2);
/*  73 */           OPACITY.unbind();
/*  74 */           s.render(rr, X1, Y1);
/*     */         }
/*     */       };
/*     */     
/*  78 */     h.add((RENDEROBJ)new GHeader.HeaderHorizontal((UI.icons()).m.citizen.resized(24), (SPRITE)imp)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  81 */             GBox b = (GBox)text;
/*     */             
/*  83 */             b.title((RD.RACES()).population.name);
/*     */             
/*  85 */             b.textLL(Dic.¤¤Current);
/*  86 */             b.tab(6);
/*  87 */             b.add((SPRITE)GFORMAT.i(b.text(), (RD.RACES()).population.get((Region)g.get())));
/*  88 */             b.NL();
/*  89 */             b.textLL(Dic.¤¤Target);
/*  90 */             b.tab(6);
/*  91 */             b.add((SPRITE)GFORMAT.i(b.text(), (int)(RD.RACES()).popTarget.getD(g.get())));
/*  92 */             b.sep();
/*     */ 
/*     */             
/*  95 */             (RD.RACES()).capacity.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), (RD.RACES()).capacity.name, true);
/*     */             
/*  97 */             b.NL(8);
/*  98 */             b.tab(1);
/*  99 */             b.textL(Dic.¤¤Used);
/*     */             
/* 101 */             double d = (RD.RACES()).capacity.get((BOOSTABLE_O)g.get()) * (RD.RACES()).population.get((Region)g.get()) / (RD.RACES()).popTarget.getD(g.get());
/*     */             
/* 103 */             b.tab(5);
/* 104 */             b.add((SPRITE)GFORMAT.f0(b.text(), -d));
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     h.addCentredY((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 116 */             GFORMAT.perc(text, (RD.RACES()).loyaltyAll.getD(g.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 121 */             (RD.RACES()).loyaltyAll.info().hover((GUI_BOX)b);
/*     */           }
/* 125 */         }).hh((SPRITE)(UI.icons()).m.rebellion), 252);
/*     */     
/* 127 */     h.addCentredY((RENDEROBJ)new HOVERABLE.Sprite((SPRITE)(UI.icons()).m.descrimination)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 130 */             (RD.RACES()).edicts.sanction.info.hover(text);
/*     */           }
/* 132 */         }476);
/*     */     
/* 134 */     h.addCentredY((RENDEROBJ)new HOVERABLE.Sprite((SPRITE)(UI.icons()).m.exit)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 137 */             (RD.RACES()).edicts.exile.info.hover(text);
/*     */           }
/* 139 */         }508);
/*     */     
/* 141 */     h.addCentredY((RENDEROBJ)new HOVERABLE.Sprite((SPRITE)(UI.icons()).m.skull)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 144 */             (RD.RACES()).edicts.massacre.info.hover(text);
/*     */           }
/* 146 */         }540);
/*     */     
/* 148 */     add((RENDEROBJ)h);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     for (RDRace r : (RD.RACES()).all) {
/* 154 */       GuiSection row = new GuiSection();
/* 155 */       row.addRightC(0, (RENDEROBJ)new HOVERABLE.Sprite((SPRITE)(r.race.appearance()).icon)
/*     */           {
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text)
/*     */             {
/* 160 */               GBox b = (GBox)text;
/* 161 */               r.race.info.hover((GUI_BOX)b);
/* 162 */               b.NL(8);
/*     */               
/* 164 */               r.race.boosts.hover(text, 1.0D, 2);
/*     */               
/* 166 */               text.NL(8);
/*     */               
/* 168 */               r.race.pref().hoverOther((GUI_BOX)b);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 174 */       GuiSection popGrowth = new GuiSection()
/*     */         {
/* 176 */           String mt = String.valueOf(Dic.¤¤Modifiers) + ": " + String.valueOf(Dic.¤¤Modifiers);
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 180 */             GBox b = (GBox)text;
/* 181 */             b.title(r.pop.name);
/*     */             
/* 183 */             b.textLL(Dic.¤¤Current);
/* 184 */             b.tab(6);
/* 185 */             b.add((SPRITE)GFORMAT.i(b.text(), r.pop.get((Region)g.get())));
/* 186 */             b.NL();
/*     */             
/* 188 */             b.textLL(Dic.¤¤Target);
/* 189 */             b.tab(6);
/* 190 */             b.add((SPRITE)GFORMAT.i(b.text(), r.pop.target((Region)g.get())));
/* 191 */             b.NL();
/*     */             
/* 193 */             b.textLL(Dic.¤¤Growth);
/* 194 */             b.tab(6);
/* 195 */             b.add((SPRITE)GFORMAT.percInc(b.text(), r.pop.growth((Region)g.get())));
/* 196 */             b.NL();
/*     */             
/* 198 */             b.textLL(Dic.¤¤Capacity);
/* 199 */             b.tab(6);
/* 200 */             b.add((SPRITE)GFORMAT.i(b.text(), (int)(RD.RACES()).capacity.get((BOOSTABLE_O)g.get())));
/* 201 */             b.NL();
/*     */             
/* 203 */             b.textLL(Dic.¤¤Rarity);
/* 204 */             b.tab(6);
/* 205 */             b.add((SPRITE)GFORMAT.perc(b.text(), r.pop.maxPopulation));
/* 206 */             b.NL();
/*     */ 
/*     */             
/* 209 */             b.sep();
/*     */             
/* 211 */             r.pop.dtarget.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), this.mt, true);
/*     */             
/* 213 */             b.sep();
/*     */             
/* 215 */             r.pop.growth.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), Dic.¤¤Growth, true);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 220 */       RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(140, 16)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER rr, float ds)
/*     */           {
/* 225 */             double c = r.pop.get((Region)g.get()) / (r.pop.maxPopulation * (RD.RACES()).capacity.get((BOOSTABLE_O)g.get()) + 1.0D);
/* 226 */             double t = r.pop.dtarget((Region)g.get());
/*     */             
/* 228 */             GMeter.renderDelta(rr, c, t, this.body.x1(), this.body.x2(), this.body.y1(), this.body.y2());
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       popGrowth.addRightC(6, (RENDEROBJ)renderImp);
/*     */       
/* 237 */       popGrowth.addRightC(8, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 241 */               GFORMAT.percInc(text, r.pop.growth((Region)g.get()));
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 246 */       popGrowth.body().incrW(64.0D);
/*     */       
/* 248 */       row.addRightC(6, (RENDEROBJ)popGrowth);
/*     */       
/* 250 */       GuiSection loyalty = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 254 */             GBox b = (GBox)text;
/* 255 */             b.title(r.loyalty.name);
/*     */             
/* 257 */             b.textLL(Dic.¤¤Current);
/* 258 */             b.tab(6);
/* 259 */             b.add((SPRITE)GFORMAT.f0(b.text(), r.loyalty.getD(g.get())));
/* 260 */             b.NL();
/* 261 */             b.textLL(Dic.¤¤Target);
/* 262 */             b.tab(6);
/* 263 */             b.add((SPRITE)GFORMAT.f0(b.text(), r.loyalty.target.get((BOOSTABLE_O)g.get())));
/* 264 */             b.NL();
/* 265 */             b.textLL(Dic.¤¤Increase);
/* 266 */             b.tab(6);
/* 267 */             b.add((SPRITE)GFORMAT.f0(b.text(), r.loyaltyTarget((Region)g.get())));
/* 268 */             b.NL();
/*     */             
/* 270 */             b.NL();
/* 271 */             b.sep();
/*     */             
/* 273 */             r.loyalty.target.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), Dic.¤¤Factors, true);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 278 */       HOVERABLE.HoverableAbs l = new HOVERABLE.HoverableAbs(140, 16)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER rr, float ds, boolean isHovered)
/*     */           {
/* 282 */             double c = (1.0D + r.loyalty.getD(g.get()) / 10.0D) / 2.0D;
/* 283 */             double t = (1.0D + r.loyalty.target.get((BOOSTABLE_O)g.get()) / 10.0D) / 2.0D;
/* 284 */             GMeter.renderC(rr, c, t, (RECTANGLE)this.body);
/*     */           }
/*     */         };
/*     */       
/* 288 */       loyalty.add((RENDEROBJ)l);
/* 289 */       loyalty.addRightC(8, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 293 */               double gg = (int)(r.loyalty.target.get((BOOSTABLE_O)g.get()) * 100.0D) / 100.0D;
/* 294 */               GFORMAT.f0(text, gg);
/*     */             }
/*     */           });
/*     */       
/* 298 */       loyalty.body().incrW(66.0D);
/* 299 */       row.addRightC(8, (RENDEROBJ)loyalty);
/*     */       
/* 301 */       for (RDEdicts.RDRaceEdict e : (RD.RACES()).edicts.all) {
/*     */         
/* 303 */         final ACTION a = new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/* 307 */               int i = e.toggled(r).get(g.get()) + 1 & 0x1;
/* 308 */               if (i == 1)
/* 309 */                 PlayPop.this.massacreAsked = VIEW.renderSecond(); 
/* 310 */               for (RDEdicts.RDRaceEdict ee : (RD.RACES()).edicts.all)
/* 311 */                 ee.toggled(r).set(g.get(), 0); 
/* 312 */               e.toggled(r).set(g.get(), i);
/*     */             }
/*     */           };
/*     */         
/* 316 */         row.addRightC(8, (RENDEROBJ)new GButt.Checkbox()
/*     */             {
/*     */               
/*     */               protected void clickA()
/*     */               {
/* 321 */                 int i = e.toggled(r).get(g.get()) + 1 & 0x1;
/* 322 */                 if (i == 1 && VIEW.renderSecond() - PlayPop.this.massacreAsked > 20.0D) {
/* 323 */                   (VIEW.inters()).yesNo.activate(PlayPop.¤¤eWarning, a, ACTION.NOP, true);
/*     */                 } else {
/* 325 */                   a.exe();
/*     */                 } 
/*     */               }
/*     */               
/*     */               protected void renAction() {
/* 330 */                 selectedSet((e.toggled(r).get(g.get()) == 1));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 335 */                 e.info.hover(text);
/* 336 */                 text.NL(8);
/* 337 */                 e.boosts.hover(text, 1.0D, 2);
/* 338 */                 e.boosts.hover(text, 1.0D, 2);
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 346 */       row.body().setWidth((width - 24));
/*     */       
/* 348 */       row.add((RENDEROBJ)new RENDEROBJ.RenderImp(row.body().width(), 4)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 352 */               GCOLOR.UI().border().render(r, this.body.x1(), this.body.x2(), this.body.y1() + 1, this.body.y1() + 2);
/*     */             }
/* 354 */           }0, row.body().y2());
/*     */ 
/*     */       
/* 357 */       rows.add(row);
/*     */     } 
/*     */ 
/*     */     
/* 361 */     height -= body().height();
/* 362 */     height = ((RENDEROBJ)rows.get(0)).body().height() * height / ((RENDEROBJ)rows.get(0)).body().height();
/*     */     
/* 364 */     add((RENDEROBJ)(new GScrollRows((Iterable)rows, height)).view(), 0, body().y2());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayPop.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */