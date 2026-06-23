/*     */ package settlement.battle.invasion;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MVictory2
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int[] res;
/* 301 */   private final double time = TIME.currentSecond();
/*     */   private boolean accepted = false;
/*     */   
/*     */   public MVictory2(int[] res) {
/* 305 */     super(Attack.¤¤vTitle);
/* 306 */     this.res = res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 312 */     String st = String.valueOf(Str.TMP.clear().add(Attack.¤¤vBody));
/*     */     
/* 314 */     section.addDown(8, (SPRITE)(new GText((UI.FONT()).M, st)).setMaxWidth(900));
/*     */ 
/*     */ 
/*     */     
/* 318 */     final Bitmap1D selected = new Bitmap1D(TR.ALL().size(), false);
/* 319 */     selected.setAll(true);
/*     */     
/* 321 */     GRows rr = new GRows(4);
/*     */ 
/*     */     
/* 324 */     for (TRADABLE r : TR.ALL()) {
/* 325 */       if (r.index() >= this.res.length || this.res[r.index()] <= 0) {
/*     */         continue;
/*     */       }
/* 328 */       GuiSection ss = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 332 */             text.title(r.name);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 337 */       ss.add((RENDEROBJ)new GButt.Checkbox()
/*     */           {
/*     */             protected void clickA() {
/* 340 */               selected.toggle(r.index());
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 345 */               selectedSet(selected.get(r.index()));
/*     */             }
/*     */           });
/*     */       
/* 349 */       ss.addRightC(2, r.icon());
/* 350 */       ss.addRightCAbs(40, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 354 */               GFORMAT.i(text, Attack.MVictory2.this.res[r.index()]);
/*     */             }
/*     */           });
/*     */       
/* 358 */       ss.body().incrW(48.0D);
/* 359 */       rr.add((RENDEROBJ)ss);
/*     */     } 
/*     */     
/* 362 */     boolean f = true;
/* 363 */     for (RENDEROBJ o : rr.rows()) {
/* 364 */       section.addRelBody(f ? 16 : 2, DIR.S, o);
/* 365 */       f = false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 370 */     section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Accept)
/*     */         {
/*     */           protected void clickA() {
/* 373 */             if (TIME.currentSecond() - Attack.MVictory2.this.time < TIME.secondsPerDay() && !Attack.MVictory2.this.accepted) {
/* 374 */               Attack.MVictory2.this.accepted = true;
/* 375 */               for (TRADABLE r : TR.ALL()) {
/* 376 */                 int am = Attack.MVictory2.this.res[r.index()];
/* 377 */                 if (am > 0 && selected.get(r.index())) {
/* 378 */                   FACTIONS.player().buyer(r).addReserveAndDeliver(am, TRADE_TYPE.spoils);
/*     */                 }
/*     */               } 
/* 381 */               (VIEW.inters()).messages.hide();
/*     */             } 
/* 383 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 388 */             activeSet((TIME.currentSecond() - Attack.MVictory2.this.time < TIME.secondsPerDay() && !Attack.MVictory2.this.accepted));
/*     */           }
/*     */         });
/*     */     
/* 392 */     section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Decline)
/*     */         {
/*     */           protected void clickA() {
/* 395 */             if (TIME.currentSecond() - Attack.MVictory2.this.time < TIME.secondsPerDay() && !Attack.MVictory2.this.accepted) {
/* 396 */               Attack.MVictory2.this.accepted = true;
/* 397 */               (VIEW.inters()).messages.hide();
/*     */             } 
/* 399 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 404 */             activeSet((TIME.currentSecond() - Attack.MVictory2.this.time < TIME.secondsPerDay() && !Attack.MVictory2.this.accepted));
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\Attack$MVictory2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */