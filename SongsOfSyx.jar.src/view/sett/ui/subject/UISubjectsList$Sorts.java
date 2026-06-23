/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.Dictionary;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Sorts
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final CLICKABLE pop;
/*     */   private final UISubjectsList.Li li;
/*     */   private Sort current;
/*     */   
/*     */   Sorts(UISubjectsList.Li li) {
/* 347 */     this.li = li;
/* 348 */     ArrayListGrower<RENDEROBJ> rows = new ArrayListGrower();
/*     */     
/* 350 */     Sort ss = new Sort(this, (SPRITE)(UI.icons()).s.admin, Dic.¤¤name)
/*     */       {
/*     */         public void format(Induvidual h, GText text)
/*     */         {
/* 354 */           text.normalify();
/* 355 */           text.add(STATS.APPEARANCE().name(h));
/*     */         }
/*     */ 
/*     */         
/*     */         public double vale(Induvidual a, Induvidual b) {
/* 360 */           Str.TMP.clear().add(STATS.APPEARANCE().name(a));
/* 361 */           return Dictionary.compare((CharSequence)Str.TMP, STATS.APPEARANCE().name(b));
/*     */         }
/*     */       };
/* 364 */     li.wSort = ss;
/*     */     
/* 366 */     rows.add(ss);
/*     */     
/* 368 */     rows.add(new Sort(this, (SPRITE)(UI.icons()).s.admin, UISubjectsList.¤¤nameF)
/*     */         {
/*     */           public void format(Induvidual h, GText text)
/*     */           {
/* 372 */             text.normalify();
/* 373 */             text.add((STATS.APPEARANCE()).nameFirst.name(h));
/*     */           }
/*     */ 
/*     */           
/*     */           public double vale(Induvidual a, Induvidual b) {
/* 378 */             Str.TMP.clear().add((STATS.APPEARANCE()).nameFirst.name(a));
/* 379 */             return Dictionary.compare((CharSequence)Str.TMP, (STATS.APPEARANCE()).nameFirst.name(b));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 384 */     rows.add(new Sort(this, (SPRITE)(UI.icons()).s.admin, UISubjectsList.¤¤nameL)
/*     */         {
/*     */           public void format(Induvidual h, GText text)
/*     */           {
/* 388 */             text.normalify();
/* 389 */             text.add((STATS.APPEARANCE()).nameLast.name(h));
/*     */           }
/*     */ 
/*     */           
/*     */           public double vale(Induvidual a, Induvidual b) {
/* 394 */             Str.TMP.clear().add((STATS.APPEARANCE()).nameLast.name(a));
/* 395 */             return Dictionary.compare((CharSequence)Str.TMP, (STATS.APPEARANCE()).nameLast.name(b));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 400 */     rows.add(new Sort(this, (SPRITE)(UI.icons()).s.clock, Dic.¤¤Age)
/*     */         {
/*     */           public void format(Induvidual h, GText text)
/*     */           {
/* 404 */             text.normalify();
/* 405 */             text.add((STATS.POP()).age.DAYS.get(h) / TIME.years().bitConversion((TIMECYCLE)TIME.days()), 2);
/*     */           }
/*     */ 
/*     */           
/*     */           public double vale(Induvidual a, Induvidual b) {
/* 410 */             return ((STATS.POP()).age.DAYS.get(a) - (STATS.POP()).age.DAYS.get(b));
/*     */           }
/*     */         });
/*     */     
/* 414 */     rows.add(new Sort(this, (SPRITE)(UI.icons()).s.hammer, (STATS.WORK()).EMPLOYED.info.name)
/*     */         {
/*     */           public void format(Induvidual h, GText text)
/*     */           {
/* 418 */             text.normalify();
/* 419 */             RoomBlueprintImp a = (RoomBlueprintImp)(STATS.WORK()).profession.get(h);
/* 420 */             if (a == null) {
/* 421 */               text.add(Dic.¤¤Oddjobber);
/*     */             } else {
/* 423 */               text.add((a.employment()).title);
/*     */             } 
/*     */           }
/*     */           
/*     */           public double vale(Induvidual a, Induvidual b) {
/* 428 */             CharSequence q1 = Dic.¤¤Oddjobber;
/* 429 */             CharSequence q2 = Dic.¤¤Oddjobber;
/*     */             
/* 431 */             RoomBlueprintImp e = (RoomBlueprintImp)(STATS.WORK()).profession.get(a);
/* 432 */             if (e != null)
/* 433 */               q1 = (e.employment()).title; 
/* 434 */             e = (RoomBlueprintImp)(STATS.WORK()).profession.get(b);
/* 435 */             if (e != null)
/* 436 */               q2 = (e.employment()).title; 
/* 437 */             return Dictionary.compare(q1, q2);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 442 */     for (STAT s : STATS.createMatterList(true, false, null)) {
/* 443 */       if (s == (STATS.POP()).age.AGE_DAYS) {
/*     */         continue;
/*     */       }
/* 446 */       rows.add(new Sort(this, (s.info()).icon, (s.info()).name)
/*     */           {
/*     */             public void format(Induvidual h, GText text)
/*     */             {
/* 450 */               if (s.info().isInt())
/* 451 */               { if (s.indu().max(h) == 1) {
/* 452 */                   GFORMAT.bool(text, (s.indu().get(h) == 1));
/*     */                 } else {
/* 454 */                   GFORMAT.i(text, s.indu().get(h));
/*     */                 }  }
/* 456 */               else { GFORMAT.perc(text, s.indu().getD(h)); }
/*     */             
/*     */             }
/*     */ 
/*     */             
/*     */             public double vale(Induvidual a, Induvidual b) {
/* 462 */               return (s.indu().get(b) - s.indu().get(a));
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 467 */     this.body.setHeight(((RENDEROBJ)rows.get(0)).body().height());
/* 468 */     this.body.setWidth(((RENDEROBJ)rows.get(0)).body().width());
/*     */     
/* 470 */     this.pop = (new GScrollRows((Iterable)rows, 500)).view();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 478 */     GButt.ButtPanel.renderBG(r, isActive, false, isHovered, (RECTANGLE)this.body);
/*     */     
/* 480 */     this.current.icon.renderCY(r, this.body.x1() + 4, this.body.cY());
/* 481 */     (UI.FONT()).S.renderCY(r, this.body.x1() + 32, this.body.cY(), this.current.name);
/*     */     
/* 483 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 489 */     (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/*     */   }
/*     */   
/*     */   private abstract class Sort
/*     */     extends GButt.ButtPanel implements UISubjectsList.SSort {
/*     */     private final SPRITE icon;
/*     */     private final CharSequence name;
/*     */     
/*     */     public Sort(SPRITE icon, CharSequence name) {
/* 498 */       super(name); Icons.S.IconS iconS;
/* 499 */       this.name = name;
/* 500 */       if (icon == null)
/* 501 */         iconS = (UI.icons()).s.cancel; 
/* 502 */       this.icon = iconS.resized(16);
/* 503 */       icon(this.icon);
/* 504 */       this.body.setWidth(400.0D);
/*     */       
/* 506 */       if (UISubjectsList.Sorts.this.current == null) {
/* 507 */         UISubjectsList.Sorts.this.current = this;
/* 508 */         UISubjectsList.Sorts.this.li.sort = this;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 514 */       UISubjectsList.Sorts.this.current = this;
/* 515 */       UISubjectsList.Sorts.this.li.sort = this;
/* 516 */       (VIEW.inters()).popup.close();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 521 */       selectedSet((UISubjectsList.Sorts.this.current == this));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectsList$Sorts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */