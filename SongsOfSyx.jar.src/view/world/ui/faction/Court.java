/*     */ package view.world.ui.faction;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.boosting.superb.SuperSpec;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.emmi.EmiTypeRoy;
/*     */ import game.faction.player.emmi.Emissaries;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.faction.royalty.opinion.RTrust;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.TRAIT;
/*     */ import init.value.GVALUES;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GInputInt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GMatrix;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.util.UIValues;
/*     */ 
/*     */ final class Court extends GuiSection {
/*  49 */   private static CharSequence ¤¤AndCrew = "¤And {0} Retinue";
/*  50 */   private static CharSequence ¤¤personal = "Personal Importance";
/*  51 */   private static CharSequence ¤¤valueSpan = "Value Span";
/*     */   
/*  53 */   private static CharSequence ¤¤minOpinion = "Opinion Required";
/*  54 */   private static CharSequence ¤¤assass = "Assassination Target (click to cycle)"; private GuiSection vvs;
/*     */   
/*     */   static {
/*  57 */     D.ts(Court.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Court(final GETTER<FactionNPC> f, int WIDTH, int HEIGHT) {
/*  65 */     GETTER<Royalty> g = new GETTER<Royalty>()
/*     */       {
/*     */         public Royalty get() {
/*  68 */           return ((FactionNPC)f.get()).king();
/*     */         }
/*     */       };
/*  71 */     this.vvs = (GuiSection)new UIValues(GVALUES.ROYALTY, g);
/*     */ 
/*     */ 
/*     */     
/*  75 */     RENDEROBJ suckers = king(f);
/*  76 */     add(suckers);
/*     */     
/*  78 */     GuiSection op = opinions(f, HEIGHT - body().height() - 8);
/*  79 */     op.addRelBody(32, DIR.E, (RENDEROBJ)emmisaries(f));
/*  80 */     addRelBody(8, DIR.S, (RENDEROBJ)op);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ king(final GETTER<FactionNPC> f) {
/*  86 */     GuiSection text = new GuiSection();
/*  87 */     text.body().setDim(600.0D, 1.0D);
/*     */ 
/*     */     
/*  90 */     text.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat(new GText((UI.FONT()).M, 32))
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  94 */             ((FactionNPC)f.get()).court().king().intro((Str)text);
/*     */           }
/*  96 */         }).r(DIR.N));
/*     */ 
/*     */     
/*  99 */     text.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat(new GText((UI.FONT()).H2, 32))
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 103 */             text.lablify().add((CharSequence)(((FactionNPC)f.get()).court().king()).name);
/*     */           }
/* 106 */         }).r(DIR.N));
/*     */     
/* 108 */     text.addRelBody(4, DIR.S, (RENDEROBJ)(new GStat(new GText((UI.FONT()).S, 32))
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 112 */             ArrayListGrower arrayListGrower = (((FactionNPC)f.get()).court().king().roy()).traits;
/* 113 */             for (int i = 0; i < arrayListGrower.size(); i++) {
/* 114 */               text.add(((TRAIT)arrayListGrower.get(i)).rTitle);
/* 115 */               if (i < arrayListGrower.size() - 1)
/* 116 */                 text.add(',').s(); 
/*     */             } 
/* 118 */             text.setMaxWidth(600);
/* 119 */             text.setMultipleLines(true);
/*     */           }
/* 121 */         }).r(DIR.N));
/*     */     
/* 123 */     text.addRelBody(24, DIR.S, (RENDEROBJ)(new GStat(new GText((UI.FONT()).S, 32))
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 127 */             text.add(Court.¤¤AndCrew);
/* 128 */             text.insert(0, ((((FactionNPC)f.get()).king()).induvidual.race()).info.pHIS.get((((FactionNPC)f.get()).king()).induvidual, false));
/*     */           }
/* 131 */         }).r(DIR.N));
/*     */     
/* 133 */     GuiSection s = new GuiSection();
/* 134 */     for (int i = 1; i < 4; i++) {
/* 135 */       final int k = i;
/* 136 */       Portrait portrait = new Portrait(this, 2, new GETTER<Royalty>()
/*     */           {
/*     */             public Royalty get()
/*     */             {
/* 140 */               return (Royalty)((FactionNPC)f.get()).court().all().get(k);
/*     */             }
/*     */           })
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 146 */             text.NL();
/* 147 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */       
/* 151 */       s.addRightC(8, (RENDEROBJ)portrait);
/*     */     } 
/*     */     
/* 154 */     text.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */     
/* 156 */     s = new GuiSection();
/* 157 */     s.add((RENDEROBJ)new Portrait(4, new GETTER<Royalty>()
/*     */           {
/*     */             public Royalty get()
/*     */             {
/* 161 */               return ((FactionNPC)f.get()).court().king().roy();
/*     */             }
/*     */           }));
/*     */ 
/*     */     
/* 166 */     text.addRelBody(8, DIR.W, (RENDEROBJ)s);
/*     */     
/* 168 */     return (RENDEROBJ)text;
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection trust(final GETTER<FactionNPC> f) {
/* 173 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 177 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/* 178 */           super.render(r, ds);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 183 */           ROPINION.trust().hover(text, (FactionNPC)f.get());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 188 */     s.add((SPRITE)(RTrust.BOOST()).bo.icon, 0, 0);
/* 189 */     s.addRightC(8, (RENDEROBJ)new GHeader((RTrust.BOOST()).bo.name));
/* 190 */     s.addRightC(16, (SPRITE)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 194 */             GFORMAT.perc(text, ROPINION.trust().get(f));
/* 195 */             if (ROPINION.trust().get(f) < 1.0D)
/* 196 */               text.errorify(); 
/*     */           }
/* 198 */         }).increase());
/*     */ 
/*     */     
/* 201 */     s.addRightC(80, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 205 */             double c = ROPINION.trust().get((FactionNPC)f.get());
/* 206 */             double n = ROPINION.EMMI().trustTarget(((FactionNPC)f.get()).king(), 1.0D);
/*     */             
/* 208 */             text.add('-').add('>').s();
/* 209 */             GFORMAT.perc(text, n);
/* 210 */             if (n < c) {
/* 211 */               text.errorify();
/* 212 */             } else if (n > c) {
/* 213 */               text.normalify2();
/*     */             } else {
/* 215 */               text.normalify();
/* 216 */             }  if ((FACTIONS.player()).emissaries.penaltyMul() < 1.0D) {
/* 217 */               text.add('*');
/*     */             }
/*     */           }
/*     */         });
/* 221 */     s.body().incrW(80.0D);
/*     */ 
/*     */     
/* 224 */     s.pad(8, 4);
/* 225 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private GuiSection opinions(final GETTER<FactionNPC> f, int height) {
/* 232 */     final ArrayList<OP> specs = new ArrayList(ROPINION.BOOST().all().size());
/* 233 */     final ArrayList<OP> as = new ArrayList(ROPINION.BOOST().all().size());
/* 234 */     for (SuperSpec<Royalty> bb : (Iterable<SuperSpec<Royalty>>)ROPINION.BOOST().all()) {
/* 235 */       OP op = new OP(bb, f);
/* 236 */       specs.add(op);
/*     */     } 
/*     */     
/* 239 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 243 */           as.clearSloppy();
/* 244 */           for (Court.OP bb : specs) {
/* 245 */             boolean b = !(!(S.get()).developer && bb.bb.get(((FactionNPC)f.get()).king()) == bb.bb.from());
/* 246 */             if (b) {
/* 247 */               as.add(bb);
/*     */             }
/*     */           } 
/* 250 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 256 */     GuiSection top = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 260 */           GBox b = (GBox)text;
/* 261 */           b.title(ROPINION.¤¤name);
/* 262 */           b.text(ROPINION.¤¤desc);
/* 263 */           b.NL();
/* 264 */           b.textLL(Court.¤¤minOpinion);
/* 265 */           b.tab(6);
/* 266 */           b.add((SPRITE)GFORMAT.f(b.text(), (DIP.get((FactionNPC)f.get())).opinionNeeded));
/* 267 */           b.text((CharSequence)b.text().add('(').add((DIP.get((FactionNPC)f.get())).name).add(')'));
/* 268 */           b.NL();
/* 269 */           b.textLL(ROPINION.¤¤wEmmi);
/* 270 */           b.tab(6);
/* 271 */           b.add((SPRITE)GFORMAT.f(b.text(), ROPINION.EMMI().opinionTarget(((FactionNPC)f.get()).king(), 1.0D)));
/*     */ 
/*     */           
/* 274 */           b.sep();
/* 275 */           ROPINION.BOOST().hoverDetailed((GUI_BOX)b, (SuperBoostableObj)((FactionNPC)f.get()).court().king().roy());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 280 */     top.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 284 */             GFORMAT.fofkInv(text, ROPINION.get((FactionNPC)f.get()), (DIP.get((FactionNPC)f.get())).opinionNeeded);
/*     */           }
/* 287 */         }).hh(ROPINION.¤¤name));
/*     */     
/* 289 */     top.addRightC(80, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 293 */             double c = ROPINION.get((FactionNPC)f.get());
/* 294 */             double n = ROPINION.EMMI().opinionTarget(((FactionNPC)f.get()).king(), 1.0D);
/*     */             
/* 296 */             text.add('-').add('>').s();
/* 297 */             GFORMAT.f(text, n);
/* 298 */             if (n < c) {
/* 299 */               text.errorify();
/* 300 */             } else if (n > c) {
/* 301 */               text.normalify2();
/*     */             } else {
/* 303 */               text.normalify();
/*     */             } 
/* 305 */             if ((FACTIONS.player()).emissaries.penaltyMul() < 1.0D) {
/* 306 */               text.add('*');
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 313 */     top.body().incrW(64.0D);
/*     */     
/* 315 */     s.addRelBody(8, DIR.S, (RENDEROBJ)top);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 320 */     s.addRelBody(4, DIR.N, (RENDEROBJ)trust(f));
/*     */     
/* 322 */     height -= s.body().height() + 16;
/*     */     
/* 324 */     GMatrix mm = new GMatrix(height / ((OP)specs.get(0)).body().height(), 4, ((OP)specs.get(0)).body().width(), ((OP)specs.get(0)).body().height())
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 328 */           return as.size();
/*     */         }
/*     */ 
/*     */         
/*     */         public RENDEROBJ get(int i, int columnI) {
/* 333 */           return (RENDEROBJ)as.get(i);
/*     */         }
/*     */       };
/*     */     
/* 337 */     s.addRelBody(8, DIR.S, (RENDEROBJ)mm);
/*     */ 
/*     */ 
/*     */     
/* 341 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private GuiSection emmisaries(final GETTER<FactionNPC> f) {
/* 347 */     GuiSection s = new GuiSection();
/*     */     
/* 349 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 353 */             int tot = 0;
/* 354 */             for (EmiTypeRoy e : (FACTIONS.player()).emissaries.roys) {
/* 355 */               for (Royalty r : ((FactionNPC)f.get()).court().all())
/* 356 */                 tot += e.get(r); 
/*     */             } 
/* 358 */             GFORMAT.i(text, tot);
/*     */           }
/* 360 */         }).hh(Emissaries.¤¤name));
/*     */     
/* 362 */     s.addRightC(64, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 366 */             GFORMAT.i(text, (FACTIONS.player()).emissaries.available());
/*     */           }
/* 368 */         }).hh(Dic.¤¤Available));
/*     */     
/* 370 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/* 372 */     for (EmiTypeRoy emiTypeRoy : (FACTIONS.player()).emissaries.roys) {
/* 373 */       if (emiTypeRoy == (FACTIONS.player()).emissaries.assasinate)
/*     */         continue; 
/* 375 */       INT.INTE iNTE = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 379 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 384 */             return m.max(((FactionNPC)f.get()).king());
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 389 */             return m.get(((FactionNPC)f.get()).king());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 394 */             m.set(((FactionNPC)f.get()).king(), t);
/*     */           }
/*     */         };
/*     */       
/* 398 */       GuiSection guiSection = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 401 */             m.hover(((FactionNPC)f.get()).king(), text);
/*     */           }
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 406 */             if (((FactionNPC)f.get()).king() == null)
/*     */               return; 
/* 408 */             super.render(r, ds);
/*     */             
/* 410 */             GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 415 */       guiSection.add(emiTypeRoy.icon, 0, 0);
/* 416 */       guiSection.addRightC(4, (RENDEROBJ)new GHeader(emiTypeRoy.name));
/*     */       
/* 418 */       guiSection.addRightCAbs(180, (RENDEROBJ)new GInputInt(iNTE, true, true));
/* 419 */       guiSection.pad(4, 4);
/*     */       
/* 421 */       rows.add(guiSection);
/*     */       
/* 423 */       s.addRelBody(2, DIR.S, (RENDEROBJ)guiSection);
/*     */     } 
/*     */ 
/*     */     
/* 427 */     final EmiTypeRoy m = (FACTIONS.player()).emissaries.assasinate;
/* 428 */     final INT.IntImp prev = new INT.IntImp();
/* 429 */     final GETTER<Royalty> roy = new GETTER<Royalty>()
/*     */       {
/*     */         
/*     */         public Royalty get()
/*     */         {
/* 434 */           for (Royalty e : ((FactionNPC)f.get()).court().all()) {
/* 435 */             if (m.get(e) > 0)
/* 436 */               return e; 
/*     */           } 
/* 438 */           if (prev.get() < ((FactionNPC)f.get()).court().all().size())
/* 439 */             return (Royalty)((FactionNPC)f.get()).court().all().get(prev.get()); 
/* 440 */           return ((FactionNPC)f.get()).king();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 449 */     INT.INTE ii = new INT.INTE()
/*     */       {
/*     */ 
/*     */         
/*     */         public int min()
/*     */         {
/* 455 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 460 */           return m.max(roy.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 465 */           return m.get(roy.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 470 */           m.set(roy.get(), t);
/*     */         }
/*     */       };
/*     */     
/* 474 */     GuiSection line = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 477 */           m.hover(((FactionNPC)f.get()).king(), text);
/*     */         }
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 482 */           if (((FactionNPC)f.get()).king() == null)
/*     */             return; 
/* 484 */           super.render(r, ds);
/*     */           
/* 486 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 491 */     line.add(m.icon, 0, 0);
/* 492 */     line.addRightC(4, (RENDEROBJ)new GHeader(m.name));
/*     */     
/* 494 */     line.addRightCAbs(180, (RENDEROBJ)new GInputInt(ii, true, true));
/* 495 */     line.pad(4, 4);
/*     */     
/* 497 */     rows.add(line);
/*     */     
/* 499 */     s.addRelBody(2, DIR.S, (RENDEROBJ)line);
/*     */ 
/*     */     
/* 502 */     UIRoyalty.Portrait portrait = new UIRoyalty.Portrait(1, roy);
/* 503 */     s.addRightC(4, (RENDEROBJ)new GButt.ButtPanel((SPRITE)portrait)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 507 */             int old = m.get(roy.get());
/* 508 */             m.set(roy.get(), 0);
/* 509 */             prev.set((prev.get() + 1) % ((FactionNPC)f.get()).court().all().size());
/* 510 */             m.set(roy.get(), old);
/* 511 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 516 */             text.text(Court.¤¤assass);
/* 517 */             text.NL();
/* 518 */             Court.hover(text, (Royalty)roy.get());
/* 519 */             super.hoverInfoGet(text);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 531 */     s.pad(16, 16);
/*     */     
/* 533 */     if ((S.get()).developer)
/*     */     {
/* 535 */       s.addRelBody(4, DIR.S, (RENDEROBJ)new GButt.ButtPanel("assasinate")
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 539 */               ROPINION.EMMI().assasinate((Royalty)roy.get(), RND.rBoolean());
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/* 545 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void hover(GUI_BOX box, Royalty ro) {
/* 552 */     GBox b = (GBox)box;
/*     */     
/* 554 */     b.title((CharSequence)ro.nameFull((Str)b.text()));
/* 555 */     b.textL((CharSequence)ro.nameSucc((Str)b.text()));
/* 556 */     b.NL();
/* 557 */     b.textLL(Dic.¤¤Age);
/* 558 */     b.tab(6);
/* 559 */     int y = (int)(STATS.POP()).age.years.getD(ro.induvidual);
/* 560 */     b.add((SPRITE)GFORMAT.i(b.text(), y));
/* 561 */     b.NL(8);
/*     */     
/* 563 */     for (TRAIT info : ro.traits) {
/* 564 */       b.textL(info.info.name);
/* 565 */       b.NL();
/* 566 */       b.text(info.info.desc);
/* 567 */       b.NL(8);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 572 */   private final GText tmp = new GText((UI.FONT()).S, 16);
/*     */   
/*     */   private class OP
/*     */     extends HOVERABLE.HoverableAbs {
/*     */     private final SuperSpec<Royalty> bb;
/*     */     private final GETTER<FactionNPC> ff;
/*     */     
/*     */     OP(SuperSpec<Royalty> bb, GETTER<FactionNPC> ff) {
/* 580 */       super(85, 30);
/* 581 */       this.bb = bb;
/* 582 */       this.ff = ff;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 587 */       boolean active = (this.bb.get(((FactionNPC)this.ff.get()).king()) != this.bb.from());
/* 588 */       GButt.ButtPanel.renderBG(r, active, false, isHovered, (RECTANGLE)this.body);
/*     */       
/* 590 */       if (!active) {
/* 591 */         OPACITY.O50.bind();
/*     */       }
/* 593 */       this.bb.info.icon.renderCY(r, this.body.x1() + 4, this.body.cY());
/*     */       
/* 595 */       Court.this.tmp.clear();
/* 596 */       if (this.bb.isMul) {
/* 597 */         Court.this.tmp.add('*');
/* 598 */         GFORMAT.f1(Court.this.tmp, this.bb.get(((FactionNPC)this.ff.get()).king()));
/*     */       } else {
/* 600 */         GFORMAT.f0(Court.this.tmp, this.bb.get(((FactionNPC)this.ff.get()).king()));
/*     */       } 
/*     */       
/* 603 */       Court.this.tmp.renderCY(r, this.body.x1() + 24, this.body.cY());
/*     */       
/* 605 */       OPACITY.unbind();
/*     */       
/* 607 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX textr) {
/* 613 */       GBox b = (GBox)textr;
/* 614 */       b.title(this.bb.info.name);
/* 615 */       b.text(this.bb.desc);
/*     */       
/* 617 */       b.NL();
/*     */       
/* 619 */       b.textLL(Dic.¤¤Value);
/* 620 */       b.tab(7);
/* 621 */       if (this.bb.isMul) {
/*     */         
/* 623 */         b.add((SPRITE)GFORMAT.f1(b.text(), this.bb.get(((FactionNPC)this.ff.get()).king())));
/*     */       } else {
/* 625 */         b.add((SPRITE)GFORMAT.f0(b.text(), this.bb.get(((FactionNPC)this.ff.get()).king())));
/* 626 */       }  b.NL();
/* 627 */       b.textLL(Court.¤¤personal);
/* 628 */       b.tab(7);
/* 629 */       b.add((SPRITE)GFORMAT.perc(b.text(), this.bb.getModifier((SuperBoostableObj)((FactionNPC)this.ff.get()).king())));
/* 630 */       b.NL();
/*     */       
/* 632 */       GText text = b.text();
/* 633 */       text.add('(');
/* 634 */       GFORMAT.f(text, this.bb.from(), 2);
/* 635 */       text.s();
/* 636 */       text.add('<').add('-').add('>');
/* 637 */       text.s();
/* 638 */       GFORMAT.f(text, this.bb.to(), 2);
/* 639 */       text.add(')');
/* 640 */       b.textLL(Court.¤¤valueSpan);
/* 641 */       b.tab(7);
/* 642 */       b.add((SPRITE)text);
/* 643 */       b.NL();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class Portrait
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final SPRITE s;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final GETTER<Royalty> g;
/*     */ 
/*     */ 
/*     */     
/*     */     final int scale;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Portrait(int scale, GETTER<Royalty> g) {
/* 669 */       this.scale = scale;
/* 670 */       this.g = g;
/* 671 */       this.s = (SPRITE)new UIRoyalty.Portrait(scale, g);
/* 672 */       this.body.setDim((this.s.width() + 4 * scale), this.s.height());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 679 */       Royalty ro = (Royalty)this.g.get();
/*     */       
/* 681 */       if (ro == null) {
/*     */         return;
/*     */       }
/* 684 */       this.s.renderC(r, this.body.cX(), this.body.cY());
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 689 */       if (this.g.get() == null)
/*     */         return; 
/* 691 */       Court.hover(text, (Royalty)this.g.get());
/* 692 */       text.NL(8);
/* 693 */       super.hoverInfoGet(text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 698 */       Royalty ro = (Royalty)this.g.get();
/* 699 */       if (ro == null)
/*     */         return; 
/* 701 */       (VIEW.inters()).popup.show((RENDEROBJ)Court.this.vvs, (CLICKABLE)this, true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Court.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */