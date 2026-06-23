/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBurial;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StatRowGrave
/*     */ {
/*     */   private final HCLASS cl;
/*     */   private final GETTER<Race> race;
/*     */   
/*     */   StatRowGrave(final HCLASS cl, final GETTER<Race> race, LinkedList<RENDEROBJ> rens) {
/* 373 */     this.race = race;
/* 374 */     this.cl = cl;
/*     */     
/* 376 */     boolean has = false;
/* 377 */     for (StatsBurial.StatGrave ss : STATS.BURIAL().graves()) {
/* 378 */       for (Race r : RACES.all()) {
/* 379 */         if ((ss.standing().definition(r).get(cl)).max > 0.0D) {
/* 380 */           has = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 385 */     if (!has) {
/*     */       return;
/*     */     }
/* 388 */     GuiSection s = new GuiSection();
/*     */     
/* 390 */     s.add((SPRITE)(new GText((UI.FONT()).H2, CatReligion.¤¤Burrial)).lablify(), 0, 0);
/* 391 */     s.addRightCAbs(268, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 395 */             double d = 0.0D;
/* 396 */             for (StatsBurial.StatGrave ss : STATS.BURIAL().graves()) {
/* 397 */               d = Math.max(d, ss.data(cl).getD(race.get()));
/*     */             }
/* 399 */             GFORMAT.perc(text, d);
/*     */           }
/*     */         });
/*     */     
/* 403 */     s.addCentredY((RENDEROBJ)new RENDEROBJ.RenderImp(200, 20)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 407 */             double max = 0.0D;
/* 408 */             double now = 0.0D;
/* 409 */             double nor = 0.0D;
/* 410 */             double prev = 0.0D;
/* 411 */             for (StatsBurial.StatGrave s : STATS.BURIAL().graves()) {
/* 412 */               max = Math.max(max, s.standing().max(cl, (Race)race.get()));
/* 413 */               now = Math.max(now, s.standing().get(cl, (Race)race.get()));
/* 414 */               prev = Math.max(prev, s.standing().getPrev(cl, (Race)race.get(), 8));
/* 415 */               nor = Math.max(nor, s.standing().normalized(cl, (Race)race.get()));
/*     */             } 
/*     */             
/* 418 */             GMeter.renderDelta(r, prev / max, now / max, this.body.x1(), (int)(body().x1() + body().width() * nor), body().y1(), body().y2());
/*     */           }
/* 420 */         }328);
/* 421 */     s.pad(4, 0);
/* 422 */     rens.add(s);
/*     */     
/* 424 */     for (StatsBurial.StatGrave ss : STATS.BURIAL().graves()) {
/* 425 */       for (Race r : RACES.all()) {
/* 426 */         if ((ss.standing().definition(r).get(cl)).max > 0.0D) {
/*     */           
/* 428 */           rens.add(service(ss));
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ service(final StatsBurial.StatGrave ss) {
/* 439 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 442 */           if (!isHoveringAHoverElement()) {
/* 443 */             ss.hover(text, CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/*     */           }
/* 445 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/* 448 */     s.add((RENDEROBJ)new StatRow.Arrow((STAT)ss, this.cl, this.race));
/* 449 */     s.addRightC(4, (RENDEROBJ)new GButt.Checkbox()
/*     */         {
/*     */           protected void clickA() {
/* 452 */             ss.grave().permission().toggle(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 457 */             selectedSet(is());
/*     */           }
/*     */           
/*     */           private boolean is() {
/* 461 */             return ss.grave().permission().get(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 466 */             if (CatReligion.StatRowGrave.this.race.get() != null) {
/* 467 */               text.text(CatReligion.¤¤AllowRace);
/*     */             } else {
/* 469 */               text.text(CatReligion.¤¤Allow);
/*     */             }  }
/*     */         });
/* 472 */     s.addRightC(4, (SPRITE)ss.grave().blueprint().iconBig());
/* 473 */     s.addRightC(4, (SPRITE)(new GText((UI.FONT()).S, (ss.grave().blueprint()).info.names)).lablifySub());
/* 474 */     s.addCentredY((SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 478 */             text.setFont((UI.FONT()).S);
/*     */             
/* 480 */             StatRow.format(text, (STAT)ss, ss.data(CatReligion.StatRowGrave.this.cl).getD(CatReligion.StatRowGrave.this.race.get()), CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/*     */           }
/* 482 */         }268);
/*     */     
/* 484 */     s.addCentredY((RENDEROBJ)new RENDEROBJ.RenderImp(200, 12)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 488 */             double max = ss.standing().max(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/* 489 */             double now = ss.standing().get(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/* 490 */             double nor = ss.standing().normalized(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/* 491 */             GMeter.render(r, GMeter.C_BLUE, now / max, this.body.x1(), (int)(body().x1() + body().width() * nor), body().y1(), body().y2());
/*     */           }
/* 493 */         }328);
/*     */ 
/*     */     
/* 496 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatReligion$StatRowGrave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */